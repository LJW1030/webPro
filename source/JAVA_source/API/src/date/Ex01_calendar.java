package date;

import java.util.Calendar;

public class Ex01_calendar {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // 싱글톤 클래스
		System.out.println(cal); // 가독성 저하
		int year = cal.get(Calendar.YEAR); // 년도
		int month = cal.get(Calendar.MONTH)+1; // 월 0,1,2,3,...,11월
		int day = cal.get(Calendar.DAY_OF_MONTH); // 일
		int week = cal.get(Calendar.DAY_OF_WEEK); // 일1,월2,화3,수4, ... 토7
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 24시간 단위
		int ampm = cal.get(Calendar.AM_PM); // 0(오전) 1(오후)
		int hour = cal.get(Calendar.HOUR); // 12시간 단위
		int min = cal.get(Calendar.MINUTE); // 분
		int sec = cal.get(Calendar.SECOND); //초
		int millisec = cal.get(Calendar.MILLISECOND); // 밀리세컨
		
		System.out.printf("%d년 %d월 %d일 \n", year, month,day);
		switch(week) {
		case 1: System.out.print("일요일"); break;
		case 7: System.out.print("월요일"); break;
		case 2: System.out.print("화요일"); break;
		case 3: System.out.print("수요일"); break;
		case 4: System.out.print("목요일"); break;
		case 5: System.out.print("금요일"); break;
		case 6: System.out.print("토요일"); break;
		}
		System.out.print(ampm == 0? "오전":"오후");
		System.out.printf("%d시 %d분 %d초 %d\n", hour, min, sec, millisec);
		System.out.printf("%d시 %d분 %d초 %d\n", hour24, min, sec, millisec);
	
		// %d(정수) %f(실수) %s(문자열) %c(문자)
		// %tY(년) %tm(월) %td(요일) %tH(24시) %t1(12시) %tM(분) %ts(초)
		System.out.printf("%tY년 %tm월 %td일 %ta요일 %tp %tl시 %tM분 %ts초 \n", cal, cal, cal, cal, cal, cal, cal, cal);
		//System.out.printf("%tY년 %tm월 %td일 %ta요일 %tp %t1시 %tM분 %tS초"
	}
}
