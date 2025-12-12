<%@page import="member.MemberDto"%>
<%@page import="member.MemberDao"%>
<%@page import="myInfo.MyInfoDao"%>
<%@page import="myInfo.MyInfoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>title</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>

<%
request.setCharacterEncoding("utf-8");

String name= request.getParameter("name");
String hp= request.getParameter("hp");
String driver= request.getParameter("driver")==null?"미보유":"보유";
String job= request.getParameter("job");

MemberDto dto=new MemberDto();

dto.setName(name);
dto.setHp(hp);
dto.setDriver(driver);
dto.setJob(job);

MemberDao dao=new MemberDao();
dao.insertMember(dto);

response.sendRedirect("memberList.jsp");
%>
</body>
</html>