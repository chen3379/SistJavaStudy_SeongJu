package day1117_jdbcstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTest_03 {

	static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:XE";

	public void getGroupSawon() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select buseo,count(*),to_char(avg(pay),'L9,999,999'),to_char(max(pay),'L9,999,999'),to_char(min(pay),'L9,999,999') from sawon group by buseo";
		// (화폐단위,천단위)
		System.out.println("부서\t인원수\t\t평균급여\t\t\t최고급여\t\t\t최저급여");
		try {
			conn = DriverManager.getConnection(ORACLE_URL, "test", "admin");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString("buseo") + "\t" + rs.getInt("count(*)") + "\t"
						+ rs.getString("to_char(avg(pay),'L9,999,999')") + "\t"
						+ rs.getString("to_char(max(pay),'L9,999,999')") + "\t"
						+ rs.getString("to_char(min(pay),'L9,999,999')"));
			}
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
	
	public void getBaedal() {
		
		//주문번호 주문자명 주문음식명 가격 음식점명 음식점위치 배달자주소
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select ono,cname,fname,fprice,shopname,shoploc,caddr from foodshop,orderapp where foodshop.fno=orderapp.fno";

		System.out.println("\t\t***FOODSHOP & ORDERAPP JOIN***");
		System.out.println("주문번호\t주문자명\t주문음식명\t가격\t음식점명\t음식점위치\t배달자주소");
		System.out.println("==================================================================");
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "test", "admin");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getInt("ono")+"\t"+rs.getString("cname")+"\t"+
			rs.getString("fname")+"\t"+rs.getInt("fprice")+"\t"+rs.getString("shopname")+"\t"+rs.getString("shoploc")+"\t"+rs.getString("caddr"));
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

	public static void main(String[] args) {
		ConnectTest_03 con = new ConnectTest_03();
//		con.getGroupSawon();
		con.getBaedal();
	}
}
