package com.sample.school.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.school.dao.CourseDAO;
import com.sample.school.dao.DeptDAO;
import com.sample.school.dao.ProfDAO;
import com.sample.school.dao.SubjectDAO;
import com.sample.school.vo.Course;
import com.sample.school.vo.Dept;
import com.sample.school.vo.Prof;
import com.sample.school.vo.Subject;

public class ProfessorService {
	
	private SubjectDAO subjectDao = new SubjectDAO();
	private CourseDAO courseDao = new CourseDAO();
	private DeptDAO deptDao = new DeptDAO();
	private ProfDAO profDao = new ProfDAO();
	
	public boolean addSubject(Subject subject) throws SQLException {
		List<Subject> allSubjects = subjectDao.getAllSubjects();
		
		if (!allSubjects.isEmpty()) {
			for (Subject savedSub : allSubjects) {
				if (savedSub.getNo() == subject.getNo()) {
					return false;
				} else if (savedSub.getDept().getNo() == subject.getDept().getNo()) {
					if(savedSub.getTitle().equals(subject.getTitle())) {
						return false;
					}
				}
			}
		}
		
		Dept dept = deptDao.getDeptByNo(subject.getDept().getNo());
		if (dept == null) {
			return false;
		}
		
		subjectDao.addSubject(subject);
		return true;
	}
	
	public Subject getSubjectByNo(int subjectNo) throws SQLException {
		Subject subject = subjectDao.getSubjectByNo(subjectNo);
		subject.setDept(deptDao.getDeptByNo(subject.getDept().getNo()));
		
		return subject;
	}
	
	public List<Subject> getAllSubjects() throws SQLException {
		List<Subject> allSubjects = subjectDao.getAllSubjects();
		
		for (Subject subject : allSubjects) {
			subject.setDept(deptDao.getDeptByNo(subject.getDept().getNo()));
		}
		
		return allSubjects;
	}
	
	public boolean addCourse(Course course) throws SQLException {
		List<Course> allCourses = courseDao.getAllCourses();
		
		if(!allCourses.isEmpty()) {
			for (Course savedCourse : allCourses) {
				if (savedCourse.getNo() == course.getNo()) {
					return false;
				} else if (savedCourse.getTitle().equals(course.getTitle())) {
					return false;
				}
			}
		}
		
		Prof prof = profDao.getProfByNo(course.getProf().getNo());
		if (prof == null) {
			return false;
		} else if (prof.getDept().getNo()!=course.getDept().getNo()) {
			return false;
		}
		
		Subject subject = subjectDao.getSubjectByNo(course.getSubject().getNo());
		if (subject == null) {
			return false;
		} else if (subject.getDept().getNo() != course.getDept().getNo()) {
			return false;
		}
		
		courseDao.addCourse(course);
		return true;
	}
	
	public Course getCourseByNo(int courseNo) throws SQLException {
		Course course = courseDao.getCourseByNo(courseNo);
		
		course.setDept(deptDao.getDeptByNo(course.getDept().getNo()));
		course.setProf(profDao.getProfByNo(course.getProf().getNo()));
		course.setSubject(subjectDao.getSubjectByNo(course.getSubject().getNo()));
		
		return course;
	}
	
	public List<Course> getAllCourses() throws SQLException {
		List<Course> allCourses = courseDao.getAllCourses();
		
		for (Course course : allCourses) {
			course.setDept(deptDao.getDeptByNo(course.getDept().getNo()));
			course.setProf(profDao.getProfByNo(course.getProf().getNo()));
			course.setSubject(subjectDao.getSubjectByNo(course.getSubject().getNo()));
		}
		
		return allCourses;
	}
}
