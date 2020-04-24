package lang1;

public class ObjectDemo4 {

	public static void main(String[] args) throws CloneNotSupportedException {
		User user = new User(10, "홍길동", "010-1111-1111");
		
		User cloneUser = user.copy();
		System.out.println(user);
		System.out.println(cloneUser);
	}
}
