package map;

import java.util.HashMap;

public class HashMapDemo1 {
	public static void main(String[] args) {

		HashMap<String, String> contacts = new HashMap<String, String>();

		// HashMap 객체에 key/value 쌍으로 저장하기
		contacts.put("eungsu", "이응수");
		contacts.put("hong", "홍길동");
		contacts.put("hong123", "홍길동");
		contacts.put("kang", "강감찬");
		
		// HashMap 객체에 저장도니 값 조회하기
		String value = contacts.get("hong");
		System.out.println("key[hong]으로 조회한 값: " + value);
		
		// HashMap 객체에 이미 key가 존재하는지 확인하기
		boolean exist = contacts.containsKey("hong");
		System.out.println("key[hong]이 존재하는가? " + exist);
		
		// HashMap 객체에 저장된 entry(키/값의 쌍)의 개수 조회하기
		int size = contacts.size();
		System.out.println("HashMap객체에 저장된 Entry의 총 개수: " + size);
		
		// HashMap 객체에 저장된 Entry 삭제하기
		contacts.remove("hong");
		
		System.out.println(contacts);
		
		// HashMap 객체에 저장된 모든 Entry 삭제하기
		contacts.clear();
		
		System.out.println(contacts);

	}

}
