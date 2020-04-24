package control;

import java.util.Scanner;

public class SelfStudyControlDemo1 {
	
	public static void main(String[] args) {
		
		int cardInt = (int) (Math.random() * 12 + 1);
		int curruntSum = 0;
		int lastSum = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.print("카드를 받으시겠습니까? 예 1 아니오 2");
		int answer = scanner.nextInt();

		if (answer == 1) {
			System.out.println("현재 획득한 카드: " + cardInt);
			curruntSum += cardInt;
			System.out.println("현재까지 합산된 수: " + curruntSum);
			cardInt = (int) (Math.random() * 12 + 1);
			System.out.print("계속 받으시겠습니까?");
			int answer2 = scanner.nextInt();

			for (; answer2 == 1 && curruntSum <= 21;) {
				System.out.println("현재 획득한 카드: " + cardInt);
				curruntSum += cardInt;
				cardInt = (int) (Math.random() * 12 + 1);
				System.out.println("현재까지 합산된 수: " + curruntSum);
				if (curruntSum < 21) {
					System.out.print("계속 받으시겠습니까?");
					answer2 = scanner.nextInt();
				} else if (curruntSum == 21) {
					System.out.println("블랙잭!\n결과: 플레이어 승");
					break;
				} else if (curruntSum > 21) {
					System.out.println("파산하셨습니다.\n결과: 딜러 승");
					break;
				}
			}
			lastSum = curruntSum;
		}

		
		  if (lastSum<21) { 
			  int dealer = (int) (Math.random()*12+1)+10; 
			  if (dealer==lastSum) { 
				  System.out.println("딜러: "+dealer+"플레이어: "+lastSum);
				    System.out.println("결과: 무승부"); 
			  } else if(dealer==21||lastSum<dealer) {
				    	 System.out.println("딜러: "+dealer+"플레이어: "+lastSum);
				    	 System.out.println("결과: 딜러 승"); 
			  } else if(lastSum>dealer) {
				    	 System.out.println("딜러: "+dealer+"플레이어: "+lastSum);
				    	 System.out.println("결과: 플레이어 승"); 
			  } 
		  }
		  
	}

}
