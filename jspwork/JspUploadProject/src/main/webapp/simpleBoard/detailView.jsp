<%@page import="simpleboard.BoardDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
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
<style type="text/css">
.day {
  color: gray;
}
</style>
</head>
<%
String num = request.getParameter("num");
BoardDao dao = new BoardDao();
BoardDto dto = dao.getOneData(num);
dao.updateReadcount(num);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<body>
  <div style="margin: 100px 100px; width: 800px;">
    <h5 style="color: green;"><%=num%>번 게시글
    </h5>
    <h3>
      <b><%=dto.getSubject()%></b>
    </h3>
    <h5><%=dto.getWriter()%></h5>
    <h6 style="color: gray;"><%=sdf.format(dto.getWriteday())%>&nbsp;&nbsp;조회수:
      <%=dto.getReadcount()%>
    </h6>
    <hr>
    <br> <img src="../save/<%=dto.getImgname()%>"><br> <br>
    <%=(dto.getContent() == null ? "" : dto.getContent().replace("\n", "<br>"))%>
    <hr>

    <button class="btn btn-outline-success" onclick="location='addForm.jsp'">글쓰기</button>
    <button class="btn btn-outline-success" type="button" onclick="location='updateForm.jsp?num=<%=num%>'">수정</button>
    <button class="btn btn-outline-success" type="button" onclick="location='deletePassForm.jsp?num=<%=num%>'">삭제</button>
    <button class="btn btn-outline-success" onclick="location='boardList.jsp'">목록</button>
  </div>
  <hr>
  <div style="margin: 100px 100px;">
    <table class="table table-condensed" style="width: 700px;">
      <tr>
        <td>
          <h4>
            <b><%=dto.getSubject()%></b>
          </h4>
          <br> <b><%=dto.getWriter()%></b><br> <span class="day"><%=sdf.format(dto.getWriteday())%></span>&nbsp;&nbsp;
          <span class="read">조회&nbsp;<%=dto.getReadcount()%></span>
        </td>
      </tr>
      <tr>
        <td>
          <a href="../save/<%=dto.getImgname()%>" target="_blank"> <img src="../save/<%=dto.getImgname()%>"
            style="max-width: 200px;"></a> <br> <br>
          <%=(dto.getContent() == null ? "" : dto.getContent().replace("\n", "<br>"))%>
        </td>
      </tr>

    </table>
    <button class="btn btn-outline-success" onclick="location='addForm.jsp'">글쓰기</button>
    <button class="btn btn-outline-success" type="button" onclick="location='updateForm.jsp?num=<%=num%>'">수정</button>
    <button class="btn btn-outline-success" type="button" onclick="location='deletePassForm.jsp?num=<%=num%>'">삭제</button>
    <button class="btn btn-outline-success" onclick="location='boardList.jsp'">목록</button>
  </div>
</body>
</html>