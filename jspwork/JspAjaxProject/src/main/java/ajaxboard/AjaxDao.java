package ajaxboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import mysql.db.DBConnect;

public class AjaxDao {

  DBConnect db = new DBConnect();

  public void insertBoard(AjaxDto dto) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "insert into ajaxboard values(null,?,?,?,?,now())";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getWriter());
      pstmt.setString(2, dto.getSubject());
      pstmt.setString(3, dto.getContent());
      pstmt.setString(4, dto.getAvata());
      pstmt.execute();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }

  }

  public List<AjaxDto> getAllData() {
    List<AjaxDto> list = new Vector<AjaxDto>();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from ajaxboard order by num desc";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {

        AjaxDto dto = new AjaxDto();
        dto.setNum(rs.getString("num"));
        dto.setWriter(rs.getString("writer"));
        dto.setSubject(rs.getString("subject"));
        dto.setContent(rs.getString("content"));
        dto.setAvata(rs.getString("avata"));
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

  public AjaxDto getData(String num) {
    AjaxDto dto = new AjaxDto();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from ajaxboard where num=" + num;

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if (rs.next()) {

        dto.setNum(rs.getString("num"));
        dto.setWriter(rs.getString("writer"));
        dto.setSubject(rs.getString("subject"));
        dto.setContent(rs.getString("content"));
        dto.setAvata(rs.getString("avata"));
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

  // 삭제
  public void deleteAjax(String num) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "delete from ajaxboard where num=" + num;

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

  // 수정
  public void updateAjax(AjaxDto dto) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "update ajaxboard set writer=?,subject=?,content=?,avata=? where num=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getWriter());
      pstmt.setString(2, dto.getSubject());
      pstmt.setString(3, dto.getContent());
      pstmt.setString(4, dto.getAvata());
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
