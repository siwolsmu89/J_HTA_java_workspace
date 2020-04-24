package oop2;

import java.util.Scanner;

public class BankingDemo2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Banking[] bankings = new Banking[5];

		int savePosition = 0;
		
		while (true) {
			System.out.println("=======================================================");
			System.out.println("1.신규\t2.조회\t3.입금\t4.출금\t5.비밀번호 변경\t6.해지\t0.종료");
			System.out.println("=======================================================");

			System.out.print("메뉴를 선택하세요(0~6): ");
			int menu = scanner.nextInt();

			if (menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				System.out.println("=======================================================");
				break;
			} else if (menu == 1) {
				Banking bank = new Banking();

				System.out.println("================== 신규 ==================");
				System.out.print("이름을 입력하세요: ");
				bank.name = scanner.next();
				System.out.print("계좌 번호를 입력하세요: ");
				bank.accountNo = scanner.next();
				System.out.print("비밀번호를 입력하세요: ");
				bank.password = scanner.nextInt();
				System.out.print("잔액을 입력하세요: ");
				bank.balance = scanner.nextLong();

				bankings[bank.savePosition] = bank;
				savePosition++;
			} else if (menu == 2) {
				Banking personalBank = new Banking(savePosition);

				System.out.println("================== 조회  ==================");
				System.out.print("계좌 번호를 입력하세요: ");
				personalBank.findAccount = scanner.next();
				
				personalBank.display(bankings, personalBank);
			} else if (menu == 3) {
				Banking personalBank = new Banking(savePosition);

				System.out.println("================== 입금 ==================");
				System.out.print("계좌 번호를 입력하세요: ");
				personalBank.findAccount = scanner.next();
				System.out.print("입금할 금액을 입력하세요: ");
				long inputMoney = scanner.nextLong();

				personalBank.deposit(bankings, personalBank,inputMoney);
			} else if (menu == 4) {
				Banking personalBank = new Banking(savePosition);

				System.out.println("================== 출금 ==================");
				System.out.print("계좌 번호를 입력하세요: ");
				personalBank.findAccount = scanner.next();				
				System.out.print("출금할 금액을 입력하세요: ");
				long outputMoney = scanner.nextLong();
				System.out.print("비밀번호를 입력하세요: ");
				int inputPassword = scanner.nextInt();

				personalBank.withdraw(bankings, personalBank, outputMoney, inputPassword);
			} else if (menu == 5) {
				Banking personalBank = new Banking(savePosition);
				
				System.out.println("================== 비밀번호 변경 ==================");
				System.out.print("계좌 번호를 입력하세요: ");
				personalBank.findAccount = scanner.next();
				System.out.print("기존의 비밀번호를 입력하세요: ");
				int oldPwd = scanner.nextInt();
				System.out.print("새 비밀번호를 입력하세요: ");
				int newPwd = scanner.nextInt();

				personalBank.changePassword(bankings, personalBank, oldPwd, newPwd);
			} else if (menu == 6) {
				Banking personalBank = new Banking(savePosition);
				
				System.out.println("================== 해지 ==================");
				System.out.print("계좌 번호를 입력하세요: ");
				personalBank.findAccount = scanner.next();
				System.out.print("비밀번호를 입력하세요: ");
				int inputPassword = scanner.nextInt();

				personalBank.closeAccount(bankings, personalBank, inputPassword);
			}
		} // while end

		scanner.close();
	}// main ed
}
