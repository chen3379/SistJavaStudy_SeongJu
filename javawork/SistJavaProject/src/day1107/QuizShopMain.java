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

		QuizShop qs = new QuizShop();
		qs.setName(name);
		qs.setColor(color);
		qs.setMade(made);
		qs.setNum(num);
		qs.setPrice(price);

		qs.setTotalPrice(num, price);
		list.add(qs);

		System.out.println("현재 상품 개수: " + list.size() + "개");

	}

	// 출력
	// 입력한 상품의 개수를 출력해본다
	// 번호 상품명 색상 제조사 수량 가격 총금액
	public void pull() {
		System.out.println("번호\t상품명\t색상\t제조사\t수량\t가격\t총금액");
		System.out.println("===========================================================");

		for (int i = 0; i < list.size(); i++) {
			QuizShop q = list.get(i);
			System.out.println((i + 1) + "\t" + q.getName() + "\t" + q.getColor() + "\t" + q.getMade() + "\t"
					+ q.getNum() + "\t" + q.getPrice() + "\t" + q.getTotalPrice());
		}

	}

	public static void main(String[] args) {

		QuizShopMain qsm = new QuizShopMain();
		int n;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("          1.추가\t    2.출력\t    9.종료");
			System.out.println("===========================================================");
			n = Integer.parseInt(sc.nextLine());

			if (n == 1)
				qsm.push();
			else if (n == 2)
				qsm.pull();
			else if (n == 9) {
				System.out.println("-----------------------프로그램 종료-----------------------");
				break;
			}
		}

	}
}
