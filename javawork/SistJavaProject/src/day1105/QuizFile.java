package day1105;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuizFile {

	public static void quizRead() {

		// 번호 상품명 수량 가격 총금액
		// Split or StringTokenizer 을 활용해서 출력해보세요
		String fileName = "C:\\sist1017\\work\\file\\quiz.txt";
		FileReader fr = null;
		BufferedReader br = null;

		int cnt = 0, sum = 0;

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			while (true) {
				String s = br.readLine();
				cnt++;

				if (s == null)
					break;
				String[] a = s.split(":");
				
				sum = Integer.parseInt(a[1]) * Integer.parseInt(a[2]);

				System.out.println("[" + cnt + "]\t" + a[0] + "\t" + a[1] + "\t" + a[2] + "\t" + sum);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		} finally { //finally 에서 DB를 닫아주지 않으면 오픈 상태로 유지되어 보안 위험이 존재하게 된다
			try {
				br.close();
				fr.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		System.out.println("번호\t상품명\t수량\t가격\t총금액");
		quizRead();
	}
}
