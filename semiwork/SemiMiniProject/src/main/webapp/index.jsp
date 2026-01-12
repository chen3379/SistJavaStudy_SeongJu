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
<style type="text/css">
div.layout {
	border: 0px solid gray;
	position: absolute;
}

div.title {
	width: 100%;
	height: 100px;
	line-height: 80px;
	top: 20px;
}

div.menu {
	width: 100%;
	height: 80px;
	line-height: 80px;
	font-size: 20pt;
	font-family: 'Nanum Myeongjo';
	text-align: center;
	top: 200px;
}

div.info {
	width: 250px;
	height: 300px;
	line-height: 10px;
	font-family: 'Nanum Myeongjo';
	left: 50px;
	top: 400px;
	padding: 20px 10px;
	border: 5px solid purple;
	border-radius: 30px;
}

div.main {
	width: 1200px;
	height: 1000px;
	font-size: '13pt';
	font-family: 'Nanum Myeongjo';
	left: 400px;
	top: 300px;
}

img.title {
	border: 1px solid purple;
	border-radius: 30px;
}
</style>
</head>
<%
//프로젝트경로
String root = request.getContextPath();

String mainPage = "layout/main.jsp";
//url을 통해서 main값을 읽은 후 메인페이지에 출력한다
if (request.getParameter("main") != null) {
	mainPage = request.getParameter("main");
}
%>
<body>
	<div class="layout title">
		<jsp:include page="layout/title.jsp" />
	</div>
	<div class="layout menu">
		<jsp:include page="layout/menu.jsp" />
	</div>
	<div class="layout info">
		<jsp:include page="layout/info.jsp" />
	</div>
	<div class="layout main">
		<jsp:include page="<%=mainPage%>" />
	</div>

</body>
</html>