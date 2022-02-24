package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/*
 * 문제) Set을 활용하여 숫자 야구 게임 프로그램을 작성하시오.
 * 		컴퓨터의 숫자는 난수를 이용해서 구한다.
 * 		(스트라이크는 S, 볼은 B로 나타낸다.)
 * 
 * 예시)
 * 		컴퓨터 난수 ==> 9 5 7
 * 실행예시)
 * 		숫자 입력 : 3 5 6
 * 		3 5 6 ==> 1S 0B
 * 		숫자 입력 : 7 8 9
 * 		7 8 9 ==> 0S 2B	
 * 		숫자 입력 : 9 7 5
 * 		9 7 5 ==> 1S 2B
 * 		숫자 입력 : 9 5 7
 * 		9 5 7 ==> 3S
 * 
 * 		축하합니다. 4번째만에 맞췄습니다.
 * 			
 */
public class BaseballTest {

	public static void main(String[] args) {
		HashSet<Integer> ballSet = new HashSet<Integer>();
		
		while (ballSet.size() < 3) {
			int random = (int)(Math.random() * 9 + 1);
			ballSet.add(random);
		}
		
		ArrayList<Integer> ballList = new ArrayList<Integer>(ballSet);
		Collections.shuffle(ballList);
		
		int S = 0;
		int B = 0;
		
		do {
			S = 0;
			B = 0;
			
			Scanner sc = new Scanner(System.in);
			System.out.print("1번 숫자를 입력하세요 > ");
			int num1 = Integer.parseInt(sc.nextLine());
			System.out.print("2번 숫자를 입력하세요 > ");
			int num2 = Integer.parseInt(sc.nextLine());
			System.out.print("3번 숫자를 입력하세요 > ");
			int num3 = Integer.parseInt(sc.nextLine());
			
			if(num1 == ballList.get(0)) S++;
			else if((num1 == ballList.get(1)) || (num1 == ballList.get(2))) B++;
			
			if(num2 == ballList.get(1)) S++;
			else if((num2 == ballList.get(0)) || (num2 == ballList.get(2))) B++;
			
			if(num3 == ballList.get(2)) S++;
			else if((num3 == ballList.get(0)) || (num3 == ballList.get(1))) B++;
			
			System.out.println(S + "S\t" + B + "B\t");
			
		}while(S!=3);
		
		System.out.println(ballList);
	}

}
