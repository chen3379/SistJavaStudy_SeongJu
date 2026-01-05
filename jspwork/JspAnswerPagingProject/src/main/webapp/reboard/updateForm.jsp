<%@page import="reboard.ReboardDao"%>
<%@page import="reboard.ReboardDto"%>
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
String currentPage = request.getParameter("currentPage");
String num = request.getParameter("num");
ReboardDao dao = new ReboardDao();
ReboardDto dto = dao.getOneData(num);
%>
<body>
  <div style="margin: 100px 200px; width: 500px;">
    <form action="updateAction.jsp?num=<%=num%>" method="post">
      <input type="hidden" name="num" value="<%=num%>">
      <input type="hidden" name="currentPage" value="<%=currentPage%>">
      <table class="table table-bordered">
        <caption align="top">
          <b>게시글 수정</b>
        </caption>
        <tr>
          <th class="table-secondary">작성자</th>
          <td>
            <input type="text" name="uwriter" value="<%=dto.getWriter()%>" class="form-control" style="width: 120px;"
              required="required">
          </td>
        </tr>
        <tr>
          <th class="table-secondary">제목</th>
          <td>
            <input type="text" name="usubject" value="<%=dto.getSubject()%>" class="form-control" style="width: 320px;"
              required="required">
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <textarea style="width: 480px; height: 100px;" name="ucontent" class="form-control"><%=dto.getContent()%></textarea>
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="submit" class="btn btn-success" value="게시글수정" style="width: 120px;">
            <input type="button" class="btn btn-success" value="목록이동" style="width: 120px;"
              onclick="location='boardList.jsp?currentPage=<%=currentPage%>'">
          </td>
        </tr>

      </table>

    </form>
  </div>
</body>
</html>