package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Book;

/**
 * SAMPLE_BOOK 테이블에 대한 데이터 엑세스 기능을 지원하는 클래스다.
 * 
 * @author JHTA
 *
 */
public class BookDAO {

	public Book resultSetToBook(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setNo(rs.getInt("book_no"));
		book.setTitle(rs.getString("book_title"));
		book.setWriter(rs.getString("book_writer"));
		book.setGenre(rs.getString("book_genre"));
		book.setPublisher(rs.getString("book_publisher"));
		book.setDiscountPrice(rs.getInt("book_price"));
		book.setPrice(rs.getInt("book_discount_price"));
		book.setRegisteredDate(rs.getDate("book_registered_date"));
		book.setStock(rs.getInt("book_stock"));

		return book;
	}

	public List<Book> resultSetToBookList(ResultSet rs) throws SQLException {
		List<Book> books = new ArrayList<Book>();
	
		while (rs.next()) {
			books.add(resultSetToBook(rs));
		}

		return books;
	}

	/**
	 * 전달받은 책 정보를 데이터베이스에 저장한다.
	 * 
	 * @param book 등록할 책정보를 포함하고 있는 Book 객체
	 * @throws Exception
	 */
	public void addBook(Book book) throws Exception {
		String sql = "INSERT INTO sample_books "
				+ "(book_no, book_title, book_writer, book_genre, book_publisher, book_price, book_discount_price, book_registered_date) "
				+ "VALUES " + "(sample_book_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, SYSDATE)";

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getWriter());
		pstmt.setString(3, book.getGenre());
		pstmt.setString(4, book.getPublisher());
		pstmt.setInt(5, book.getPrice());
		pstmt.setInt(6, book.getDiscountPrice());
		pstmt.executeUpdate();

		pstmt.close();
		connection.close();
	}

	/**
	 * 지정된 번호에 해당하는 책 정보를 반환한다.
	 * @param no 조회할 책 번호
	 * @return 조회된 책 정보가 없으면 null이 반환된다.
	 * @throws Exception
	 */
	public Book getBookByNo(int no) throws Exception {
		Book book = null;

		String sql = "SELECT * " 
				+ "FROM sample_books " 
				+ "WHERE book_no = ? ";

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, no);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			book = resultSetToBook(rs);
		}
		
		rs.close();
		pstmt.close();
		connection.close();

		return book;
	}

	/**
	 * 저장된 모든 책을 반환한다.
	 * @return 책 정보를 담고 있는 List 객체
	 * @throws SQLException
	 */
	public List<Book> getAllBooks() throws SQLException {
		List<Book> books = new ArrayList<Book>();

		String sql = "SELECT * " 
				+ "FROM sample_books " 
				+ "ORDER BY book_no DESC";

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		books = resultSetToBookList(rs);

		rs.close();
		pstmt.close();
		connection.close();

		return books;
	}

	public List<Book> getBooksByTitle(String title) throws Exception {
		List<Book> books = new ArrayList<Book>();

		String sql = "SELECT * "
				+ "FROM sample_books "
				+ "WHERE book_title like '%'||?||'%' "
				+ "ORDER BY book_no DESC";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, title);

		ResultSet rs = pstmt.executeQuery();
		books = resultSetToBookList(rs);

		rs.close();
		pstmt.close();
		connection.close();

		return books;
	}

	public List<Book> getBooksByGenre(String genre) throws Exception {
		List<Book> books = new ArrayList<Book>();

		String sql = "SELECT * " 
				+ "FROM sample_books " 
				+ "WHERE book_genre like '%'||?||'%' "
				+ "ORDER BY book_no DESC";

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, genre);

		ResultSet rs = pstmt.executeQuery();
		books = resultSetToBookList(rs);

		rs.close();
		pstmt.close();
		connection.close();

		return books;
	}

	public List<Book> getBooksByPriceRange(int minPrice, int maxPrice) throws Exception {
		List<Book> books = new ArrayList<Book>();

		String sql = "SELECT * " 
				+ "FROM sample_books " 
				+ "WHERE (book_price BETWEEN ? AND ?) "
				+ "ORDER BY book_no DESC";

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, minPrice);
		pstmt.setInt(2, maxPrice);

		ResultSet rs = pstmt.executeQuery();
		books = resultSetToBookList(rs);

		rs.close();
		pstmt.close();
		connection.close();

		return books;
	}

	/**
	 * 지정된 책 번호에 해당하는 책 정보를 데이터베이스에서 삭제한다.
	 * @param no 삭제할 책 번호
	 * @throws Exception
	 */
	public void removeBookByNo(int no) throws Exception {
		String sql = "DELETE "
				+ "FROM sample_books "
				+ "WHERE book_no = ? ";

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.execute();
		
		pstmt.close();
		connection.close();
	}

	/**
	 * 지정된 책 정보에 해당하는 책 정보를 변경한다.
	 * @param book 변경할 책 정보가 포함된 Book 객체
	 * @throws Exception
	 */
	public void updateBook(Book book) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("book.updateBook"));
		
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getWriter());
		pstmt.setString(3, book.getGenre());
		pstmt.setString(4, book.getPublisher());
		pstmt.setInt(5, book.getPrice());
		pstmt.setInt(6, book.getDiscountPrice());
		pstmt.setInt(7, book.getStock());
		pstmt.setInt(8, book.getNo());
		
		pstmt.execute();
		
		pstmt.close();
		connection.close();
	}

}
