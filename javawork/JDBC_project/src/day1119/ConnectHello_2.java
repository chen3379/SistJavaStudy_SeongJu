//Update부분에서 번호가 없으면 즉시 update 종료 버전

package day1119;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectHello_2 {

	DBConnect db = new DBConnect();

	// insert
	public void insertHello(Scanner sc) {

		// hello 테이블에 입력할 데이터 요청
		System.out.println("당신의 이름은?");
		String name = sc.nextLine();
		System.out.println("당신의 나이는?");
		int age = Integer.parseInt(sc.nextLine());

		// sql문
		// 입력된 이름과 나이가 sql문의 변수로 들어가야 하므로 입력값 아래에 sql문 위치
		String sql = "insert into hello values(seq1.nextval,'" + name + "'," + age + ",sysdate)";
		System.out.println(sql);

		// db연결
		Connection conn = db.getDBConnect();

		// statement
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("[INSERT 완료]");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}

	// select
	public void selectHello() {

		Connection conn = db.getDBConnect();

		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from hello";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("===========================================");
			System.out.println("번호\t이름\t나이\t등록일자");
			System.out.println("===========================================");
			while (rs.next()) {
				System.out.println(rs.getInt("num") + "\t" + rs.getString("name") + "\t" + rs.getInt("age") + "\t"
						+ rs.getString("writeday"));
			}
			System.out.println("===========================================");
			System.out.println("[SELECT 완료]");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}

	}

	// delete
	public void deleteHello(Scanner sc) {

		Connection conn = db.getDBConnect();

		Statement stmt = null;
		int n;

		System.out.println("삭제할 번호를 입력해주세요");
		n = Integer.parseInt(sc.nextLine());

		String sql = "delete from hello where num=" + n;

		try {
			stmt = conn.createStatement();
			int a = stmt.executeUpdate(sql);
			if (a == 1) // 삭제되면 1이 반환
				System.out.println("[" + n + "번 정보가 삭제되었습니다]");
			else
				System.out.println("[해당 번호가 존재하지 않습니다]");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}

	// update
	public void updateHello(Scanner sc) {

		Connection conn = db.getDBConnect();

		Statement stmt = null;
		ResultSet rs = null;
		int n;

		System.out.println("변경할 번호를 입력해주세요");
		n = Integer.parseInt(sc.nextLine());
		String sqlCk = "select * from hello where num =" + n;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlCk);

			if (rs.next()) {
				System.out.println("변경할 이름 입력");
				String name = sc.nextLine();
				System.out.println("변경할 나이 입력");
				int age = Integer.parseInt(sc.nextLine());

				String sql = "update hello set name='" + name + "',age= " + age + " where num=" + n;

				stmt.executeUpdate(sql);
				System.out.println("[UPDATE 완료]");

			} else
				System.out.println("[해당 번호는 존재하지 않습니다]");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
	}

	public static void main(String[] args) {

		ConnectHello_2 ch = new ConnectHello_2();

		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("[DB: HELLO]");
		while (true) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.INSERT  2.SELECT  3.DELETE  4.UPDATE  9.EXIT");
			System.out.println("-----------------------------------------------");
			n = Integer.parseInt(sc.nextLine());

			switch (n) {

			case 1:
				ch.insertHello(sc);
				break;
			case 2:
				ch.selectHello();
				break;
			case 3:
				ch.deleteHello(sc);
				break;
			case 4:
				ch.updateHello(sc);
				break;
			case 9:
				System.out.println("[시스템 종료]");
				sc.close();
				System.exit(0);
			default:
				System.out.println("다른 숫자를 입력해주세요");
				break;

			}
		}

	}
}
