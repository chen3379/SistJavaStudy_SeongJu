<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<h1>수정폼</h1>
<form action="update" method="post">
<input type="hidden" value="${dto.num }" name="num">
		<table class="table table-bordered" style="width: 400px;">
			<tr>
				<th>자동차명</th>
				<td><input type="text" value="${dto.cname}" name="cname" required="required"></td>
			</tr>

			<tr>
				<th>색상</th>
				<td><input type="color" value="${dto.ccolor }" name="ccolor" required="required"></td>
			</tr>

			<tr>
				<th>가격</th>
				<td><input type="text" value="${dto.cprice}" name="cprice"></td>
			</tr>

			<tr>
				<th>입고일</th>
				<td><input type="date" value="${dto.cguip }" name="cguip" required="required"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">수정</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>