package date1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo4 {

	public static void main(String[] args) throws ParseException {
		/*
		 *  지정된 날짜 형식으로 작성된 문자열을 Date로 변환하기
		 */
		
		String text = "2020.4.6.";
		text = "1989.10.27";
//		SimpleDateFormat의 파라미터와 text의 형식이 틀리면 ParseException 발생, 읽어오지 못함.		
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
//		Date date = df.parse(text);   -> throws ParseException
	
		SimpleDateFormat df = new SimpleDateFormat("yyyy.M.d");
		Date date = df.parse(text);
		System.out.println(date);
		
	}
}
