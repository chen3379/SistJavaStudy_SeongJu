<%@page import="myboard.BoardDao"%>
<%@page import="myboard.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
  href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap"
  rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>title</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
  <%
  String num = request.getParameter("num");
  String pass = request.getParameter("pass");

  BoardDao dao = new BoardDao();

  Boolean flag = dao.isEqualPass(num, pass);
  if (flag) {
  	response.sendRedirect("updateForm.jsp?num=" + num);
  } else {
  %>
  <script type="text/javascript">
      alert("비밀번호가 틀렸습니다");
      history.back();
    </script>
  <%
  }
  %>
</body>
</html>