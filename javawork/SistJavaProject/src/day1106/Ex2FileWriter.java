package day1106;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Ex2FileWriter {

	public static void fileWrite() {
		FileWriter fw=null;
		String fileName="C:\\sist1017\\work\\file\\test1.txt";
		
		try {
			fw=new FileWriter(fileName); //파일 새로 생성(같은 이름이 존재하더라도 새로 생성)
			
			//파일에 내용 추가
			fw.write("Have a Nice Day!!!\n");
			fw.write(new Date().toString());
			
			System.out.println("파일 저장 성공");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void fileWrite2() {
		
		FileWriter fw=null;
		String fileName="C:\\sist1017\\work\\file\\test2.txt";
		
		try {
			fw=new FileWriter(fileName, true);
			
			fw.write("Hi, I'm seongju!\n");
			fw.write(new Date().toString()+"\n");
			
			System.out.println("파일2 저장 성공");
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		fileWrite();
		fileWrite2();
	}
}
