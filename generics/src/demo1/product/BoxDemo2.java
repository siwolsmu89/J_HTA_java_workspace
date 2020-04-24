package demo1.product;

public class BoxDemo2 {

	public static void main(String[] args) {
		
		// Tv가 타입파라미터로 지정된 Box 객체
		// Tv객체만 다룰 수 있다.
		Box<Tv> box1 = new Box<Tv>();
		box1.add(new Tv("초대형 텔레비전", 5000000, 100.5));
//		box1.add(new SmartPhone("아이폰", 1600000, "010-1111-1111", "192.168.10.100"));
		
		// SmartPhone이 타입파라미터로 지정된 Box 객체
		// SmartPhone객체만 다룰 수 있다.
		Box<SmartPhone> box2 = new Box<SmartPhone>();
//		box2.add(new Tv("초대형 텔레비전", 5000000, 100.5));
		box2.add(new SmartPhone("아이폰", 1600000, "010-1111-1111", "192.168.10.100"));
		
		// Product가 타입파라미터로 지정된 Box 객체
		// Product와 Product의 자손인 Tv, Product의 자손인 SmartPhone 객체도 다룰 수 있다.
		Box<Product> box3 = new Box<Product>();
		box3.add(new Product("노트북", 2000000));
		box3.add(new Tv("초대형 텔레비전", 5000000, 100.5));
		box3.add(new SmartPhone("아이폰", 1600000, "010-1111-1111", "192.168.10.100"));
	
	}
}
