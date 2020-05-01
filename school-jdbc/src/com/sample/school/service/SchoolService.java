package com.sample.school.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.school.dao.CourseDAO;
import com.sample.school.dao.DeptDAO;
import com.sample.school.dao.ProfDAO;
import com.sample.school.dao.RegDAO;
import com.sample.school.dao.StudentDAO;
import com.sample.school.dao.SubjectDAO;
import com.sample.school.vo.Course;
import com.sample.school.vo.Dept;
import com.sample.school.vo.Prof;
import com.sample.school.vo.Reg;
import com.sample.school.vo.Student;
import com.sample.school.vo.Subject;

public class SchoolService {
	
	private SubjectDAO subjectDao = new SubjectDAO();
	private CourseDAO courseDao = new CourseDAO();
	private DeptDAO deptDao = new DeptDAO();
	private ProfDAO profDao = new ProfDAO();
	private StudentDAO studentDao = new StudentDAO();
	private RegDAO regDao = new RegDAO();
	
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
		
		if (course == null) {
			return course;
		}
		
		if (course.getDept() != null) {
			Dept dept = deptDao.getDeptByNo(course.getDept().getNo());
			course.setDept(dept);
		}
		if (course.getProf() != null) {
			Prof prof = profDao.getProfByNo(course.getProf().getNo());
			course.setProf(prof);
		}
		if (course.getSubject() != null) {
			Subject subject = subjectDao.getSubjectByNo(course.getSubject().getNo());
			course.setSubject(subject);
		}
		
		return course;
	}
	
	public List<Course> getAllCourses() throws SQLException {
		List<Course> allCourses = courseDao.getAllCourses();
		
		if (allCourses.isEmpty()) {
			return allCourses;
		}
		
		for (Course course : allCourses) {
			if (course.getDept() != null) {
				Dept dept = deptDao.getDeptByNo(course.getDept().getNo());
				course.setDept(dept);
			}
			if (course.getProf() != null) {
				Prof prof = profDao.getProfByNo(course.getProf().getNo());
				course.setProf(prof);
			}
			if (course.getSubject() != null) {
				Subject subject = subjectDao.getSubjectByNo(course.getSubject().getNo());
				course.setSubject(subject);
			}
		}
		
		return allCourses;
	}

	public List<Course> getCoursesByDeptNo(int deptNo) throws SQLException {
		List<Course> deptCourses = courseDao.getCoursesByDeptNo(deptNo);
		Dept dept = deptDao.getDeptByNo(deptNo);
		if(dept == null) {
			return deptCourses;
		}
		
		if (deptCourses.isEmpty()) {
			return deptCourses;
		}
		
		for (Course course : deptCourses) {
			course.setDept(dept);
			if (course.getProf() != null) {
				Prof prof = profDao.getProfByNo(course.getProf().getNo());
				course.setProf(prof);
			}
			if (course.getSubject() != null) {
				Subject subject = subjectDao.getSubjectByNo(course.getSubject().getNo());
				course.setSubject(subject);
			}
		}
		
		return deptCourses;
	}
	
	public boolean addReg(Reg reg) throws SQLException {
		if (reg.getStudent() == null) {
			return false;
		}
		if(reg.getCourse() == null) {
			return false;
		} 

		Student savedStudent = studentDao.getStudentByNo(reg.getStudent().getNo());
		Course savedCourse = courseDao.getCourseByNo(reg.getCourse().getNo());
		
		if (savedStudent == null) {
			return false;
		} else if (savedCourse == null) {
			return false;
		} else if (savedStudent.getDept().getNo()!=savedCourse.getDept().getNo()) {
			return false;
		}
		
		if (!savedCourse.isRegisterable()) {
			return false;
		} else {
			if(savedCourse.getStudentCount()<=0) {
				return false;
			}
		}
		// 학생번호, 과정번호가 같은 신청내역이 중복되지는 않는지
		List<Reg> allRegs = regDao.getAllRegs();
		for (Reg savedReg : allRegs) {
			if (savedReg.getCourse().getNo()==savedCourse.getNo()) {
				if (savedReg.getStudent().getNo()==savedStudent.getNo()) {
					return false;
				}
			}
		}
		
		savedCourse.setStudentCount(savedCourse.getStudentCount()-1);
		if(savedCourse.getStudentCount()<=0) {
			savedCourse.setRegisterable(false);
		}
		courseDao.updateCourse(savedCourse);

		regDao.addReg(reg);
		return true;
	}
	
	public boolean cancelReg(Reg reg) {
		return true;
	}
	
	public List<Reg> getMyRegs(int studentNo) throws SQLException {
		List<Reg> myRegs = regDao.getMyRegs(studentNo);
		
		if (!myRegs.isEmpty()) {
			for (Reg reg : myRegs) {
				Course course = courseDao.getCourseByNo(reg.getCourse().getNo());
				Dept dept = deptDao.getDeptByNo(course.getDept().getNo());
				course.setDept(dept);
				course.setProf(profDao.getProfByNo(course.getProf().getNo()));
				reg.setCourse(course);
				Student student = studentDao.getStudentByNo(reg.getStudent().getNo());
				student.setDept(dept);
				reg.setStudent(studentDao.getStudentByNo(reg.getStudent().getNo()));
			}
		}
		
		return myRegs;
	}
	
	public boolean cancelReg(int regNo) throws SQLException {
		Reg savedReg = regDao.getRegByNo(regNo);
		if (savedReg == null) {
			return false;
		} else if (savedReg.isCanceled()) {
			return false;
		}
		
		savedReg.setCanceled(true);
		
		Course course = courseDao.getCourseByNo(savedReg.getCourse().getNo());
		course.setStudentCount(course.getStudentCount()+1);
		if(course.getStudentCount()>0) {
			course.setRegisterable(true);
		}
		courseDao.updateCourse(course);

		regDao.updateReg(savedReg);
		
		return true;
	}
	
}
