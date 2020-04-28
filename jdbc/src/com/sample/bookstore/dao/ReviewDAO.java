package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Review;
import com.sample.bookstore.vo.User;

public class ReviewDAO {
	
	public Review resultSetToReview(ResultSet rs) throws SQLException {
		Review review = new Review();

		int no = rs.getInt("review_no");
		String content = rs.getString("review_content");
		double point = rs.getDouble("review_point");
		Date registeredDate = rs.getDate("review_registered_date");
		
		Book book = new Book();
		int bookNo = rs.getInt("book_no");
		book.setNo(bookNo);
		User user = new User();
		String userId = rs.getString("user_id");
		user.setId(userId);
		
		review.setNo(no);
		review.setContent(content);
		review.setPoint(point);
		review.setRegisteredDate(registeredDate);
		review.setBook(book);
		review.setUser(user);
		
		return review;
	}
	
	public void addReview(Review review) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.addReview"));
		
		pstmt.setString(1, review.getContent());
		pstmt.setDouble(2, review.getPoint());
		pstmt.setInt(3, review.getBook().getNo());
		pstmt.setString(4, review.getUser().getId());
		pstmt.executeUpdate();

		pstmt.close();
		connection.close();
	}
	
	public List<Review> getMyReviews(String userId) throws SQLException{
		List<Review> myReviews = new ArrayList<Review>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.getMyReviews"));
		pstmt.setString(1, userId);

		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			myReviews.add(resultSetToReview(rs));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return myReviews;
	}
	
	public List<Review> getAllReviews() throws SQLException {
		List<Review> allReviews = new ArrayList<Review>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.getAllReviews"));
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			allReviews.add(resultSetToReview(rs));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return allReviews;
	}
	
	public Review getReviewByNo(int reviewNo) throws SQLException {
		Review review = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.getReviewByNo"));
		pstmt.setInt(1, reviewNo);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			review = resultSetToReview(rs);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return review;
	}
	
	public boolean updateReview() {
		return false;
	}
	
	public void removeReview(Review review) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.removeReview"));
		pstmt.setInt(1, review.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
}
