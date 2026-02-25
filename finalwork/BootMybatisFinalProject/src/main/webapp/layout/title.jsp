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
<style>
body {
	background-color: #fff;
	color: #000;
}

.mymenu {
	display: flex;
	list-style: none;
	padding: 0;
	margin: 20px 0;
	justify-content: center;
}

.mymenu li {
	margin: 0 15px;
}

.mymenu li a {
	color: #000;
	text-decoration: none;
}

.title-image-container {
	text-align: center;
	margin-bottom: 20px;
}

a {
	font-weight: bold;
}
</style>
</head>
<!-- 절대경로 -->
<c:set var="root" value="${pageContext.request.contextPath}" />
<body>
	<div class="title-image-container">
		<a href="${root }"><img src="${root }/image2/title_new.png"></a>
		<c:if test="${sessionScope.loginok==null }">
			<button type="button" class="btn btn-secondary"
				onclick="location.href='${root}/login/main'">Login</button>
		</c:if>
		<c:if test="${sessionScope.loginok!=null }">
		<b>${sessionScope.myid }님 로그인 중</b>
			<button type="button" class="btn btn-secondary"
				onclick="location.href='${root}/login/main'">Logout</button>
		</c:if>

	</div>
	<ul class="mymenu">
		<li><a href="${root }/">Home</a></li>
		<li><a href="${root }/ipgo/list">상품목록</a></li>
		<li><a href="${root }/member/form">회원가입</a></li>
		<li><a href="${root }/member/list">회원목록</a></li>
		<li><a href="${root }/board/list">회원게시판</a></li>
		<li><a href="${root }/login/main">로그인</a></li>
		<li><a href="${root }/member/myinfo">나의정보</a></li>

	</ul>


</body>
</html>