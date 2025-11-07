package day1106;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex5QuizWriteRead {

	Scanner sc = new Scanner(System.in);
	static final String FILENAME = "C:\\sist1017\\work\\file\\shop.txt";
	FileWriter fw;
	FileReader fr;
	BufferedReader br;

	public int getProcess() {
		int num = 0;
		System.out.println("=================================================================================");
		System.out.println("***[메뉴]\t1.상품추가\t2.상품재고현황\t\t9.종료***");
		num = Integer.parseInt(sc.nextLine());
		return num;
	}

	// 입력 후 파일에 저장 ==> 아이폰12,5,1200000
	public void fileWrite() {

		System.out.println("상품명 입력");
		String name = sc.nextLine();
		System.out.println("입고된 수량");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("상품 가격");
		int price = Integer.parseInt(sc.nextLine());

		try {
			fw = new FileWriter(FILENAME, true);

			fw.write(name + "," + num + "," + price + "\n");
			System.out.println("상품 추가 완료");
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}
	
	public int getDiscount(int num,int price) {
		 int discount=0;
		if(num>=10)
			discount=num*price/10;
		
		return discount;
	}

	public void fileRead() {
		System.out.println("=================================================================================");
		System.out.println("번호\t상품명\t\t입고수량\t가격\t할인가격\t총가격");
		System.out.println("=================================================================================");

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			int cnt=1;
			System.out.println();
			while (true) {
				String s = br.readLine();
				if (s == null)
					break;
				String[] a = s.split(",");
				int n1=Integer.parseInt(a[1]);
				int n2=Integer.parseInt(a[2]);
				int totalPrice=n1*n2-getDiscount(n1, n2);
				System.out.println(cnt++ +"\t"+ a[0] + "  \t" + a[1] + "\t\t" + a[2]+" \t "+getDiscount(n1,n2)+"\t\t"+totalPrice);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		Ex5QuizWriteRead qwr = new Ex5QuizWriteRead();

		while (true) {
			int num = qwr.getProcess();
			switch (num) {
			case 1:
				qwr.fileWrite();
				break;
			case 2:
				qwr.fileRead();
				break;
			case 9:
				break;
			default:
				System.exit(0);
			}
		}
	}
}
