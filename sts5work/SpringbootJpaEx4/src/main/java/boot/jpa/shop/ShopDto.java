package boot.jpa.shop;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="jpashop")
@Data
public class ShopDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	
	@Column(name = "sangpum")
	private String sangpum;
	
	@Column
	private int price;

	@Column
	private String photo;
	
	@Column
	private String ipgoday;
	
}
