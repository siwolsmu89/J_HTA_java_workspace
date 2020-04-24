package com.sample.school.vo;

/**
 * 교수정보를 저장하는 객체를 위한 클래스다.
 * @author JHTA
 *
 */
public class Professor extends User {

	private String dept;
	private String position;
	private int salary;
	
	// 기본 생성자를 정의하시오.
	public Professor() {
		
	}
	
	// 이름, 이메일, 학과, 직위, 급여를 초기화하는 생성자를 정의하시오.
	public Professor(String name, String email, String dept, String position, int salary) {
		super(name, email);
		this.dept = dept;
		this.position = position;
		this.salary = salary;
	}
	
	// 모든 멤버변수에 대한 getter/setter 메소드를 정의하시오.
	public String getDept() {
		return dept;
	}
	
	public String getPosition() {
		return position;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String getRole() {
		
		return "P";
	}
	
	
}
