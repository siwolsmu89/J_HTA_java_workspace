package lang2;

public class NumberDemo1 {

	public static void main(String[] args) {
		double num1 = 0.1;
		double num2 = 0.2;
		
		// 실수끼리의 연산 결과는 정확한 값이 나오지 않을 수 있다.
		System.out.println(num1+num2);							// 0.30000000000000004

		// 실수끼리의 연산은 적절한 10^n 값을 곱해서 연산한 후, 다시 10^n값 으로 나누어 준다.
		System.out.println( (num1*10 + num2*10)/10  );			// 0.3
	}
}
