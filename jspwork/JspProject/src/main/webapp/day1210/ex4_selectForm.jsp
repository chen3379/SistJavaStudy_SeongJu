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
	<form action="ex4_action.jsp" method="post">

		<table class="table table-bordered" style="width: 300px">
			<tr>
				<th style="width: 70px;">거주지</th>
				<td><select name="city" class="form-control" size="1">
						<option value="서울">서울</option>
						<option value="대전">대전</option>
						<option value="부산">부산</option>
						<option value="광주">광주</option>
						<option value="울산">울산</option>
						<option value="대구">대구</option>
						<option value="전주">전주</option>
						<option value="용인">용인</option>
				</select></td>
			</tr>
			<tr>
				<th style="width: 120px;">희망근무지</th>
				<td><select name="wishCity" class="form-control" size="7"
					multiple="multiple">
						<option value="서울">서울</option>
						<option value="대전">대전</option>
						<option value="부산">부산</option>
						<option value="광주">광주</option>
						<option value="울산">울산</option>
						<option value="대구">대구</option>
						<option value="전주">전주</option>
						<option value="용인">용인</option>
				</select></td>
			</tr>

			<tr><td colspan="2" align="center">
			<button type="submit" class="btn btn-primary" style="width: 150px;">전송</button>
			</td></tr>
		</table>
	</form>

</body>
</html>