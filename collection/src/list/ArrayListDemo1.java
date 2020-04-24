package list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo1 {

	public static void main(String[] args) {

		/*
		 * ArrayList의 특징 0. 저장했던 순서대로 다시 꺼낼 수 있다. (순서가 보장됨) -제일 중요! 1. 타입파라미터<E>는 특정 타입만
		 * 저장하는 콜렉션을 생성한다. (타입 안전성) 2. 저장소의 크기를 별도로 지정할 필요가 없다. 3. 더이상 저장할 공간이 없으면 공간의
		 * 크기를 자동으로 조절한다. 4. 저장할 때 인덱스를 별도로 지정할 필요가 없다. 5. Enhanced-for문을 사용해서 저장된 모든
		 * 객체를 쉽게 꺼낼 수 있다. 6. 특정 위치의 객체를 삭제하면 자동으로 그 다음에 위치하고 있는 객체들이 앞으로 이동해서 빈 곳을 채운다.
		 */

		// ArrayList 생성하기 <--- String 객체를 담는 ArrayList객체 생성
		ArrayList<String> names = new ArrayList<String>();

		// ArrayList 저장소에 String 객체 담기
		names.add("홍길동");
		names.add("김유신");
		names.add("강감찬");
		names.add("이순신");
		names.add("류관순");

		// ArrayList 저장소에 저장된 String 객체 꺼내기
		// 1. Enhanced-for문 사용 (꺼내기만 하고 지울 일은 없을 때 사용)
		// * 조회만 가능하다
		// * 삭제가 안 된다 (ConcurrentModificationException)
		// * 객체를 저장할 때마다 자동으로 배열의 크기를 계산해서 맨 마지막으로 객체를 저장한 위치까지 반복문을 실행한다.
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println();

		// 2. Iterator 사용 (무언가 지울 일이 있을 때 사용)
		// * 조회가 가능하다
		// * 삭제가 가능하다 (Iterator에서 삭제하면 ArrayList에서도 삭제되고, 빈 공간이 없도록 배열의 크기를 조정한다.)
		Iterator<String> itr = names.iterator();
		while (itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);

			if (name.equals("강감찬")) {
				itr.remove();
			}
		}
		System.out.println(names);
		System.out.println();

		// 3. 일반 for문 사용 (List의 자손들만 가능)
		// * 권장하지 않는다.
		// * index를 활용해야 할 때 정 어쩔 수 없으면 사용 (그때도 마음에 들지 않아요)
		int length = names.size();
		// for문을 돌릴 때 조건부에 names.size() 메소드를 바로 사용하지 말고 변수에 저장해서 사용할 것 -> 매 반복에
		// size()메소드가 실행되지 않도록
		for (int i = 0; i < length; i++) {
			String name = names.get(i);
			System.out.println(name);
		}
		System.out.println();
		
		boolean empty = names.isEmpty();
		System.out.println("비어있는가? " + empty);
		
		// 저장된 객체 전부 삭제하기
		names.clear();
		
		empty = names.isEmpty();
		System.out.println("비어있는가? " + empty);
		
		// 저장된 객체의 개수 조회하기
		int size = names.size();
		System.out.println("저장된 개수: " + size);

	}
}
