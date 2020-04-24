package control;

import java.util.Scanner;

public class IfDemo3 {

	public static void main(String[] args) {
		/*
		 * if ~ else if ~ else if ~ else 문
		 * 3개 이상의 경우의 수를 처리해야 할 때 사용되는 조건문이다.
		 * if(조건식 1) {
		 * 		조건식 1이 true로 판정될 때 실행된다. 이후의 문장은 실행되지 않는다.
		 * } else if (조건식 2) {
		 * 		조건식 2가 true로 판정될 때 실행된다. 이후의 문장은 실행되지 않는다.
		 * } else if (조건식 3) {
		 * 		조건식 3이 true로 판정될 때 실행된다. 이후의 문장은 실행되지 않는다.
		 * } else {
		 * 		조건식 1, 조건식2, 조건식3이 모두 false로 판정될 때 실행된다.
		 * }
		 */
		
		/*
		 * 구매금액이 500만원 이상인 경우 10만원 상품권 지급
		 * 		  100만원 이상인 경우 1만원 상품권 지급
		 * 		  50만원 이상인 경우 커피 쿠폰 지급
		 * 		     그 외에는 주차할인권 지급
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("구매금액을 입력하세요: ");
		int orderPrice = scanner.nextInt();
		
		if (orderPrice >= 5_000_000) {
			System.out.println("[구매금액: "+orderPrice+"원] = 10만원 상품권");
		} else if (orderPrice >= 1_000_000) {
			System.out.println("[구매금액: "+orderPrice+"원] = 1만원 상품권");
		} else if (orderPrice >= 500_000) {
			System.out.println("[구매금액: "+orderPrice+"원] = 커피 쿠폰");
		} else {
			System.out.println("[구매금액: "+orderPrice+"원] = 주차 할인권");		
		}
		
 	}
}
