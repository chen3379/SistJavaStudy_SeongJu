package mysql_myteam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DBConnect;

public class TeamDao {

    DBConnect db = new DBConnect();

    // insert
    public void insertMyTeam(TeamDto dto) {

	Connection conn = db.getDBConnect();
	PreparedStatement pstmt = null;

	String sql = "insert into myteam values(null,?,?,?,now())";

	try {
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, dto.getName());
	    pstmt.setString(2, dto.getAddr());
	    pstmt.setString(3, dto.getMarry());
	    pstmt.execute();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    db.dbClose(pstmt, conn);
	}

    }

    // select
    public List<TeamDto> selectTeam() {
	List<TeamDto> list = new Vector<TeamDto>();

	Connection conn = db.getDBConnect();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql = "select * from myteam order by num";

	try {
	    pstmt = conn.prepareStatement(sql);
	    rs = pstmt.executeQuery();

	    while (rs.next()) {
		TeamDto dto = new TeamDto();
		dto.setNum(rs.getString("num"));
		dto.setName(rs.getString("name"));
		dto.setAddr(rs.getString("addr"));
		dto.setMarry(rs.getString("marry"));
		dto.setGaipday(rs.getTimestamp("gaipday"));

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
    public void delTeam(String num) {
	Connection conn = db.getDBConnect();
	PreparedStatement pstmt = null;

	String sql = "delete from myteam where num=?";

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

    // selectOne
    public TeamDto selectOne(String num) {

	TeamDto dto = new TeamDto();

	Connection conn = db.getDBConnect();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql = "select * from myteam where num=?";

	try {
	    pstmt = conn.prepareStatement(sql);
	    rs = pstmt.executeQuery();
	    pstmt.setString(1, num);
	    if (rs.next()) {
		dto.setNum(rs.getString("num"));
		dto.setName(rs.getString("name"));
		dto.setAddr(rs.getString("addr"));
		dto.setMarry(rs.getString("marry"));
		dto.setGaipday(rs.getTimestamp("gaipday"));

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
    public void updateTeam(TeamDto dto) {
	Connection conn = db.getDBConnect();
	PreparedStatement pstmt = null;

	String sql = "update myteam set name=?,addr=?,marry=? where num=?";

	try {
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, dto.getName());
	    pstmt.setString(2, dto.getAddr());
	    pstmt.setString(3, dto.getMarry());
	    pstmt.setString(4, dto.getNum());

	    pstmt.execute();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    db.dbClose(pstmt, conn);
	}

    }

}
