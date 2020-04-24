package control;

public class ForDemo1 {

	public static void main(String[] args) {
		
		/*
		 * for문
		 * 		지정된 횟수만큼 블록내의 수행문을 실행시킨다.
		 * 		반복횟수의 지정은 초기식, 조건식, 증감식을 사용해서 조절한다.
		 * 		for (초기식; 조건식; 증감식) {
		 * 			수행문;
		 * 		} 
		 * 		* 초기식 : 반복의 횟수를 지정하기 위한 변수를 초기화한다.
		 * 		* 조건식 : 조건식의 연산결과가 true로 판정되는 동안 반복을 지속한다.
		 * 		* 증감식 : 반복문을 제어하기 위해서 초기식에서 선언한 변수의 값을 변경시킨다.
		 * 		for (int i=1; i<=3; i++){
		 *			System.out.println("안녕");
	     *		}
	     *
		 * 		반복횟수	초기식	조건식			수행문	수행문 실행 중 i값		증감식
		 * 		1		i=1		i<=3 -> true	"안녕"		1			i=2
		 * 		2				i<=3 -> true	"안녕"		2			i=3
		 * 		3				i<=3 -> true	"안녕"		3			i=4
		 * 						i<=3 -> false -> 반복 중단
		 * 		
		 */
	
		for (int i=1;i<=3;i++) {
			System.out.println("안녕");
		}
		
		for (int i=1; i<=3; i++) {
			System.out.println("안녕 " + i);
		}
		
		for (int i=1; i<=30; i++) {
			int number = (int) (Math.random()*45 + 1);
			System.out.print(number+"\t");
			if (i%6 == 0) {
				System.out.println();
			}
		}
			
	}
	
}
