package day1027;

import java.util.Scanner;

public class ArrayQuiz_09 {

	public static void main(String[] args) {

		// 메뉴명을 입력하여 '해당 메뉴는 2번째에 있습니다' Q or q를 입력 시 프로그램 종료
		// 티본스테이크 처럼 없는 메뉴 입력 시 '해당 메뉴는 존재하지 않습니다'

		String menu[] = {"아보카도 샌드위치","에그샌드위치","콥샐러드","치아바타 샌드위치","스테이크 샐러드","까르보나라 파스타","토마토 파스타"};

		boolean flag;

		Scanner sc=new Scanner(System.in);

		while(true) {
			System.out.println("검색할 메뉴명을 입력하세요");
			String a=sc.nextLine();

			if(a.equalsIgnoreCase("q")) {
				System.out.println("프로그램 종료");
				break;
			}
			flag=false;

			for(int i=0;i<menu.length;i++) {		
				if(a.equals(menu[i])) {
					flag=true;
					System.out.println("해당 메뉴는 "+(i+1)+"번째에 있습니다\n");
				}
				
			}
			
			if(!flag) 
				System.out.println("해당 메뉴는 존재하지 않습니다\n");
			
		}
		sc.close();

	}
}
