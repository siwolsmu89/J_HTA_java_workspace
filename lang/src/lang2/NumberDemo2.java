package lang2;

import java.math.BigInteger;

public class NumberDemo2 {
	public static void main(String[] args) {
		// BigInteger : long으로 다룰 수 없는 정수
		// BigDecimal : double로 다룰 수 없는 실수
		
		//long number1 = 123456789012345678901234567890L;
		//long number2 = 1234567890;
		
		// 정수가 long의 범위를 벗어날 때는 BigInteger를 사용한다.
		BigInteger big1 = new BigInteger("123456789012345678901234567890");
		BigInteger big2 = new BigInteger("1234567890");
		
		BigInteger result1 = big1.add(big2);
		BigInteger result2 = big1.subtract(big2);
		BigInteger result3 = big1.multiply(big2);
		BigInteger result4 = big1.divide(big2);
		System.out.println("덧셈결과: " + result1.toString());
		System.out.println("뺄셈결과: " + result2.toString());
		System.out.println("곱셈결과: " + result3.toString());
		System.out.println("나눗셈결과: " + result4.toString());
	}
}
