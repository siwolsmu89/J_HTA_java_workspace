package oop2;

import java.util.Scanner;

public class BankingDemo3 {

	public static void main(String[] args) {
		BankingService service = new BankingService();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.println("[계좌관리 프로그램]");
			System.out.println("--------------------------------------------------");
			System.out.println("1.조회  2.검색  3.신규  4.입금  5.출금  6.해지  0.종료");
			System.out.println("--------------------------------------------------");

			System.out.print("메뉴를 선택하세요: ");
			int menuNo = scanner.nextInt();

			if (menuNo == 1) {
				service.printAllBankings();

			} else if (menuNo == 2) {
				System.out.println("[계좌 조회 메뉴]");
				System.out.print("조회할 계좌번호를 입력하세요.");
				String no = scanner.next();
				service.printBankingByNo(no);

			} else if (menuNo == 3) {
				System.out.println("[신규 계좌 개설 메뉴]");
				System.out.println("신규 계좌개설에 필요한 정보를 입력해주세요.");
				System.out.print("고객명을 입력하세요.");
				String name = scanner.next();
				System.out.print("비밀번호를 입력하세요.");
				int password = scanner.nextInt();
				System.out.print("첫 입금액을 입력하세요.");
				long balance = scanner.nextLong();

				service.addNewBanking(name, password, balance);

			} else if (menuNo == 4) {
				System.out.println("[입금 메뉴]");

				System.out.println("입금에 필요한 정보를 입력해주세요.");
				System.out.print("계좌번호를 입력하세요.");
				String bankingNo = scanner.next();
				System.out.print("입금액을 입력하세요.");
				long money = scanner.nextLong();

				service.depositBanking(bankingNo, money);
			} else if (menuNo == 5) {
				System.out.println("[출금 메뉴]");
				System.out.println("출금에 필요한 정보를 입력해주세요.");
				System.out.print("계좌번호를 입력하세요.");
				String bankingNo = scanner.next();
				System.out.print("출금액을 입력하세요.");
				long outputMoney = scanner.nextLong();
				System.out.print("비밀번호를 입력하세요.");
				int inputPassword = scanner.nextInt();
				
				long withdrawMoney = service.withdraw(bankingNo, outputMoney, inputPassword);
				System.out.println("["+bankingNo+"] 계좌에서 "+withdrawMoney+"원이 인출되었습니다.");
				
			} else if (menuNo == 6) {
				System.out.println("[해지 메뉴]");
				System.out.println("해지에 필요한 정보를 입력해주세요.");
				System.out.print("계좌번호를 입력하세요.");
				String bankingNo = scanner.next();
				System.out.print("비밀번호를 입력하세요.");
				int inputPassword = scanner.nextInt();

				long money = service.closeBanking(bankingNo, inputPassword);
				System.out.println("총 해지금액 ["+money+"]원을 가져가세요.");
			} else if (menuNo == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

		}
		scanner.close();
	}
}
