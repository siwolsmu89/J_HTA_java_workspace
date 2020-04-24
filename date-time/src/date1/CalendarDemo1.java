package date1;

import java.util.Calendar;

public class CalendarDemo1 {

	public static void main(String[] args) {
		
		// getInstance 메소드를 사용하면 해당 지역에서 사용하는 적절한 달력 객체를 만들어서 제공해준다.
		// 우리나라는 GregorianCalendar가 생성된다.
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		int yoil = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("년: "+year);
		System.out.println("월: "+(month+1)); // 월은 실제 월-1로 표시됨
		System.out.println("일: "+day);
		System.out.println("시: "+hour);
		System.out.println("분: "+minute);
		System.out.println("초: "+second);
		System.out.println("요일: "+yoil);	// 요일은 숫자로 표시됨(일요일1 월요일2..)
	}
}
