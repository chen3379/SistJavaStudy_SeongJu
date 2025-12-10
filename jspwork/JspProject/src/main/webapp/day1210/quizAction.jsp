<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>title</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");		
String name= request.getParameter("name");
String menu=request.getParameter("menu");
String[] lang=request.getParameterValues("lang");
%>
<h3>[정보]</h3>
	<h3>
		이름:
		<%=name%></h3>
		<h3>오늘점심메뉴: <%=menu %></h3>
	<h3>
		가능IT언어:
		<%
	if (lang == null) {
	%>
		가능언어 없음
		<%
	} else {
	for (int i = 0; i < lang.length; i++) {
	%>[<%=lang[i]%>]&nbsp;
		<%
		}%>총 <%=lang.length %>개 사용 가능 <%
		}
		%>
		<!--foreach: for(String lg:lange) 으로도 가능  -->
		<br>

		<a href="javascript:history.back()">다시입력</a>
	</h3>
</body>
</html>