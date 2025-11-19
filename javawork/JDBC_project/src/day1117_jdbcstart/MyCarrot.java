package day1117_jdbcstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MyCarrot {

	static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:XE";

	public void getSelectMyCarrot() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		System.out.println("***MyCarrot 조회***");
		System.out.println("---------------------------------------");
		System.out.println("번호\t상품명\t가격\t매너점수\t상대방주소");
		System.out.println("---------------------------------------");
		String sql = "select * from mycarrot";

		try {
			conn = DriverManager.getConnection(ORACLE_URL, "test", "admin");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			System.out.println(rs.getInt("cnum")+"\t"+rs.getString("csangpum")+"\t"+rs.getInt("cprice")+"\t"+rs.getInt("cscore")+"\t"+rs.getString("caddr"));
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}

	public void getDeleteMyCarrot() {
		Connection conn = null;
		Statement stmt = null;

		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("몇 번의 시퀀스를 삭제하실건가요?");
		n = sc.nextInt();
		String sql = "delete from mycarrot where cnum=" + n;
		try {
			conn = DriverManager.getConnection(ORACLE_URL, "test", "admin");
			stmt = conn.createStatement();
			

			stmt.execute(sql);
			
			System.out.println(n+"번 시퀀스가 삭제되었습니다");
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		MyCarrot mc = new MyCarrot();

		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("[과제물_1117]");
		while (true) {
			System.out.println("----------------------");
			System.out.println("1.조회\t2.삭제\t9.종료");
			System.out.println("----------------------");
			System.out.println("숫자를 입력하세요");
			n = sc.nextInt();
			switch (n) {
			case 1:
				mc.getSelectMyCarrot();
				break;
			case 2:
				mc.getDeleteMyCarrot();
				break;
			case 9:
				System.out.println("종료되었습니다");
				System.exit(0);
			default:
				System.out.println("다시 입력해주세요");
				break;

			}
		}

	}
}
