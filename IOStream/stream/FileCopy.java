package kr.or.ddit.basic.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 문제) D드라이브의 d_other폴더에 있는 '펭귄.jpg'파일을 
 * D드라이브의 d_other폴더에 있는 '연습용'폴더에 
 * '펭귄_복사본.jpg'파일로 복사하는 프로그램을 작성하시오.
 */

public class FileCopy {

	public static void main(String[] args) {

		try {
			FileInputStream fin = new FileInputStream("d:/d_other/펭귄.jpg");
			BufferedInputStream bin = new BufferedInputStream(fin);
			
			FileOutputStream fout = new FileOutputStream("d:/d_other/연습용/펭귄_복사본.jpg");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			
			
			bout.flush();
			
			// 버퍼스트림의 close()는 버퍼의 내용을 모두 flush한 후에 닫아준다.
			bout.close();
			
			System.out.println("작업 끝...");
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
