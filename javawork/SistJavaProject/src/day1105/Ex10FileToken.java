package day1105;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ex10FileToken {

	public static void fileRead() {
		String fileName = "C:\\sist1017\\work\\file\\food.txt";
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			System.out.println("파일읽기 결과");
			System.out.println("-------------------------");
			System.out.println("메뉴명\t가격\t맛평가");
			System.out.println("-------------------------");

			while (true) {
				String s = br.readLine();

				if (s == null)
					break;
				//split
//				String[] foodD = s.split(",");
//
//				System.out.println(foodD[0] + "\t" + foodD[1] + "\t" + foodD[2]);
				
				//StringTokenizer
				StringTokenizer st=new StringTokenizer(s,",");
				System.out.println(st.nextToken()+"\t"+st.nextToken()+"\t"+st.nextToken());
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
		fileRead();
	}
}
