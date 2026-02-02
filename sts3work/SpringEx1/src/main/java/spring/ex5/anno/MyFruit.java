package spring.ex5.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyFruit {

	@Autowired
	Fruit fruit;
	
	public void writeFruit() {
		
		System.out.println("내가 가장 좋아하는 과일은!");
		fruit.writeFruitName();
	}
}
