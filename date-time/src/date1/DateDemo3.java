package date1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo3 {
	
	public static void main(String[] args) {
		/*
		 * Date를 지정된 형식의 문자열로 변환하기
		 */
		
		
		Date today = new Date();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy년 M월 d일(EEEE) Hmss");
		String formatedText = df.format(today);
		System.out.println(formatedText);
		
	}
	
	/*
	 *  패턴				출력내용			출력값			비고
	 *  ---------------------------------------------------------
	 *  yyyy			년				2020
	 *  MM				월				04				1~9월을 01~09로 표시
	 *  M				월				4				1~9월을 1~9로 표시 (10월부터는 10~12로 표시됨)
	 *  dd				일				06				
	 *  d				일				6
	 *  yyyy-MM-dd						2020-04-06
	 *  yyyy.M.d.						2020.4.6.
	 *  yyyy년 M월 d일						2020년 4월 6일
	 *  
	 *  EEEE			요일				월요일			영어로는 Monday
	 *  E, EEE			요일				월				영어로는 M, MON
	 *  a				오전/오후			오전
	 *  H, HH			24시간제(0~23시)	1, 01	
	 *	h, hh			12시간제(1~12시)	1, 01
	 *	m, mm			분(0~59)			1, 01
	 *	s, ss			초(0~59)			1, 01
	 *
	 */

}
