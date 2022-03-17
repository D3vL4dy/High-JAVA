package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제) LPROD_ID값을 2개를 입력 받아서 두 값들 중 작은 값부터 큰 값 사이의 자료들을 출력하시오.

public class JdbcTest03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("lprod_id 입력1 : ");
		int num1 = scan.nextInt();
		
		System.out.print("lprod_id 입력2 : ");
		int num2 = scan.nextInt();
		
		int min = Math.min(num1, num2);
		int max = Math.max(num1, num2);

		if (num1 > num2) {
			max = num1;
			min = num2;
		} else {
			max = num2;
			min = num1;
		}

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. DB연결 ==> Connection객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KJI97", "java");
			
			String sql = "select * from lprod where lprod_id between " + min + " and " + max;
//			String sql = "select * from lprod where lprod_id >= " + min + " and lprod_id <= " + max;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("==  쿼리문 처리 결과  ==");
			while(rs.next()) {
				 
				System.out.println("lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("lprod_id : " + rs.getString("lprod_gu"));
				System.out.println("lprod_id : " + rs.getString("lprod_nm"));
				System.out.println("-------------------------------");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); } catch(SQLException e) {}
			if(stmt!=null) try { stmt.close(); } catch(SQLException e) {}
			if(conn!=null) try { conn.close(); } catch(SQLException e) {}
		}

	}

}
