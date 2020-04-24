package operator;

public class OpDemo6 {

	public static void main(String[] args) {
		// 문자열 비교
		// equals() 메소드를 사용해서 문자열의 내용을 비교하자.
		
		// 문자열 리터럴을 이용해서 String 객체를 생성하게 되면
		// 동일한 문자열인 경우 새로 객체를 만들지 않고 기존 객체를 같이 사용한다.
		// 즉, str1과 str2가 참조하는 객체는 동일한 객체다.
		// 즉, str1과 str2가 가지고 있는 주소값도 동일하다.
		String str1 = "홍길동";
		String str2 = "홍길동";
		
		System.out.println(str1 == str2);		// true, str1과 str2의 주소값이 동일하기 때문
		System.out.println(str1.equals(str2));	// true
		System.out.println(str2.equals(str1));	// true
		
		
		// new 키워드를 이용해서 String객체를 생성하게 되면
		// 일반적인 객체들처럼 매번 새로운 객체를 생성하고 참조하게 된다.
		// 즉, str3와 str4가 참조하는 객체는 서로 다른 객체다.
		// 즉, str3와 str4가 가지고 있는 주소값도 서로 다르다.
		String str3 = new String ("홍길동");
		String str4 = new String ("홍길동");
		
		System.out.println(str3 == str4);		// false, str3와 str4의 주소값이 다르기 때문
		System.out.println(str3.equals(str4));	// true
		System.out.println(str4.equals(str3));	// true
		
		// equals() 메소드는 String 객체의 생성방식과 상관없이 문자열의 내용을 비교하기 때문에
		// 문자열의 내용이 동일하기만 하면 true가 획득된다.
		System.out.println(str1.equals(str3));	// true
		System.out.println(str4.equals(str2));	// true
	}
}
