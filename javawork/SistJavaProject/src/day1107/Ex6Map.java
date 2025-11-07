package day1107;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex6Map {

	public static void main(String[] args) {
		// Map은 키(key)와 값(value) 의 쌍으로 저장
		// key는 중복 불가능
		Map<String, String> map=new HashMap<String, String>();
		
		//put으로 담고 get으로 가져온다
		map.put("name", "a");
		map.put("addr", "b");
		map.put("age", "c");
		//중복된 키_중복된 기존 키 값은 사라진다
		map.put("name", "d");
		System.out.println("key값 size:"+map.size());
		
		System.out.println("key값을 정확하게 알면 value를 구할 수 있다");
		
		System.out.println("이름: "+map.get("name"));
		System.out.println("주소: "+map.get("addr"));
		System.out.println("나이: "+map.get("age"));
		
		//맵에 없는 키값 조회 시 null 출력
		System.out.println("map에 없는 키 값 입력 시: "+map.get("city"));
		
		System.out.println("키값을 먼저 한꺼번에 얻은 후 값을 얻는 방법");
		Set<String> keyset=map.keySet();
		
		System.out.println("Iterator로 출력");
		Iterator<String> iter=keyset.iterator();
		while (iter.hasNext()) {
			String s = (String) iter.next();
			System.out.println(s+": "+map.get(s));
		}
		System.out.println("for~each로 출력");
		for(String s:keyset)
			System.out.println(s+": "+map.get(s));
	}
}
