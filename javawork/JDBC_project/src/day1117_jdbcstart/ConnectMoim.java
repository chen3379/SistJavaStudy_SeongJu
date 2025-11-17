package day1117_jdbcstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectMoim {
	
	static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	public void getSelectMoim() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select no,name,addr,hp,job,gaipday from moim";		
		
		System.out.println("회원번호\t회원명\t회원주소\t연락처\t직업\t가입일");
		System.out.println("--------------------------------------------------");
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "test", "admin");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
			System.out.println(rs.getInt("no")+"\t"+rs.getString("name")+"\t"+rs.getString("addr")+"\t"+rs.getString("hp")+"\t"+rs.getString("job")+"\t"+rs.getString("gaipday"));	
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
	
	public void getDeleteMoim() {
		Connection conn=null;
		Statement stmt=null;
		
		Scanner sc=new Scanner(System.in);
		int no;
		System.out.println("삭제할 번호를 입력하세요");
		no=sc.nextInt();
		String sql="delete from moim where no="+no;
		

		try {
			conn=DriverManager.getConnection(ORACLE_URL, "test", "admin");
			stmt=conn.createStatement();
			
			//서버에 업데이트 execute, executeupdate
			stmt.execute(sql);
			
			System.out.println("선택한 회원이 삭제되었습니다");
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
	
		ConnectMoim con=new ConnectMoim();
		Scanner sc=new Scanner(System.in);
		int n;
		System.out.println("***Oracle_db 연습문제_test계정의 moim테이블***");
		
		while(true) {
			System.out.println("[1.조회\t2.삭제\t9.종료]");
			System.out.println("- 숫자를 입력하세요 -");
			n=Integer.parseInt(sc.nextLine());
			
			switch(n) {
			case 1:
				con.getSelectMoim();
				break;
			case 2:
				con.getDeleteMoim();
				break;
			case 9:
				System.out.println("종료되었습니다");
				sc.close();
				System.exit(0);
			default :
				System.out.println("다시 입력해주세요");
				break;
			}
		
		}
	}

}
