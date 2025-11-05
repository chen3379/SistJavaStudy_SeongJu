package day1105;

import java.util.Scanner;

//throws: 호출한 영역으로 예외처리를 던짐
//throw: 강제로 예외를 발생시킬 때


public class Ex7Throws {

	//method
	public static void scoreInput() throws Exception{
		Scanner sc=new Scanner(System.in);
		int score=0;
		
		//점수가 1~100 점 사이가 아니면 exception 발생
		System.out.println("점수를 입력하세요");
		score=sc.nextInt();
		
		if(score<1 || score>100)
			throw new Exception("점수가 잘못 입력됐습니다");
		else
			System.out.println("나의 점수는 "+score+"점 입니다");
	}
	
	
	public static void main(String[] args) {
		try {
			scoreInput();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("오류메세지: "+e.getMessage());
		}
		System.out.println("정상종료");
	}
}
