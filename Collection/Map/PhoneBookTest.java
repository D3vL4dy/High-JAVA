package kr.or.ddit.basic;

import java.util.HashMap;
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
public class PhoneBookTest {
	Scanner scan = new Scanner(System.in);
	HashMap<String, Phone> map = new HashMap<String, Phone>();
	
	public static void main(String[] args) {
		new PhoneBookTest().start();
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

	private void telInsert() {
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String n1 = scan.nextLine();
		
		System.out.print("전화번호 >> ");
		String n2 = scan.nextLine();
		System.out.print("주소 >> ");
		String n3 = scan.nextLine();

		map.put("name", new Phone(n1, n2, n3));
		System.out.println();
		if(map.containsKey("name")) {
			System.out.println("'" + n1 + "'은 이미 등록된 사람입니다.\n");
			System.out.println(map);
			return;
		}else {
			System.out.println("'" + n1 + "' 전화번호 정보 등록 완료!!\n");
			System.out.println(map);
			return;
		}
	}
	
	private void telUpdate() {
		System.out.println("수정할 전화번호 주인을 입력하세요.");
		System.out.print("이름 >> ");
		String n1 = scan.nextLine();
		
		if(map.containsKey("name")) {
			System.out.print("전화번호 >> ");
			String n2 = scan.nextLine();
			System.out.print("주소 >> ");
			String n3 = scan.nextLine();
			map.put("name", new Phone(n2, n3));
			System.out.println("'" + n1 + "' 전화번호 정보 수정 완료!!\n");
			return;
		}else {
			System.out.println("찾는 이름이 없습니다.\n");
			return;
		}
	}
	
	private void telDelete() {
		System.out.println("삭제할 전화번호 주인을 입력하세요.");
		System.out.print("이름 >> ");
		String n1 = scan.nextLine();
		
		if(map.containsKey("name")) {
			map.remove("name", "addr");
			map.remove("name", "tel");
			System.out.println("'" + n1 + "' 전화번호 정보 삭제 완료!!\n");
			return;
		}else {
			System.out.println("찾는 이름이 없습니다.\n");
			return;
		}
	}

	private void telSelect() {
//		Set<Phone> keySet = map.keySet();
//		System.out.println("조회할 전화번호 주인을 입력하세요.");
//		System.out.print("이름 >> ");
//		String n1 = scan.nextLine();
//		
//		if(map.containsKey("name")) {
//			for(Phone name : keySet) {
//				String value = map.get(key);
//				System.out.println(key + " ==> " + value);
//			}
//			System.out.println("'" + n1 + "' 전화번호 정보 조회 완료!!\n");
//			return;
//		}else {
//			System.out.println("찾는 이름이 없습니다.\n");
//			return;
//		}
	}
	
	private void telSelectAll() {
		// TODO Auto-generated method stub
		
	}
	
	
}

class Phone{
	String name;
	String addr;
	String tel;
	
	public Phone(String name, String addr, String tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}

	public Phone(String addr, String tel) {
		super();
		this.addr = addr;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}
