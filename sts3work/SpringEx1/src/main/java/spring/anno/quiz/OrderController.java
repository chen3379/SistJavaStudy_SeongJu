package spring.anno.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderController {

	@Autowired
	ShopDao shopdao;
	
	int cnt=20;
	String name="김나난";
	
	public void jumunInsert(String sang,int p) {
		
		shopdao.insertShop(sang, p);
		System.out.println(name+"님이 "+cnt+"개 주문함!!!");
	}
	
	public void jumunSelect(String sang,int p) {
		
		shopdao.selectShop(sang, p);
		System.out.println("주문자: "+name);
		System.out.println("주문개수: "+cnt+"개");
	}
	
}
