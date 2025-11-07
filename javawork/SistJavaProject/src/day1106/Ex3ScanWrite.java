package day1106;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex3ScanWrite {

	Scanner sc;
	FileWriter fw;
	FileReader fr;
	BufferedReader br;

	
	static final String FILENAME = "C:\\sist1017\\work\\file\\test3.txt";

	public Ex3ScanWrite() {
		
		sc=new Scanner(System.in);

	}

	public void fileWrite() {


		try {

			fw = new FileWriter(FILENAME,true);
			
			System.out.println("이름 입력");
			String name=sc.nextLine();
			System.out.println("주소 입력");
			String addr = sc.nextLine();
			System.out.println("핸드폰 입력");
			String num = sc.nextLine();

			fw.write(name+"\n");
			fw.write(addr+"\n");
			fw.write(num+"\n");

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
	
	public void fileRead() {
		System.out.println("\n\t===Test 2정보===");
		System.out.println("번호\t이름\t주소\t핸드폰");
		System.out.println("================================");
		
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);

			int cnt=0;
			
			while(true)
			{
				String name=br.readLine();
				
				if(name==null)
					break;
				
				String addr=br.readLine();
				String num=br.readLine();
				
				System.out.println(cnt++ +"\t"+name+"\t"+addr+"\t"+num);
			}
			
			System.out.println("\t===Test 2출력===");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
		}
		
	}

	public static void main(String[] args) {
		Ex3ScanWrite sw = new Ex3ScanWrite();
		sw.fileWrite();
		sw.fileRead();

	}
}
