package control;

import java.util.Scanner;

public class IfDemo4 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * 고객의 등급(일반, 로얄, 플래티넘 중 하나)과 총 구매금액을 입력받는다.
		 * 고객의 등급이 플래티넘인 경우 구매금액의 10%를 할인한다.
		 * 			로얄인 경우 구매금액의 3%를 할인한다.
		 * 			일반인 경우 구매금액의 1%를 할인한다.
		 * 결제금액은 총 구매금액에서 할인된 금액만큼을 차감한 금액이다.
		 * 적립포인트는 결제금액의 3%를 적립한다.
		 * 
		 * 출력내용은 
		 * 		총 구매금액, 고객등급, 할인된 금액, 결제할 금액, 적립된 포인트
		 */
		
		System.out.print("고객등급을 입력하세요(일반, 로얄, 플래티넘 중 하나): ");
		String grade = scanner.next();
		System.out.print("총 구매금액을 입력하세요: ");
		int orderPrice = scanner.nextInt();

		double pointRate = 0.03;
		double discountRate = 0.00;
		if (grade.equals("플래티넘")) {
			discountRate = 0.10;
		} else if (grade.equals("로얄")) {
			discountRate = 0.03;
		} else if (grade.equals("일반")) {
			discountRate = 0.01;
		} else {
			discountRate = 0.00;
		}
		
		int discountPrice = (int)(orderPrice * discountRate);
		int payPrice = (orderPrice - discountPrice);
		int depositPoint = (int)(payPrice * pointRate);
		
		System.out.println("총 구매금액: " + orderPrice);
		System.out.println("고객등급: " + grade);
		System.out.println("할인된 금액: " + discountPrice);
		System.out.println("결제할 금액: " + payPrice);
		System.out.println("적립된 포인트: " + depositPoint);
		
		
	}

}
