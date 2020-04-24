package data.app;

import java.util.Scanner;

import data.service.DataService;

public class DataApp {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		DataService service = new DataService();

		while(true) {
			System.out.println("========================================");
			System.out.println("1.전체조회  2.지역별조회  3.날짜별조회  4.통계  0.종료");
			System.out.println("========================================");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 0) {
				System.out.println("[종료]");
				break;
			} else if (menuNo == 1) {
				System.out.println("[전체 조회 메뉴]");
				
				service.printAllDataCount();
			} else if (menuNo == 2) {
				System.out.println("[지역별 조회 메뉴]");
				System.out.print("조회하려는 시, 도 이름을 입력하세요(2글자): ");
				String sido = scanner.next();
				
				service.printDataBysido(sido);
			} else if (menuNo == 3) {
				System.out.println("[날짜별 조회 메뉴]");
				System.out.print("조회하려는 날짜를 입력하세요(MM-dd): ");
				String day = scanner.next();
				
				service.printDataByDay(day);
			} else if (menuNo == 4) {
				System.out.println("[통계 메뉴]");
				System.out.println("========================================");
				System.out.println("1.지역별  2.월별  3.요일별  4.위반내용별  5.요약");
				System.out.println("========================================");
				System.out.print("통계 메뉴를 선택하세요: ");
				int statsMenuNo = scanner.nextInt();
				
				if(statsMenuNo == 0) {
					System.out.println("[0은 항상 종료야]");
					break;
				} else if (statsMenuNo == 1) {
					System.out.println("[지역별 통계 메뉴]");
					System.out.print("조회하려는 지역명을 입력하세요: ");
					String sido = scanner.next();
					
					service.printStatBySido(sido);
				} else if (statsMenuNo == 2) {
					System.out.println("[월별 통계 메뉴]");
					
					service.printStatByMonth();
					
				} else if (statsMenuNo == 3) {
					
				} else if (statsMenuNo == 4) {
					
				} else if (statsMenuNo == 5) {
					
					service.printSummary();
				}
				
			}
		}
	
	
	}
}
