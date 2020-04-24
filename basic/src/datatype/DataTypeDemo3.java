package datatype;

public class DataTypeDemo3 {

	public static void main(String[] args) {
		
		// score는 변수다.
		// score에 저장되는 값을 언제나 변경할 수 있다.
		// 변수는 값을 언제든지 변경할 수 있는 저장소다.
		int score = 70;				// 변수의 선언과 초기화
		System.out.println(score);
/* 
		자료형 식별자 ---> 항상 새로운 변수를 만드는 수행문이다.
		score라는 이름을 가진 변수가 이미 존재하기 때문에
		동일한 이름을 가진 변수를 만드는 것은 문법 오류다.
		int score = 100; 			// 오류
		System.out.println(score);
		duplicate local variable score
 */
		score = 60;					// 변수의 값 변경
		System.out.println(score);
	
		// 상수 만들기
		// final 자료형 식별자 = 값;
		// 상수는 값을 변경할 수 없는 저장소다.
		final int pointDepositRate = 3;
		System.out.println(pointDepositRate);
/*
		상수는 값을 변경할 수 없다.
		pointDepositRate = 5;		// 문법 오류
		System.out.println(pointDepositRate);
		The final local variable pointDepositRate cannot be assigned
*/
	}
}
