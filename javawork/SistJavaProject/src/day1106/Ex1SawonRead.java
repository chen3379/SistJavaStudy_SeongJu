package day1106;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex1SawonRead {

	public static void sawonRead() {

		String fileName = "C:\\sist1017\\work\\file\\stu.txt";
		FileReader fr = null;
		BufferedReader br = null;
		int num = 0;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			System.out.println("\t\t\t\t**사원급여**");
			System.out.println("========================================================================================");
			System.out.println("번호\t사원명\t기본급\t가족수\t초과근무시간\t가족수당\t시간수당\t총급여");
			System.out.println("========================================================================================");

			while (true) {
				String s = br.readLine();
				num++;
				if (s == null)
					break;
				String a[] = s.split(":");
				int fPay = Integer.parseInt(a[2]) * 30000;
				int hPay = Integer.parseInt(a[3]) * 20000;
				int totalPay = Integer.parseInt(a[1]) + fPay + hPay;
				System.out.println("[" + num + "]\t" + a[0] + "\t" + a[1] + "\t  " + a[2] + "\t    " + a[3] + "\t\t"
						+ fPay + "\t\t" + hPay + "\t\t" + totalPay);

			}
			System.out.println("========================================================================================");
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

		sawonRead();
	}

}
