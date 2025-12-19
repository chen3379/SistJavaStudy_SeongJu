<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="mysql.db.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
DBConnect db = new DBConnect();

Connection conn = db.getDBConnect();
PreparedStatement pstmt = null;
ResultSet rs = null;

String sql = "select * from shop order by num";

try{
pstmt=conn.prepareStatement(sql);
rs=pstmt.executeQuery();

JSONArray arr=new JSONArray();

while(rs.next()){
  String num=rs.getString("num");
  String sangpum=rs.getString("sangpum");
  String price=rs.getString("price");
  String color=rs.getString("color");
  String imgname=rs.getString("imgname");
  
  JSONObject ob= new JSONObject();
  ob.put("num",num);
  ob.put("sangname",sangpum);
  ob.put("price",price);
  ob.put("col",color);
  ob.put("photo",imgname);
  
  arr.add(ob);
}
%>
<%=arr.toString() %>
<%
}catch(Exception e){
  e.printStackTrace();
}finally{
  db.dbClose(rs, pstmt, conn);
}
%>