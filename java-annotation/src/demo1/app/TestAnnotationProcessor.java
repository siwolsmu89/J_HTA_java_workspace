package demo1.app;

import java.lang.reflect.Method;

import demo1.annotation.Test;

public class TestAnnotationProcessor {

	public static void main (String[] args) throws Exception {
		
		MyTester tester = new MyTester();
		
		// 생성된 객체의 설계도정보가 들어있는 Class객체를 조회한다.
		Class clazz = tester.getClass();
		
		// Class 객체의 설계또정보 중에서 해당 객체에 선언된 메소드를 전부 조회한다.
		// 메소드정보가 포함된 Method객체의 배열이 획득된다.
		Method[] methods = clazz.getDeclaredMethods();
		
		// 각 메소드 순회하기
		for (Method method : methods) {
			// 메소드의 이름 조회하기
			String methodName = method.getName();
			// 메소드에 @Test 어노테이션이 부착되어 있는지 확인하기
			boolean isPresent = method.isAnnotationPresent(Test.class);
			System.out.println(methodName + ", @Test 부착여부: " + isPresent);
			
			// @Test 어노테이션이 부착되어 있으면 
			if (isPresent) {
				// 해당 객체의 메소드를 실행한다.
				method.invoke(tester);
			}
		
		}
	}
}
