package day1105;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class Ex8FileException {
	
	public static void read() {
		
		// 경로는 / 혹은 \\
		String fileName="C:\\sist1017\\work\\file\\readTest.txt";
		BufferedReader br=null;
		FileReader fr=null; //문자단위
		
		//읽기 위해서 파일열기..생성
		try {
			fr=new FileReader(fileName);
			System.out.println("파일을 열었습니다\n");
			br=new BufferedReader(fr);
			
			//여러 줄을 읽을 수 있으므로 while(true)문으로 읽는다
			while(true) {
				
				//메모장에서 내용을 한 줄씩 읽는다
				String s=br.readLine();
				
				if(s==null)
					break;
				
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			// Exception 이 발생하던 안하던 무조건 실행되는 영역
			// 파일이나 DB 자원을 반납
			// 실행한 순서의 거꾸로 닫는다
			
			try {
				br.close();
				fr.close();
				System.out.println("파일에 대한 자원을 모두 정리했습니다");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		read();
		System.out.println("정상 종료");
	}

}
