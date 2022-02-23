package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 정렬과 관련된 interface는 Comparable, Comparator 2가지 있다.
 * Comaprable은 Collection에 추가되는 데이터 자체에 정렬 기준을 넣고 싶을 때 
 * 즉, 내부 정렬 기준을 구현하는 인터페이스이고,
 * 
 * Comparator는 외부에 별도로 정렬 기준을 구현하고 싶을 때 즉, 
 * 외부 정렬 기준을 구현할 때 사용하는 인터페이스 이다.
 * 
 * Comparable에서는 compareTo() 메서드를 재정의 해야 하고,
 * Comparator에서는 compare() 메서드를 재정의 해야 한다.
 * 
 * String클래스, Wrapper클래스, Date클래스, File클래스 등에는 내부 정렬 기준이 이미 구현되어 있다.
 * (내부 정렬 기준은 오름차순으로 처리되도록 구현되어 있다.)
 */

public class ListSortTest {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();

		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");

		System.out.println("정렬전 : " + list);

		// 정렬은 Collections.sort() 메서드를 이용하여 정렬한다.
		// Collections.sort() 메서드는 정렬할 데이터의 '내부 정렬 기준'을 바탕으로 정렬한다.
		// 보통의 '내부 정렬 기준'은 오름차순으로 정렬되도록 구현되어 있다.

		Collections.sort(list);

		System.out.println("정렬 후 : " + list);

		Collections.shuffle(list); // 자료 섞기
		System.out.println("자료 섞기 후 : " + list);
		System.out.println();

		// 외부 정렬 기준을 지정해서 정렬하기
		Collections.sort(list, new Desc()); // 외부 정렬 기준 객체를 생성해서 넣기
		System.out.println("내림차순 정렬 후 : " + list);
	}

}

// 외부 정렬 기준을 정해주는 class
class Desc implements Comparator<String> {

	// 정렬하는 기준을 설정하는 compare() 메서드 재정의 하기

	// compare() 메서드의 반환 값의 역할
	// 반환 값이 0 일 때 ==> 두 값이 서로 같다.
	// 반환 값이 양수 일 때 ==> 두 값의 순서가 바뀐다.
	// 반환 값이 음수 일 때 ==> 두 값의 순서가 바뀌지 않는다.

	// 오름차순 정렬일 경우 
	// ==> 앞의 값이 크면 양수
	// ==> 앞의 값이 같으면 0
	// ==> 앞의 값이 작으면 음수가 반환되도록 구현하면 된다.
	@Override
	public int compare(String str1, String str2) {
		// 내림차순으로 정렬하는 기준 만들기

		// 방법1
//		if (str1.compareTo(str2) < 0) {
//			return 1; // 양수 아무거나 반환하면 되는데 보통 1을 적는다.
//		} else if (str1.compareTo(str2) > 0) { // str2가 더 작을 때
//			return -1; // 이미 내림차순이므로 순서를 바꾸지 않는다.
//		} else {
//			return 0;
//		}

		// 방법2
		return str1.compareTo(str2) * -1;
	}
}
