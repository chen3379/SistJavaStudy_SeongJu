package spring.ex3.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SawonMain {
	public static void main(String[] args) {
		// writeData() 출력하기
		ApplicationContext app=new ClassPathXmlApplicationContext("sawonConfig.xml");
		Sawon sa=app.getBean("saw",Sawon.class);
		sa.writeData();
		Sawon sa2=app.getBean("saw2",Sawon.class);
		sa2.writeData();
	}
}
