package oop1;

public class TvDemo2 {

	public static void main(String[] args) {
		
		Tv tv1 = new Tv();
		IPTv tv2 = new IPTv();
		NetflixTv tv3 = new NetflixTv();
		NetflixTv tv4 = new NetflixTv();
		
		String desc1 = tv1.toString();
		String desc2 = tv2.toString();
		String desc3 = tv3.toString();
		String desc4 = tv4.toString();
		
		System.out.println(desc1);
		System.out.println(desc2);
		System.out.println(desc3);
		System.out.println(desc4);
		
		// 자바는 참조변수의 값을 출력해 볼 수 없다.
		// 참조변수의 값을 출력하려고 시도하면, 참조변수의 값을 출력하는 대신 참조변수가 참조하는 객체의 toString() 메소드를 실행한다.
		System.out.println(tv1);
		System.out.println(tv2);
		System.out.println(tv3);
		System.out.println(tv4);
		
		System.out.println(tv1.toString());
		System.out.println(tv2.toString());
		System.out.println(tv3.toString());
		System.out.println(tv4.toString());
	}
	
}
