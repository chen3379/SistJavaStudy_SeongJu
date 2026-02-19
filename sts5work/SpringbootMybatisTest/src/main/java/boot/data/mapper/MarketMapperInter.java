package boot.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.MarketDto;

@Mapper
public interface MarketMapperInter {

	//등록된 상품 갯수
	public int getTotalCount();
	
	//상품 등록
	public void insertMarket(MarketDto dto);
	
	//전 상품 조회
	public List<MarketDto> getAllSangpums();
	
	public void deleteMarket(String num);
	
	public MarketDto getSangpum(String num);
	
	public void updateMarket(MarketDto dto);
}
