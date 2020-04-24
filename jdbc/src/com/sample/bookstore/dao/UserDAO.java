package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.vo.User;

public class UserDAO {
	
	public User resultSetToUser(ResultSet rs) throws SQLException {
		User user = new User();
		
		user.setId(rs.getString("user_id"));
		user.setPassword(rs.getString("user_password"));
		user.setName(rs.getString("user_name"));
		user.setEmail(rs.getString("user_email"));
		user.setPoint(rs.getInt("user_point"));
		user.setRegisterdDate(rs.getDate("user_registered_date"));
		
		return user;
	}

	public void addUser(User user) throws Exception {
		String sql = "INSERT INTO sample_book_users "
				+ "(user_id, user_password, user_name, user_email, user_point, user_registered_date) "
				+ "VALUES " 
				+ "(?, ?, ?, ?, ?, SYSDATE)";

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		pstmt.setInt(5, user.getPoint());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public User getUserById(String userId) throws Exception {
		User user = null;
		
		String sql = "SELECT * "
				+ "FROM sample_book_users "
				+ "WHERE user_id = ? ";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			user = resultSetToUser(rs);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return user;
	}
	
}
