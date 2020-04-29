package com.sample.school.app;

import com.sample.school.util.KeyboardUtil;

public class SchoolAppAdmin {

	public static void main(String[] args) throws Exception {
		
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
					
				} else if (deptMenuNo == 2) {
					System.out.println("[학과정보수정]");
					
				} else if (deptMenuNo == 3) {
					System.out.println("[학과삭제]");

				} else if (deptMenuNo == 4) {
					System.out.println("[전체학과조회]");
					
				} else if (deptMenuNo == 5) {
					System.out.println("[학과검색]");
					
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
