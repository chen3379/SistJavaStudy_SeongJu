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
	String city = request.getParameter("city");
	String[] wish = request.getParameterValues("wishCity");
	%>
	<h3>[희망근무지 결과]</h3>
	<h3>
		거주지:
		<%=city%></h3>
	<h3>
		희망근무지:
		<%
	if (wish == null) {
	%>
		희망근무지역 없음
		<%
	} else {
	for (int i = 0; i < wish.length; i++) {
	%>[<%=wish[i]%>]&nbsp;
		<%
		}%>총 <%=wish.length %>개 지역을 희망함 <%
		}
		%>
		<br>
		<a href="ex4_selectForm.jsp">다시입력</a>
		<a href="javascript:history.back()">다시입력</a>
	</h3>
</body>
</html>