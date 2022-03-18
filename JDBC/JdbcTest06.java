package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 * 회원을 관리하는 프로그램을 작성하시오.
 * (MYMEMBER테이블 이용)
 * 
 * 아래 메뉴의 기능을 모두 구현하시오(CRUD기능 구현하기)
 * 
 * 메뉴 예시)
 * ------------------------------------
 * 		== 작업 선택 ==
 * 	  1. 자료 추가		--> insert (C)
 *    2. 자료 수정		--> update (U)
 *    3. 자료 삭제		--> delete (D)
 *    4. 전체 자료 출력	--> select (R)
 *    0. 작업 끝.	
 * ------------------------------------ 
 * 
 * 조건)
 * 1) 자료 추가에서 '회원ID'는 중복되지 않는다.(중복되면 다시 입력 받는다.)
 * 2) 자료 삭제는 '회원ID'를 입력 받아서 처리한다.
 * 3) 자료 수정에서 '회원ID'는 변경되지 않는다.
 */

public class JdbcTest06 {
	Scanner scan = new Scanner(System.in);
	
	Connection conn = null;
	Statement stmt = null; 
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	
	String id;
	String name;
	String pass;
	String tel;
	String addr;
	
	
	public static void main(String[] args) {
		new JdbcTest06().start();
	}
	
	public void start() {
		System.out.println();
		System.out.println("---------------------------");
		System.out.println("     == 작업 선택 ==");
		System.out.println("---------------------------");
		System.out.println();
		
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			case 1 : // 추가
				insert();
				break;
			case 2 : // 수정
				update();
				break;
			case 3 : // 삭제
				delete();
				break;
			case 4 : // 전체 출력
				select();
				break;
			case 0 :
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			default : 
				System.out.println("작업 번호를 잘못 입력했습니다.");
				System.out.println("다시 선택하세요.");
			}
		}
	}
	
	// 4. 자료 전체 출력
	private void select() {
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select mem_id, mem_name, mem_pass, mem_tel, mem_addr from mymember";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			System.out.println("==  자료 전체 출력 결과  ==");
			
			while(rs.next()) {
				System.out.println("MEM_ID : " + rs.getString("mem_id"));
				System.out.println("MEM_ID : " + rs.getString("mem_name"));
				System.out.println("MEM_ID : " + rs.getString("mem_pass"));
				System.out.println("MEM_ID : " + rs.getString("mem_tel"));
				System.out.println("MEM_ID : " + rs.getString("mem_addr"));
				System.out.println("-------------------------------------------");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); } catch(SQLException e) {}
			if(stmt!=null) try { stmt.close(); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); } catch (SQLException e) {}
		}
		
	}

	// 3. 자료 삭제
	private void delete() {
		// 자료 삭제는 '회원ID'를 입력 받아서 처리한다.
		try {
			conn = DBUtil.getConnection();
			
			int count = 0;
			
			do {
				System.out.print("삭제할 회원 아이디 : ");
				id = scan.next();
				
				String sql1 = "select count(*) cnt from mymember " 
						+ "where mem_id = ?";
				
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
				
				if(count > 0) {
					System.out.println(id + "는 등록된 회원입니다.");
					System.out.println("자료 삭제를 시작합니다.");
					break;
				} else {
					System.out.println(id + "는 등록된 회원입니다.");
					System.out.println("다시 입력하세요.");
				}
				
			}while(count > 0); 
			
			
			String sql2 = "delete from mymember " + 
					"where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, id);
			
			int cnt = pstmt.executeUpdate(); 
			
			if(cnt > 0) {
				System.out.println("삭제 성공!!");
			}else {
				System.out.println("삭제 실패...");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); } catch(SQLException e) {}
			if(pstmt!=null) try { pstmt.close(); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); } catch (SQLException e) {}
		}
	}

	// 2. 자료 수정
	private void update() {
		// 자료 수정에서 '회원ID'는 변경되지 않는다.
		try {
			conn = DBUtil.getConnection();
			
			int count = 0;
			
			do {
				System.out.print("수정할 회원 아이디 : ");
				id = scan.next();
				
				String sql1 = "select count(*) cnt from mymember " 
						+ "where mem_id = ?";
				
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
				
				if(count > 0) {
					System.out.println(id + "는 등록된 회원입니다.");
					System.out.println("자료 수정을 시작합니다.");
					break;
				}else {
					System.out.println(id + "는 등록된 회원입니다.");
					System.out.println("다시 입력하세요.");
				}
				
			}while(count > 0); 
			
			System.out.print("회원 이름 : ");
			name = scan.next();
			
			System.out.print("비밀번호 : ");
			pass = scan.next();
			
			System.out.print("전화번호 : ");
			tel = scan.next();
			
			System.out.print("주소 : ");
			scan.nextLine();
			addr = scan.nextLine();
			
			String sql2 = "insert into mymember " + 
					"(mem_name, mem_pass, mem_tel, mem_addr)" +
					"values(?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			pstmt.setString(3, tel);
			pstmt.setString(4, addr);
			
			int cnt = pstmt.executeUpdate(); 
			
			if(cnt > 0) {
				System.out.println("수정 성공!!");
			}else {
				System.out.println("수정 실패...");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); } catch(SQLException e) {}
			if(pstmt!=null) try { pstmt.close(); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); } catch (SQLException e) {}
		}
		
	}

	// 1. 자료 추가
	private void insert() {
		try {
			conn = DBUtil.getConnection();
			
			// 자료 추가에서 '회원ID'는 중복되지 않는다.(중복되면 다시 입력 받는다.)
			int count = 0; // 입력한 회원아이디의 개수가 저장될 변수
			
			do {
				System.out.print("회원 아이디 : ");
				id = scan.next();
				
				String sql1 = "select count(*) cnt from mymember " 
						+ "where mem_id = ?";
				
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
				
				if(count > 0) {
					System.out.println("입력한 회원ID " + id + "는 이미 등록된 ID입니다.");
					System.out.println("다시 입력하세요.");
				}
				
			}while(count > 0); // 중복되면 반복처리 되도록 한다.
			
			System.out.print("회원 이름 : ");
			name = scan.next();
			
			System.out.print("비밀번호 : ");
			pass = scan.next();
			
			System.out.print("전화번호 : ");
			tel = scan.next();
			
			System.out.print("주소 : ");
			scan.nextLine();
			addr = scan.nextLine();
			
			String sql2 = "insert into mymember " + 
					"values(?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pass);
			pstmt.setString(4, tel);
			pstmt.setString(5, addr);
			
			int cnt = pstmt.executeUpdate(); 
			
			if(cnt > 0) {
				System.out.println("추가 성공!!");
			}else {
				System.out.println("추가 실패...");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); } catch(SQLException e) {}
			if(pstmt!=null) try { pstmt.close(); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); } catch (SQLException e) {}
		}		
	}

	// 메뉴를 출력하고 작업 번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("----------------------------");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 수정");
		System.out.println("3. 자료 삭제");
		System.out.println("4. 자료 전체 출력");
		System.out.println("0. 작업 끝");
		System.out.println("----------------------------");
		System.out.print("번호입력 >> ");
		int num = scan.nextInt();
		System.out.println();
		return num;
	}
	

}
