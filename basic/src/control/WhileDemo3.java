package control;
import java.util.Scanner;

public class WhileDemo3 {

	public static void main(String[] args) {
		// 1~100까지 임의의 정수를 하나 생성한다.
		// 생성한 정수와 사용자가 입력한 값을 비교해서 up/down을 표시한다.
		// 사용자가 입력한 값이 생성한 정수와 일치하면
		// 몇 번만에 맞췄는지 화면에 표시한다.
		
		int secretNumber =(int)(Math.random()*100+1);
		int inputCount;
		int inputNumber;
		int numMax, numMin;
		
		Scanner scanner = new Scanner(System.in);
		
		inputCount=0;
		numMax=100; numMin=1; 
		
		System.out.print("1~100 범위의 숫자를 하나 입력해주세요: ");
		inputNumber = scanner.nextInt();

		while (true) {
			inputCount++;
			if (inputNumber==secretNumber) {
				System.out.print("found! ");
				System.out.println("정답: "+secretNumber+" 시도한 횟수: "+inputCount);
				break;
			} else if (inputNumber<secretNumber) {
				System.out.print("up! 입력한 값: "+inputNumber);
				numMin = inputNumber;
				System.out.println(" 예상범위: "+numMin+"부터 "+numMax+"사이");
			} else {
				System.out.print("down! 입력한 값: "+inputNumber);
				numMax = inputNumber;
				System.out.println(" 예상범위: "+numMin+"부터 "+numMax+"사이");
			}
			inputNumber=(int)(Math.random()*(numMax-numMin)+numMin);
		}
		
		
		
	}
	
}
