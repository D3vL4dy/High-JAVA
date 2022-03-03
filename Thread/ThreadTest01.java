package kr.or.ddit.basic;

public class ThreadTest01 {

	public static void main(String[] args) {
		// 싱글쓰레드 프로그램 : 순차적 실행
		for (int i = 1; i <= 200; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println();

		for (int i = 1; i <= 200; i++) {
			System.out.print("$");
		}

	}

}
