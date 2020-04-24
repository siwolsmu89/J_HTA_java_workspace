package demo2;

import java.util.ArrayList;

public class FruitBox<T> {
	
	private ArrayList<T> list = new ArrayList<T>();

	public void add(T t) {
		list.add(t);
	}
	
	public T get(int index) {
		return list.get(index);
	}
	
	public int size() {
		return list.size();
	}
	
}
