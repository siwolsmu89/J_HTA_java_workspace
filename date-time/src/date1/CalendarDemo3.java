package date1;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo3 {

	public static void main(String[] args) {
		
		// Date ---> Calendar
		Date date1 = new Date();
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		
		// Calendar ---> Date
		Calendar cal2 = Calendar.getInstance();
		Date date2 = new Date(cal2.getTimeInMillis());
		
	}
}
