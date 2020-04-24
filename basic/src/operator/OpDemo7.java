package operator;

public class OpDemo7 {

	public static void main(String[] args) {
		// 논리연산자(이항 연산자)
		// && 	||	 !
		// and	or	not
		// 논리연산자의 피연산자는 boolean값을 제공하는 연산식(혹은 표현식)이어야 한다.
		// 논리연산자의 연산 결과는 항상 true/false 중의 하나다.
		// 논리연산자는 업무로직의 구현에 필수적으로 사용된다.
		
		// 주행거리가 50000km 이상이거나 구입기간이 5년이 넘은 경우 유상처리한다. (OR결합, ||)
	    int distance = 60000;
		int usedYear = 3;
		boolean isPay = (distance >= 50000 || usedYear > 5);
		boolean isPay2 = !(distance < 50000 && usedYear <= 5); // 가독성이 떨어짐 (이렇게는 안 씀)
		System.out.println("유상수리여부: " + isPay);
		System.out.println("유상수리여부: " + isPay2);
		
		
		
		// 당일 구매금액이 100만원 이상이고, 100번째, 200번째, 300번째, .... 에 
		// 방문한 고객에게 사은품을 지급한다. (AND결합, &&)
		// 사은품 지급 조건 = (당일 구매금액 >= 1000000 && 방문 순서%100 == 0 ); 
		int orderPrice = 1400000;
		int count = 157;
		boolean isFreebieGetable = ((orderPrice >= 1000000) && (count%100 == 0));
		System.out.println("사은품 지급여부: "+isFreebieGetable);
		
		// 시험성적이 90점 이상이고, 학년석차가 3등 이내인 학생에게 전액 장학금을 지원한다.
		int score = 94;
		int ranking = 2;
		boolean isScholarship = (score >= 90 && ranking <= 3);
		System.out.println("장학금 지원여부: "+isScholarship);
		
		String message = "";
		boolean empty = message.isEmpty();				// 메세지가 없을 때 true를 반환하는 기능
		System.out.println("메세지가 있습니까? " + !empty);
		System.out.println("메세지가 없습니까? " + empty);
		
	}
}
