<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
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
BoardDao dao = new BoardDao();
List<BoardDto> list = dao.getAllDatas();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<body>
  <div style="margin: 100px 100px; width: 800px;">
    <table class="table table-bordered">
      <caption align="top" style="font-size: 1.4em;">
        <b>게시판형 목록 보기</b>
        <button class="btn btn-outline-primary" type="button" onclick="location='addForm.jsp'">글쓰기</button>
        <br> <br>
        <h6><%=list.size()%>개의 글
        </h6>
      </caption>
      <tr style="text-align: center" class="table-secondary">
        <th colspan="2" width="400px">제목</th>
        <th width="120px" align="center">작성자</th>
        <th width="120px" align="center">작성일</th>
        <th width="70px" align="center">조회수</th>
      </tr>
      <%
      if (list.size() == 0) {
      %>
      <tr>
        <td colspan="3">
          <h3>등록된 글이 없습니다.</h3>
        </td>
      </tr>
      <%
      } else {
      for (int i = 0; i < list.size(); i++) {
        BoardDto dto = list.get(i);
      %>
      <tr>
        <td width="50" style="text-align: center"><%=list.size() - i%></td>
        <td style="cursor: pointer; text-decoration: none; color: black;"
          onclick="location='detailView.jsp?num=<%=dto.getNum()%>'">
          &nbsp;<%=dto.getSubject()%></td>
        <td>
          &nbsp;<%=dto.getWriter()%></td>
        <td align="center"><%=sdf.format(dto.getWriteday())%></td>
        <td align="center"><%=dto.getReadcount()%></td>
      </tr>
      <%
      }
      }
      %>
    </table>
  </div>

</body>
</html>