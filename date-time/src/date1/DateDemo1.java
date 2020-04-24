package date1;

import java.util.Date;

public class DateDemo1 {

	public static void main(String[] args) {
		
		// 시스템의 현재 시간 정보를 갖는 Date 객체가 생성된다.
		Date now = new Date();
		System.out.println(now);
		
		// 1970-01-01 00:00:00 이후로부터 Date객체가 가리키는 시간까지의 밀리초값 (1초에 1000씩 증가)
		long unixTime = now.getTime();
		System.out.println(unixTime);
		unixTime = System.currentTimeMillis();
		System.out.println(unixTime);
		
		
	}
}
