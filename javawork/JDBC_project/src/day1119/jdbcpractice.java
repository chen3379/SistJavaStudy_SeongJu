package day1119;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcpractice {

	private final static String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:XE";

	public void getConnectSawon() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from c_sawon";
		System.out.println("[사원정보 조회]");
		System.out.println("사원번호\t사원명\t직급\t이메일\t\t연락처");
		System.out.println("=====================================================");

		try {
			conn = DriverManager.getConnection(ORACLE_URL, "chen", "admin");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt("companyid") + "\t" + rs.getString("name") + "\t"
						+ rs.getString("position") + "\t" + rs.getString("email") + "\t" + rs.getString("phone"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

	public void getDeleteSawon() {

		Connection conn = null;
		Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("[사원정보 삭제]");
		System.out.println("삭제할 시퀀스 번호를 입력하세요");
		n = sc.nextInt();

		String sql = "delete from c_sawon where companyid =" + n;

		try {
			conn = DriverManager.getConnection(ORACLE_URL, "chen", "admin");
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println(n + "번 시퀀스가 삭제되었습니다");

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

		jdbcpractice pr = new jdbcpractice();

		System.out.println("c_sawon 조회삭제 테스트");

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("===================");
			System.out.println("1.조회  2.삭제  9.종료");
			System.out.println("===================");
			int n;
			n = sc.nextInt();

			switch (n) {
			case 1:
				pr.getConnectSawon();
				break;
			case 2:
				pr.getDeleteSawon();
				break;
			case 9:
				System.out.println("시스템이 종료되었습니다");
				sc.close();
				System.exit(0);
			default:
				System.out.println("숫자를 잘못 입력하였습니다");
				break;

			}
		}
	}
}
