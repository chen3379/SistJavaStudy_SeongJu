<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../../layout/title.jsp"></jsp:include>
	<div style="margin-left: 130px;">
		<form action="loginprocess" method="post">
			<table class="table table-bordered" style="width: 300px;">
				<caption align="top">
					<b>세션 로그인</b>
				</caption>
				<tr>
					<td colspan="2" align="center"><input type="checkbox"
						name="cbsave" class="form-check-input"
						${sessionScope.saveok==null? "":"checked" }>아이디저장</td>
				</tr>
				<tr>
					<th width="100" class="table-secondary">아이디</th>
					<td><input type="text" name="id" class="form-control"
						autofocus="autofocus" required="required" style="width: 120px;"
						value="${sessionScope.saveok==null? '':sessionScope.myid}">
					</td>
				</tr>
				<tr>
					<th width="100" class="table-secondary">비밀번호</th>
					<td><input type="password" name="pass" class="form-control"
						required="required" style="width: 150px;"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-success"
							style="width: 100px;">로그인</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>