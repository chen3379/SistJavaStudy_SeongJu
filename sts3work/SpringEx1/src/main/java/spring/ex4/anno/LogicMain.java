package spring.ex4.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogicMain {
	public static void main(String[] args) {
		ApplicationContext app1=new ClassPathXmlApplicationContext("annoContext4.xml");
		
		LogicController lg1=(LogicController)app1.getBean("logicController");
		lg1.insert("점심메뉴");
		lg1.delete("3");
	}
}
