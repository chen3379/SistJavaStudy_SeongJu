<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="mysql.db.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
DBConnect db=new DBConnect();

Connection conn=db.getDBConnect();
PreparedStatement pstmt = null;
ResultSet rs =null;

String sql ="select * from mystu order by num";

String s= "[";

try{
pstmt=conn.prepareStatement(sql);
rs=pstmt.executeQuery();

while(rs.next()){
  String num=rs.getString("num");
  String stuname=rs.getString("stuname");
  String stuphoto=rs.getString("stuphoto");
  String java=rs.getString("java");
  String ajax=rs.getString("ajax");
  
  s+="{";
  s+="\"num\":"+num+",";
  s+="\"stuname\":\""+stuname+"\",";
  s+="\"stuphoto\":\""+stuphoto+"\",";
  s+="\"java\":"+java+",";
  s+="\"ajax\":"+ajax;
  s+="},";
  
}
s=s.substring(0,s.length()-1);
s+="]";

}catch(Exception e){
  e.printStackTrace();
}finally{
  db.dbClose(rs, pstmt, conn);
  
}
%>
<%=s%>