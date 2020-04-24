package array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo7 {

	public static void main(String[] args) {
		// 숫자를 5번 입력받아서 입력받은 숫자의 총합을 계산하기
		
		// 키보드 입력받기
		Scanner scanner = new Scanner(System.in);
		
		// 숫자 5개를 입력받는 배열 생성
		int[] inputNumbers = new int[5];
		
		// 숫자 5번 입력받기
		for (int i=0;i<5;i++) {
			// 입력받은 숫자를 변수에 저장하기
			// 변수에 저장된 값을 배열에 담기
			System.out.print("숫자를 입력하세요: ");
			inputNumbers[i] = scanner.nextInt();
		}
		
		// 입력받은 숫자들의 총합 계산하기
		int total = 0;
		// enhanced-for문 사용하기
		for (int i : inputNumbers) {		// inputNumbers 배열의 값을 하나씩 순서대로 i에 담기
			// total에 숫자 누적시키기				
			total += i;						// i에 담겼던 값을 total에 누적시키기
		}
		
		System.out.println(Arrays.toString(inputNumbers));
		System.out.println("총합: "+total);

	}
	
}
