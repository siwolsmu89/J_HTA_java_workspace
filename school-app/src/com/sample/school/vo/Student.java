package com.sample.school.vo;

/**
 * 학생 정보를 저장하는 객체를 위한 클래스다.
 * @author JHTA
 *
 */
public class Student extends User {

	private String dept;
	private int grade;
	
	// 기본 생성자를 정의하시오
	public Student() {
		
	}
	
	// 이름, 이메일, 학과, 학년을 초기화하는 생성자를 정의하시오.
	// 부모 생성자를 활용하시오
	public Student(String name, String email, String dept, int grade) {
		super(name, email);
		this.dept = dept;
		this.grade = grade;
	}
	
	// 모든 멤버변수에 대한 getter/setter 메소드를 정의하시오.
	public String getDept() {
		return dept;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public String getRole() {
		// TODO Auto-generated method stub
		return "S";
	}
	
	
}
