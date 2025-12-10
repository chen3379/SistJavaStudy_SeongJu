<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>title</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<!-- 폼으로 quizAction에 전송 후 action페이지에서 처리할 것!!!  -->
	<!-- 1. 본인 이름입력(text) 2. 오늘점심메뉴(radio) 3.가능IT언어(check 다중) -->
	<form action="quizAction.jsp">
		<table class="table table-bordered" style="width: 400px;">
			<tr>
				<th class="table-primary">이름</th>
				<td colspan="4"><input type="text" name="name"
					style="width: 100px"></td>
			</tr>
			<tr>
				<th class="table-primary">오늘점심메뉴</th>
				<td><input type="radio" value="중식" name="menu">중식&nbsp;
					<input type="radio" value="한식" name="menu">한식&nbsp; <input
					type="radio" value="양식" name="menu">양식&nbsp; <input
					type="radio" value="일식" name="menu">일식&nbsp;</td>
			</tr>
			<tr>
				<th class="table-primary">가능IT언어</th>
				<td><input type="checkbox" value="java" name="lang">java&nbsp;
					<input type="checkbox" value="python" name="lang">python&nbsp;
					<input type="checkbox" value="c++" name="lang">c++&nbsp; <input
					type="checkbox" value="javascript" name="lang">javascript&nbsp;</td>
			</tr>
			<tr>

				<td colspan="2" align="center"><button type="submit"
						class="btn btn-primary" style="width: 100px;">전송</button></td>
			</tr>


		</table>

	</form>
</body>
</html>