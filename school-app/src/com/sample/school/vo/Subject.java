package com.sample.school.vo;

/**
 * 과목정보를 저장하는 객체를 위한 클래스다.<br />
 * 과목명, 학과, 학점을 교수가 직접 입력해서 강의 과목으로 등록해야 한다.
 * @author JHTA
 *
 */
public class Subject {

	private int no;			// 과목번호
	private String title;	// 과목명
	private String dept;	// 학과
	private int credit;		// 학점(1~3사이의 값)
	
	// 기본 생성자를 정의하시오.
	public Subject() {
		
	}

	// 과목명, 학과, 학점을 초기화하는 생성자를 정의하시오.
	public Subject(String title, String dept, int credit) {
		this.title = title;
		this.dept = dept;
		this.credit = credit;
	}
	
	// getter/setter 메소드를 정의하시오.
	public int getNo() {
		return no;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDept() {
		return dept;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
}
