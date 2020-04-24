package com.sample.school.vo;

/**
 * 개설 과정 정보를 저장하는 객체 생성에 필요한 클래스다.<br />
 * 과정번호는 등록시에 자동으로 부여된다.<br />
 * 정원을 초과해서 등록할 수 없다.
 * @author JHTA
 *
 */
public class Course {

	private int no;					// 과정번호
	private String name;			// 과정명
	private int subjectNo;			// 과목번호
	private int professorNo;		// 담당교수 번호
	private int quota;				// 과정 신청 정원
	
	// 기본 생성자를 정의하시오
	public Course() {}
	
	// 과정명, 과목코드, 담당교수, 정원을 초기화하는 생성자를 정의하시오.
	public Course(String name, int subjectNo, int professorNo, int quota) {
		this.name = name;
		this.subjectNo = subjectNo;
		this.professorNo = professorNo;
		this.quota = quota;
	}
	
	// getter/setter 메소드를 정의하시오.
	public int getNo() {
		return no;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSubjectNo() {
		return subjectNo;
	}
	
	public int getProfessorNo() {
		return professorNo;
	}
	
	public int getQuota() {
		return quota;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}
	
	public void setProfessorNo(int professorNo) {
		this.professorNo = professorNo;
	}
	
	public void setQuota(int quota) {
		this.quota = quota;
	}
		
}
