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
import com.sample.school.vo.Dept;
import com.sample.school.vo.Prof;
import com.sample.school.vo.Subject;

public class CourseDAO {
	
	public void addCourse(Course course) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("course.addCourse"));
		pstmt.setString(1, course.getTitle());
		pstmt.setInt(2, course.getDept().getNo());
		pstmt.setInt(3, course.getSubject().getNo());
		pstmt.setInt(4, course.getProf().getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public Course resultSetToCourse(ResultSet rs) throws SQLException {
		Course course = new Course();
		
		boolean registerable = true;
		if(rs.getString("course_registerable").equalsIgnoreCase("N")) {
			registerable = false;
		}
		
		Dept dept = new Dept();
		dept.setNo(rs.getInt("dept_no"));
		
		Prof prof = new Prof();
		prof.setNo(rs.getInt("prof_no"));
		
		Subject subject = new Subject();
		subject.setNo(rs.getInt("subject_no"));
		
		course.setNo(rs.getInt("course_no"));
		course.setTitle(rs.getString("course_title"));
		course.setDept(dept);
		course.setSubject(subject);
		course.setProf(prof);
		course.setStudentCount(rs.getInt("course_student_count"));
		course.setRegisterable(registerable);
		course.setRegisteredDate(rs.getDate("course_registered_date"));
		return course;
	}
	
	public Course getCourseByNo(int courseNo) throws SQLException {
		Course course = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("course.getCourseByNo"));
		pstmt.setInt(1, courseNo);
		
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			course = resultSetToCourse(rs);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		return course;
	}
	
	public List<Course> getAllCourses() throws SQLException {
		List<Course> allCourses = new ArrayList<Course>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("course.getAllCourses"));
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Course course = resultSetToCourse(rs);
			allCourses.add(course);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return allCourses;
	}
	
}
