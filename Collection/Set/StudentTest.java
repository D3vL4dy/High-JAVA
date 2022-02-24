package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 문제) 학번, 이름(String), 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
 * 	    이 Student클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 한다.
 *      이 클래스는 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현한다.
 *      
 *      이 Student객체는 List에 저장하여 관리한다.
 *      
 *      List에 저장된 Student 객체를 총점의 역순으로 정렬하는데 총점이 같으면 
 *      이름의 오름차순으로 정렬이되는 외부 정렬 기준 클래스도 작성하시오.
 *      
 *      (단, 등수는 List에 전체 데이터가 모두 저장된 후에 구한다.)
 */

public class StudentTest {
	// 등수를 구하는 메서드
	public void setRanking(List<Student> stdList) { // static이 붙지 않아 main에서 직접 호출할 수 없음
		// 기준이 되는 데이터를 위한 반복문 (등수를 구할 값)
		for (Student std1 : stdList) { // List 수 만큼 비교하는 반복문
			int rank = 1; // 처음에는 등수를 1로 초기화

			// 비교 대상을 찾기 위한 반복문
			for (Student std2 : stdList) {

				// 기준보다 큰 값을 만나면 rank값을 증가
				if (std1.getSum() < std2.getSum()) { // std1.getSum()이 기준
					rank++;
				}
			}
			// 구해진 등수를 Student 객체의 rank변수에 저장한다.
			std1.setRank(rank);
		}

	}

	public static void main(String[] args) {
		StudentTest test = new StudentTest(); // 인스턴스 메서드인 StudentTest의 객체 생성

		List<Student> stdList = new ArrayList<Student>();
		stdList.add(new Student(1, "강정인", 100, 100, 100));
		stdList.add(new Student(4, "김정인", 90, 95, 75));
		stdList.add(new Student(5, "이정인", 80, 85, 90));
		stdList.add(new Student(2, "오정인", 80, 100, 85));
		stdList.add(new Student(3, "노정인", 85, 70, 95));

		// 등수를 구하는 메서드 호출
		test.setRanking(stdList);

		System.out.println("정렬 전");
		for (Student std : stdList) {
			System.out.println(std);
		}
		System.out.println();

		// 학번의 오름차순으로 정렬하기
		Collections.sort(stdList); //

		System.out.println("학번의 오름차순 정렬 후");
		for (Student std : stdList) {
			System.out.println(std);
		}
		System.out.println();

		// 총점의 역순으로 정렬하기
		Collections.sort(stdList, new SortBySum());
		
		System.out.println("총점의 내림차순 정렬 후");
		for (Student std : stdList) {
			System.out.println(std);
		}
		System.out.println();
	}

}

class Student implements Comparable<Student> { // 내부 정렬 기준
	private int hakbun; // 학번
	private String name; // 이름
	private int kor; // 국어점수
	private int eng; // 영어점수
	private int math; // 수학점수
	private int sum; // 총점
	private int rank; // 등수

	// 자동 생성(Alt + Shift + s)
	public Student(int hakbun, String name, int kor, int eng, int math) {
		super();
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		sum = kor + eng + math;
	}

	public int getHakbun() {
		return hakbun;
	}

	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [hakbun=" + hakbun + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", sum=" + sum + ", rank=" + rank + "]";
	}

	// 학번의 오름차순의 내부 정렬 기준 만들기
	@Override
	public int compareTo(Student std) {
		return Integer.compare(hakbun, std.getHakbun());
	}
}

// 총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이되는 외부 정렬 기준 클래스
class SortBySum implements Comparator<Student> {
	@Override
	public int compare(Student std1, Student std2) {
		if (std1.getSum() == std2.getSum()) { // 총점이 같으면 이름의 오름차순으로 정렬
			return std1.getName().compareTo(std2.getName());
		} else { // 총점의 역순으로 정렬
//			return Integer.compare(std1.getSum(), std2.getSum()) * -1;
			return new Integer(std1.getSum()).compareTo(std2.getSum()) * -1; //compareTo는 new 사용
		}
	}

}
