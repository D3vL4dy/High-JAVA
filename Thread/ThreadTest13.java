package thread;

/*
 * 10마리의 말들이 경주하는 경마 프로그램 작성하기
 * 
 * 말은 Horse라는 이름의 쓰레드 클래스로 작성하는데 
 * 이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
 * 그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 있다.
 * (Compare인터페이스 구현)
 * 
 * 경기 구간은 1 ~ 50 구간으로 되어 있다.
 * 
 * 경기가 끝나면 등수 순으로 출력한다.
 * 
 * 경기가 진행 중일때는 중간 중간에 말들의 위치를 아래와 같이 나타낸다. 
 * 예) (출력도 하나의 쓰레드)
 * 01번말 : ----10---------------------
 * 02번말 : ---------15----------------
 * ...
 * 10번말 : -------13------------------
 */

public class ThreadTest13 {

	public static void main(String[] args) {
		Horse[] horse = new Horse[] { new Horse("1번"), new Horse("2번"), new Horse("3번"), new Horse("4번"), new Horse("5번"),
				new Horse("6번"), new Horse("7번"), new Horse("8번"), new Horse("9번"), new Horse("10번") };

		for (Horse hs : horse) {
			hs.start();
		}

		// 모든 사람의 출력이 끝날 때까지 기다린다.
		for (Horse hs : horse) {
			try {
				hs.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println();
		System.out.println("경기 결과");
		System.out.println("순위 : " + Horse.rank);

	}

}

// 말 쓰레드
class Horse extends Thread {
	public static String name;
	public int location;
	public static int rank;
	

	public Horse(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			System.out.println(name + "의 위치 : " + location);
				location += i;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
		}
		System.out.println(name + "출력 끝.......................");
	}
}

// 경기 구간 출력 쓰레드
class PrintLocation extends Thread {
//	public int location;
	public String lane;

	@Override
	public void run() {
		for (int j = 0; j < 10; j++) {

			for (int i = 1; i <= 50; i++) {
				lane += "-";
				try {
					Thread.sleep((int) (Math.random() * 50 + 1));
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
		}
		System.out.println(Horse.name + "의 위치" + Horse.location);
		
	}
}