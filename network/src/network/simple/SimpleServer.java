package network.simple;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	
	public static void main(String[] args) throws Exception {
		// ServerSocket
		//		클라이언트의 연결요청을 기다리는 객체다.
		//		클라이언트의 연결요청이 접수되면 해당 클라이언트와 데이터 교환을 담당하는 Socket 객체를 반환한다.
		// 8000번 포트로 들어오는 클라이언트의 연결요청을 기다리는 서버소켓 생성
		System.out.println("서버 프로그램 시작됨 ...");
		
		ServerSocket server = new ServerSocket(8000);
		System.out.println("클라이언트의 연결요청을 대기중 ...");
		
		// 서버소켓의 accept() 메소드는 클라이언트의 연결이 접수되면 실행되는 메소드다.
		// 클라이언트의 연결요청이 접수되면 accept()가 실행되고, 연결은 요청한 클라이언트와 데이터 교환을 할 Socket 객체가 제공된다.
		Socket socket = server.accept();
		System.out.println("클라이언트의 연결요청을 받음 ...");
		
		// 읽고 쓰기 스트림 획득
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(is, "utf-8"));
		PrintWriter out = new PrintWriter(os, true); 
		
		// 메시지 수신하기
		String message = in.readLine();
		
		// 클라이언트로 메시지 보내기
		out.println(message + "님 반갑습니다.");
	}
}
