<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<c:set var="root" value="${pageContext.request.contextPath}" />
<body>
	<jsp:include page="../../layout/title.jsp"></jsp:include>

	<div class="container">
		<img alt="" src="${root }/image/flower_ani/s6.JPG"> <br> <br>
		<b>${loginname }님이 로그인되었습니다</b>
		<button type="button" class="btn btn-secondary"
			onclick="location='logoutprocess'">logout</button>
	</div>
</body>
</html>