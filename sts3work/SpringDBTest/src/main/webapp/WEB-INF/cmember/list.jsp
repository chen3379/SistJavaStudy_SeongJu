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
	<div class="container mt-3">
		<table class="table table-bordered" style="width: 700px;">
			<thead class="table-light">
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>연락처</th>
					<th>주소</th>
					<th>가입일</th>
					<th>관리</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list}" varStatus="i">
					<tr>
						<td>${i.count}</td>
						<td>${dto.name}</td>
						<td>${dto.hp}</td>
						<td>${dto.addr}</td>
						<td><fmt:formatDate value="${dto.gaipday }" pattern="YYYY-MM-dd"/></td>
						<td><button type="button"
								onclick="location='updateform?num=${dto.num}'">수정</button>
							<button type="button" onclick="del(${dto.num})">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<button type="button" class="btn btn-info"
			onclick="location.href='addform'">등록</button>
	</div>
	<script type="text/javascript">
	function del(num) {
        if(confirm("정말로 이 상품을 삭제하시겠습니까?")) {
            location.href="delete?num=" + num;
        }
    }
	</script>
</body>
</html>