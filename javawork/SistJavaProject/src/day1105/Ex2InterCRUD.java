package day1105;

import java.util.Scanner;

interface Command{
	public void write();

}

//4개의 클래스는 모두 Command
//INSERT
class Insert implements Command{
	@Override
	public void write() {
		System.out.println("게시판에 게시글을 작성합니다");
	}
}
//SELECT
class Select implements Command{
	@Override
	public void write() {
		System.out.println("게시판에 게시글을 조회합니다");
	}
}
//UPDATE
class Update implements Command{
	@Override
	public void write() {
		System.out.println("게시판에 게시글을 수정합니다");
	}
}
//DELETE
class Delete implements Command{
	@Override
	public void write() {
		System.out.println("게시판에 게시글을 삭제합니다");
	}
}

public class Ex2InterCRUD {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Command comm=null;
		int num;

		while(true) {
			System.out.println("[메뉴] 1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.println("-------------------------------------------");

			num=sc.nextInt();

			if(num==1) {
				comm=new Insert();
				comm.write();
				System.out.println();}

			else if(num==2) {
				comm=new Select();
				comm.write();
				System.out.println();}

			else if(num==3) {
				comm=new Update();
				comm.write();
				System.out.println();}

			else if(num==4) {
				comm=new Delete();
				comm.write();
				System.out.println();}

			else {
				System.out.println("메뉴를 종료합니다");
				break;}
		}
		sc.close();
	}

}
