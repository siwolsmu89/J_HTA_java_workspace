package datatype;

public class DataTypeDemo1 {

	public static void main(String[] args) {
		// 변수 만들기(변수의 선언)
		// 자료형 식별자;
		
		// 국어 점수를 담는 변수 만들기
		int kor;
		// 수학 점수를 담는 변수 만들기
		int math;
		// 영어 점수를 담는 변수 만들기
		int eng;
		
		// 변수의 초기화(변수에 값을 대입하는 것)
		// 변수명(식별자) = 값;
		
		// kor이라는 이름을 가진 저장소에 60을 저장한다.
		kor = 60;
		// math에 100 저장하기
		math = 100;
		// eng에 70 저장하기
		eng = 70;
		
		// 변수에 저장된 값의 사용
		System.out.println(kor);
		System.out.println(math);
		System.out.println(eng);
		System.out.println(kor + math + eng);
		System.out.println((kor+math+eng)/3);
		
	}
}
