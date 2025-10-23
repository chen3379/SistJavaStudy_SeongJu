package day1023;

public class StringIndex_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "나는 지금 쌍용교육센터에서 IT교육중입니다";
		
		char ch = str.charAt(6); // 6번째 문자(0번부터 시작)
		String word1 = str.substring(6); // 6번부터 끝까지(0번부터 시작)
		String word2 = str.substring(6, 12); // 6번부터 11번까지(a,b면 a부터 b-1까지)
		int i = str.length();
		
		System.out.println(ch); // 쌍
		System.out.println(word1); // 쌍용교육센터에서 IT교육중입니다
		System.out.println(word2);
		System.out.println(i);
	}

}
