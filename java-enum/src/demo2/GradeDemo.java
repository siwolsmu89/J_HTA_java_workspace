package demo2;

public class GradeDemo {

	public static void main(String[] args) {
		
		// String name()
		// 열거형 상수의 이름을 문자열로 반환한다.
		String name = Grade.VIP.name();
		System.out.println(name);

		// int ordinal()
		// 열거형 상수의 순서값을 반환한다. (0부터 시작)
		int no1 = Grade.VIP.ordinal();
		int no2 = Grade.GOLD.ordinal();
		int no3 = Grade.SILVER.ordinal();
		int no4 = Grade.BRONZE.ordinal();
		
		System.out.println(Grade.VIP + " " + no1);
		System.out.println(Grade.GOLD + " " + no2);
		System.out.println(Grade.SILVER + " " + no3);
		System.out.println(Grade.BRONZE + " " + no4);
		
		// static T valueOf(Class<T> enumType, String name)
		// static T valueOf(String name)
		// 지정된 열거형 타입에서 이름에 해당하는 열거형 상수를 반환한다.
		Grade grade = Enum.valueOf(Grade.class, "VIP");
		System.out.println(grade.name() + ", " + grade.ordinal());
	}
}
