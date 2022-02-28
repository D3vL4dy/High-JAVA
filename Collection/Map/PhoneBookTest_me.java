package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/*
 * 문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고,
 * 		Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 * 
 * 		전화번호 정보는 Map에 저장하여 관리한다.
 * 		(key값은 입력받은 사람의 '이름'으로 하고,
 * 		value값은 'Phone클래스의 인스턴스'로 한다.)
 * 
 * 		아래 메뉴의 기능을 모두 작성하시오.
 * 		(삭제, 검색 기능은 '이름'을 입력 받아 처리한다.)
 * 
 * 		메뉴 예시)
 * 		1. 전화번호 등록
 * 		2. 전화번호 수정
 * 		3. 전화번호 삭제
 * 		4. 전화번호 검색	
 * 		5. 전화번호 전체 출력	
 * 		0. 프로그램 종료
 * -------------------------------
 * 실행 예시)
 * 		1. 전화번호 등록
 * 		2. 전화번호 수정
 * 		3. 전화번호 삭제
 * 		4. 전화번호 검색	
 * 		5. 전화번호 전체 출력	
 * 		0. 프로그램 종료
 * 		------------------
 * 		번호입력 >> 1
 * 		
 * 		새롭게 등록할 전화번호 정보를 입력하세요.
 * 		이름 >> 홍길동
 * 		전화번호 >> 010-1111-1111
 * 		주소 >> 대전시 중구 오류동
 * 
 * 		'홍길동'전화번호 정보 등록 완료!!
 * 
 * 		1. 전화번호 등록
 * 		2. 전화번호 수정
 * 		3. 전화번호 삭제
 * 		4. 전화번호 검색	
 * 		5. 전화번호 전체 출력	
 * 		0. 프로그램 종료
 * 		------------------
 * 		번호입력 >> 1
 * 
 * 		새롭게 등록할 전화번호 정보를 입력하세요.
 * 		이름 >> 홍길동
 * 		'홍길동'은 이미 등록된 사람입니다.
 * 
 * 		1. 전화번호 등록
 * 		2. 전화번호 수정
 * 		3. 전화번호 삭제
 * 		4. 전화번호 검색	
 * 		5. 전화번호 전체 출력	
 * 		0. 프로그램 종료
 * 		------------------
 * 		번호입력 >> 5
 * 
 * -----------------------------------------
 * 번호  이름     전화번호          주소
 * -----------------------------------------
 *  1   홍길동   010-1111-1111  대전시 중구 오류동
 * -----------------------------------------
 * 출력 완료...
 * 
 * 		1. 전화번호 등록
 * 		2. 전화번호 수정
 * 		3. 전화번호 삭제
 * 		4. 전화번호 검색	
 * 		5. 전화번호 전체 출력	
 * 		0. 프로그램 종료
 * 		------------------
 * 		번호입력 >>    
 */
public class PhoneBookTest_me {
	Scanner scan = new Scanner(System.in);
	HashMap<String, Phone> map = new HashMap<String, Phone>();
	
	public static void main(String[] args) {
		new PhoneBookTest_me().start();
	}
	
	public void start() {
		while (true) {
			System.out.println("전화번호 관리 프로그램");
			System.out.println("----------------------------");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("0. 프로그램 종료");
			System.out.println("----------------------------");
			System.out.print("번호입력 >> ");
			int input = Integer.parseInt(scan.nextLine());
			System.out.println();

			switch (input) {
			case 1:
				telInsert();
				break;
			case 2:
				telUpdate();
				break;
			case 3:
				telDelete();
				break;
			case 4:
				telSelect();
				break;
			case 5:
				telSelectAll();
				break;
			case 0:
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			}
		}
	}

	// 등록
	private void telInsert() {
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.nextLine();
		
		Set<String> keySet = map.keySet();
		if(keySet.contains(name)) {
			System.out.println("'" + name + "'은 이미 등록된 사람입니다.\n");
			return;
		}
		
		System.out.print("전화번호 >> ");
		String tel = scan.nextLine();
		System.out.print("주소 >> ");
		String addr = scan.nextLine();
		
		map.put(name, new Phone(name, tel, addr));
		System.out.println();
		System.out.println("'" + name + "' 전화번호 정보 등록 완료!!\n");

	}
	
	// 수정
	private void telUpdate() {
		System.out.println("수정할 전화번호 주인을 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.nextLine();
		
		if(map.containsKey(name)) { 
			System.out.print("전화번호 >> ");
			String tel = scan.nextLine();
			System.out.print("주소 >> ");
			String addr = scan.nextLine();
			map.put(name, new Phone(name, tel, addr));
			System.out.println("'" + name + "' 전화번호 정보 수정 완료!!\n");
			return;
		}else {
			System.out.println("찾는 이름이 없습니다.\n");
			return;
		}
	}
	
	// 삭제
	private void telDelete() {
		System.out.println("삭제할 전화번호 주인을 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.nextLine();
		
		if(map.containsKey(name)) {
			map.remove(name);
			System.out.println("'" + name + "' 전화번호 정보 삭제 완료!!\n");
			return;
		}else {
			System.out.println("찾는 이름이 없습니다.\n");
			return;
		}
	}

	// 검색
	private void telSelect() {
		System.out.println("조회할 전화번호 주인을 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.nextLine();
		
		if(map.containsKey(name)) {
			Phone value = map.get(name); 
			System.out.println(value);
			System.out.println("'" + name + "' 전화번호 정보 조회 완료!!\n");
			return;
		}else {
			System.out.println("찾는 이름이 없습니다.\n");
			return;
		}
		
	}
	
	// 전체 출력
	private void telSelectAll() {
		System.out.println("-------------------------------------");
		System.out.println("번호\t이름\t전화번호\t\t주소");
		System.out.println("-------------------------------------");
		for(Phone value : map.values()) {
			System.out.println(value);
		}
		System.out.println("-------------------------------------");
		System.out.println();

		// 혜지
//		System.out.println("번호\t이름\t전화번호\t\t주소");
//		int count = 1;
//		for(Phone value : map.values()) {
//			System.out.println(count 
//					+ "\t" + value.getName() 
//					+ "\t" + value.getTel() 
//					+ "\t" + value.getAddr());
//			count++;
//		}
		
	}
}

//class Phone{
//	String name;
//	String addr;
//	String tel;
//	
//	public Phone(String name, String addr, String tel) {
//		super();
//		this.name = name;
//		this.addr = addr;
//		this.tel = tel;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getAddr() {
//		return addr;
//	}
//
//	public void setAddr(String addr) {
//		this.addr = addr;
//	}
//
//	public String getTel() {
//		return tel;
//	}
//
//	public void setTel(String tel) {
//		this.tel = tel;
//	}
//
//	@Override
//	public String toString() {
//		return "Phone [name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
//	}
//
//}
