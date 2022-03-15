package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TcpClient01 {

	public static void main(String[] args) throws IOException {
		// 현재 자신 컴퓨터를 나타내는 방법
		// 1) 원래의 IP주소 : 예) 192.168.34.37
		// 2) 지정된 IP주소 : 127.0.0.1 (현재 자신의 IP주소를 나타냄)
		// 3) 원래의 컴퓨터이름 : 예) DESKTOP-50C4BM9
		// 4) 지정된 컴퓨터이름 : localhost
		
		Socket socket = new Socket("192.168.34.37", 7777); // 서버와 연결된 소켓
		
		// 이 부분은 서버와 연결이 완료된 이후에 실행되는 코드이다.
		System.out.println("서버에 연결되었습니다...");
		System.out.println();
		
		// OutputStream : 상대방에게 보내기
		// InputStream : 상대방에게 받기
		
		// 서버에서 보낸 메세지를 받아서 화면에 출력하기
		InputStream is = socket.getInputStream();
		
		// 문자열 기반 메서드(readUTF)를 사용하기 위해 DataOutputStream 보조스트림 사용
		// 보낼 때 DataOutputStream를 사용했기 때문에 받을때도 맞춰줌
		DataInputStream dis = new DataInputStream(is);
		
		// 서버가 보낸 데이터를 받아서 출력하기
		System.out.println("서버에서 보낸 메세지 : " + dis.readUTF());
		System.out.println();
		
		System.out.println("연결을 종료합니다.");
		dis.close();
		socket.close();

	}

}
