package oop2;

/**
 * 고객들의 계좌정보를 관리한다. 신규계쫘의 등록, 계좌에 대한 입출금/해지 등의 서비스를 제공한다.
 * 
 * @author JHTA
 *
 */
public class BankingService {

	// 모든 개설된 계좌정보를 저장하는 배열
	Banking[] db = null;
	int savePosition = 0;

	// 기본생성자를 사용하는 경우 계좌정보 100개를 저장할 수 있는 배열을 생성함
	BankingService() {
		db = new Banking[100];
	}

	// 이 생성자를 사용하는 경우 전달받은 size만큼의 계좌정보를 저장할 수 있는 배열을 생성함
	BankingService(int size) {
		db = new Banking[size];
	}

	// 서비스에서 자주 사용되는, 계좌번호에 해당하는 계좌번호를 찾아서 반환하는 기능
	Banking findAccount(String bankingNo) {
		Banking bank = new Banking();
		for (int i = 0; i < savePosition; i++) {
			if (bankingNo.equals(db[i].accountNo)) {
				bank = db[i];
			}
		}
		return bank;
	}
	
	// 등록된 전체 계좌정보를 출력하는 서비스
	void printAllBankings() {

		System.out.println("===========================================================");
		System.out.println("예 금 주\t계  좌  번  호\t잔    액\t가입 기간");
		System.out.println("===========================================================");

		for (int i = 0; i < savePosition; i++) {
			Banking banking = db[i];
			System.out.print(banking.name + "\t");
			System.out.print(banking.accountNo + "\t\t");
			System.out.print(banking.balance + "\t");
			System.out.println(Banking.period);
		}
		if (savePosition == 0) {
			System.out.println("DB에 등록된 계좌 정보가 없습니다.");
		}
		System.out.println("===========================================================");

	}

	// 신규계좌를 등록하는 서비스
	void addNewBanking(String name, int pwd, long money) {
		Banking newAccount = new Banking();

		newAccount.name = name;
		newAccount.accountNo = "" + (int) (Math.random() * 100000 + 10000);
		newAccount.password = pwd;
		newAccount.balance = money;

		db[savePosition] = newAccount;
		savePosition++;
		
		System.out.println("계좌 개설 성공!");
		System.out.println("["+newAccount.name+"] 고객님의 계좌번호는 [" + newAccount.accountNo + "]입니다.");
	}

	// 계좌번호에 해당하는 계좌정보를 조회(출력)하는 서비스
	void printBankingByNo(String bankingNo) {
		Banking bank = findAccount(bankingNo);
		if(bank!=null) {
			bank.display();
		} else {
			System.out.println("계좌번호 [" + bankingNo + "]에 해당하는 계좌의 정보가 없습니다.");
		}
	}

	// 계좌번호, 입금액을 전달받아 해당 계좌에 입금하는 서비스
	void depositBanking(String bankingNo, long money) {
		Banking bank = findAccount(bankingNo);
		if(bank!=null) {
			bank.deposit(money);
		} else {
			System.out.println("계좌번호 [" + bankingNo + "]에 해당하는 계좌의 정보가 없습니다.");
		}
	}

	// 계좌번호, 비밀번호, 출금액을 전달받아 출금액만큼 반환하는 서비스
	long withdraw(String bankingNo, long outputMoney, int inputPassword) {
		long result=0L;
		
		Banking bank = findAccount(bankingNo);
		if(bank!=null) {
			result = bank.withdraw(outputMoney, inputPassword);
		} else {
			System.out.println("계좌번호 [" + bankingNo + "]에 해당하는 계좌의 정보가 없습니다.");
		}
		return result;
	}

	// 계좌번호, 비밀번호를 전달받아서 계좌를 해지하고, 해지금액 전체를 반환하는 서비스
	long closeBanking(String bankingNo, int inputPassword) {
		long finalMoney = 0L;
		Banking bank = findAccount(bankingNo);
		if(bank!=null) {
			finalMoney = bank.closeAccount(inputPassword);
		} else {
			System.out.println("계좌번호 [" + bankingNo + "]에 해당하는 계좌의 정보가 없습니다.");
		}
		return finalMoney;
	}

}
