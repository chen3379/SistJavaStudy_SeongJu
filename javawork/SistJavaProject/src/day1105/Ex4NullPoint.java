package day1105;

import java.util.Date;

public class Ex4NullPoint {

	Date date; //선언
	
	public void writeday() {
		int y,m,d;
		
		try {
		y=date.getYear()+1900;
		m=date.getMonth()+1;
		d=date.getDay();
		System.out.println(y+"년"+m+"월"+d+"일입니다");
		}catch (NullPointerException e) {
			System.out.println("객체 생성을 하지 않았습니다"+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Ex4NullPoint ex;
		ex=new Ex4NullPoint();
		ex.writeday();
		
		System.out.println("정상 종료");
	}
}
