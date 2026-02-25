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
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
<style type="text/css">
#showimg {
	width: 130px;
	height: 160px;
	border: 1px solid gray;
}
</style>
</head>
<body>
	<jsp:include page="../../layout/title.jsp"></jsp:include>

	<div class="container" style="width: 500px;">
		<form action="update" method="post">
		<input type="hidden" num="${dto.num }" value="${dto.num }">
			<h4>회원정보수정</h4>
			<div class="row">
				
				<div class="col-md-8">
					<div class="">
						<label for="name" class="form-label">이름</label> <input type="text"
							value="${dto.name }" name="name" id="name" class="form-control">
					</div>
					<div class="">
						<label for="email" class="form-label">이메일</label> <input
							type="text" value="${dto.email }" name="email" id="email"
							class="form-control">
					</div>
				</div>
			</div>
			<div class="mt-4 text-center">
				<button type="submit" class="btn btn-outline-success">수정</button>
			</div>
		</form>
	</div>
</body>
</html>