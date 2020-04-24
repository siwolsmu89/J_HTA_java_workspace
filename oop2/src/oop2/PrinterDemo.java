package oop2;

public class PrinterDemo {

	public static void main(String[] args) {
		
		Printer p1 = new Printer();
		p1.on();
		p1.print();
		p1.off();
		
		ColorPrinter p2 = new ColorPrinter();
		p2.on();
		p2.print();
		p2.off();
		
		LaserPrinter p3 = new LaserPrinter();
		p3.on();
		p3.print();
		p3.off();

	}
}
