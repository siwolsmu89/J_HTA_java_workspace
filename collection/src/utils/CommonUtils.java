package utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
	
	private static final DecimalFormat NUMBER_FORMATTER = new DecimalFormat("#,###");
	private static final SimpleDateFormat NORMAL_DATE_FORMATTER = new SimpleDateFormat("yyyy/MM/dd");
	private static final SimpleDateFormat DETAIL_DATE_FORMATTER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public static String numberToString(long number) {
		return NUMBER_FORMATTER.format(number);
	}
	
	public static String simpleDateString(Date date) {
		if (date == null) {
			return " ";
		}
		
		return NORMAL_DATE_FORMATTER.format(date);
	}
	
	public static String detailDateString(Date date) {
		if (date == null) {
			return " ";
		}
		
		return DETAIL_DATE_FORMATTER.format(date);
	}
}
