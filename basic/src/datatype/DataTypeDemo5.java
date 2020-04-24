package datatype;

public class DataTypeDemo5 {

	public static void main(String[] args) {
		
		// 기본 자료형의 형변환
		
		// 자동 형변환
		//		컴파일러가 알아서 타입을 변환한다.
		// 		크기가 작은 타입의 값을 크기가 큰 타입으로 변환시키는 것
		// 		정밀도가 낮은 타입의 값을 정밀도가 높은 타입으로 변환시키는 것
		//		값의 손실이 발생하지 않는 타입 변환이다.
		// byte -> short -> char -> int -> long -> float -> double
		
		// 정수(int) -> 실수(double) : 4Byte 정수를 8Byte 실수형 변수에 담기 
		double a = 3;		// 3 -> 3.0으로 변환 -> 3.0이 a에 대입
		System.out.println(a);
		
		int b = 30;
		// 정수(int) -> 정수(long) : 4Byte 정수를 8Byte long형 변수에 담기
		long c = b; 	// 30 -> 8Byte 30으로 변환 -> c에 대입
		System.out.println(c);
		
		// 정수(int) -> 실수(float) : 4Byte 정수(낮은 정밀도)를 4Byte 실수형(높은 정밀도) 변수에 담기
		float d = b;	// 30 -> 30.0으로 변환 -> d에 대입
		System.out.println(d);
		
		// 연산의 결과는 연산에 참여한 값의 타입과 동일한 타입의 값이 나온다.
		System.out.println(2/3);		// 정수/정수			  ----> 결과 : 정수값
		System.out.println(2/3.0);		// 정수/실수 -----> 실수/실수 ---> 결과 : 실수값 
										// 		     형변환
		
		// 수동 형변환
		// 		개발자가 직접 변환할 타입을 지정해서 형변환을 시킨다.
		
		// 실수 -> 정수로 변환하는 것
		// 데이터의 손실이 발생하는 변환임. 컴파일러가 3.14를 3으로 변환하지 않고 오류를 표시함.
		// (int)와 같은 연산식으로 형변환 의사를 직접 표시한다. (형변환 연산자)
		// double -> float -> long -> int -> char -> short -> byte
	 	int x = (int) 3.14;
		System.out.println(x);
		
		int y = (int) (67.5/3.14);
		System.out.println(y);

		double z = (double) (70 + 42 + 88)/3;
		System.out.println(z);
		// double z = (70+42+88)/3; 이러면 수식 계산 하고 나온 결과값(정수)이 마지막에 double로 변환돼서 .0만 붙음
	
	
	}
}
