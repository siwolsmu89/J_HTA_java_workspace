package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		// 1. JDBC 드라이버를 JVM 드라이버 레지스트리에 등록하기
		Class.forName("oracle.jdbc.OracleDriver");	// 지정된 클래스파일을 메모리에 로딩
		Scanner scanner = new Scanner(System.in);
		System.out.print("등급을 입력하세요: ");
		String grade = scanner.next();
		
		// 2. 데이터베이스와 연결을 담당하는 Connection 객체 획득하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);
		
		// 3. SQL 실행, 결과값 반환을 담당하는 PreparedStatement 객체 획득하기
		// ?는 바인딩 변수 - 값이 들어갈 자리
		String sql = "SELECT gra, lowest_sal, highest_sal FROM job_grades WHERE gra = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		// 바인딩 변수에 값을 입력해줌
		pstmt.setString(1, grade);
		
		// 4. SQL 실행하고, 조회결과 획득하기
		ResultSet rs = pstmt.executeQuery();
		
		// 5. 조회결과 가져오기
		System.out.println("---------------------");
		System.out.println("grade\tlow\thigh");
		System.out.println("---------------------");
		while(rs.next()) {
			String gra = rs.getString("gra");
			int lowest_sal = rs.getInt("lowest_sal");
			int highest_sal = rs.getInt("highest_sal");
			
			System.out.println(gra+"\t"+lowest_sal+"\t"+highest_sal);
		}
		System.out.println("---------------------");

		// 6. 데이터베이스와 연결된 모든 자원 해제하기, 획득한 순서의 역순으로 해제
		rs.close();
		pstmt.close();
		connection.close();
		scanner.close();
		
	}
}
