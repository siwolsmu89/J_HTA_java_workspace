package control;

public class IfDemo1 {

	public static void main(String[] args) {
		
		/*
		 * if문
		 * 		- 제시된 조건식의 연산결과에 따라서 특정 수행문의 실행여부를 결정한다.
		 * 		- if(조건식) {
		 * 				조건식의 연산결과가 true로 판정될 때 실행될 수행문;
		 * 				조건식의 연산결과가 true로 판정될 때 실행될 수행문;
		 * 				조건식의 연산결과가 true로 판정될 때 실행될 수행문;
		 * 		  }
		 *
		 * if ~ else문
		 * 		- if (조건식) {
		 *		  		조건식의 연산결과가 true로 판정될 때 실행될 수행문;
		 *		  		조건식의 연산결과가 true로 판정될 때 실행될 수행문;
		 *		  		조건식의 연산결과가 true로 판정될 때 실행될 수행문;
		 *		  } else {
		 *				조건식의 연산결과가 false로 판정될 때 실행될 수행문;
		 *				조건식의 연산결과가 false로 판정될 때 실행될 수행문;
		 *				조건식의 연산결과가 false로 판정될 때 실행될 수행문;
		 *		  }
		 */

		// 시험성적이 60점 이상인 경우만 합격이라고 표시하기
		int score = 61;
		if (score >= 60) {
			System.out.println("합격입니다.");
		}
		
		// 사용자의 접근권한이 관리자인 경우 "접근허용", 그 외에는 "접근거부"라고 표시하기
		String userRole = "관리자";
		if (userRole.equals("관리자")) {
			System.out.println("접근허용");
		} else {
			System.out.println("접근거부");
		}
		
	}
}
