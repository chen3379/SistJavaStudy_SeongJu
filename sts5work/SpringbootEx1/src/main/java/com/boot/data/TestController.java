package com.boot.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.test.ShopDto;
import com.boot.test.TestDto;

@Controller
public class TestController {

	@ResponseBody
	@GetMapping("/test")
	public TestDto hello() {
		TestDto dto=new TestDto();
		
		dto.setAddr("강남");
		dto.setName("고윤정");
		
		return dto;
	}
	
	@ResponseBody
	@GetMapping("/shop/list")
	public List<ShopDto> shop(){
		List<ShopDto> list=new ArrayList<>();
		ShopDto dto=new ShopDto();
		dto.setSangpum("아이폰17");
		dto.setSu(42);
		dto.setDan(2000000);
		
		
		ShopDto dto2=new ShopDto();
		dto2.setSangpum("아이폰18");
		dto2.setSu(50);
		dto2.setDan(2300000);
		
		list.add(dto);
		list.add(dto2);
		
		return list;
	}
	
}
