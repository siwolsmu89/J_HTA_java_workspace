package set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo1 {

	public static void main(String[] args) {
		HashSet<String> names = new HashSet<String>();
		
		names.add("홍길동");
		names.add("홍길동");
		names.add("홍길동");
		names.add("김유신");
		names.add("강감찬");
		names.add("이순신");
		names.add("류관순");
		names.add("안중근");

		// 꺼내기
		// Enhanced-for문
		for(String name : names) {
			System.out.println(name);
		}
		System.out.println();
		
		// Iterator
		Iterator<String> itr = names.iterator();
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
		System.out.println();
		
		// 저장된 객체의 개수 반환
		int size = names.size();
		System.out.println("저장된 객체의 수 :" + size);
		System.out.println();
		
		// 전부 삭제
		names.clear();
		
		// 비어있으면 true 반환
		boolean empty = names.isEmpty();
		System.out.println("비어있는가? " + empty);
		
		System.out.println(names);
	}
}
