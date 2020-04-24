package demo1.product;

public class BoxDemo3 {

	public static void main(String[] args) {
	
		// BoxForSmartPhone<T extends SmartPhone> 제네릭클래스는 Product를 타입파라미터로 지정할 수 없다.
//		BoxForSmartPhone<Product> box1 = new BoxForSmartPhone<Product>();

		// BoxForSmartPhone<T extends SmartPhone> 제네릭클래스는 Tv를 타입파라미터로 지정할 수 없다.
//		BoxForSmartPhone<Tv> box2 = new BoxForSmartPhone<Tv>();
		
		BoxForSmartPhone<SmartPhone> box3 = new BoxForSmartPhone<SmartPhone>();
		
		BoxForSmartPhone<Galaxy> box4 = new BoxForSmartPhone<Galaxy>();
		
		BoxForSmartPhone<Iphone> box5 = new BoxForSmartPhone<Iphone>();
	}
}
