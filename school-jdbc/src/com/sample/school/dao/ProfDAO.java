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
import com.sample.school.vo.Prof;

public class ProfDAO {

	public void addProf(Prof prof) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("prof.addProf"));
		pstmt.setString(1, prof.getName());
		pstmt.setString(2, prof.getPosition());
		pstmt.setInt(3, prof.getDept().getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void updateProf(Prof prof) {
		
	}
	
	public void removeProf(Prof prof) {
		
	}
	
	public Prof resultSetToProf(ResultSet rs) throws SQLException {
		Prof prof = new Prof();
		Dept dept = new Dept();
		dept.setNo(rs.getInt("dept_no"));
		
		prof.setNo(rs.getInt("prof_no"));
		prof.setName(rs.getString("prof_name"));
		prof.setPosition(rs.getString("prof_position"));
		prof.setDept(dept);
		prof.setRegisteredDate(rs.getDate("prof_registered_date"));
		
		return prof;
	}
	
	public Prof getProfByNo(int profNo) throws SQLException {
		Prof prof = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("prof.getProfByNo"));
		pstmt.setInt(1, profNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			prof = resultSetToProf(rs);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		return prof;
	}
	
	public List<Prof> getAllProfs() throws SQLException {
		List<Prof> allProfs = new ArrayList<Prof>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("prof.getAllProfs"));
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Prof prof = resultSetToProf(rs);
			allProfs.add(prof);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return allProfs;
	}
}
