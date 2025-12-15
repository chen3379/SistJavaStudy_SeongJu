package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import oracle_db.DBConnect;

public class MemberDao {

    DBConnect db = new DBConnect();

    // insert
    public void insertMember(MemberDto dto) {

	Connection conn = db.getDBConnect();
	PreparedStatement pstmt = null;

	String sql = "insert into member values(seq1.nextval,?,?,?,?,sysdate)";

	try {
	    pstmt = conn.prepareStatement(sql);

	    pstmt.setString(1, dto.getName());
	    pstmt.setString(2, dto.getHp());
	    pstmt.setString(3, dto.getDriver());
	    pstmt.setString(4, dto.getJob());

	    pstmt.execute();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    db.dbClose(pstmt, conn);
	}

    }

    // select
    public List<MemberDto> selectMember() {
	List<MemberDto> list = new Vector<MemberDto>();

	Connection conn = db.getDBConnect();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql = "select * from member order by num";

	try {
	    pstmt = conn.prepareStatement(sql);
	    rs = pstmt.executeQuery();

	    while (rs.next()) {

		MemberDto dto = new MemberDto();

		dto.setNum(rs.getString("num"));
		dto.setName(rs.getString("name"));
		dto.setHp(rs.getString("hp"));
		dto.setDriver(rs.getString("driver"));
		dto.setJob(rs.getString("job"));
		dto.setWriteday(rs.getTimestamp("writeday"));

		list.add(dto);
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    db.dbClose(rs, pstmt, conn);
	}

	return list;

    }

    // delete
    public void deleteMember(String num) {

	Connection conn = db.getDBConnect();
	PreparedStatement pstmt = null;

	String sql = "delete from member where num=?";

	try {
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, num);
	    pstmt.execute();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    db.dbClose(pstmt, conn);
	}

    }

    // one_select
    public MemberDto selectOne(String num) {
	MemberDto dto = new MemberDto();

	Connection conn = db.getDBConnect();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql = "select * from member where num=?";

	try {
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, num);
	    rs = pstmt.executeQuery();

	    if (rs.next()) {
		dto.setNum(rs.getString("num"));
		dto.setName(rs.getString("name"));
		dto.setHp(rs.getString("hp"));
		dto.setDriver(rs.getString("driver"));
		dto.setJob(rs.getString("job"));
		dto.setWriteday(rs.getTimestamp("writeday"));

	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    db.dbClose(rs, pstmt, conn);
	}

	return dto;
    }

    // update
    public void updateMember(MemberDto dto) {
	Connection conn = db.getDBConnect();
	PreparedStatement pstmt = null;

	String sql = "update member set name=?,hp=?,driver=?,job=? where num=?";

	try {
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, dto.getName());
	    pstmt.setString(2, dto.getHp());
	    pstmt.setString(3, dto.getDriver());
	    pstmt.setString(4, dto.getJob());
	    pstmt.setString(5, dto.getNum());
	    pstmt.execute();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    db.dbClose(pstmt, conn);
	}
    }

}
