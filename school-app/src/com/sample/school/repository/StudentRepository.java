package com.sample.school.repository;

import java.util.Arrays;

import com.sample.school.vo.Student;

public class StudentRepository {

	private Student[] db = new Student[100];
	private int position = 0;
	private int sequence = 60000;
	
	public StudentRepository() {
		insertStudent(new Student("김유신", "kim@gmail.com", "컴퓨터공학과", 2));
		insertStudent(new Student("강감찬", "kang@daum.net", "컴퓨터공학과", 3));
		insertStudent(new Student("이순신", "lee@gmail.com", "컴퓨터공학과", 1));
		insertStudent(new Student("홍길동", "hong@daum.net", "전자공학과", 2));
		insertStudent(new Student("류관순", "ryu@naver.com", "전자공학과", 4));
		insertStudent(new Student("안중근", "ahn@naver.com", "전자공학과", 3));
	}
	
	public void insertStudent(Student student) {
		student.setNo(sequence);
		db[position] = student;
		
		sequence++;
		position++;
	}
	
	public Student getStudentByNo(int studentNo) {
		Student student = null;
		
		if(position==0) {
			return student;
		}
		
		for (int i=0; i<position; i++) {
			if(studentNo == db[i].getNo()) {
				student = db[i];
				break;
			} 
		}
		
		return student;
	}
	
	public Student[] getAllStudents() {
		return Arrays.copyOfRange(db, 0, position);
	}
}