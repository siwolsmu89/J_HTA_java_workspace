package oop1;

import java.util.Scanner;

public class ScoreDemo1 {

	public static void main(String[] args) {
		/*
		 *  학생의 이름, 국어, 영어, 수학 점수를 입력받아 배열에 저장한다.
		 *  배열에 저장된 학생성적정보를 출력할 수 있다.
		 *  배열에 저장된 학생성적정보를 검색할 수 있다.
		 */
		
		Scanner scanner = new Scanner(System.in);
		Score[] scores = new Score[100];
		int savePosition = 0;
		
		while(true) {
			System.out.println();
			System.out.println("==================================================");
			System.out.println("1.조회  2.검색  3.입력  4.수정  0.종료");
			System.out.println("==================================================");

			System.out.print("번호를 입력하세요: ");
			int menuNo = scanner.nextInt();
			
			if(menuNo==0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if(menuNo==1) {
				System.out.println("[성적정보 조회]");
				
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부");
				System.out.println("---------------------------------------------");
				for(int i=0; i<savePosition; i++) {
					
					Score scr = scores[i];
					System.out.print(scr.studentName+"\t");
					System.out.print(scr.kor+"\t");
					System.out.print(scr.eng+"\t");
					System.out.print(scr.math+"\t");
					System.out.print(scr.total+"\t");
					System.out.print(scr.average+"\t");
					System.out.println(scr.isPassed);
				}
			} else if(menuNo==2) {
				System.out.print("검색하려는 이름을 입력하세요: ");
				String findName = scanner.next();
				
				Score foundScore = null;
				for (int i =0; i<savePosition; i++) {
					Score scr = scores[i];

					if (findName.equals(scr.studentName)) {
						foundScore = scr;
						break;
					} 
				}
				if (foundScore != null) {
					System.out.println("---- ["+findName+"] 검색 결과 ----");
					System.out.println("---------------------------------------------");
					System.out.println("이      름: " +foundScore.studentName);
					System.out.println("국어점수: " +foundScore.kor);
					System.out.println("영어점수: " +foundScore.eng);
					System.out.println("수학점수: " +foundScore.math);
					System.out.println("총      점: " +foundScore.total);
					System.out.println("평      균: " +foundScore.average);
					System.out.println("합격여부: " +foundScore.isPassed);
					System.out.println("---------------------------------------------");
				} else {
					System.out.println("["+findName+"]과 일치하는 학생정보를 찾을 수 없습니다.");
				}
			} else if(menuNo==3) {
				System.out.println("[성적정보 입력]");
								
				Score scr = new Score();
				System.out.print("이름을 입력하세요: ");
				scr.studentName = scanner.next();
				System.out.print("국어점수를 입력하세요: ");
				scr.kor = scanner.nextInt();
				System.out.print("영어점수를 입력하세요: ");
				scr.eng = scanner.nextInt();
				System.out.print("수학점수를 입력하세요: ");
				scr.math = scanner.nextInt();
				scr.total = scr.kor + scr.eng + scr.math;
				scr.average = scr.total/3;
				scr.isPassed = (scr.average >= 60? true : false);
				
				scores[savePosition] = scr;
				
				savePosition++;
			} else if (menuNo==4) {
				System.out.println("[성적정보 변경]");
				System.out.print("성적을 변경할 학생의 이름을 입력하세요: ");
				String findName = scanner.next();
				
				Score foundScore = null;
				for (int i =0; i<savePosition; i++) {
					Score scr = scores[i];

					if (findName.equals(scr.studentName)) {
						foundScore = scr;
						break;
					}
				}
				
				if (foundScore!=null) {
					System.out.print("성적을 변경할 과목명을 입력하세요 (국어,영어,수학 중 하나): ");
					String subject = scanner.next();
					System.out.print("새 점수를 입력하세요: ");
					int newScore = scanner.nextInt();
					System.out.println();
					System.out.println("성적을 변경한 과목: "+subject);
					
					if (subject.equals("국어")) {
						System.out.println("기존점수: "+foundScore.kor);
						foundScore.kor = newScore;
						System.out.println("바뀐 국어점수: "+newScore);
					} else if (subject.equals("영어")) {
						System.out.println("기존점수: "+foundScore.eng);
						foundScore.eng = newScore;
						System.out.println("바뀐 영어점수: "+newScore);
					} else if (subject.equals("수학")) {
						System.out.println("기존점수: "+foundScore.math);
						foundScore.math = newScore;
						System.out.println("바뀐 수학점수: "+newScore);
					} 
					
					foundScore.total = foundScore.kor+foundScore.eng+foundScore.math;
					foundScore.average = foundScore.total/3;
				} else if(foundScore==null) {
					System.out.println("["+findName+"]과 일치하는 학생정보를 찾을 수 없습니다.");
				}
				
			}
			
		}
		scanner.close();
	}
}
