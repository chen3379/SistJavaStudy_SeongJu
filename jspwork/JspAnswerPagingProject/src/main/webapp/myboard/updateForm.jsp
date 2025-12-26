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
<%
String num = request.getParameter("num");
BoardDao dao = new BoardDao();
BoardDto dto = dao.getOneData(num);
%>
<body>
  <div style="margin: 50px 100px; width: 500px;">
    <form action="updateAction.jsp" method="post">
      <input type="hidden" name="num" value="<%=num%>">
      <table class="table table-bordered">
      <caption align="top"><b>수정</b></caption>
        <tr>
          <th width="100" class="table-secondary">작성자</th>
          <td>
            <input type="text" name="writer" class="form-control" style="width: 120px;" value="<%=dto.getWriter()%>">
          </td>
        </tr>
        <tr>
          <th width="100" class="table-secondary">제목</th>
          <td>
            <input type="text" name="subject" class="form-control" style="width: 350px;" value="<%=dto.getSubject()%>">
          </td>
        </tr>
        <tr>
        <tr>
          <td colspan="2">
            <textarea style="width: 480px; height: 80px;" name="content" class="form-control"><%=dto.getContent()%></textarea>
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <button type="submit" class="btn btn-outline-primary">수정하기</button>
            <button type="button" class="btn btn-outline-warning" onclick="location='boardList.jsp'">목록가기</button>
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>