package kr.or.ddit.basic;
/*
 * 문제) 5명의 사람 이름을 입력받아 ArrayList에 저장한 후 이들 중 '김'씨 성의 이름을 모두 출력하시오.
 *      (입력은 Scanner객체를 이용한다.)
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<String>();
		
		System.out.println("5명의 이름을 입력하세요.");
		for(int i = 1; i <= 5; i++) {
			System.out.print(i + "번째 사람 이름 : ");
			String name = sc.next();
			nameList.add(name);
		}
		
		System.out.println();
		System.out.println("김씨 성을 가진 사람들...");
		
		// 방법1
		for(int i = 0; i < nameList.size(); i++) {
			if(nameList.get(i).substring(0, 1).equals("김")) {
				System.out.println(nameList.get(i));
			}
		}
		
		// 방법2 (charAt() : 특정 인덱스에 위치한 문자를 반환)
//		if(nameList.get(i).charAt(0)=='김') { 
//			System.out.println(nameList.get(i));
//		}
		
		// 방법3 (indexOf(비교객체) : 앞에서 뒤쪽으로 가면서 자리 검사)
//		if(nameList.get(i).indexOf("김")==0) { 
//			System.out.println(nameList.get(i));
//		}
		
		// 방법4 (startsWith(비교객체)특정 문자 또는 문자열로 시작하는지 체크)
//		if(nameList.get(i).startsWith("김")==true) { // boolean값 반환
//			System.out.println(nameList.get(i)); 
//		}
	}
}
