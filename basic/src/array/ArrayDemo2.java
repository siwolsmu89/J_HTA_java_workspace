package array;

public class ArrayDemo2 {

	public static void main(String[] args) {
		// 배열의 값 조회/변경하기
		
		// 정수형 배열 생성
		int[] scores = new int[3];
		// 배열의 각 요소에 정수 대입하기
		scores[0] = 90;
		scores[1] = 70;
		scores[2] = 60;
		// 배열의 각 요소에 저장된 정수값 사용하기
		int total = scores[0] + scores[1] + scores[2];
		System.out.println("국어점수: " + scores[0]);
		System.out.println("영어점수: " + scores[1]);
		System.out.println("수학점수: " + scores[2]);
		System.out.println("총점: " + total);
		
		// String형 배열 생성
		String[] names = {"이순신", "강감찬", "홍길동"};
		System.out.println("0번째 문자열: " + names[0]);
		System.out.println("1번째 문자열: " + names[1]);
		System.out.println("2번째 문자열: " + names[2]);
		// System.out.println("3번째 문자열: " +names[3]);  // 예외발생 : ArrayIndexOutOfBoundsException
	
		names[1] = "김유신";
		System.out.println("1번째 문자열: " + names[1]);
	}
}
