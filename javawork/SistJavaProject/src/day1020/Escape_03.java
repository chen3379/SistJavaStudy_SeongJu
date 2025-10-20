package day1020;

public class Escape_03 {

	public static void main(String[] args) {
		//문자열 내에서 특별한 의미로 해석되는 문자(Escape Sequence)
		// \t :탭
		// \n :다음줄로 이
		// \' :소따옴표
		// \" :대따옴표
		// \\: \백슬래시

		System.out.println("Apple\tOrange\tBanana");
		System.out.println("Apple\nOrange\nBanana");
		//출력을  'Apple'
		System.out.println("\'Apple\'");
		//출력을 c:\
		System.out.println("c:\\");
		// 출력을   "blue","yellow","pink"  이렇게 출력해 보세여
		System.out.println("\"blue\",\"yellow\",\"pink\"");
	}

}
