package demo1.product;

public class Box<T> {
	
	private T data;
	
	public void add(T t) {
		data = t;
	}
	
	public T get() {
		return data;
	}
	
}
