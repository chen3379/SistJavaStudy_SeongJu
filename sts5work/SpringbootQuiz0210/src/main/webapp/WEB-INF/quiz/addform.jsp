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
	<div style="margin: 100px 100px; width: 500px;">
		<h1 class="alert alert-secondary">[0210과제]</h1>
		<form action="foodshow" method="post">
			<table class="table table-bordered">
				<tr>
					<th width="100">음식명</th>
					<td><input type="text" name="foodname" class="form-control"
						required="required"></td>
				</tr>
				<tr>
					<th width="100">가격</th>
					<td><input type="text" name="foodprice" class="form-control"
						required="required"></td>
				</tr>
				<tr>
					<th width="100">음식이미지</th>
					<td>
					<input type="checkbox" name="foodphoto" value="/image/Food/1.jpg" checked="checked">에그샌드위치
					<input type="checkbox" name="foodphoto" value="/image/Food/2.jpg">햄샌드위치 
					<input type="checkbox" name="foodphoto" value="/image/Food/3.jpg">치킨샌드위치
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-secondary">전송</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>