package operator;

public class OpDemo8 {

	public static void main(String[] args) {
		// 조건 연산자(삼항 연산자)
		// 조건식 ? 식1 : 식2
		// 조건식은 true/false 결과로 판정되는 식이어야 한다.
		// 조건식의 연산 결과가 true인 경우 식1
		// 				false인 경우 식2가 연산결과가 된다.
		// 식1/식2의 최종 연산값은 동일한 타입이어야 한다.
		
		// 성적이 60점 이상인 경우 "합격입니다."를, 아닌 경우 "불합격입니다."를 제공하는 연산식
		int score = 67;
		String result = score >= 60 ? "합격입니다." : "불합격입니다.";
		System.out.println("결과: " + result);
		
		// 고객등급이 "guest", "bronze", "silver"인 경우 구매금액의 3%를 포인트로 적립하고,
		// 고객등급이 "gold"인 경우 구매금액의 5%를 포인트로 적립한다.
		String grade = "silver";
		int orderPrice = 500000;
		int depositPoint = grade.equals("gold") ? (int) (orderPrice*0.05) : (int) (orderPrice*0.03);
		System.out.println("적립포인트: " + depositPoint);
		
	}
}
