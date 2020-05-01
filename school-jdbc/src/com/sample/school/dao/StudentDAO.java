package com.sample.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.school.util.ConnectionUtil;
import com.sample.school.util.QueryUtil;
import com.sample.school.vo.Dept;
import com.sample.school.vo.Student;

public class StudentDAO {
	
	public Student resultSetToStudent(ResultSet rs) throws SQLException {
		Student student = new Student();
		Dept dept = new Dept();
		dept.setNo(rs.getInt("dept_no"));

		student.setNo(rs.getInt("student_no"));
		student.setName(rs.getString("student_name"));
		student.setYear(rs.getInt("student_year"));
		student.setDept(dept);
		student.setRegisteredDate(rs.getDate("student_registered_date"));
		
		return student;
	}
	
	public Student getStudentByNo(int studentNo) throws SQLException {
		Student student = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("student.getStudentByNo"));
		pstmt.setInt(1, studentNo);
		
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			student = resultSetToStudent(rs);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return student;
	}
}
