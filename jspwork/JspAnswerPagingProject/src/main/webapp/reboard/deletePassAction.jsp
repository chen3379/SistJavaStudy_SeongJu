<%@page import="reboard.ReboardDto"%>
<%@page import="reboard.ReboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String num = request.getParameter("num");
String pass = request.getParameter("pass");
String currentPage = request.getParameter("currentPage");

ReboardDao dao = new ReboardDao();
boolean check = dao.isEqualPass(num, pass);
if (check) {
	dao.deleteReboard(num);

	response.sendRedirect("boardList.jsp?num=" + num + "&currentPage=" + currentPage);
} else {
%>
<script type="text/javascript">
  alert("비밀번호가 틀렸습니다");
  history.back();
</script>
<%
}
%>