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
import com.sample.school.vo.Subject;

public class SubjectDAO {
	
	public void addSubject(Subject subject) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("subject.addSubject"));
		pstmt.setString(1, subject.getTitle());
		pstmt.setInt(2, subject.getDept().getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public Subject resultSetToSubject(ResultSet rs) throws SQLException {
		Subject subject = new Subject();
		
		subject.setNo(rs.getInt("subject_no"));
		subject.setTitle(rs.getString("subject_title"));
		subject.setRegisteredDate(rs.getDate("subject_registered_date"));
		
		Dept dept = new Dept();
		dept.setNo(rs.getInt("dept_no"));
		subject.setDept(dept);
		
		return subject;
	}
	
	public Subject getSubjectByNo(int subjectNo) throws SQLException {
		Subject subject = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("subject.getSubjectByNo"));
		pstmt.setInt(1, subjectNo);
		
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			subject = resultSetToSubject(rs);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return subject;
	}
	
	public List<Subject> getAllSubjects() throws SQLException {
		List<Subject> allSubjects = new ArrayList<Subject>();

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("subject.getAllSubjects"));
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Subject subject = resultSetToSubject(rs);
			allSubjects.add(subject);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return allSubjects;
	}
	
	
}
