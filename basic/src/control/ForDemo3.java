package control;

import java.util.Scanner;

public class ForDemo3 {

	// 정수 2개를 입력받아서 두 정수 사이의 숫자를 더한 값을 구하기
	// 예) 10 13
	// 	  10 + 11 + 12 + 13 ---> 
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫번째 숫자를 입력하세요: ");
		int firstNumber = scanner.nextInt();
		
		System.out.print("두번째 숫자를 입력하세요: ");
		int secondNumber = scanner.nextInt();
		
		int sum= 0;
		/*		(1) 내가 궁금했던 방법
		 * 
		 * 		for (;firstNumber<=secondNumber;) {
			
						sum += firstNumber;
						firstNumber++;
				}
				 이런 식으로도 표현할 수 있다. 
				 하지만 이런 식으로 표현하면 마지막에 firstNumber변수를 사용할 때 firstNumber 값이 반복문 이후 변경되어버림
		 */			
		
		/* (2) 정석 답안
		 * 		for (int i=firstNumber;i<=secondNumber;i++) {
		 * 
		 * 			sum += firstNumber;
		 * 
		 * 		}
		 */
		
		//(3) 또 내 맘대로 방법
		// 근데 사실 이렇게 하는 건 코드만 복잡해지고 아무 의미가 없는 것 같다.
		int startNum = firstNumber;
		int finishNum = secondNumber;
		for (;startNum<=finishNum;) {
			sum += startNum;
			startNum++;
		}
		
		System.out.println(firstNumber+"~"+secondNumber+"의 합계: "+sum);
		
	}
	
}
