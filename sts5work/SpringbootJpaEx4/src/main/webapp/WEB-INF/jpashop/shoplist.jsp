<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JPA Shop 목록</title>
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
body * {
	font-family: 'Dongle';
	font-size: 25px;
}
</style>
</head>
<body>
	<div style="margin: 30px 50px;">
		<h2>상품 목록</h2>
		<hr width="700px;">
		<h5>총 ${count}개의 상품이 있습니다.</h5>

		<table class="table table-bordered" style="width: 700px;">
			<tr class="table-light" valign="middle" align="center">
				<th width="60">번호</th>
				<th width="200">상품명</th>
				<th width="120">사진</th>
				<th width="120">가격</th>
				<th width="150">입고일</th>
				<th width="150">Edit</th>
			</tr>

			<c:forEach var="dto" items="${list}" varStatus="i">
				<tr align="center" valign="middle">
					<td>${i.count}</td>
					<td>${dto.sangpum}</td>
					<td><img src="../image/logoImg/${dto.photo}" width="50"
						height="50" border="1"></td>
					<td><fmt:formatNumber value="${dto.price}" type="currency" />
					</td>
					<td>${dto.ipgoday}</td>
					<td>
						<button type="button"
							onclick="location='/myjpa/updateshop?num=${dto.num}'"
							class="btn btn-outline-secondary">수정</button>
						<button type="button" onclick="location='/myjpa/delete?num=${dto.num}'"
							class="btn btn-outline-secondary">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		<button type="button" onclick="location='/myjpa/addshop'"
			class="btn btn-outline-secondary">등록</button>

	</div>
</body>
</html>