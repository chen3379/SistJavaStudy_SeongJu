package day1107;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class QuizShopMain {

	// 리스트의 제네릭유형은 QuizShop이라는 클래스이다
	List<QuizShop> list = new Vector<QuizShop>();

	// 입력
	// 상품,색상,제조사,수량,가격에 대해서 값을 입력받는다
	public void push() {
		Scanner sc = new Scanner(System.in);

		System.out.println("상품명");
		String name = sc.nextLine();
		System.out.println("색상");
		String color = sc.nextLine();
		System.out.println("제조사");
		String made = sc.nextLine();
		System.out.println("수량");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("가격");
		int price = Integer.parseInt(sc.nextLine());

		QuizShop q = new QuizShop();
		q.setName(name);
		q.setColor(color);
		q.setMade(made);
		q.setNum(num);
		q.setPrice(price);

		q.setTotalPrice(num, price);
		list.add(q);

		System.out.println("현재 상품 개수: " + list.size() + "개");

	}

	// 출력
	// 입력한 상품의 개수를 출력해본다
	// 번호 상품명 색상 제조사 수량 가격 총금액
	public void pull() {
		System.out.println("번호\t상품명\t색상\t제조사\t수량\t가격\t총금액");
		System.out.println("=================================================================");

		for (int i = 0; i < list.size(); i++) {
			QuizShop q = list.get(i);
			System.out.println((i + 1) + "\t" + q.getName() + "\t" + q.getColor() + "\t" + q.getMade() + "\t"
					+ q.getNum() + "\t" + q.getPrice() + "\t" + q.getTotalPrice());
		}

	}

	// 상품검색
	public void search() {
		// 상품 입력시(이름의 일부도 가능..equals,contains)
		// 없을 경우 "해당제품 없음"
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 상품명을 입력하세요");
		String sname = sc.nextLine();
		boolean find = false;
		System.out.println("***검색 결과***");
		for (QuizShop s : list) {
			if (s.getName().equals(sname)) {
				find = true;
				System.out.println("=================================================================");
				System.out.println("상품명\t색상\t제조사\t수량\t가격\t총금액");
				System.out.println("=================================================================");
				System.out.println(s.getName() + "\t" + s.getColor() + "\t" + s.getMade() + "\t" + s.getNum() + "\t"
						+ s.getPrice() + "\t" + s.getTotalPrice());
			}
			if (!find) {
				System.out.println("해당 상품이 존재하지 않습니다");
			}
		}

	}

	public void delete() {

		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 상품명을 입력하세요");
		String sname = sc.nextLine();
		boolean find = false;

		for (int i = 0; i < list.size(); i++) {
			QuizShop s = list.get(i);
			if (s.getName().equals(sname)) {
				find = true;
				list.remove(i);
				System.out.println("***삭제 완료***");
			}
			if (!find) {
				System.out.println("삭제할 상품이 없습니다");
			}
		}

	}

	public static void main(String[] args) {

		QuizShopMain q = new QuizShopMain();
		int n;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.추가\t    2.출력\t   3.검색\t   4.삭제\t   9.종료");
			System.out.println("=================================================================");
			n = Integer.parseInt(sc.nextLine());

			if (n == 1)
				q.push();
			else if (n == 2)
				q.pull();
			else if (n == 3)
				q.search();
			else if (n == 4)
				q.delete();
			else if (n == 9) {
				System.out.println("-----------------------프로그램 종료-----------------------");
				break;
			}
		}

	}
}
