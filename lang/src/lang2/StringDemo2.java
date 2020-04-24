package lang2;

import java.util.StringTokenizer;

public class StringDemo2 {

	public static void main(String[] args) {
		
		// split()과 StringToeknizer
		String str = "김유신,,강감찬,이순신";
		
		// split()
		// 구분자를 기준으로 잘랐을 때 빈 문자열도 배열에 담아둔다.
		String[] items = str.split(",");	 // 결과 -> ["김유신", "", "강감찬", "이순신"]
		
		for(String item : items) {
			System.out.println("배열의 값: ["+item+"]");
		}
		System.out.println();
		
		// StringTokenizer
		// token : (컴) 길게 있던 것을 일정한 구분자로 잘게 나누어놓은 것
		// 구분자를 기준으로 잘랐을 때 비어 있는 문자열은 버린다.
		StringTokenizer tokens = new StringTokenizer(str, ",");		// 결과 -> ["김유신", "강감찬", "이순신]
		while (tokens.hasMoreTokens()) {
			String value = tokens.nextToken();
			System.out.println("토큰의 값: ["+value+"]");
		}
		
		// 어떤 항목에 1:1로 대입해서 값을 꺼내야 하는 경우에는 split을 사용해야 함(비어있는 값도 '비어있다'는 유의미한 정보를 표시하므로)
		// 똑같은 데이터를 입력받는데 사이사이에 데이터가 없어서 공백이 생긴 경우에는 tokenizer를 사용하는 것이 유리
		
	}
}
