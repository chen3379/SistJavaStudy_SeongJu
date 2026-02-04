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
	<form action="uploadproc2" method="post" enctype="multipart/form-data">
		<table class="table table-bordered" style="width: 400px;">
			<caption align="top">
				<b>스프링 파일업로드(여러개)</b>
			</caption>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" class="form-control"
					style="width: 200px;"></td>
			</tr>
			<tr>
				<th>업로드</th>
				<td><input type="file" name="photo" class="form-control"
					style="width: 200px;" multiple="multiple"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><button type="submit" class="btn btn-info">업로드</button></td>
			</tr>
		</table>
	</form>
</body>
</html>