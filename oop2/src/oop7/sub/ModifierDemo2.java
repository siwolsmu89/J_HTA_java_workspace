package oop7.sub;

public class ModifierDemo2 {
	public static void main(String[] args) {
		Modifier m = new Modifier();
		
		// Modifier와 같은 패키지에 위치한 ModifierDemo2에서는
		// default, protected, public 접근제한이 지정된 멤버에 접근할 수 있다.
		m.b = 10;
		m.c = 10;
		m.d = 10;
		
		
	}
}
