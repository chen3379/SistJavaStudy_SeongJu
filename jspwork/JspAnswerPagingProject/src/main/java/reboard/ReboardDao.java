package reboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mysql.db.DBConnect;

public class ReboardDao {

  DBConnect db = new DBConnect();

  // num의 max값 구해서 리턴(null이면 0 리턴)
  public int getMaxNum() {

    int max = 0;

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select ifnull(max(num),0) max from reboard";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        max = rs.getInt("max");
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, pstmt, conn);
    }


    return max;
  }

  // 데이터 추가시 같은 그룹중 전달받은 step보다 큰값을 가진 데이터들은 무조건 +1한다
  public void updateRestep(int regroup, int restep) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "update reboard set restep=restep+1 where regroup=? and restep>?";

    try {
      pstmt = conn.prepareStatement(sql);

      // 바인딩
      pstmt.setInt(1, regroup);
      pstmt.setInt(2, restep);

      pstmt.execute();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }

  // insert: 제일중요 ==> 새글로 추가할지,답글로 추가할지
  // 판단을 db에 있는 num이 null이면 새글로, null이 아니면 답글로 insert
  public void insertReboard(ReboardDto dto) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String num = dto.getNum();
    int regroup = dto.getRegroup();
    int restep = dto.getRestep();
    int relevel = dto.getRelevel();

    String sql = "insert into reboard (writer,subject,content,pass,"
        + "regroup,restep,relevel,writeday) values(?,?,?,?,?,?,?,now())";

    if (num == null) {
      // 새글을 의미
      regroup = getMaxNum() + 1;
      restep = 0;
      relevel = 0;
    } else {
      // 답글을 의미
      // 같은 그룹 중에서 restep이 전달받은값보다 큰 경우 무조건 1 증가
      this.updateRestep(regroup, restep);
      // 그리고 전달받은 level, step은 1증가
      relevel += 1;
      restep += 1;
    }

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getWriter());
      pstmt.setString(2, dto.getSubject());
      pstmt.setString(3, dto.getContent());
      pstmt.setString(4, dto.getPass());
      pstmt.setInt(5, regroup);
      pstmt.setInt(6, restep);
      pstmt.setInt(7, relevel);

      pstmt.execute();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }

  }

  // 디테일 페이지
  public ReboardDto getOneData(String num) {
    ReboardDto dto = new ReboardDto();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from reboard where num=" + num;

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if (rs.next()) {

        dto.setNum(rs.getString("num"));
        dto.setWriter(rs.getString("writer"));
        dto.setSubject(rs.getString("subject"));
        dto.setContent(rs.getString("content"));
        dto.setPass(rs.getString("pass"));
        dto.setRegroup(rs.getInt("regroup"));
        dto.setRestep(rs.getInt("restep"));
        dto.setRelevel(rs.getInt("relevel"));
        dto.setReadcount(rs.getInt("readcount"));
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

  // 디테일페이지 안의 조회수 1증가
  public void updateReadcount(String num) {
    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "update reboard set readcount=readcount+1 where num=" + num;

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

  // 페이징_1.범위에 따른 리스트, 2.총갯수

  // 1.범위에 따른 리스트
  public List<ReboardDto> getPagingList(int start, int perpage) {
    List<ReboardDto> list = new ArrayList<ReboardDto>();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from reboard order by regroup desc,restep asc limit ?,?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, start);
      pstmt.setInt(2, perpage);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        ReboardDto dto = new ReboardDto();

        dto.setNum(rs.getString("num"));
        dto.setWriter(rs.getString("writer"));
        dto.setSubject(rs.getString("subject"));
        dto.setContent(rs.getString("content"));
        dto.setPass(rs.getString("pass"));
        dto.setRegroup(rs.getInt("regroup"));
        dto.setRestep(rs.getInt("restep"));
        dto.setRelevel(rs.getInt("relevel"));
        dto.setReadcount(rs.getInt("readcount"));
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

  // 총 목록갯수 구하기
  public int getTotalCount() {

    int tot = 0;

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select count(*) from reboard";

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

}
