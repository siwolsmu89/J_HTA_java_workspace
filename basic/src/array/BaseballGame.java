package array;

// 풀이는 ArrayDemo14에 있음.

import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 난수 3개 생성해서 배열에 담기
		int[] secrets = new int[3];
		for (int i=0; i<secrets.length; i++) {
			secrets[i] = (int)(Math.random()*9)+1;
		}
		
		int[] inputNums = new int[3];
		int  trial=0;
		
		while(true) {
			int strike=0, ball=0;

			for (int i=0; i<secrets.length; i++) {
				System.out.print("숫자를 입력해주세요("+(i+1)+"번째): ");
				inputNums[i] = scanner.nextInt();
			}
			// 숫자 입력받아 배열에 저장하기
			
			for(int i=0; i<inputNums.length; i++) {
				for(int j=0; j<secrets.length; j++) {
					if (inputNums[i]==secrets[j]) {
						if(i==j) {
							strike++;
						} else {
							ball++;
						}
					}
				} 
			}


			// strike/ball 결과 출력
			System.out.println("Strike: "+strike);
			System.out.println("Ball: "+ball);
		
			if (strike==3) {
				System.out.println("승리!");
				break;
			}
			trial++;
			if (trial==10) {
				System.out.println("게임오버");
				break;
			}
			
		}
	}
}
