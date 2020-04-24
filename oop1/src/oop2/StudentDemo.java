package oop2;

import java.util.Scanner;

public class StudentDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student[] students = new Student[100];
		int savePosition = 0;
		
		while (true) {
			System.out.println("===============================================");
			System.out.println("1.조회\t2.검색\t3.입력\t0.종료");
			System.out.println("===============================================");
			System.out.print("원하시는 메뉴를 선택하세요(0~3): ");
			int menu = scan.nextInt();
			
			if (menu == 0) {
				System.out.println("==================[프로그램 종료]==================");
				break;
			} else if(menu == 1) {
				System.out.println("==================[학생 정보 조회]==================");
				System.out.println("학생이름\t 반 \t번  호\t국어점수\t영어점수\t수학점수\t총  점\t평  균");
				if (savePosition == 0) {
					System.out.println("현재 입력된 학생 정보가 없습니다.");
				} else {
					for (int i=0;i<savePosition;i++) {
						
						Student student = students[i];	
						student.printStudentsInfo();
					}
				}
			} else if (menu == 2) {
				System.out.println("==================[학생 정보 검색]==================");
				System.out.print("검색하려는 학생 이름 입력: ");
				String searchName = scan.next();

				System.out.println("학생이름\t 반 \t번  호\t국어점수\t영어점수\t수학점수\t총  점\t평  균");
				boolean isFound = false;
				for (int i=0; i<savePosition; i++) {
					Student student = students[i];
					if (student.studentName.equals(searchName)) {
						student.printStudentsInfo();
						isFound = true;
					} 
				}
				if (!isFound) {
					System.out.println("["+searchName+"]과(와) 일치하는 학생 정보가 없습니다.");
				}
			} else if (menu == 3) {
				Student student = new Student();
				System.out.println("==================[학생 정보 입력]==================");
				System.out.print("학생이름을 입력하세요: ");
				student.insertName(scan.next());
				System.out.print("학생의 반을 입력하세요: ");
				student.insertClassNo(scan.nextInt());
				System.out.print("학생의 번호를 입력하세요: ");
				student.studentNo = scan.nextInt();
				System.out.print("학생의 국어점수를 입력하세요: ");
				student.kor = scan.nextInt();
				System.out.print("학생의 영어점수를 입력하세요: ");
				student.eng = scan.nextInt();
				System.out.print("학생의 수학점수를 입력하세요: ");
				student.math = scan.nextInt();
				
				students[savePosition] = student;
				
				savePosition++;
			} // if-else if(menu==?) end
			
		} // while end
		
		
		
		
		
		
		
		
		scan.close();
	}// main end
} // Class end
