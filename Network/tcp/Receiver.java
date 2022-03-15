package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

// 받는 쓰레드
public class Receiver extends Thread {
	private Socket socket;
	private DataInputStream dis; // 받기

	// 생성자
	public Receiver(Socket socket) {
		this.socket = socket;
		try {
			dis = new DataInputStream(this.socket.getInputStream());
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	@Override
	public void run() {
		while (dis != null) {
			try {
				// 상대방이 보낸 메시지 출력
				System.out.println(dis.readUTF());
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}

}
