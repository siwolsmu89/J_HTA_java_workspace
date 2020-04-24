package demo1.product;

// 제네릭의 제한
// 제네릭타입에 extends를 사용하면 특정 타입의 자손들만 타입파라미터로 대입할 수 있다.
public class BoxForSmartPhone<T extends SmartPhone> {

	private T t;
	
	public void add(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
}
