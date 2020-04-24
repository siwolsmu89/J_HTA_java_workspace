package list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		
		// 오류 : 타입파라미터<E>에는 클래스명이 정의되어야 한다.
		// 		기본자료형 int는 자바의 키워드로, 클래스명이 아니다.
		// ArrayList<int> numbers = new ArrayList<int>();
		// ArrayList<long> numbers = new ArrayList<long>();
		// ArrayList<double> numbers = new ArrayList<double>();
		
		// 기본자료형은 해당하는 wrapper class를 타입파라미터로 지정해야 한다. (근데 이렇게 담을 일이 거의 없음 - 우리가 다루는 data들은 값이 여럿으로 이루어져 있기 때문에)
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Long> currencies = new ArrayList<Long>();
		ArrayList<Double> scores = new ArrayList<Double>();
		
		
		numbers.add(new Integer(10));
		numbers.add(10);				// AutoBoxing : 자바 1.5부터 가능해짐 (실제 코드는 위의 코드가 실행)
		
		
		currencies.add(new Long(100000000000L));
		currencies.add(100000000000L);	// AutoBoxing : 자바 1.5부터 가능해짐 (실제 코드는 위의 코드가 실행)
		
		
		scores.add(new Double(4.2));
		scores.add(4.2);				// AutoBoxing : 자바 1.5부터 가능해짐 (실제 코드는 위의 코드가 실행)
		
		for(Integer num : numbers) {
			System.out.println(num);
		}
		
		for(int num : numbers) {
			System.out.println(num);
		}
		
		Iterator<Long> itr = currencies.iterator();
		while(itr.hasNext()) {
			Long curr = itr.next();
			System.out.println(curr);
		}
		
		itr = currencies.iterator();
		while(itr.hasNext()) {
			long curr = itr.next();
			System.out.println(curr);
		}
	}
}
