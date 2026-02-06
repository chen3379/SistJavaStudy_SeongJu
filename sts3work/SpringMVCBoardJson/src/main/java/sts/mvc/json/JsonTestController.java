package sts.mvc.json;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Controller - 일반(비동기)
//RestController - 비동기

@Controller
public class JsonTestController {

	@ResponseBody //일반Controller의 경우 json처리 후 브라우저로 출력
	@GetMapping("/list1")
	public Map<String, String> list(){
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "김성주");
		map.put("hp", "010-2222-2222");
		map.put("addr", "강남구 테헤란로");
		
		return map;
	}
}
