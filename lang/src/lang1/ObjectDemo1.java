package lang1;

public class ObjectDemo1 {

	public static void main(String[] args) {

		User user1 = new User(10, "홍길동", "010-1111-1111");
		User user2 = new User(10, "홍길동", "010-1111-1111");

		// user1의 주소값과 user2의 주소값이 같은지 비교한다.
		boolean result1 = user1 == user2;
		System.out.println("같은 객체인가? " + result1);

		// Object의 equals(Object other)는
		// user1과 user2의 주소값이 같은지 비교한다.
		// 만약 User에서 equals 메소드를 재정의했다면 해당 내용으로 실행된다.
		boolean result2 = user1.equals(user2);
		System.out.println("같은 객체인가? " + result2);

		String str1 = new String("홍길동");
		String str2 = new String("홍길동");

		boolean result3 = str1 == str2;
		System.out.println("같은 객체인가? " + result3);
		
		boolean result4 = str1.equals(str2);
		System.out.println("내용이 같은가? " + result4);
	}
}
