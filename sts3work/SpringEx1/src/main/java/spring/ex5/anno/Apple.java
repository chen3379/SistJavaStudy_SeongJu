package spring.ex5.anno;

import org.springframework.stereotype.Component;

@Component //xml에 apple이라는 id로 자동등록
public class Apple implements Fruit{

	@Override
	public void writeFruitName() {
		// TODO Auto-generated method stub
	System.out.println("나는 사과입니다");	
	}
}
