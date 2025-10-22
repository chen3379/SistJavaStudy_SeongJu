package day1021;

public class OperTest_12 {

	public static void main(String[] args) {
		// 비교(관계)연산자: >, <, >=, <=, ==, !=
		// 논리연산자: &&(and), ||(or), !(not)

		int a=5,b=3,c=5;
		
		// 결과값이 true, false
		System.out.println(a>b); // true
		System.out.println(a==b); // false
		System.out.println(!(a==b)); // true
		System.out.println(a!=b); // true
		System.out.println(a>b&&b>c); // t&&f => false
		System.out.println(a>b&&b<c); // t&&t => true
		System.out.println(a>b||b>c); // t||f => true
	}

}
