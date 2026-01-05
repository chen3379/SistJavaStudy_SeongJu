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
  request.setCharacterEncoding("utf-8");
  %>
  <jsp:useBean id="dto" class="reboard.ReboardDto" />
  <jsp:useBean id="dao" class="reboard.ReboardDao" />
  <jsp:setProperty property="*" name="dto" />
  <%
  //insert
  dao.insertReboard(dto);
  //페이지 번호 읽기
  String currentPage = request.getParameter("currentPage");
  //insert된 num값 얻기
  int num = dao.getMaxNum();

  if (currentPage == null)
    currentPage = "1";
  //이동
  response.sendRedirect("detailPage.jsp?num=" + num + "&currentPage=" + currentPage);
  %>
</body>
</html>