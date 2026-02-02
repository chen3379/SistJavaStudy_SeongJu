package spring.anno.quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopMain {

	public static void main(String[] args) {
		//OrderController에 있는 메서드 2개를 호출하여 출력하시오
		ApplicationContext app = new ClassPathXmlApplicationContext("quizContext.xml");
		
		OrderController order=(OrderController)app.getBean("orderController");
		
		order.jumunInsert("바나나", 3);
		order.jumunSelect("사과", 2);
	}
}
