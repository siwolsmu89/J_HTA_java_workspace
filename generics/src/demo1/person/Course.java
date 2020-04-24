package demo1.person;

public class Course<T> {

	private String title;
	private T t;
	
	public Course() {}
	
	public Course(String title) {
		this.title = title;
	}
	
	public void add(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
}
