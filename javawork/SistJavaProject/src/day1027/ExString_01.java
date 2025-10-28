package day1027;

import java.util.Iterator;

public class ExString_01 {

	public static void main(String[] args) {

		// 문자열에 관한 함수_String 객체의 메서드

		String str1="apple";
		String str2="Apple";
		String str3="Happy Monday!!!";
		String str4="	Happy day	";

		// 길이

		System.out.println("str3의 길이: "+str3.length());
		System.out.println("str4의 길이: "+str4.length());

		// str의 공백 제거 후의 길이
		System.out.println("str4의 길이: "+str4.trim().length());

		// 인덱스
		System.out.println("str3에서 M의 인덱스: "+str3.indexOf('M'));
		System.out.println("str4에서 d의 인덱스: "+str4.indexOf("d"));

		// str4의 day 추출

		System.out.println("str4의 day 추출: "+str4.substring(7,10));

		// equals ..같으면 true, 다르면 false

		System.out.println("문자열 비교: "+str1.equals(str2)); // false
		System.out.println("문자열 비교(대소문자 구분X) : "+str1.equalsIgnoreCase(str2)); // true

		// a.compareTo(b)
		// a와 b가 같을 경우 0
		// a가 작을 경우 -값
		// a가 클 경우 +값

		System.out.println("str1 과 str2 비교: "+str1.compareTo(str2)); // 32: a(97)pple A(65)pple 비교
		System.out.println("str1 과 str1 비교: "+str1.compareTo(str1));
		System.out.println("키위".compareTo("오렌지"));
		System.out.println("kiwi".compareTo("orange"));

		// startsWith

		System.out.println(str3.startsWith("H"));

		// 문자열분리: split
		// 배열선언

		String str5="이태주 김민지 조성진 허현";

		System.out.println("str5를 컴마로 분리해서 출력");
		String arr[]=str5.split(" ");
		System.out.println("분리된 이름 개수: "+arr.length);

		//출력

		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");

		String str6="이태주-김민지-조성진-허현";

		System.out.println("\nstr6를 컴마로 분리해서 출력");
		String arr2[]=str6.split("-");
		System.out.println("분리된 이름 개수: "+arr2.length);
		System.out.println(arr2[2]);


	}

}
