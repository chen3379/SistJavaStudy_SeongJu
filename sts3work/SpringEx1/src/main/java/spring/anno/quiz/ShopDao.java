package spring.anno.quiz;

import org.springframework.stereotype.Component;

@Component
public class ShopDao implements ShopDaoInter {

	@Override
	public void insertShop(String sangpum, int price) {
		// TODO Auto-generated method stub
		System.out.println(sangpum+":"+price);

	}

	@Override
	public void deleteShop(String num) {
		// TODO Auto-generated method stub
		System.out.println(num+"번상품 삭제됨");
	}

	@Override
	public void selectShop(String sangpum, int price) {
		// TODO Auto-generated method stub
		System.out.println("**상품재고 조회**");
		System.out.println("상품명:"+sangpum);
		System.out.println("상품가격:"+price);

	}

}
