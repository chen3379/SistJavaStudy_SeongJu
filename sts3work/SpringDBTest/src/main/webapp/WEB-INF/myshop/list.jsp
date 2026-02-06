<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
</head>
<body>
	<c:if test="${count==0 }">
		<h3>입고된 상품이 없습니다</h3>
	</c:if>
	<c:if test="${count!=0 }">
		<h3>총 ${count}개의 상품이 입고중입니다</h3>
	</c:if>
	<table class="table table-bordered" style="width: 600px;">
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>가격</th>
			<th>입고일</th>
		</tr>
		<c:forEach var="dto" items="${list}" varStatus="i">
			<tr style="line-height: 50px;">
				<td>${i.count }</td>
				<td><a href="detail?num=${dto.num }">${dto.sangpum}</a></td>
				<td><fmt:formatNumber value="${dto.price}" type="currency" /></td>
				<td>${dto.ipgoday}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<button type="button" onclick="location.href='addform'">입력폼</button>
</body>
</html>