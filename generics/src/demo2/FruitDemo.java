package demo2;

public class FruitDemo {

	public static void main(String[] args) {

		// Fruit, Apple, Grape 객체를 담는 과일 상자
		FruitBox<Fruit> box1 = new FruitBox<Fruit>();
		box1.add(new Fruit());
		box1.add(new Apple());
		box1.add(new Grape());
		
		// Apple만 담는 과일 상자
		FruitBox<Apple> box2 = new FruitBox<Apple>();
//		box2.add(new Fruit());
//		box2.add(new Grape());
		box2.add(new Apple());
		
		// Grape만 담는 과일 상자
		FruitBox<Grape> box3 = new FruitBox<Grape>();
//		box3.add(new Fruit());
//		box3.add(new Apple());
		box3.add(new Grape());
		
		Mixer.mix(box1);		// 과일박스
		Mixer.mix(box2);		// 과일박스<Apple>
		Mixer.mix(box3);		// 과일박스<Grape>
		
		Mixer.mix2(box1);
		
	}
}
