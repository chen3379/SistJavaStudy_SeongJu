package day1106;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex4FileWriteRead {

	static final String FILENAME = "C:\\sist1017\\work\\file\\sungjuk.txt";

	FileWriter fw;
	FileReader fr;
	BufferedReader br;
	Scanner sc = new Scanner(System.in);

	// getMenu에서 num의 값에 따라 다른 메서드 실행시키도록 if 문 구현
	public int getMenu() {
		int num = 0;
		System.out.println("=================================================");
		System.out.println("1.추가\t\t    2.전체출력    \t  9.종료");
		System.out.println("=================================================");
		num = Integer.parseInt(sc.nextLine());
		// if(num==1)

		return num;
	}

	public void sungjukInput() {
		System.out.println("이름을 입력하시오");
		String name = sc.nextLine();
		System.out.println("점수를 입력하시오");
		int score = Integer.parseInt(sc.nextLine());

		try {
			fw = new FileWriter(FILENAME, true);

			fw.write(name + "\n");
			fw.write(score + "\n");

			System.out.println("***학생정보 저장***");

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

	public void sungjukOutput() {
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			while (true) {

				String name = br.readLine();
				if (name == null)
					break;
				int score = Integer.parseInt(br.readLine());

				System.out.println("이름: " + name + "  성적: " + score + "점  " + "학점: " + getGrade(score)
						+ "  평가: " + getRe(score));
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

	// 학점 반환 메서드
	public char getGrade(int score) {
		char grade;

		if (score >= 90)
			grade = 'A';
		else if (score >= 80)
			grade = 'B';
		else if (score >= 70)
			grade = 'C';
		else
			grade = 'F';

		return grade;
	}

	// 평가 메서드
	public String getRe(int score) {
		String re;

		if (score >= 90)
			re = "장학생";
		else if (score >= 80)
			re = "통과";
		else
			re = "재수강";

		return re;
	}

	public static void main(String[] args) {
		Ex4FileWriteRead fwr = new Ex4FileWriteRead();

		while (true) {
			int num = fwr.getMenu();

			switch (num) {
			case 1:
				fwr.sungjukInput();
				break;
			case 2:
				fwr.sungjukOutput();
				break;
			case 9:
				System.out.println("***프로그램 종료***");
				System.exit(0);
			default:
				System.out.println("***해당되는 번호를 눌러주세요***");
				break;
			}

		}
	}
}
