package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 *  문제) 5명의 사람 이름을 입력받아 AraryList에 저장한 후 이들 중 '김'씨 성의 이름을 모두 출력하시오.
 *  (입력은 Scanner객체를 이용한다.)
 */
public class ArrayListTest02 {

	public static void main(String[] args) {

		ArrayList<String> name = new ArrayList<String>();
		System.out.println("5명의 이름을 입력하세요 > ");
		
		Scanner scanner = new Scanner(System.in);
		String name1 = scanner.nextLine();
		String name2 = scanner.nextLine();
		String name3 = scanner.nextLine();
		String name4 = scanner.nextLine();
		String name5 = scanner.nextLine();
		
		name.add(name1);
		name.add(name2);
		name.add(name3);
		name.add(name4);
		name.add(name5);
		
	}

}
