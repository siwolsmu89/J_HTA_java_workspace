package com.sample.school.vo;

/**
 * 학생 및 교수 정보 저장에 공통으로 사용되는 속성 및 기능이 정의된 추상클래스다.
 * @author JHTA
 *
 */
public abstract class User {

	private int no;
	private String name;
	private String email;
	
	// 기본 생성자를 정의하시오
	public User() {
		
	}
	
	// 이름과 이메일을 초기화하는 생성자를 초기화하는 생성자를 정의하시오
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	// 모든 멤버변수에 대한 getter/setter 메소드를 정의하시오
	public int getNo() {
		return no;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	// 유저의 역할을 반환하는 기능을 추상화함.
	// 학생은 "S"를 교수는 "P"를 반환하도록 학생클래스와 교수클래스에 구현하시오.
	public abstract String getRole();
	
	
}