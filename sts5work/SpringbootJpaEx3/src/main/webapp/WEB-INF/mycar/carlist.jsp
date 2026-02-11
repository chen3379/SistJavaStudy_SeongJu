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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
</head>
<body>
	<div style="margin: 100px 100px;" class="alert alert-secondary">
		<img alt="" src="../image/jquery_img/01.png"><br> <br>
		<h3>총 ${count }개의 차 정보가 있습니다</h3>
		<table class="table table-bordered">
			<caption align="top">
				<b>자동차 정보 목록&nbsp;&nbsp;</b>
				<button type="button" onclick="location='addform'"
					class="btn btn-outline-info btn-sm">등록폼</button>
			</caption>
			<tr align="center" class="table-info">
				<th width="80">번호</th>
				<th width="180">자동차명</th>
				<th width="180">색상</th>
				<th width="180">가격</th>
				<th width="220">구입일</th>
				<th width="220">Edit</th>
			</tr>
			<c:forEach items="${list}" var="dto" varStatus="i">
				<tr align="center" >
					<td>${i.count }</td>
					<td>${dto.carname }</td>
					<td style="color: ${dto.carcolor}">${dto.carcolor}</td>
					<td>${dto.carprice}</td>
					<td>${dto.guipday}</td>
					<td>
						<button type="button" onclick="location='updateform?num=${dto.num}'"
							class="btn btn-outline-primary btn-sm">수정</button>
						<button type="button" onclick="location='delete?num=${dto.num}'"
							class="btn btn-outline-warning btn-sm">삭제</button>
					</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>