package spring.day0202.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("자바방식의 Hello메서드 호출");
		Hello hello1 = new Hello();
		System.out.println(hello1.getMessage());

		Hello hello2 = new Hello();
		System.out.println(hello2.getMessage());
	
		System.out.println(hello1==hello2); //레퍼런스 주소비교
		
		System.out.println("스프링방식의 Hello메서드 호출");
		//설정xml파일, 어플리케이션에서만 필요
		//웹으로 실행시 web.xml에 설정이 이미 되어있음
		ApplicationContext helloApp=new ClassPathXmlApplicationContext("helloContext.xml");
		
		Hello h1=(Hello)helloApp.getBean("hello");
		System.out.println(h1.getMessage()); //방법1
		
		Hello h2=helloApp.getBean("hello",Hello.class);
		System.out.println(h2.getMessage()); //방법1

		System.out.println(h1==h2); //스프링은 기본이 싱글턴 true 생성주소가 같다
		
	}

}
