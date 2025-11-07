package day1107;

import java.util.List;
import java.util.Vector;

public class Ex4List {

	public static void write(String title,List<String> list) {
		System.out.println("***"+title+"***");
		
		for(int i=0;i<list.size();i++) {
			System.out.println(i+" : "+list.get(i));
		}
	}
	
	public static void main(String[] args) {
		String [] data= {"바나나","복숭아","딸기"};
		
		//배열의 데이타를 list 에 넣기
		List<String> list=new Vector<String>();
		for(String s:data)//data 배열의 데이타를 list 에 추가
			list.add(s);
		write("초기 배열",list);
		
		list.remove(1);//.remove 삭제
		write("1번 인덱스 삭제 후 결과", list);
		
		list.add(1, "자두");//.add index 추가
		write("1번 인덱스 추가 후 결과", list);
		
		list.add(2, "멜론");
		write("2번 인덱스 추가 후 결과", list);
		
		list.set(0, "포도");//.add 해당 index 변경
		write("0번 인덱스 변경 후 결과", list);
		
		//전체 삭제 후 사이즈 출력
		list.clear();//.clear 전체 삭제
		write("전체 삭제 후 사이즈", list);

	}
}
