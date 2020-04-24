package hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo3 {

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	private static String nextString() throws Exception {
		return reader.readLine();
	}
	
	private static int nextInt() throws Exception {
		return Integer.parseInt(reader.readLine());
	}
	
	private static String typeSql() throws Exception {
		String sql="";
		while(true) {
			System.out.print("SQL문을 입력하세요:");
			String next = reader.readLine();
			sql += " " + next;
			if (sql.contains(";")) {
				break;
			}
		}
		sql = sql.substring(0, sql.length()-1);
		return sql;
	}
	
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
//		String sql = "SELECT * "
//				+ "FROM sample_books "
//				+ "WHERE book_title like '%' || ? || '%' "
//				+ "ORDER BY book_no DESC";

		String sql = typeSql();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		if (sql.contains("?")) {
			System.out.println("[도서 검색하기]");
			System.out.print("입력값 순번: ");
			int count = nextInt();
			System.out.print("검색어 입력: ");
			String keyword = nextString();
			pstmt.setString(count, keyword);
		}
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int no = rs.getInt("book_no");
			String title = rs.getString("book_title");
			String writer = rs.getString("book_writer");
			String genre = rs.getString("book_genre");
			String publisher = rs.getString("book_publisher");
			int price = rs.getInt("book_price");
			int discountPrice = rs.getInt("book_discount_price");
			Date registeredDate = rs.getDate("book_registered_date");
			
			System.out.print(no+", ");
			System.out.print(title+", ");
			System.out.print(writer+", ");
			System.out.print(genre+", ");
			System.out.print(publisher+", ");
			System.out.print(price+", ");
			System.out.print(discountPrice+", ");
			System.out.print(registeredDate);
			System.out.println();
		}
		
		rs.close();
		pstmt.close();
		connection.close();
	}
	
}
