package array;

import java.util.Scanner;

public class ArrayDemo13 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] names = new String[20];
		int[] korGrades = new int[20];
		int[] engGrades = new int[20];
		int[] mathGrades = new int[20];
		int menu = 0;
		
		int savePosition = 0;
		
		while(true) {
			System.out.println();
			System.out.println("[성적 관리 프로그램]");
			System.out.println("------------------------------------");
			System.out.println("1.조회  2.검색  3.입력  0.종료");
			System.out.print("메뉴선택: ");
			menu = scanner.nextInt();
			if (menu==0) {
				System.out.println("[성적관리 프로그램]을 종료합니다.");
				break;
			} else if(menu==1) {
				System.out.println("[성적 조회]");
				
				System.out.println("순번\t이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println("------------------------------------");
				for (int i=0; i<(savePosition); i++) {
					System.out.print((i+1)+"\t");
					System.out.print(names[i]+"\t");
					System.out.print(korGrades[i]+"\t");
					System.out.print(engGrades[i]+"\t");
					System.out.print(mathGrades[i]+"\t");
					int total = korGrades[i]+engGrades[i]+mathGrades[i];
					int avg = total/3;
					System.out.print(total+"\t");
					System.out.println(avg);
				}
			} else if (menu==2) {
				System.out.println("[성적 검색]");
				
				System.out.print("조회할 학생의 이름을 입력하세요: ");
				String searchName = scanner.next();
				//for (int i=0; i<savePosition; i++) {
				//	if (savePosition == 0) {
				//		System.out.println("입력된 성적정보가 없습니다.");
				//		break;
				//	}
				//	if (searchName.equals(names[i])) {
				//		System.out.println("[조회결과]");
				//		System.out.println("------------------------------------");
				//		System.out.println("학생이름: " + names[i]);
				//		System.out.println("국어점수: " + korGrades[i]);
				//		System.out.println("영어점수: " + engGrades[i]);
				//		System.out.println("수학점수: " + mathGrades[i]);
				//		int total = korGrades[i] + engGrades[i] + mathGrades[i];
				//		System.out.println("총      점: " + total);
				//		System.out.println("평      균: " + total/3);
				//		System.out.println("------------------------------------");
				//		break;
				//	} else if(i==savePosition-1) {
				//		System.out.println("["+searchName+"]과 일치하는 성적정보가 존재하지 않습니다.");
				//		break;
				//	}
				//}
				int index = -1;
				for (int i=0; i<savePosition; i++) {
					if (searchName.equals(names[i])) {
						index = i;
					}
				}
				
				if (index != -1) {
					System.out.println("[조회결과]");
					System.out.println("------------------------------------");
					System.out.println("학생이름: " + names[index]);
					System.out.println("국어점수: " + korGrades[index]);
					System.out.println("영어점수: " + engGrades[index]);
					System.out.println("수학점수: " + mathGrades[index]);
					int total = korGrades[index] + engGrades[index] + mathGrades[index];
					System.out.println("총      점: " + total);
					System.out.println("평      균: " + total/3);
					System.out.println("------------------------------------");
				} else {
					System.out.println("["+searchName+"]과 일치하는 성적정보가 존재하지 않습니다.");
				}
				
			} else if (menu==3) {
				System.out.println("[성적 입력]");
				
				System.out.print("이름을 입력하세요: ");
				names[savePosition] = scanner.next();
				System.out.print("국어 성적을 입력하세요: ");
				korGrades[savePosition] = scanner.nextInt();
				System.out.print("영어 성적을 입력하세요: ");
				engGrades[savePosition] = scanner.nextInt();
				System.out.print("수학 성적을 입력하세요: ");
				mathGrades[savePosition] = scanner.nextInt();
				
				savePosition++;
				System.out.println("성적정보가 저장되었습니다!");
			}
		}
		
		
		
	}
}
