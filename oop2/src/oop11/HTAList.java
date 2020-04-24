package oop11;

public class HTAList {
	private String[] data = new String[100];
	private int position = 0;
	
	public void add(String value) {
		data[position] = value;
		position++;
	}
	
	// 꺼내기 기능이 구현된 HTAIterator 타입의 HTAListIterator 객체가 반환됨
	public HTAIterator iterator() {
		HTAListIterator iter = new HTAListIterator();
		return iter;
	}
	
	// HTAList에 저장한 데이터에 대한 꺼내기 기능이 구현된 HTAListIterator 클래스
	class HTAListIterator implements HTAIterator {
		
		private int currentPosition = 0;
		
		@Override
		public String next() {
			String value = data[currentPosition];				// 멤버 변수 data 사용 (private이지만 문제x)
			currentPosition++;
			
			return value;
		}

		@Override
		public boolean hasNext() {
			boolean hasValue = true;
			if (currentPosition == position) {					// 멤버 변수 position 사용 (private이지만 문제x)
				hasValue = false;
			}
			return hasValue;
		}
	}


}
