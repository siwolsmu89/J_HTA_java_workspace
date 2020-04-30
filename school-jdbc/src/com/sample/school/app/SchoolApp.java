package com.sample.school.app;

import java.util.List;

import com.sample.school.service.SchoolService;
import com.sample.school.util.KeyboardUtil;
import com.sample.school.vo.Course;
import com.sample.school.vo.Dept;
import com.sample.school.vo.Prof;
import com.sample.school.vo.Subject;

public class SchoolApp {
	
	public static void main(String[] args) throws Exception {
		SchoolService service = new SchoolService();
		
		while(true) {
			System.out.println("학사관리 프로그램");
			System.out.println("----------------------------------------");
			System.out.println("1.교수  2.학생");
			System.out.println("----------------------------------------");
			System.out.print("사용자를 선택하세요: ");
			int menuNo = KeyboardUtil.nextInt();
			
			if (menuNo == 0) {
				System.out.println("### 프로그램 종료");
				KeyboardUtil.close();
				break;
			} else if (menuNo == 1) {
				System.out.println("학사관리 프로그램(교수용)");
				System.out.println("----------------------------------------");
				System.out.println("1.과목조회        2.과목등록");
				System.out.println("3.과정목록조회  4.과정상세조회  5.과정등록");
				System.out.println("----------------------------------------");
				System.out.print("메뉴를 선택하세요: ");
				int profMenuNo = KeyboardUtil.nextInt();
				
				if (profMenuNo == 1) {
					System.out.println("과목 목록 조회");
					
					List<Subject> allSubjects = service.getAllSubjects();
					if (allSubjects.isEmpty()) {
						System.out.println("!!! 과목 목록 조회 과정에서 오류가 발생했습니다.");
					} else {
						System.out.println("### 과목 목록 조회");
						System.out.println("과목번호\t과목명\t학과번호\t학과명\t등록일");
						System.out.println("----------------------------------------");
						for (Subject subject : allSubjects) {
							System.out.print(subject.getNo() + "\t");
							System.out.print(subject.getTitle() + "\t");
							System.out.print(subject.getDept().getNo() + "\t");
							System.out.print(subject.getDept().getName() + "\t");
							System.out.print(subject.getRegisteredDate() + "\n");
						}
						System.out.println("----------------------------------------");
					}
					
				} else if (profMenuNo == 2) {
					System.out.println("과목등록");
					System.out.print("과목명을 입력하세요: ");
					String title = KeyboardUtil.nextString();
					System.out.print("학과번호를 입력하세요: ");
					int deptNo = KeyboardUtil.nextInt();
					
					Subject subject = new Subject();
					Dept dept = new Dept();

					dept.setNo(deptNo);
					subject.setTitle(title);
					subject.setDept(dept);

					boolean isSuccess = service.addSubject(subject);
					if (isSuccess) {
						System.out.println("### 과목등록이 완료되었습니다.");
					} else {
						System.out.println("!!! 과목등록 과정에서 오류가 발생했습니다.");
					}
					System.out.println("----------------------------------------");
				} else if (profMenuNo == 3) {
					System.out.println("과정목록조회");
					
					List<Course> allCourses = service.getAllCourses();
					if (allCourses.isEmpty()) {
						System.out.println("!!! 과정목록조회 과정에서 오류가 발생했습니다.");
					} else {
						System.out.println("### 과정목록조회");
						System.out.println("과정번호\t과정명\t학과명\t담당교수\t마감여부");
						System.out.println("----------------------------------------");
						for (Course course : allCourses) {
							String registerable = "마감전";
							if (!course.isRegisterable()) {
								registerable = "마감완료";
							}
							System.out.print(course.getNo() + "\t");
							System.out.print(course.getTitle() + "\t");
							System.out.print(course.getDept().getName() + "\t");
							System.out.print(course.getProf().getName() + "\t");
							System.out.print(registerable + "\n");
						}
					}
					System.out.println("----------------------------------------");
				} else if (profMenuNo == 4) {
					System.out.println("과정상세조회");
					System.out.print("과정번호를 입력하세요: ");
					int courseNo = KeyboardUtil.nextInt();
					
					Course course = service.getCourseByNo(courseNo);
					if (course == null) {
						System.out.println("!!! 과정상세조회 과정에서 오류가 발생했습니다.");
					} else {
						System.out.println("### 과정상세조회");
						String registerable = "마감전";
						if (!course.isRegisterable()) {
							registerable = "마감완료";
						}
						System.out.println("----------------------------------------");
						System.out.println("과정번호: " + course.getNo());
						System.out.println("과정명 : " + course.getTitle());
						System.out.println("과목명 : " + course.getSubject().getTitle());
						System.out.println("개설학과: " + course.getDept().getName());
						System.out.println("담당교수: " + course.getProf().getName());
						System.out.println("마감여부:" + registerable);
						System.out.println("잔여인원:" + course.getStudentCount());
						System.out.println("등록일자: " + course.getRegisteredDate());
					}
					System.out.println("----------------------------------------");
				} else if (profMenuNo == 5) {
					System.out.println("과정등록");
					System.out.print("과정명을 입력하세요: ");
					String title = KeyboardUtil.nextString();
					System.out.print("학과번호를 입력하세요: ");
					int deptNo = KeyboardUtil.nextInt();
					System.out.print("교수번호를 입력하세요: ");
					int profNo = KeyboardUtil.nextInt();
					System.out.print("과목번호를 입력하세요: ");
					int subjectNo = KeyboardUtil.nextInt();
					
					Dept dept = new Dept();
					dept.setNo(deptNo);
					Prof prof = new Prof();
					prof.setNo(profNo);
					Subject subject = new Subject();
					subject.setNo(subjectNo);
					
					Course course = new Course();
					course.setTitle(title);
					course.setDept(dept);
					course.setProf(prof);
					course.setSubject(subject);
					
					boolean isSuccess = service.addCourse(course);
					if (isSuccess) {
						System.out.println("### 과정등록이 성공적으로 완료되었습니다.");
					} else {
						System.out.println("!!! 과정등록과정에서 오류가 발생했습니다.");
					}
				}
				System.out.println("----------------------------------------");
			} else if (menuNo == 2) {
				System.out.println("학사관리 프로그램(학생용)");
				System.out.println("----------------------------------------");
				System.out.print("메뉴를 선택하세요: ");
				int studentMenuNo = KeyboardUtil.nextInt();
			}
			
		} // while end
	} // main end
}
