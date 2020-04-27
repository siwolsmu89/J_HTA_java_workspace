package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.User;

public class OrderDAO {
	
	private Order resultSetToOrder(ResultSet rs) throws Exception {
		Order order = new Order();
		User user = new User();
		Book book = new Book();
		
		user.setId(rs.getString("user_id"));
		user.setPassword(rs.getString("user_password"));
		user.setName(rs.getString("user_name"));
		user.setEmail(rs.getString("user_email"));
		user.setPoint(rs.getInt("user_point"));
		user.setRegisterdDate(rs.getDate("user_registered_date"));
		
		book.setNo(rs.getInt("book_no"));
		book.setTitle(rs.getString("book_title"));
		book.setWriter(rs.getString("book_writer"));
		book.setGenre(rs.getString("book_genre"));
		book.setPublisher(rs.getString("book_publisher"));
		book.setPrice(rs.getInt("book_price"));
		book.setDiscountPrice(rs.getInt("book_discount_price"));
		book.setStock(rs.getInt("book_stock"));
		book.setRegisteredDate(rs.getDate("book_registered_date"));

		order.setOrderNo(rs.getInt("order_no"));
		order.setUser(user);
		order.setBook(book);
		order.setPrice(rs.getInt("order_price"));
		order.setAmount(rs.getInt("order_amount"));
		order.setRegistredDate(rs.getDate("order_registered_date"));
		
		return order;
	}
	
	public void addOrder(Order order) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.addOrder"));
		
		User user = order.getUser();
		Book book = order.getBook();
		
		pstmt.setString(1, user.getId());
		pstmt.setInt(2, book.getNo());
		pstmt.setInt(3, order.getPrice());
		pstmt.setInt(4, order.getAmount());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public List<Order> getOrdersByUserId(String userId) throws Exception {
		List<Order> orders = new ArrayList<Order>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getOrdersByUserId"));
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			orders.add(resultSetToOrder(rs));
		}
		
		return orders;
	}
	
	public Order getOrderByNo(int orderNo) throws Exception {
		Order order = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getOrderByNo"));
		pstmt.setInt(1, orderNo);
		
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			order = resultSetToOrder(rs);
		}
		
		return order;
		
	}
	
}
