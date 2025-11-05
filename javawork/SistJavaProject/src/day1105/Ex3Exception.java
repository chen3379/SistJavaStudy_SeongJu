package day1105;

public class Ex3Exception {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작!!");
		try {
			int num=3/0; //정수를 0으로 나누면 에러발생
		} catch (Exception e) {
			// 예외처리
			//e.printStackTrace();//자세한 예외정보
			System.out.println(e.getMessage()); //에러발생 메세지로 출력
		} 
		System.out.println("프로그램 정상종료!!!");
	}
}
