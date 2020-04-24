package com.sample.school.repository;

import java.util.Arrays;

import com.sample.school.vo.Course;

public class CourseRepository {

	private Course[] db = new Course[100];
	private int position = 0;
	private int sequence = 40000;
	
	public CourseRepository() {
		insertCourse(new Course("회로이론-1", 30000, 20000, 30));
		insertCourse(new Course("회로이론-2", 30000, 20000, 30));
		insertCourse(new Course("전자기학-1", 30001, 20002, 20));
		insertCourse(new Course("전자기학-2", 30001, 20002, 20));
		insertCourse(new Course("공업수학-1", 30002, 20002, 30));
		insertCourse(new Course("공업수학-2", 30002, 20002, 30));
		insertCourse(new Course("기초 전기전자 실험-1", 30003, 20000, 10));
		insertCourse(new Course("기초 전기전자 실험-2", 30003, 20000, 10));
		
		insertCourse(new Course("이산수학-1", 30004, 20001, 30));
		insertCourse(new Course("이산수학-2", 30004, 20001, 30));
		insertCourse(new Course("프로그램기초 실습", 30005, 20001, 20));
		insertCourse(new Course("데이터베이스기초 실습", 30006, 20001, 10));
		insertCourse(new Course("암호학 개론 및 실습", 30007, 20001, 10));
	}
	
	public void insertCourse(Course course) {
		course.setNo(sequence);
		db[position] = course;
		
		sequence++;
		position++;
	}
	
	public Course getCourseByNo(int courseNo) {
		Course course = null;
		
		if(position==0) {
			return course;
		}
		
		for (int i=0; i<position; i++) {
			if(courseNo == db[i].getNo()) {
				course = db[i];
				break;
			} 
		}
		return course;
	}
	
	public Course[] getAllCourse() {
		return Arrays.copyOfRange(db, 0, position);
	}
	
}