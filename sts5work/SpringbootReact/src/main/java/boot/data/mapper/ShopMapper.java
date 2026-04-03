package boot.data.mapper;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.ShopDto;

@Mapper
public interface ShopMapper {

	public void insertShop(ShopDto dto);
}
