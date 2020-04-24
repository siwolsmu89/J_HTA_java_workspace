package oop2;

public class ColorPrinter extends Printer {

	
	// Printer로부터 상속받은 print() 메소드의 기능을 재정의하기

	// @는 Annotation이라는 것을 표시한다. 
	// Annotation은 부가적인 정보를 나타낼 때 사용된다.
	// Annotation의 정보는 편집기, 컴파일러, 프레임워크, 응용프로그램 등에서 활용될 수 있다.
	// @Override : 부모의 메소드를 재정의한 메소드라는 것을 나타냄
	@Override 
	void print() {
		System.out.println("컬러로 내용을 출력합니다.");
	}
	
}
