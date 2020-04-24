package oop2;

public class GugudanDemo {
	
	public static void main(String[] args) {
		Gugudan a = new Gugudan();
		a.print99dan();
	
		a.print99danByNumber(5);
		a.print99danByNumber(19);
		a.print99danByNumber(1);

		a.print99danByRange(5, 10);
		a.print99danByRange(11, 19);
	}
}
