<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>title</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String sname = request.getParameter("s_name");
	String cbarea = request.getParameter("cbarea");
	String ipsaday = request.getParameter("ipsaday");
	String menu = request.getParameter("menu");
	String[] lang = request.getParameterValues("lang");
	String gift = request.getParameter("gift");
	String bgColor = request.getParameter("bgColor");
	%>

	<div style='background-color:<%=bgColor%>; width:500px;'>
		<h3>
			<b>사원명: <%=sname%></b>
		</h3>
		<h3>
			<b>해외근무여부: <%=cbarea != null ? "가능" : "불가능"%></b>
		</h3>
		<h3>
			<b>입사일자: <%=ipsaday%></b>
		</h3>
		<h3>
			<b>가장좋았던 점심메뉴: <%=menu%></b>
		</h3>
		<h3>
			<b>받고싶은 명절선물: </b>
		</h3>
		<img src='<%=gift%>' />
		<h3>
			<b>가능언어: <%
			if (lang == null) {
			%> 가능언어 없음 <%
			} else {
			for (int i = 0; i < lang.length; i++) {
			%> <%=lang[i]%>&nbsp; <%
 }
 }
 %>
			</b>
		</h3>

	</div>
</body>
</html>