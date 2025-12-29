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
body * {
	font-family: Gamja Flower;
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
/* List<BoardDto> list = dao.getAllDatas(); */

int totalCount = dao.getTotalCount(); //전체 글갯수
int perPage = 4; //한페이지에 보여질 글갯수
int perBlock = 5; //한블럭에 보여질 페이지갯수
int startNum; //db에서 가져올 글의 시작번호(mysql이므로 첫글이 0, oracle은 1)
int startPage; //각블럭당 보여질 시작페이지
int endPage; //각블럭당 보여질 끝페이지
int currentPage; //현재페이지
int totalPage; //총페이지

int no; //각페이지당 출력할 시작번호

//현재페이지 읽기, 단 null일 경우는 1로 준다
if (request.getParameter("currentPage") == null)
  currentPage = 1;
else
  currentPage = Integer.parseInt(request.getParameter("currentPage"));

//총페이지 구하기
//총페이지갯수/한페이지에 보여질 갯수로 나눔(7/5=1)
//나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지 필요)
totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);

//각블럭당 보여질 시작페이지
//perBlock=5일 경우 현재페이지 1~5일 경우는 시작페이지1, 끝5
//만약 현재페이지가 13 시작:11 끝:15
startPage = (currentPage - 1) / perBlock * perBlock + 1;
endPage = startPage + perBlock - 1;

//총페이지갯수가 23일 경우 끝페이지가 25가 아닌 23
if (endPage > totalPage)
  endPage = totalPage;

//각페이지에서 보여질 시작번호(5개의 글을 한페이지)
//예: 1페이지-> 0 2페이지-> 5 3페이지-> 10
startNum = (currentPage - 1) * perPage;

no = totalCount - (currentPage - 1) * perPage;

//페이지에서 보여질 글만 가져오기
List<BoardDto> list = dao.getPagingList(startNum, perPage);

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
  <div style="margin: 30px 100px; width: 800px;">
    <button type="button" class="btn btn-success" onclick="location.href='insertForm.jsp'">글쓰기</button>
    <br>
    <h5><%=totalCount%>개의 게시글이 있습니다
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
      if (totalCount == 0) {
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
        <td><%=no - i%></td>
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
    <!-- 페이지 번호 출력 -->
    <div>
      <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">

          <%
          //이전
          if (startPage > 1) {
          %>
          <li class="page-item"><a class="page-link" href="boardList.jsp?currentPage=<%=startPage-1%>">Previous</a></li>
          <%
          }
          for (int pp = startPage; pp <= endPage; pp++) {
          if (pp == currentPage) { //현재페이지와 같을 경우 active css클래스 추가
          %>
          <li class="page-item active"><a href="boardList.jsp?currentPage=<%=pp%>" class="page-link"><%=pp%></a></li>
          <%
          } else {
          %>
          <li class="page-item"><a href="boardList.jsp?currentPage=<%=pp%>" class="page-link"><%=pp%></a></li>
          <%
          }
          }

          //다음
          if (endPage < totalPage) {
          %>
          <li class="page-item"><a class="page-link" href="boardList.jsp?currentPage=<%=endPage + 1%>">Next</a></li>
          <%
          }
          %>
        </ul>
      </nav>
    </div>
  </div>



</body>
</html>