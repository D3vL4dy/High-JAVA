package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseballTest {

	private ArrayList<Integer> numList; // 난수가 저장될 List
	private ArrayList<Integer> userList; // 사용자가 입력한 값이 저장될 List

	private int strike; // 스트라이크 개수
	private int ball; // 볼 개수가 저장될 변수

	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		BaseballTest02 b = new BaseballTest02();
//		b.gameStart();

		// => 줄여서 적으면
		new BaseballTest().gameStart();
	}

	// 게임이 시작되는 메서드
	public void gameStart() {

		// 난수 만드는 메서드 호출
		getNum();

		// 확인용
		System.out.println("컴퓨터 난수 : " + numList);

		int cnt = 0; // 몇번째만에 맞췄는지를 저장하는 변수

		do {
			cnt++;

			// 사용자로부터 입력받는 메서드 호출
			inputNum();

			// 볼 카운트 구하기
			ballCount();

		} while (strike != 3);
		System.out.println();
		System.out.println("축하합니다.");
		System.out.println("당신은 " + cnt + "번째만에 맞췄습니다.");
	}

	// 1~9사이의 서로 다른 난수 3개를 만들어서 List에 저장하는 메서드
	// (Set 이용)
	private void getNum() {
		Set<Integer> numSet = new HashSet<Integer>();

		// 1~9사이의 난수 만들기
		while (numSet.size() < 3) {
			numSet.add((int) (Math.random() * 9 + 1));
		}

		// 만들어진 난수를 List에 저장한다.
		numList = new ArrayList<Integer>(numSet); // Set의 데이터를 List에 담아 객체 생성

		// List의 데이터를 섞어준다.
		Collections.shuffle(numList);
	}

	// 사용자로부터 3개의 정수를 압력받아서 List에 저장하는 메서드
	// 입력한 정수는 중복되지 않게 한다.
	private void inputNum() {
		int n1, n2, n3; // 입력한 정수가 저장될 변수 선언

		do {
			System.out.print("숫자입력 : ");
			n1 = scan.nextInt();
			n2 = scan.nextInt();
			n3 = scan.nextInt();

			if (n1 == n2 || n1 == n3 || n2 == n3) {
				System.out.println("중복되는 숫자는 입력할 수 없습니다.");
				System.out.println("다시 입력하세요.");
			}

		} while (n1 == n2 || n1 == n3 || n2 == n3);

		// 입력한 데이터를 List에 저장한다.
		userList = new ArrayList<Integer>();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);

	}

	// 스트라이크와 볼을 판정하고 결과를 출력하는 메서드
	private void ballCount() {
		// 스트라이크와 볼의 개수를 0으로 초기화
		strike = 0;
		ball = 0;

		for (int i = 0; i < userList.size(); i++) {
			for (int j = 0; j < numList.size(); j++) {
				// 값이 같은지 검사
				if (userList.get(i) == numList.get(j)) {
					// 위치가 같은지 검사
					if (i == j) {
						strike++;
					} else {
						ball++;
					}
				}
			}
		}

		// 볼카운트 결과 출력하기
		System.out.printf("%d %d %d => %dS %dB\n", 
				numList.get(0), numList.get(1), numList.get(2), strike, ball);
	}

}
