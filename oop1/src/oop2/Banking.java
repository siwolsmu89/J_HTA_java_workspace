package oop2;

/**
 * 계좌에 대한 입금기능, 출금기능, 조회기능, 비밀번호 변경기능, 해지기능을 제공하는 클래스다.
 * 
 * @author JHTA
 *
 */
public class Banking {

	static final double RATE_OF_INTEREST =0.02;
	String name;
	String accountNo;
	String findAccount;
	int password;
	long balance;
	static int period = 24;
	int savePosition;
	
	Banking(){
		
	}
	
	Banking(int number){
		savePosition=number;
	}

	Banking findAccount(Banking[] bankings, Banking foundBanking) {

		for (int i = 0; i < savePosition; i++) {
			if (findAccount.equals(bankings[i].accountNo)) {
				foundBanking = bankings[i];
			} else {
				foundBanking = null;
			}
		}
		return foundBanking;
	}

	// 조회기능은 소유주, 계좌번호, 현재잔액을 화면에 출력한다.
	void display() {
		System.out.println("-------- 계좌 조회 --------");
		System.out.println("예금주: " + name);
		System.out.println("계좌번호: " + accountNo);
		System.out.println("현재잔액: " + balance + "원");
		System.out.println("적금기간: " + period + "개월");
		System.out.println("-----------------------");
	}
	
	void display(Banking[] bankings, Banking foundBanking) {
		foundBanking = findAccount(bankings, foundBanking);
		
		if (foundBanking != null) {
			foundBanking.display();
		} else if (foundBanking == null) {
			System.out.println("계좌정보가 없습니다.");
		}
	}
	
	// 입금기능은 입금액을 전달받아서 잔액을 증가시킨다.
	void deposit(long inputMoney) {
		balance += inputMoney;
		System.out.println("입금이 완료되었습니다.");
		System.out.println("현재 잔액은 " + balance + "원입니다.");
	}
	
	void deposit(Banking[] bankings, Banking foundBanking, long inputMoney) {
		foundBanking = findAccount(bankings, foundBanking);

		if (foundBanking != null) {
			foundBanking.deposit(inputMoney);
		} else if (foundBanking == null) {
			System.out.println("계좌정보가 없습니다.");
		}
	}

	// 출금기능은 출금액과 비밀번호를 전달받아서 비밀번호가 일치하는 경우
	// 잔액을 출금액만큼 감소시키고, 출금액에서 수수료(1300원)를 뺀 금액을 반환한다.
	long withdraw(long outputMoney, int inputPassword) {
		long withdrawMoney = 0;

		if (balance >= outputMoney + 1300) {
			if (inputPassword == password) {
				balance -= (outputMoney + 1300);
				withdrawMoney = outputMoney;
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		} else {
			System.out.println("잔액이 부족합니다.");
		}

		return withdrawMoney;
	}
	
	void withdraw(Banking[] bankings, Banking foundBanking, long outputMoney, int inputPassword) {
		foundBanking = findAccount(bankings, foundBanking);

		if (foundBanking != null) {
			foundBanking.withdraw(outputMoney, inputPassword);
		} else if (foundBanking == null) {
			System.out.println("계좌정보가 없습니다.");
		}
	}

	// 비밀번호 변경 기능은 이전 비밀번호와 새 비밀번호를 전달받아서
	// 이전 비밀번호가 일치하는 경우에만 비밀번호를 새 비밀번호로 바꾼다.
	void changePassword(int oldPwd, int newPwd) {
		if (oldPwd == password) {
			password = newPwd;
			System.out.println("비밀번호 변경에 성공했습니다.");
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
	}
	
	void changePassword(Banking[] bankings, Banking foundBanking, int oldPwd, int newPwd) {
		foundBanking = findAccount(bankings, foundBanking);

		if (foundBanking != null) {
			foundBanking.changePassword(oldPwd, newPwd);
		} else if (foundBanking == null) {
			System.out.println("계좌정보가 없습니다.");
		}
	}

	// 해지기능은 비밀번호를 전달받아서 비밀번호가 일치하는 경우에만
	// 계좌를 해지하고, 금리를 적용한 총해지금액을 반환한다.
	long closeAccount(int inputPassword) {
		long finalMoney = balance+(long)(balance*(period/12)*RATE_OF_INTEREST);
		
		if (inputPassword == password) {
			// 계좌정보 폐기
			name = null;
			accountNo = null;
			password = 0;
			balance = 0;
			period = 0;
		} else {
			System.out.println("계좌번호 또는 비밀번호가 일치하지 않습니다.");
			finalMoney=0L;
		}
		
		return finalMoney;
	}
	void closeAccount(Banking[] bankings, Banking foundBanking, int inputPassword) {
		foundBanking = findAccount(bankings, foundBanking);

		if (foundBanking != null) {
			foundBanking.closeAccount(inputPassword);
		} else if (foundBanking == null) {
			System.out.println("계좌정보가 없습니다.");
		}
	}

}
