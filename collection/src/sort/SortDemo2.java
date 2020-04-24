package sort;

import java.util.TreeSet;

public class SortDemo2 {

	public static void main(String[] args) {
		
		TreeSet<String> set = new TreeSet<String>();
		set.add("류관순");
		set.add("이순신");
		set.add("강감찬");
		set.add("안중근");
		set.add("김유신");
		set.add("김구");
		set.add("윤봉길");
		
		for(String name : set) {
			System.out.print(name+"\t");
		}
	}
}
