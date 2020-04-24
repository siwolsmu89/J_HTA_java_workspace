package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDemo {

	public static void main(String[] args) 
		throws FileNotFoundException, IOException, ClassNotFoundException {
		
		FileInputStream fis = new FileInputStream("c:/files/user.sav");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// 스트림으로 읽어온 직렬화된 객체의 정보를 바탕으로 User 객체를 복원한다.
		// ois.readObject()의 반환 타입은 Object이기 때문에 (User)로 수동형변환을 해준다.
		User user = (User) ois.readObject();
		System.out.println("번    호: " + user.getNo());
		System.out.println("아 이 디: " + user.getUserId());
		System.out.println("비밀번호: " + user.getPassword());
		System.out.println("전화번호: " + user.getTel());
		System.out.println("이 메 일: " + user.getEmail());
		System.out.println("등    급: " + user.getGrade());
		
		ois.close();
		
	}
}
