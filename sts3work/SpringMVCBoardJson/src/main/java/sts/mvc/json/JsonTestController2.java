package sts.mvc.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonTestController2 {

	@GetMapping("/list2")
	public List<FoodDto> list2(){
		List<FoodDto> list=new ArrayList<FoodDto>();
		list.add(new FoodDto("샌드위치", "1.jpg"));
		list.add(new FoodDto("타코야끼", "2.jpg"));
		list.add(new FoodDto("김치우동", "3.jpg"));
		
		return list;
	}
}
