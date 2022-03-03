package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 * 
 * 컴퓨터의 가위 바위 보는 난수를 이용해서 구하고,
 * 사용자의 가위 바위 보는 showInputDialog()를 이용해서 입력 받는다.
 * 
 * 입력 시간은 5초로 제한하고 카운트다운을 진행한다.
 * 5초 안에 입력이 없으면 게임에 진것으로 처리한다.
 * 
 * 5초 안에 입력이 있으면 승패를 구해서 출력한다.
 * 
 * 
 * 결과 예시)
 *  1) 5초 안에 입력이 없을 때
 *    - 결 과 -
 *   시간 초과로 당신이 졌습니다.
 *   
 *  2) 5초 안에 입력이 있을 때
 *    - 결 과 -
 *   컴퓨터 : 가위
 *   당 신 : 바위
 *   결 과 : 당신이 이겼습니다.   
 */

public class ThreadTest07 {

	public static void main(String[] args) {

		Thread th1 = new Computer();
		Thread th2 = new UserInput();
		Thread th3 = new Time();
		th1.start();
		th2.start();
		th3.start();
	}

}

// 컴퓨터의 가위바위보 생성 쓰레드
class Computer extends Thread{
	public static String com;
	@Override
	public void run() {
		int random = (int)(Math.random() * 3 + 1);
		if(random == 1) {
			com = "가위";
		}else if(random == 2){
			com = "바위";
		}else {
			com = "보";
		}
		
	}
}

// 사용자가 입력하는 쓰레드
class UserInput extends Thread{
	
	public static boolean inputCheck = false;
	public static String user;
	
	@Override
	public void run() {
		user = JOptionPane.showInputDialog("가위 바위 보를 입력하세요.");
		inputCheck = true;
//		System.out.println("입력값 : " + user);
	}
}

// 카운트다운을 하는 쓰레드
class Time extends Thread {

	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			System.out.println(i);
			if (UserInput.inputCheck == true) {
				if (Computer.com.equals(UserInput.user)) {
					System.out.println("비겼습니다.");
				} else {
					if ((Computer.com.equals("가위") && UserInput.user.equals("바위"))
							|| (Computer.com.equals("바위") && UserInput.user.equals("보"))
							|| (Computer.com.equals("보") && UserInput.user.equals("가위"))) {
						System.out.println("당신이 이겼습니다.");
					} else if ((Computer.com.equals("바위") && UserInput.user.equals("가위"))
							|| (Computer.com.equals("가위") && UserInput.user.equals("보"))
							|| (Computer.com.equals("보") && UserInput.user.equals("바위"))) {
						System.out.println("당신이 졌습니다.");
					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		System.out.println("시간 초과로 당신이 졌습니다.");
		System.exit(0);
	}
}

// 결과를 출력하는 쓰레드
