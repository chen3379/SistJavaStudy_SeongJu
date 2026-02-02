package spring.anno.quiz;

import org.springframework.stereotype.Component;

public interface ShopDaoInter {
	public void insertShop(String sangpum,int price);
	public void deleteShop(String num);
	public void selectShop(String sangpum,int price);
	
}
