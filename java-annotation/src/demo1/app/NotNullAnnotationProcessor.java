package demo1.app;

import java.lang.reflect.Field;

import demo1.annotation.NotNull;

public class NotNullAnnotationProcessor {

	public static void main(String[] args) throws Exception {
		User user = new User();
		
		user.setName("홍길동");

		Class clz = user.getClass();
		
		Field[] fields = clz.getDeclaredFields();
 		for (Field field : fields) {
 			String fieldName = field.getName();
 			boolean isNotNullField = field.isAnnotationPresent(NotNull.class);
 			if (isNotNullField) {
 				String value = (String)field.get(user);
 				System.out.println("필드명: " + fieldName + ", " + value);
 				if (value == null) {
 					NotNull annotation = field.getAnnotation(NotNull.class);
 					String message = annotation.message();
 					System.out.println("에러 메시지: " + message);
 				}
 			}
 		}
	}
}
