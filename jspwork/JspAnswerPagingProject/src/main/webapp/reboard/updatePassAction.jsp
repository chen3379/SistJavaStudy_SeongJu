<%@page import="reboard.ReboardDto"%>
<%@page import="reboard.ReboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//수정폼에서 넘긴 3개 받아서

//num,pass - 비번 체크 후 맞으면 updateForm(num, currentPage), 틀리면 경고창
String num = request.getParameter("num");
String pass = request.getParameter("pass");
String currentPage = request.getParameter("currentPage");

ReboardDao dao = new ReboardDao();
boolean check = dao.isEqualPass(num, pass);

if (check) {

	response.sendRedirect("updateForm.jsp?num=" + num + "&currentPage=" + currentPage);
} else {
%>
<script type="text/javascript">
  alert("비밀번호가 틀렸습니다");
  history.back();
</script>
<%
}
%>