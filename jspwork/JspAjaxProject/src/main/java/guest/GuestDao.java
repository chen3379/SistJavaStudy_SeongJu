package guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import mysql.db.DBConnect;

public class GuestDao {

  DBConnect db = new DBConnect();

  // insert
  public void insertGuest(GuestDto dto) {
    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "insert into guest values(null,?,?,?,now())";

    try {
      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, dto.getNickname());
      pstmt.setString(2, dto.getContent());
      pstmt.setString(3, dto.getEmot());

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }

  }

  // select(전체조회)
  public List<GuestDto> getAllGuest() {
    List<GuestDto> list = new Vector<GuestDto>();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from guest order by num desc";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        GuestDto dto = new GuestDto();
        dto.setNum(rs.getString("num"));
        dto.setNickname(rs.getString("nickname"));
        dto.setContent(rs.getString("content"));
        dto.setEmot(rs.getString("emot"));
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

  public void deleteGuest(String num) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "delete from guest where num=" + num;

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }



  }

  public GuestDto getData(String num) {

    GuestDto dto = new GuestDto();
    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from guest where num=" + num;

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        dto.setNum(rs.getString("num"));
        dto.setNickname(rs.getString("nickname"));
        dto.setContent(rs.getString("content"));
        dto.setEmot(rs.getString("emot"));
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

  public void updateGuest(GuestDto dto) {



    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "update guest set nickname=?,content=?,emot=? where num=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getNickname());
      pstmt.setString(2, dto.getContent());
      pstmt.setString(3, dto.getEmot());
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
