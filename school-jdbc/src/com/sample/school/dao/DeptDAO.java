package com.sample.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.school.util.ConnectionUtil;
import com.sample.school.util.QueryUtil;
import com.sample.school.vo.Dept;

public class DeptDAO {

	public void addDept(Dept dept) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("dept.addDept"));
		pstmt.setString(1, dept.getName());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void updateDept(Dept dept) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("dept.updateDept"));
		pstmt.setString(1, dept.getName());
		pstmt.setInt(2, dept.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void removeDept(Dept dept) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("dept.removeDept"));
		pstmt.setInt(1, dept.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public Dept resultSetToDept(ResultSet rs) throws SQLException {
		Dept dept = new Dept();
		
		dept.setNo(rs.getInt("dept_no"));
		dept.setName(rs.getString("dept_name"));
		
		return dept;
	} 
	
	public Dept getDeptByNo(int deptNo) throws SQLException {
		Dept dept = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("dept.getDeptByNo"));
		pstmt.setInt(1, deptNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			dept = resultSetToDept(rs);
		}
		
		rs.close();
		pstmt.close();
		connection.close();

		return dept;
	}
	
	public Dept getDeptByName(String deptName) throws SQLException {
		Dept dept = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("dept.getDeptByName"));
		pstmt.setString(1, deptName);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			dept = resultSetToDept(rs);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return dept;
	}
	
	public List<Dept> getAllDepts() throws SQLException {
		List<Dept> allDepts = new ArrayList<Dept>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("dept.getAllDepts"));

		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Dept dept = resultSetToDept(rs);
			allDepts.add(dept);
		}
		
		rs.close();
		pstmt.close();
		connection.close();

		
		return allDepts;
	}
	
}
