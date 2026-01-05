<%@page import="javax.security.auth.Subject"%>
<%@page import="reboard.ReboardDao"%>
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
//답글일 경우 읽어야할 것들 처리하기
String num = request.getParameter("num");
//새글 null, 답글은 원글의 num이 넘어온다
String regroup = "", relevel = "", restep = "", subject = "", currentPage = "";
//dao
ReboardDao dao = new ReboardDao();

if (num != null) { //답글인 경우
  regroup = request.getParameter("regroup");
  relevel = request.getParameter("relevel");
  restep = request.getParameter("restep");
  currentPage = request.getParameter("currentPage");

  //원글의 제목
  subject = "[답글]" + dao.getOneData(num).getSubject();
}
%>
<body>
  <div style="margin: 100px 200px; width: 500px;">
    <form action="addAction.jsp" method="post">

      <!-- 답글일 경우에만 hidden으로 넘기는 것들 num, re 3개, currentPage -->
      <%
      if (num != null) {
      %>
      <input type="hidden" name="currentPage" value="<%=currentPage%>">
      <input type="hidden" name="num" value="<%=num%>">
      <input type="hidden" name="regroup" value="<%=regroup%>">
      <input type="hidden" name="restep" value="<%=restep%>">
      <input type="hidden" name="relevel" value="<%=relevel%>">
      <%
      }
      %>
      <table class="table table-bordered">
        <caption align="top">
          <b><%=num == null ? "새글등록" : "답글등록"%></b>
        </caption>
        <tr>
          <th class="table-secondary">작성자</th>
          <td>
            <input type="text" name="writer" class="form-control" style="width: 120px;" required="required">
          </td>
        </tr>
        <tr>
          <th class="table-secondary">제목</th>
          <td>
            <input type="text" value="<%=subject%>" name="subject" class="form-control" style="width: 320px;"
              required="required">
          </td>
        </tr>
        <tr>
          <th class="table-secondary">비밀번호</th>
          <td>
            <input type="text" name="pass" class="form-control" style="width: 120px;" required="required">
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <textarea style="width: 480px; height: 100px;" name="content" class="form-control"
              placeholder="자유롭게 게시글을 남겨주세요~~"></textarea>
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="submit" class="btn btn-success" value="게시글등록" style="width: 120px;">
            <input type="button" class="btn btn-success" value="목록이동" style="width: 120px;"
              onclick="location='boardList.jsp'">
          </td>
        </tr>

      </table>

    </form>
  </div>
</body>
</html>