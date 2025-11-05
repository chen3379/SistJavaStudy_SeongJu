package day1105;

import java.io.IOException;
import java.io.InputStream;

//문자스트림: Reader, Writer 대부분 문자 단위로 처리
//바이트스트림: InputStream, OutputStream _ 대부분 바이트 단위로 처리
public class Ex6StreamException {

	public static void main(String[] args) {
		
		InputStream is=System.in; //console 에서 입력받기 위한 stream
		int a=0;
		
		System.out.println("한글자 입력: ");
		try {
			//Java 에서 read()를 호출할 때 try-catch를 쓰도록 규정
			a=is.read(); //read()는 1바이트밖에 못 읽는다(한글 불가)
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("오류: "+e.getMessage());
		}
		System.out.println("3초 뒤에 출력합니다");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("입력값: "+(char)a);
	}
}
