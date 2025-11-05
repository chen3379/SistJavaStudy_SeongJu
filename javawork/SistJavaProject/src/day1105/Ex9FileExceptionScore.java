package day1105;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex9FileExceptionScore {

	//	score.txt 읽고 총 몇 개인지 구하고
	//	점수에 대한 총점 평균 구해서 출력하기
	public static void scoreRead() throws IOException,FileNotFoundException {
		String fileName="C:\\sist1017\\work\\file\\score.txt";
		FileReader fr=null;
		BufferedReader br=null;
		int cnt=0;
		int sum=0;
		//파일읽기
		fr=new FileReader(fileName);
		System.out.println("파일이 정상적으로 오픈!");
		br=new BufferedReader(fr);

		while(true) {
			String s = br.readLine();

			if(s==null)
				break;
			else {
				int a=Integer.parseInt(s);
				cnt++;
				sum+=a;					
			}


			System.out.println(s);
		}
		System.out.println("--------------------------------");
		System.out.println("총 "+cnt+"개\n총점: "+sum+"점\n평균: "+(double)sum/cnt+"점");	
		//finally - 자원닫기
		br.close();
		fr.close();

	}


	public static void main(String[] args) {
		try {
			scoreRead();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}System.out.println("정상종료");
	}
}
