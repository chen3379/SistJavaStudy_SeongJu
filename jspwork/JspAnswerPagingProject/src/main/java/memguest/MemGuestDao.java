package memguest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mysql.db.DBConnect;

public class MemGuestDao {
  DBConnect db = new DBConnect();

  public void insertGuest(MemGuestDto dto) {
    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "insert into memguest values(null,?,?,?,now())";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getMyid());
      pstmt.setString(2, dto.getPhoto());
      pstmt.setString(3, dto.getContent());

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }

  }

  // 페이징1 List num 내림차순
  public List<MemGuestDto> getPagingList(int startNum, int perPage) {
    List<MemGuestDto> list = new ArrayList<MemGuestDto>();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from memguest order by num desc limit ?,?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, startNum);
      pstmt.setInt(2, perPage);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        MemGuestDto dto = new MemGuestDto();

        dto.setNum(rs.getString("num"));
        dto.setMyid(rs.getString("myid"));
        dto.setPhoto(rs.getString("photo"));
        dto.setContent(rs.getString("content"));
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

  // 페이징2 totalCount
  public int getTotalCount() {

    int tot = 0;

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select count(*) from memguest";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        tot = rs.getInt(1);// 총개수는 1열이므로 인덱스 1

      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, pstmt, conn);
    }

    return tot;
  }

  // 삭제
  public void deleteGuest(String num) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "delete from memguest where num=" + num;

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

  // 한 개의 데이터 조회
  public MemGuestDto getOneData(String num) {
    MemGuestDto dto = new MemGuestDto();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from memguest where num=" + num;

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        dto.setNum(rs.getString("num"));
        dto.setMyid(rs.getString("myid"));
        dto.setPhoto(rs.getString("photo"));
        dto.setContent(rs.getString("content"));
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

  // 수정
  public void updateGuest(MemGuestDto dto) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    // String sql = "update memguest set photo=?,content=? where num=?";
    // photo를 수정 안했을 때 photo를 유지하는 sql문

    try {
      if (dto.getPhoto().equals("no")) {
        String sql = "update memguest set content=? where num=?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, dto.getContent());
        pstmt.setString(2, dto.getNum());

      } else {
        String sql = "update memguest set photo=?,content=? where num=?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, dto.getPhoto());
        pstmt.setString(2, dto.getContent());
        pstmt.setString(3, dto.getNum());

      }

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }

}
