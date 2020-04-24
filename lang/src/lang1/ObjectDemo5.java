package lang1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectDemo5 {
	
	public static void main(String[] args) {
		
		User user = new User (10, "hong", "010-1111-2345");
		
		// user참조변수가 참조하는 객체의 설계도 정보를 가지고 있는 Class객체가 반환된다.
		Class<? extends User> clazz = user.getClass(); // class는 변수명으로 쓸 수 없어서 clazz라고 많이 씀
		
		String className = clazz.getName();
		System.out.println("클래스명: " + className);
		
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println("필드명: "+field.getName()+", "+field.getType().getTypeName());
		}
		
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			String returnType = method.getReturnType().getTypeName();
			String name = method.getName();
			System.out.println(returnType+" "+name);
		}
	}
}
