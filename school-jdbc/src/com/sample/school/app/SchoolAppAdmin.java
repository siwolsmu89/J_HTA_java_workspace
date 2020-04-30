package com.sample.school.app;

import java.util.List;

import com.sample.school.service.AdminService;
import com.sample.school.util.KeyboardUtil;
import com.sample.school.vo.Dept;

public class SchoolAppAdmin {
	

	public static void main(String[] args) throws Exception {
		AdminService service = new AdminService();
		
		while(true) {
			System.out.println("학사관리 프로그램(관리자용)");
			System.out.println("----------------------------------------");
			System.out.println("1.학과관리  2.교수관리  3.학생관리");
			System.out.println("4.과목관리  5.과정관리  6.수강신청관리  0.종료");
			System.out.println("----------------------------------------");
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = KeyboardUtil.nextInt();
			
			if (menuNo == 0) {
				System.out.println("### 프로그램 종료");
				KeyboardUtil.close();
				break;
			} else if (menuNo == 1) {
				System.out.println("[학과(Dept) 관리]");
				System.out.println("----------------------------------------");
				System.out.println("1.신규학과등록  2.학과정보수정  3.학과삭제");
				System.out.println("4.전체조회  5.학과검색");
				System.out.println("----------------------------------------");
				System.out.print("메뉴를 선택하세요: ");
				int deptMenuNo = KeyboardUtil.nextInt();
				
				if (deptMenuNo == 1) {
					System.out.println("[신규학과등록]");
					System.out.print("학과명을 입력하세요: ");
					String deptName = KeyboardUtil.nextString();
					
					Dept dept = new Dept();
					dept.setName(deptName);

					boolean isSuccess = service.addNewDept(dept);
					if (isSuccess) {
						System.out.println("### 학과등록이 정상적으로 완료되었습니다.");
					} else {
						System.out.println("!!! 학과등록 과정에서 오류가 발생했습니다.");
					}
					System.out.println("----------------------------------------");
				} else if (deptMenuNo == 2) {
					System.out.println("[학과정보수정]");
					System.out.print("학과번호를 입력하세요: ");
					int deptNo = KeyboardUtil.nextInt();
					System.out.print("학과명을 입력하세요: ");
					String deptName = KeyboardUtil.nextString();
					
					Dept dept = new Dept();
					dept.setName(deptName);
					dept.setNo(deptNo);
					
					boolean isSuccess = service.updateDept(dept);
					if (isSuccess) {
						System.out.println("### 학과정보 수정이 정상적으로 완료되었습니다.");
					} else {
						System.out.println("!!! 학과정보 수정 과정에서 오류가 발생했습니다.");
					}
					System.out.println("----------------------------------------");
				} else if (deptMenuNo == 3) {
					System.out.println("[학과삭제]");
					System.out.print("학과번호를 입력하세요: ");
					int deptNo = KeyboardUtil.nextInt();
					System.out.print("학과명을 입력하세요: ");
					String deptName = KeyboardUtil.nextString();
					
					Dept dept = new Dept();
					dept.setName(deptName);
					dept.setNo(deptNo);
					
					boolean isSuccess = service.removeDept(dept);
					if (isSuccess) {
						System.out.println("### 학과정보 수정이 정상적으로 완료되었습니다.");
					} else {
						System.out.println("!!! 학과정보 수정 과정에서 오류가 발생했습니다.");
					}
					System.out.println("----------------------------------------");
				} else if (deptMenuNo == 4) {
					System.out.println("[전체학과조회]");
					
					List<Dept> allDepts = service.getAllDepts();
					if (allDepts.isEmpty()) {
						System.out.println("!!! 조회된 학과정보가 없습니다.");
					} else {
						System.out.println("학과번호\t학과명");
						for (Dept dept : allDepts) {
							System.out.print(dept.getNo() + "\t");
							System.out.print(dept.getName() + "\n");
						}
					}
					System.out.println("----------------------------------------");
				} else if (deptMenuNo == 5) {
					System.out.println("[학과검색]");
					System.out.print("학과명 또는 학과번호를 정확히 입력하세요: ");
					String keyword = KeyboardUtil.nextString();
					
					Dept dept = service.getDeptByKeyword(keyword);
					if (dept == null) {
						System.out.println("!!! 조회된 학과정보가 없습니다.");
					} else {
						System.out.println("학과번호: " + dept.getNo());
						System.out.println("학 과 명 : " + dept.getName());
					}
					System.out.println("----------------------------------------");
				}
			} else if (menuNo == 2) {
				System.out.println("[교수(Prof) 관리]");
				
			} else if (menuNo == 3) {
				System.out.println("[학생(Student) 관리]");
				
			} else if (menuNo == 4) {
				System.out.println("[과목(Subject) 관리]");
				
			} else if (menuNo == 5) {
				System.out.println("[과정(Course) 관리]");
				
			} else if (menuNo == 6) {
				System.out.println("[수강신청(Reg) 관리]");
				
			}
		
			
		} // while end
	} // main end
}
