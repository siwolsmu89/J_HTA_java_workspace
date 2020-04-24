package array;

import java.util.Scanner;

/*
 * 야구 게임
 * 1~9까지의 임의의 수 3개를 가진 배열이 있다.
 * 사용자로부터 숫자 3개를 입력받아 순서대로 배열에 저장한다.
 * 사용자가 입력한 숫자와 임의의 숫자들을 비교해서
 * 숫자가 동일하고 인덱스도 동일하면 strike
 * 숫자는 동일하지만 인덱스가 일치하지 않으면 ball로 판정한다.
 * 		최대 10회까지 시도할 수 있다.
 * 		출력값이 "3S0B"인 경우 사용자가 숫자를 모두 맞힌 경우다.
 */

public class ArrayDemo14 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 임의의 숫자 3개를 저장하는 배열
		int[] secretNumbers = new int[3];
		// 사용자가 입력한 숫자 3개를 저장하는 배열
		int[] inputNumbers = new int[3];

		// 1~9 임의의 숫자를 secretNumbers에 순서대로 저장하기
		for(int i=0; i<secretNumbers.length; i++) {
			int randomNumber = (int)(Math.random()*9 + 1);
			
			// secretNumbers에 중복된 숫자가 저장되지 않게 하기
			boolean isExist = false;
			for(int j=0;j<secretNumbers.length;j++) {
				// 새로 발생한 난수와 secretNumbers의 배열의 값을 순서대로 비교한다.
				if(secretNumbers[j]==randomNumber) {
					// 동일한 숫자가 발견되면 isExist를 true로 만들고, 
					// 숫자를 비교하는 for문을 탈출한다.
					isExist = true;
					break;
				}
			}
			// isExist가 false면 중복없음, isExist가 true면 중복 발생
			if (!isExist) {
				// 중복이 없었으므로 난수를 배열에 저장
				secretNumbers[i] = randomNumber;
			} else {
				// 이번에 뽑은 난수에서 중복이 발생했으므로 이번 회차를 재시도하기 위해서 i를 1 감소시킴
				i--;
			}
		}
		
		
		// 사용자가 숫자 맞추기
		boolean isSame = false;
		int tryCount = 1;
		
		while(true) {
			if (tryCount>10) {
			System.out.println("실패 - 시도 횟수가 10회를 넘었습니다!");
			break;
			}
			
			System.out.print("첫 번째 숫자를 입력하세요: ");
			inputNumbers[0] = scanner.nextInt();
			System.out.print("두 번째 숫자를 입력하세요: ");
			inputNumbers[1] = scanner.nextInt();
			System.out.print("세 번째 숫자를 입력하세요: ");
			inputNumbers[2] = scanner.nextInt();
		
			int strikeCount=0, ballCount=0;
			for (int i=0; i<inputNumbers.length; i++) {
				for (int j=0; j<secretNumbers.length; j++) {
					if (inputNumbers[i] == secretNumbers[j]) {
						if(i==j) {
							strikeCount++;
						} else {
							ballCount++;
						}
					}
				}
			}
			System.out.println("출력값: "+strikeCount+"S"+ballCount+"B");
			if(strikeCount==3) {
				System.out.println("정답입니다. 시도횟수는 총 "+tryCount+"회 입니다.");
				break;
			}	
			tryCount++;
		}
		
		
		
		
		
	}
}
