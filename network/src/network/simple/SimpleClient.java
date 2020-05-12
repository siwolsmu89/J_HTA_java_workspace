package network.simple;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
	
	public static void main(String[] args) throws Exception {
		// Socket 
		//		클라이언트와 서버간의 데이터 교환을 담당하는 객체다.
		//		객체 생성시 서버의 ip 주소와 해당 서버가 사용하는 포트 번호를 지정해야 한다.
		
		System.out.println("클라이언트 프로그램 시작됨 ...");
		
		// 192.168.10.65 컴퓨터의 8000번 포트를 사용하는 서버 프로그램에 연결 요청 메시지를 보낸다.
		Socket socket = new Socket("192.168.10.65", 8000); 
		
		System.out.println("192.168.10.65의 8000번 포트에서 실행중인 서버에 연결요청을 보냄 ...");
		
		// 읽기, 쓰기 스트림 획득하기
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream();
		
		// 텍스트 데이터를 전송하기 위해서 PrintWriter와 BufferedReader 연결
		PrintWriter out = new PrintWriter(os, true);
		BufferedReader in = new BufferedReader(new InputStreamReader(is, "utf-8"));
		
		// 서버로 메시지 보내기
		out.println("권민석");
		
		// 메시지 수신하기
		String message = in.readLine();
		System.out.println("수신된 메시지: " + message);
	}
}
