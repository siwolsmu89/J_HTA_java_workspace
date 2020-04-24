package array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo10 {

	public static void main(String[] args) {
		/*
		 * 숫자를 10개 입력받아서 인접한 두 수의 차이가 가장 많이 나는 숫자를 각각 출력하기
		 */
		int count = 0;
		int[] inputNums = new int[10];
		Scanner scanner = new Scanner(System.in);

		for (int i=0; i<(inputNums.length); i++) {
			System.out.print("정수를 입력하세요: ");
			inputNums[i] = scanner.nextInt();
		}
		
		
		int gap=0, prev=0, next=0;
		for (int i=0; i<(inputNums.length-1); i++) {
			if (gap<=Math.abs(inputNums[i] - inputNums[i+1])) {
				gap = Math.abs(inputNums[i] - inputNums[i+1]);
				prev = inputNums[i]; 
				next = inputNums[i+1];
				count++;
				for (int j=0; j<count; j++) {
				int[][] gapNums = new int[count][2];
				gapNums[j][0] = prev;
				gapNums[j][1] = next;
				}
			}
			// int tempPrev = i번째값;
			// int tempNext = i+1번째값;
			// int currentGap = Math.abs(tempPrev-tempNext);
			// 기존의 gap과 currentGap을 비교
			
		}
		System.out.println("prev= "+prev+", next= "+next+", gap= "+gap);
	}
}
