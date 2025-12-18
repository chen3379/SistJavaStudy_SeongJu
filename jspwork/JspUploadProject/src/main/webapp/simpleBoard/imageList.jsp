<%@page import="java.text.SimpleDateFormat"%>
<%@page import="simpleboard.BoardDto"%>
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
        <b>이미지형 목록 보기</b>
        <button class="btn btn-outline-primary" type="button" onclick="location='addForm.jsp'">글쓰기</button>
        <br>
        <br>
        <span style="font-size: 0.9em;"><%=list.size()%>개의 글
        </span><br>
        <a href="boardList.jsp">
          <i class="bi bi-list-ul"></i>
        </a>
        <a>
          <i class="bi bi-images"></i>
        </a>
      </caption>

      <%
      if (list.size() == 0) {
      %>
      <tr>
        <td colspan="3">
          <h3>등록된 글이 없습니다.</h3>
        </td>
      </tr>
      <tr>
        <%
        } else {
        for (int i = 0; i < list.size(); i++) {
          BoardDto dto = list.get(i);
        %>
        <td>
          <img src="../save/<%=dto.getImgname()%>" style="width: 240px; height: 240px; border: 1px solid gray;">
          <br>
          <b><%=dto.getSubject()%></b>
          <br>
          <%=dto.getWriter()%><br>
          <span style="color: gray; font-size: 0.9em;"><%=sdf.format(dto.getWriteday())%></span> <span
            style="color: gray; font-size: 0.9em;">조회수: <%=dto.getReadcount()%></span>
        </td>
        <%
        if ((i + 1) % 4 == 0) {
        %>
      
      </tr><tr>
        <%
        }
        }
        }
        %>
      
      <tr>
    </table>

  </div>
</body>
</html>