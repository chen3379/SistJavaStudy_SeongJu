package day1021;

public class DataType_03 {

	public static void main(String[] args) {
		// 묵시적 형 변환: 자동으로 결정되는 타입
		
		//String+int=String (2023 + 원 => 문자열)
		//double+int=double
		//long+short=long
		//char+int=int (char는 문자형이지만 ASCII코드를 품고 있기 때문)
		
		char a='A' ;
		
		System.out.println(a);
		System.out.println((int)a); // char는 숫자를 숨긴 문자형이므로 int로 형 변환 시 해당하는 숫자 출력
		System.out.println(a+32); // 97
		System.out.println(a+2); //67
		System.out.println((char)(a+32)); //a
		System.out.println((char)(a+2)); //C
		
		System.out.println("A"+(5+6)); //A11
		System.out.println('A'+3); //68
		System.out.println(2+'b'); //100
		System.out.println('a'+'b'); //97+98=195
		
	}

}
