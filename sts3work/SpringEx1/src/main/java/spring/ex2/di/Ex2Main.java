package spring.ex2.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex2Main {

	public static void main(String[] args) {
		ApplicationContext app2=new ClassPathXmlApplicationContext("appContext2.xml");
		
		//MyInfo
		MyInfo my=(MyInfo)app2.getBean("my");
		
		//값 확인
		System.out.println(my.toString());
		System.out.println(my); //메서드 생략시 자동호출되는 메서드
		
		//Person
		Person p=(Person)app2.getBean("person");
		
		p.writeData();
	}
}
