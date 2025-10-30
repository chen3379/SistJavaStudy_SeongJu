package day1021;

import java.util.Calendar;
import java.util.Date;

public class CalTest_04 {

	@SuppressWarnings({ "deprecation", "static-access" })
	public static void main(String[] args) {
		// 
		
		Date date=new Date();
		
		System.out.println("지금은 "+(date.getYear()+1900)+"년입니다");
		
		Calendar cal =Calendar.getInstance();
		
		System.out.println("지금은 "+cal.get(cal.YEAR)+"년도입니다");
		System.out.println("지금은 "+(cal.get(cal.MONTH)+1)+"월입니다");
		System.out.println("지금은 "+cal.get(cal.DAY_OF_MONTH)+"일입니다");
		System.out.println("지금은 "+cal.get(cal.DATE)+"일입니다");
		System.out.println("시간은 "+cal.get(cal.HOUR_OF_DAY)+"시"+cal.get(cal.MINUTE)+"분입니다");
		
		
		
	}

}
