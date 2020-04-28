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
import com.sample.bookstore.vo.Like;
import com.sample.bookstore.vo.User;

public class LikeDAO {
	
	public Like resultSetToLike(ResultSet rs) throws SQLException {
		Like like = new Like();
		
		Book book = new Book();
		book.setNo(rs.getInt("book_no"));
		like.setBook(book);
		
		User user = new User();
		user.setId(rs.getString("user_id"));
		like.setUser(user);

		return like;
	}
	
	public void addLike(Like like) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("like.addLike"));
		pstmt.setInt(1, like.getBook().getNo());
		pstmt.setString(2, like.getUser().getId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public List<Like> getMyLikes(String userId) throws SQLException {
		ArrayList<Like> myLikes = new ArrayList<Like>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("like.getMyLikes"));
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Like like = resultSetToLike(rs);
			myLikes.add(like);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return myLikes;
	}  
	
	public List<Like> getAllLikes() throws SQLException{
		ArrayList<Like> allLikes = new ArrayList<Like>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("like.getAllLikes"));
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Like like = resultSetToLike(rs);
			allLikes.add(like);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return allLikes;
	}
	
	public void removeLike(Like like) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("like.removeLike"));
		pstmt.setInt(1, like.getBook().getNo());
		pstmt.setString(2, like.getUser().getId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
}
