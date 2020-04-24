package lang1;

import java.util.HashSet;

public class ObjectDemo2 {

	public static void main(String[] args) {

		User user1 = new User(10, "홍길동", "010-1111-1111");
		User user2 = new User(10, "홍길동", "010-1111-1111");

		// HashSet은 객체를 여러 개 담을 수 있는 자료구조 객체이다.
		// HashSet은 동일한 객체를 중복저장하지 않는다.
		HashSet<User> set = new HashSet<User>();

		set.add(user1);
		set.add(user2);

		System.out.println("Set에 저장된 객체 --> " + set);

	}
}
