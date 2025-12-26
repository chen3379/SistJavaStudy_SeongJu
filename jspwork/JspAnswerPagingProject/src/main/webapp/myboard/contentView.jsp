<%@page import="java.text.SimpleDateFormat"%>
<%@page import="myboard.BoardDto"%>
<%@page import="myboard.BoardDao"%>
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
dao.updateReadcount(num);
BoardDto dto = dao.getOneData(num);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
  <div style="margin: 50px 100px;">
    <table class="table table-bordered" style="width: 500px;">
      <caption align="top">
        <b style="font-size: 1.2em;"><%=dto.getSubject()%></b>
      </caption>
      <tr>
        <td>
          <b>작성자: <%=dto.getWriter()%></b><br> <span class="day"><%=sdf.format(dto.getWriteday())%></span>&nbsp;&nbsp;
          <span>조회수: &nbsp;<%=dto.getReadcount()%></span>
        </td>
      </tr>
      <tr height="200">
        <td>
          <%=dto.getContent().replace("\n", "<br>")%>
        </td>
      </tr>
      <tr>
        <td>
          <button class="btn btn-outline-success" onclick="location='insertForm.jsp'">글쓰기</button>
          <button class="btn btn-outline-primary" type="button" onclick="location='updatePassForm.jsp?num=<%=num%>'">수정</button>
          <button class="btn btn-outline-warning" type="button" onclick="location='deletePassForm.jsp?num=<%=num%>'">삭제</button>
          <button class="btn btn-outline-info" onclick="location='boardList.jsp'">목록</button>
        </td>
      </tr>
    </table>
  </div>
</body>
</html>