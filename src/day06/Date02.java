package day06;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date02 {

	public static void main(String[] args) {
		// LocalDateTime
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today);
		System.out.println(today.getYear());
		String t = today.toString();
		System.out.println(t);
		String date = t.substring(0, t.indexOf("T"));
		System.out.println(date);
		String hms = t.substring(t.indexOf("T")+1,t.indexOf("T")+9);
		System.out.println(hms);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		System.out.println(dtf.format(today));
		
		LocalDateTime sDate = LocalDateTime.of(1998, 4, 21, 14, 00);
		System.out.println(sDate.format(dtf));
	}

}
