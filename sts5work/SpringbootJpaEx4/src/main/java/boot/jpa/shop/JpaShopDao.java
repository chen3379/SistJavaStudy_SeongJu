package boot.jpa.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaShopDao {

	@Autowired
	JpaShopDaoInter inter;
	
	public void insertShop(ShopDto dto) {
		inter.save(dto);
	}
	
	public List<ShopDto> getAllSangpums() {
		return inter.findAll();
	}
	
	public ShopDto getSangpum(int num) {
		return inter.getById(num);		
	}
	
	public void deleteShop(int num) {
		inter.deleteById(num);
	}
	
	public void updateShop(ShopDto dto) {
		inter.save(dto);
	}
	
}
