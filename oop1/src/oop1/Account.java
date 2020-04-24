package oop1;

public class Account {

	// 클래스 변수 - 대부분 상수
	static final double RATE_OF_INTEREST = 0.021; // 상수는 모든 글자를 대문자로 적고, 여러 단어의 합성어인 경우 '_'를 사용하여 구분
	
	// 인스턴스 변수
	String owner;	     // 예금주
	String no;			 // 계좌번호
 	String password;	 // 비밀번호
	int balance;		 // 잔액
	int period;			 // 가입기간
	
}
