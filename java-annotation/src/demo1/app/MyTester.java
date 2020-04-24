package demo1.app;

import demo1.annotation.Test;

public class MyTester {

	@Test
	public void test1() {
		System.out.println("test1 실행됨");
	}
	
	public void test2() {
		System.out.println("test2 실행됨");
	}
	
	@Test
	public void test3() {
		System.out.println("test3 실행됨");
	}
	
}
