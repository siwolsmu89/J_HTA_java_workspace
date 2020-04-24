package date1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateDemo5 {

	public static void main(String[] args) throws ParseException {
		
		// 기념일 계산기
		Date today = new Date();
		final long ONE_DATE_TIME = 60*60*24*1000;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy.M.d");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("--------------------------");
		System.out.println("1.며칠째 날?  2.그 날은 며칠일까? ");
		
		System.out.print("메뉴를 선택하세요: ");
		int menuNo = scanner.nextInt();
		
		if(menuNo == 1) {
			System.out.print("기념일을 입력하세요(입력예 : 2001.4.29) : ");
			String text = scanner.next();
		
			Date memorialDay = df.parse(text);
			
			long todayTime = today.getTime();
			long memorialDayTime = memorialDay.getTime();
			
			long dayCount = (todayTime-memorialDayTime)/ONE_DATE_TIME;
			
			System.out.println("오늘은 "+dayCount +"일째 날입니다.");
		} else if (menuNo == 2) {
			System.out.print("날 수를 입력하세요(입력예 : 100) : ");
			int dayCount = scanner.nextInt();
			
			long todayTime = today.getTime();
			long dayTime = ONE_DATE_TIME * dayCount;
			
			Date futureDay = new Date(todayTime+dayTime);
			String text = df.format(futureDay);
			System.out.println("["+dayCount+"]일째 되는 날은 "+text+"입니다.");
		
		}
		
		
	}
}
