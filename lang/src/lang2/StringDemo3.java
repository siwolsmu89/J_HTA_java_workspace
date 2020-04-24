package lang2;

import java.util.StringJoiner;

public class StringDemo3 {

	public static void main(String[] args) {
		
		// String.join()과 StringJoiner는 1.8버전부터 추가된 기능
		// 더 낮은 버전에서는 사용할 수 없다.
		
		// String.join(CharSequence 구분자, CharSequence... element) 
		// 전달받은 엘리먼트들을 지정된 구분자로 이어붙인다.
		// CharSequence... element: 가변 길이 문자 배열. 
		//					길이가 가변적인 문자 배열(element에 여러 개를 적어도 되며, 나중에 element들이 모두 문자열의 각 요소가 된다.)
		//					다른 것과 함께 나열된다면 항상 맨 마지막에 위치해야 함
		
		String[] names = {"김유신","이순신","강감찬","류관순"};
		String text1 = String.join(":", names);
		
		String text2 = String.join("-", "자바","파이썬","루비","펄","고","줄리아","코틀린");
		
		System.out.println(text1);
		System.out.println(text2);
		
		// StringJoiner
		// new StringJoiner(CharSequence 구분자)
		// new StringJoiner(CharSequence 구분자, CharSequence 접두사, CharSequence 접미사)
		// void add(CharSequence item) : StringJoiner에 아이템을 추가한다.
		// String toString() : StringJoiner에 추가된 아이템을 전부 이어붙여서 문자열로 반환한다.
		String[] fileNames = {"휴가신청서", "병가신청서","사직서"};
		StringJoiner joiner1 = new StringJoiner(",");
		
		for (String name : fileNames) {
			joiner1.add(name);
		}
		
		String text3 = joiner1.toString();
		System.out.println(text3);
		
	}
}
