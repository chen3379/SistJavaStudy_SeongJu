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
	<c:if test="${totalcount==0 }">
		<div class="alert alert-success">
			<b>저장된 상품 정보가 없습니다</b>
		</div>
	</c:if>
	<c:if test="${totalcount>0 }">
		<div class="alert alert-success">
			<b>${totalcount }개의 상품 정보가 있습니다</b>
		</div>
	</c:if>
	<button type="button" class="btn btn-info" onclick="location='form'">상품
		정보 입력</button>

	<br>

	<br>
	<table class="table table-bordered" style="width: 700px;">
		<tr align="center" valign="middle">
			<th width="50px">번호</th>
			<th width="90px">상품명</th>
			<th width="90px">상품사진</th>
			<th width="90px">가격</th>
			<th width="120px">입고일</th>
			<th width="100px">편집</th>
		</tr>
		<c:forEach items="${list }" var="i" varStatus="a">
			<tr align="center" valign="middle">
				<td>${a.count }</td>
				<td>${i.sang }</td>
				<td>
				<c:if test="${i.photoname!=null }">
						<img alt="" src="../photo/${i.photoname }" width="50px;" align="center">
					</c:if>
					
				<c:if test="${i.photoname==null }">
						<img alt="" src="../image/logoImg/a.png" width="50px;">
					</c:if>
					
					</td>
				<td><fmt:formatNumber value="${i.dan }" type="currency"/> </td>
				<td><fmt:formatDate value="${i.ipgo}" pattern="yyyy-MM-dd HH:mm"/> </td>
				<td>
				<button type="button" class="btn btn-sm btn-outline-primary" onclick="location='updateform?num=${i.num}'">수정</button>
				<button type="button" class="btn btn-sm btn-outline-danger" onclick="location='delete?num=${i.num}'">삭제</button>
				</td>
			</tr>
	</c:forEach>
	</table>
</body>
</html>