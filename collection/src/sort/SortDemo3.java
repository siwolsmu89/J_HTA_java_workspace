package sort;

import java.util.ArrayList;
import java.util.Collections;

public class SortDemo3 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("류관순");
		list.add("이순신");
		list.add("안중근");
		list.add("강감찬");
		list.add("김유신");
		list.add("김구");
		list.add("윤봉길");
		
		Collections.sort(list);
		
		for(String name : list) {
			System.out.print(name+"\t");
		}
	}
}
