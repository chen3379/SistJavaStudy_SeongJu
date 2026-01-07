package memanswer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mysql.db.DBConnect;

public class AnswerDao {

  DBConnect db = new DBConnect();

  // insert
  public void insertAnswer(AnswerDto dto) {
    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "insert into memanswer values(null,?,?,?,now())";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getNum());
      pstmt.setString(2, dto.getMyid());
      pstmt.setString(3, dto.getMemo());

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }

  }

  // select
  public List<AnswerDto> getAnswerList(String num) {
    List<AnswerDto> list = new ArrayList<AnswerDto>();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from memanswer where num=" + num + " order by idx";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        AnswerDto dto = new AnswerDto();

        dto.setIdx(rs.getString("idx"));
        dto.setNum(rs.getString("num"));
        dto.setMyid(rs.getString("myid"));
        dto.setMemo(rs.getString("memo"));
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
  public void deleteAnswer(String idx) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "delete from memanswer where idx=" + idx;

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

  // idx에 따른 memo 반환
  // 댓글 수정 시 댓글 내용을 가져와야 하므로
  public String getMemo(String idx) {

    String memo = "";

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select memo from memanswer where idx=" + idx;

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        memo = rs.getString("memo");
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, pstmt, conn);
    }
    return memo;
  }

  // 수정
  public void updateMemo(AnswerDto dto) {
    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "update memanswer set memo=? where idx=?";

    try {

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getMemo());
      pstmt.setString(2, dto.getIdx());
      pstmt.execute();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }

}
