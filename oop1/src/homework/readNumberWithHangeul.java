package homework;

import java.util.Scanner;

public class readNumberWithHangeul {

	/*
	 * 123123 이라는 숫자 -> 십이만삼천백이십삼 이라고 표기하고싶으면?
	 * 
	 * 자릿수를 4씩 끊으면 /천백십일/천백십일/천백십일 반복 4단위 자릿수 경/조/억/만/0
	 */

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String[] digits = { "", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };
		String[] roundingFigures = { "", "십", "백", "천" };
		String[] biggerFigures = { "", "만 ", "억 ", "조 ", "경 " };
		int[] individualNums = new int[100];
		int savePosition = 0;
		int resultNum = 0;
		
		System.out.print("변환을 원하는 숫자 입력: ");
		int inputNum = scanner.nextInt();
		resultNum = inputNum;
		
		while (true) {
			individualNums[savePosition] = resultNum % 10;
			resultNum = resultNum / 10;
			
			savePosition++;

			if (resultNum == 0) {
				break;
			}
		}
		
		System.out.print("["+inputNum + "]의 변환 결과는 [");
		for (int i = savePosition-1; i >= 0; i--) {
			
			String result = digits[individualNums[i]]+roundingFigures[i%4];
			
			if (individualNums[i] == 0) {
				result = digits[individualNums[i]];
			}
			
			if (individualNums[i] == 1) {
				if (i%4 == 0) {
					result = digits[individualNums[i]];
				} else {
					result = roundingFigures[i%4];
				}
			}
			
//			if (individualNums[i] == 0) {
//				result = "";
//			} else if (i % 4 == 0 && individualNums[i] == 1) {
//				result = "일";
//			} else {
//				result = digits[individualNums[i]] + roundingFigures[i % 4];
//			}
			
			if (i % 4 == 0) {
				result += biggerFigures[i / 4];
			}
			
			System.out.print(result);
		}System.out.println("] 입니다.");
	// 반복문 돌려서 돌릴 때마다 나누기 10, savep ++, result가 0이 되면 break --> savep가 자릿수
	// while문까지 하고 나면 individualNums[]에 {5,4,3,2,1,0,0,0,0,0,0,0,0...} 이렇게 담길 것
	// int individualNums[0] = 4 이거를 한글로 변환하려면 digits[4] 하면 되니까
	// digits[individualNums[1]] 이러면 10의 0승 자리의 숫자(일의 자리의 숫자), [2]하면 10의 1승 자리의 숫자
	// digits[individualNums[savePosition]] 해서 savePosition-- 하면
	// digits[individualNums[4]] -> digits[1] -> ""
	// digits[individualNums[3]] -> digits[4] -> "사"
	// 이런식으로 될 것

	// figures[savePosition%4] 이러면 자릿수 나옴
	// digits[individualNums[savePosition]]+roundingFigures[savePosition%4]
	// digits[individualNums[4]]+roundingFigures[4%4] -> "" +"" +"만"(나중에 만들것)
	// digits[individualNums[3]]+roundingFigures[3%4] -> "사"+"천"

	// biggerFigures는 biggerFigures[savePosition/4]
	// biggerFigures[4/4] = biggerFigures[1] = 만

	// digits[individualNums[savePosition]]+roundingFigures[figures구하기]+biggerFigures[biggerFigures구하기]
	scanner.close();
}

}
