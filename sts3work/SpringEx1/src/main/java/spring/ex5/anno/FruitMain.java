package spring.ex5.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FruitMain {

	public static void main(String[] args) {
		ApplicationContext app1 = new ClassPathXmlApplicationContext("annoContext4.xml");
		
		Apple apple=(Apple)app1.getBean("apple");
		apple.writeFruitName();
		
		MyFruit my=(MyFruit)app1.getBean("myFruit");
		my.writeFruit();

		
	}
}
