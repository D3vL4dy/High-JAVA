package kr.or.ddit.basic.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedIOTest02 {

	public static void main(String[] args) {
		// 문자 기반의 Buffered스트림 사용 예제
		try {
			// 'FileTest01.java'파일을 읽어와 출력하기
//			FileReader fr = new FileReader("D:\\A_TeachingMaterial\\03_HighJava\\workspace\\javaIOTest\\src\\kr\\or\\ddit\\basic"); // 절대경로
			
			// D:\\A_TeachingMaterial\\03_HighJava\\workspace\\javaIOTest\\ ==> 지금 사용하고 있는 현재 프로젝트 위치까지 지우기
			FileReader fr = new FileReader("./src/kr/or/ddit/basic/FileTest01.java"); // 상대경로
			BufferedReader br = new BufferedReader(fr); // Buffer의 크기를 지정하지 않으면 8KB
			
			String temp = ""; // 읽어온 문자열을 저장할 변수
			/*
			for(int i = 1; (temp = br.readLine()) != null; i++) {
				System.out.printf("%4d : %s\n", i, temp);
			}
			*/
			 int i = 1;
			 while((temp = br.readLine()) != null) {
				 System.out.printf("%4d : %s\n", i, temp);
				 i++;
			 }
			
			br.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
