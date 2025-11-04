package day1104;

import java.util.Scanner;

//super
abstract class Board{
	public abstract void process(); //abstract - 미완성 메서드 의미
}

//sub1
class Insert extends Board{
	@Override
	public void process() {
		System.out.println("게시글 작성");
	}
}

//sub2
class Select extends Board{
	@Override
	public void process() {
		System.out.println("게시글 조회");
	}
}

//sub3
class Update extends Board{
	@Override
	public void process() {
		System.out.println("게시글 추가");
	}
}

//sub4
class Delete extends Board{
	@Override
	public void process() {
		System.out.println("게시글 삭제");
	}
}

public class Ex4Abstract {

	public static void main(String[] args) {


		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);

		int num;

		Board board=null;

		while(true) {
			System.out.println("1.입력 2.출력 3.수정 4.삭제 5.종료");
			num=sc.nextInt();

			switch (num) {
			case 1:
				board=new Insert();
				break;
			case 2:
				board=new Select();
				break;
			case 3:
				board=new Update();
				break;
			case 4:
				board=new Delete();
				break;
			default:
				System.out.println("종료합니다");
				System.exit(0);
			}

			board.process();

		}
	}

}
