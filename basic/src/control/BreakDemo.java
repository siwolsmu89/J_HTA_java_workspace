package control;

import java.util.Scanner;

public class BreakDemo {

	public static void main(String[] args) {
		// break
		//	반복문을 탈출한다. for문, while문 안에서 사용된다.
		
		// 내가 입력한 주사위 숫자와 동일한 숫자가 나오면 탈출
		Scanner scanner = new Scanner(System.in);
		
		for (int i=1 ; i <= 3 ; i++) {
			System.out.print("주사위 숫자를 입력하세요(1~6): ");
			int diceInput = scanner.nextInt();
			int diceRandom = (int) (Math.random()*6 + 1);

			System.out.println("내가 입력한 주사위: ["+diceInput+"], 굴려서 나온 주사위: ["+diceRandom+"]");
			
			if (diceInput == diceRandom) {
				System.out.println("탈출 성공: ["+diceInput+"]");
				break;
			}
			if (i == 3 && diceInput != diceRandom) {
			System.out.println("탈출 실패");
			}
		}
		
	}
}
