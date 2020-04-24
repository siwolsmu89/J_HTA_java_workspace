package operator;

public class OpDemo2 {

	public static void main(String[] args) {
		// 증감연산자
		// 아래의 기술된 수행문 중 일부는 비추천 수행문
		// 증감연산자를 다른 연산자와 같이 사용하는 것은 코드의 가독성을 나쁘게 한다.
		int num1 = 10;
		int num2 = 10;
		
		// 증감연산자를 비교연산자와 같이 사용한 경우
		// 강력히 비추천, 절대로 비추천, 진짜로 비추천
		boolean result1 = num1++ > 10; // 비추천 수행문
		boolean result2 = ++num2 > 10; // 비추천 수행문
		System.out.println(result1);
		System.out.println(result2);
		
		// 증감연산자를 비교연산자와 같이 사용하지 않은 경우
		int num3 = 10;
		int num4 = 10;
		num3++;
		++num4;
		
		boolean result3 = num3 > 10;
		boolean result4 = num4 > 10;
		System.out.println(result3);
		System.out.println(result4);
		
		
	}
}
