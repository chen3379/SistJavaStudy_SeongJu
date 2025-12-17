<%@page import="simpleboard.BoardDto"%>
<%@page import="simpleboard.BoardDao"%>
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
String pass =request.getParameter("pass");
BoardDao dao = new BoardDao();
%>
<body>
  <div style="margin: 100px 100px; width: 350px;">
    <form action="deletePassProc.jsp" method="post">
      <input type="hidden" name="num" value="<%=num%>">
      <table class="table table-bordered">
        <caption align="top">삭제하시려면 비밀번호를 입력해주세요</caption>
        <tr >
          <th style="text-align: center;" class="table-secondary">비밀번호</th>
          <td>
            <input type="password" placeholder="ex)1234" name="pass">
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <button type="submit" class="btn btn-primary">확인</button>
            <button type="button" class="btn btn-warning" onclick="location='detailView.jsp?num=<%=num%>'">취소</button>
          </td>
        </tr>
      </table>
    </form>
  </div>


</body>
</html>