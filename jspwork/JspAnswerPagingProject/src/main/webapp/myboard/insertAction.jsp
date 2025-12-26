<%@page import="myboard.BoardDao"%>
<%@page import="myboard.BoardDto"%>
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

String writer=request.getParameter("writer");
String subject=request.getParameter("subject");
String content =request.getParameter("content");
String pass=request.getParameter("pass");

BoardDto dto=new BoardDto();
dto.setWriter(writer);
dto.setSubject(subject);
dto.setContent(content);
dto.setPass(pass);

BoardDao dao=new BoardDao();
dao.insertBoard(dto);

response.sendRedirect("boardList.jsp");
%>

</body>
</html>