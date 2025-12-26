<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
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
<style type="text/css">
body *{
font-family:Gamja Flower;
}

a:link, a:visited {
text-decoration: none;
color: black;
}
a:hover {
	text-decoration: underline;
}
</style>
</head>
<%
BoardDao dao = new BoardDao();
List<BoardDto> list = dao.getAllDatas();

int count = dao.getTotalCount();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
  <div style="margin: 30px 100px; width: 800px;">
    <button type="button" class="btn btn-success" onclick="location.href='insertForm.jsp'">글쓰기</button>
    <br>
    <h5><%=count%>개의 게시글이 있습니다
    </h5>

    <table class="table table-bordered">
      <caption align="top">
        <b>MyBoard 전체목록출력</b>
      </caption>
      <tr class="table-success">
        <th width="100">번호</th>
        <th width="350">제목</th>
        <th width="200">작성자</th>
        <th width="200">작성일</th>
        <th width="100">조회수</th>
      </tr>

      <%
      if (count == 0) {
      %>
      <tr>
        <td colspan="5" align="center">
          <b>등록된 게시글이 없습니다</b>
        </td>
      </tr>
      <%
      } else {
      for (int i = 0; i < list.size(); i++) {
        BoardDto dto = list.get(i);
      %>
      <tr>
        <td><%=count - i%></td>
        <td>
          <a href="contentView.jsp?num=<%=dto.getNum()%>"><%=dto.getSubject()%></a>
        </td>
        <td><%=dto.getWriter()%></td>
        <td><%=sdf.format(dto.getWriteday())%></td>
        <td><%=dto.getReadcount()%></td>
      </tr>
      <%
      }
      }
      %>
    </table>
  </div>



</body>
</html>