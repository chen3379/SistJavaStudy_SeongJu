<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="mysql.db.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
DBConnect db = new DBConnect();
Connection conn = db.getDBConnect();
PreparedStatement pstmt = null;
ResultSet rs = null;

String sql = "select * from info order by num";

String s = "[";
try {
  pstmt = conn.prepareStatement(sql);
  rs = pstmt.executeQuery();

  while (rs.next()) {

    String num = rs.getString("num");
    String name = rs.getString("hp");
    String hp = rs.getString("hp");
    String age = rs.getString("age");
    String photo = rs.getString("photo");

    s += "{";
    s += "\"num\":" + num + ",";
    s += "\"name\":\"" + name + "\",";
    s += "\"hp\":\"" + hp + "\",";
    s += "\"age\":\"" + age + "\",";
    s += "\"photo\":\"" + photo + "\"";
    s += "},";
  }
  //마지막 컴마 제거
  s = s.substring(0, s.length() - 1);

  s += "]";

} catch (Exception e) {
  e.printStackTrace();
} finally {
  db.dbClose(rs, pstmt, conn);
}
%>
<%=s%>