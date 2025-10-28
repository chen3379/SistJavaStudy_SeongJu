package day1027;

public class ArrayString_03 {

	public static void main(String[] args) {
		
				
		String str[]=new String[4];
		
		// 초기값
		str[0]="김밥";
		str[1]="떡볶이";
		str[2]="쫄면";
		str[3]="돈까스";
		
		
		System.out.println("출력_#1");
		for(int i=0;i<str.length;i++)
			System.out.print(str[i]+" ");
		System.out.println();
		
		System.out.println("출력_#2");
		for(String s1:str)
			System.out.print(s1+" ");
		
		System.out.println();
		System.out.println("선언과 동시에 초기값을 지정");
		String menu[] = {"파스타", "피자", "샐러드","양송이스프"};
		System.out.println("메뉴 개수: "+menu.length);
		
		// menu 1==> 파스타 출력해보기
		for(int i=0;i<menu.length;i++)
			System.out.println("menu "+(i+1)+"==> "+menu[i]);
		for(String m1:menu)
			System.out.print(m1+" ");
		
		System.out.println();
		
		String a[][]= {{"1","2","3","4"},{"5","6","7","8"}};
		System.out.println(a[1][3]);
		String b[][]=new String[(3)][(4)];
		System.out.println(b[2][3]);
		
	}
}
