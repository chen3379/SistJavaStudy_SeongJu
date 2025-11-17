package day1117_jdbcstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;

public class ConnectTest_02 {

	//url
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public void getConnectFoodShop() {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs =null;
		
		String sql="select fno,fname,fprice,shopname,shoploc from foodshop";

		System.out.println("FoodShop 테이블 출력");
		System.out.println("음식번호\t음식명\t가격\t가게명\t가게위치");
		System.out.println("======================================================");
		try {
			conn=DriverManager.getConnection(ORACLE_URL,"test","admin");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				int fno=rs.getInt("fno");
				String fname=rs.getString("fname");
				int fprice=rs.getInt("fprice");
				String shopname=rs.getString("shopname");
				String shoploc=rs.getString("shoploc");
				System.out.println(fno+"\t"+fname+"\t"+fprice+"\t"+shopname+"\t"+shoploc);
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
	
	//Q.성별 인원수와 평균나이
	//성별 인원수 평균나이
	//여자 6 33세
	//남자 4 26세
	
	public void getConnectPerson() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql= "select gender, count(*), round(avg(age),0) from person group by gender";
		
		System.out.println("***Person 테이블 조회***");
		System.out.println("========================");
		System.out.println("성별\t인원수\t평균나이");
		System.out.println("========================");
		try {
			conn=DriverManager.getConnection(ORACLE_URL,"test","admin");
			stmt=conn.createStatement(); //connection이 연결된 상태여야 가능
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("gender")+"\t"+rs.getInt("count(*)")+"\t"+rs.getInt("round(avg(age),0)"));
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
	
	//professor테이블
	//직급별 평균급여_ 평균급여는 화폐단위와 천단위구분기호 붙일 것
	public void getConnectProfessor() {
		
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql="select position,count(*), to_char(max(pay),'L9,999'),to_char(min(pay),'L9,999') from professor group by position";

		System.out.println("\t   ***직급별 급여 조회***");
		System.out.println("==================================================");
		System.out.println("직급\t인원수\t\t최고급여\t최소급여");
		System.out.println("==================================================");
		try {
			conn=DriverManager.getConnection(ORACLE_URL,"chen","admin");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("position")+"\t"+rs.getInt("count(*)")+"\t"+rs.getString("to_char(max(pay),'L9,999')")+"\t"+rs.getString("to_char(min(pay),'L9,999')"));
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
		ConnectTest_02 con=new ConnectTest_02();
//		con.getConnectFoodShop();
//		con.getConnectPerson();
		con.getConnectProfessor();
	}
}
