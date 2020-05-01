package com.sample.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.school.util.ConnectionUtil;
import com.sample.school.util.QueryUtil;
import com.sample.school.vo.Course;
import com.sample.school.vo.Reg;
import com.sample.school.vo.Student;

public class RegDAO {
	
	public void addReg(Reg reg) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reg.addReg"));
		pstmt.setInt(1, reg.getCourse().getNo());
		pstmt.setInt(2, reg.getStudent().getNo());
		
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void removeReg(int regNo) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reg.removeReg"));
		pstmt.setInt(1, regNo);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void updateReg(Reg reg) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reg.updateReg"));
		
		/*
		 * course_no = ? \
			  	, student_no = ? \
			  	, reg_canceled = ? \
			  	, reg_completed = ? \
			  	, reg_grade = ? \
			  WHERE reg_no = ?	
		 */
		String cancel = "N";
		if (reg.isCanceled()) {
			cancel = "Y";
		}
		String complete = "N";
		if (reg.isCompleted()) {
			complete = "Y";
		}
		
		pstmt.setInt(1, reg.getCourse().getNo());
		pstmt.setInt(2, reg.getStudent().getNo());
		pstmt.setString(3, cancel);
		pstmt.setString(4, complete);
		pstmt.setInt(5, reg.getGrade());
		pstmt.setInt(6, reg.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public Reg resultSetToReg(ResultSet rs) throws SQLException {
		Reg reg = new Reg();
		
		boolean isCanceled = false;
		if (rs.getString("reg_canceled").equalsIgnoreCase("Y")) {
			isCanceled = true;
		}
		boolean isCompleted = false;
		if (rs.getString("reg_canceled").equalsIgnoreCase("Y")) {
			isCompleted = true;
		}
		
		Course course = new Course();
		course.setNo(rs.getInt("course_no"));
		
		Student student = new Student();
		student.setNo(rs.getInt("student_no"));
		
		reg.setNo(rs.getInt("reg_no"));
		reg.setCanceled(isCanceled);
		reg.setCompleted(isCompleted);
		reg.setCourse(course);
		reg.setStudent(student);
		reg.setGrade(rs.getInt("reg_grade"));
		reg.setRegisteredDate(rs.getDate("reg_registered_date"));
		
		return reg;
	}
	
	public Reg getRegByNo(int regNo) throws SQLException {
		Reg reg = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reg.getRegByNo"));
		pstmt.setInt(1, regNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			reg = resultSetToReg(rs);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return reg;
	}
	
	public List<Reg> getMyRegs(int studentNo) throws SQLException {
		List<Reg> myRegs = new ArrayList<Reg>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reg.getMyRegs"));
		pstmt.setInt(1, studentNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Reg reg = resultSetToReg(rs);
			myRegs.add(reg);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return myRegs;
	}
	
	public List<Reg> getAllRegs() throws SQLException {
		List<Reg> allRegs = new ArrayList<Reg>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reg.getAllRegs"));
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Reg reg = resultSetToReg(rs);
			allRegs.add(reg);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return allRegs;
	}
	
}
