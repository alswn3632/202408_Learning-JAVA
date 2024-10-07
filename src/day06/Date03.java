package day06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date03 {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println(date);
		// Date 형식의 날짜를 포멧에 맞춰서 문자열로 변경
		// yyyy-MM-dd(E) hh:mm:ss
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
		// String 형식으로 변경됨
		System.out.println(sdf.format(date));
		
		// 날짜 모양의 문자열을 => Date로 변경
		String dateStr = "2024-10-07(월) 04:48:00";
		Date date2 = null;
		date2 = sdf.parse(dateStr);
		System.out.println(date2);
		
	}	

}
