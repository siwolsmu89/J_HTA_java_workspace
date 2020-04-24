package oop2;

public class BankingDemo {

	public static void main(String[] args) {
		Banking b = new Banking();
		
		b.name = "홍길동";
		b.balance = 2000000;
		b.accountNo = "12-3456-789";
		b.password = 1234;

		// 현재 계좌정보 조회하기
		b.display();

		// 입금하기
		b.deposit(11300);
		b.display();
		
		//출금하기
		long money1 = b.withdraw(10000, 1234);
		System.out.println("출금액: "+ money1);		
		
		//비번 바꾸기
		b.changePassword(1234, 1111);
		
		// 계좌 닫기
	}
}
