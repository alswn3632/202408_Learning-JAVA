package day06;

import java.util.Calendar;
import java.util.Date;

public class Date01 {

	public static void main(String[] args) {
		/* 날짜, 시간 클래스
		 * Date 클래스 => Deprecated(비권장)
		 * Calendar => Date 후속작! 얘는 추상클래스 => 객체를 생성할 수 없음!
		 * New 키워드로 객체 생성이 불가능함
		 * GetInstance() 메서드를 이용하여 객체를 얻어 옴!
		 * 
		 */
		
		Date d = new Date();
		d.getDate();
		System.out.println(d.getDate()); // 나오긴 함!
		
		Calendar c = Calendar.getInstance(); // 오늘 날짜
		System.out.println(c);
		//month 0~11 반드시 +1로 표현해야 현재 월을 알 수 있음
		int year = c.get(Calendar.YEAR); 
		System.out.println(year);
		int month = c.get(Calendar.MONTH);
		System.out.println(month+1);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		int week = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		
		System.out.println(year + "-" + (month+1) + "-" + day);
		
		//2024-10-07(월) 오후 3:51 출력해보자
//		java.util.GregorianCalendar
//		[time=1728283896355,areFieldsSet=true,areAllFieldsSet=true,lenient=true,
//		zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,
//		dstSavings=0,useDaylight=false,transitions=30,lastRule=null],
//		firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2024,MONTH=9,
//		WEEK_OF_YEAR=41,WEEK_OF_MONTH=2,DAY_OF_MONTH=7,DAY_OF_YEAR=281,
//		DAY_OF_WEEK=2,DAY_OF_WEEK_IN_MONTH=1,AM_PM=1,HOUR=3,HOUR_OF_DAY=15,
//		MINUTE=51,SECOND=36,MILLISECOND=355,ZONE_OFFSET=32400000,DST_OFFSET=0]
		
		String weekStr = week == 1? "일" : week == 2? "월" : week == 3? "화" : week == 4? "수" : week == 5? "목" : week == 6? "금" : "토"; 
		String amtmStr = c.get(Calendar.AM_PM) == 1? "오후" : "오전";
		String dateStr = year + "-" + (month+1) + "-" + day + "(" + weekStr + ") " + amtmStr + " " + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE);
		System.out.println(dateStr);
	
		
		
	}

}
