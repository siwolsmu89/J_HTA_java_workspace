package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.vo.Order;

public class OrderDAO {
	
	private Order resultSetToOrder(ResultSet rs) throws Exception {
		Order order = new Order();
		
		order.setOrderNo(rs.getInt("order_no"));
		order.setUserId(rs.getString("user_id"));
		order.setBookNo(rs.getInt("book_no"));
		order.setPrice(rs.getInt("order_price"));
		order.setAmount(rs.getInt("order_amount"));
		order.setRegistredDate(rs.getDate("order_registered_date"));
		
		return order;
	}
	
	public void addOrder(Order order) throws Exception {
		String sql = "INSERT INTO sample_book_orders "
				+ "(order_no, user_id, book_no, order_price, order_amount, order_registered_date) "
				+ "VALUES "
				+ "(sample_order_seq.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		pstmt.setString(1, order.getUserId());
		pstmt.setInt(2, order.getBookNo());
		pstmt.setInt(3, order.getPrice());
		pstmt.setInt(4, order.getAmount());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public List<Order> getOrdersByUserId(String userId) throws Exception {
		List<Order> orders = new ArrayList<Order>();
		
		String sql = "SELECT * "
				+ "FROM sample_book_orders "
				+ "WHERE user_id = ? "
				+ "ORDER BY order_no ASC ";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			orders.add(resultSetToOrder(rs));
		}
		
		return orders;
	}
	
	public Order getOrderByNo(int orderNo) throws Exception {
		Order order = null;
		
		String sql = "SELECT * "
				+ "FROM sample_book_orders "
				+ "WHERE order_no = ?";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, orderNo);
		
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			order = resultSetToOrder(rs);
		}
		
		return order;
		
	}
	
}
