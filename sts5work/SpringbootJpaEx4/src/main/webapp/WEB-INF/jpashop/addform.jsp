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

	<div style="margin: 100px 100px;">
		<form action="add" method="post">
			<table class="table table-bordered" style="width: 300px;">
				<tr>
					<th>상품명</th>
					<td><input type="text" name="sangpum" class="form-control"
						style="width: 150px;" required="required"></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="text" name="price" class="form-control"
						style="width: 150px;" required="required"></td>
				</tr>
				<tr>
					<th>이미지</th>
					<td><select name="photo">
							<option value="acc01.png">시계</option>
							<option value="acc02.png">스카프</option>
							<option value="acc03.png">향수</option>
							<option value="icon03.png">게임기</option>
							<option value="shoe01.png">블랙구두</option>
							<option value="shoe02.png">핑크구두</option>
					</select></td>
				</tr>
				<tr>
					<th>입고일</th>
					<td><input type="date" name="ipgoday" class="form-control"
						style="width: 150px;" required="required"></td>
				</tr>
				<tr>
					
					<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-success">등록</button>
					<button type="button" onclick="location='shoplist'" class="btn btn-outline-success">목록이동</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>