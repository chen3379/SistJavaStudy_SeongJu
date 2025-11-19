package day1119;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectStudent {

	private static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	
	public void getconnectStudent() {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select name,grade,height from student order by name";
		System.out.println("이름\t학년\t신장");
		System.out.println("-------------------");

		try {
			conn=DriverManager.getConnection(ORACLE_URL, "chen", "admin");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			

			while(rs.next()) { //true 반환, 더 이상 데이터 없으면 false
				System.out.println(rs.getString("name")+"\t"+rs.getInt("grade")+"\t"+rs.getInt("height"));
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
		
		ConnectStudent cs=new ConnectStudent();
		cs.getconnectStudent();
	}
}
