package demo1.product;

public class BoxDemo {

	public static void main(String[] args) {
		
		// String이 타입파라미터로 지정된 Box 객체
		Box<String> box1 = new Box<String>();
		box1.add("안녕하세요");
		String value1 = box1.get();
		System.out.println(value1);
		
		// Product가 타입파라미터로 지정된 Box 객체
		Box<Product> box2 = new Box<Product>();
		box2.add(new Product("노트북", 1500000));
		Product p = box2.get();
		String value2 = p.getName();
		int value3 = p.getPrice();
		System.out.println(value2 + ": " + value3);
	}
}
