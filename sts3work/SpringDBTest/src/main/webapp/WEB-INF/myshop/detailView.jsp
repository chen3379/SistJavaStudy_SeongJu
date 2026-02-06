<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-5">
				<c:choose>
					<c:when test="${dto.photo == 'no-image' or empty dto.photo}">
						<h3>
							<b>등록된 이미지가 없습니다</b>
						</h3>
					</c:when>
					<c:otherwise>
						<c:set var="photoArray" value="${fn:split(dto.photo, ',')}" />
						<img src="../photo/${photoArray[0]}" id="mainImage"
							class="img-fluid rounded border mb-3"
							style="width: 100%; height: 400px; object-fit: contain;">

						<div class="d-flex flex-wrap gap-2">
							<c:forEach var="p" items="${photoArray}">
								<img src="../photo/${p}" class="img-thumbnail thumb"
									style="width: 80px; height: 80px; object-fit: cover; cursor: pointer;"
									onclick="document.getElementById('mainImage').src=this.src">
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>
			</div>

			<div class="col-md-7">
				<div class="ps-md-4">
					<h2 class="fw-bold mb-3">${dto.sangpum}</h2>
					<hr>
					<table class="table table-borderless fs-5">
						<tr>
							<th width="150" class="text-secondary">상품 번호</th>
							<td>${dto.num}</td>
						</tr>
						<tr>
							<th class="text-secondary">가격</th>
							<td class="text-danger fw-bold"><fmt:formatNumber
									value="${dto.price}" type="currency" /></td>
						</tr>
						<tr>
							<th class="text-secondary">입고일</th>
							<td>${dto.ipgoday}</td>
						</tr>
						<tr>
							<th class="text-secondary">등록 시각</th>
							<td><fmt:formatDate value="${dto.writeday}"
									pattern="YYYY-MM-dd" /></td>
						</tr>
					</table>

					<hr class="mt-4">

					<div class="d-grid gap-2 d-md-flex justify-content-md-start mt-4">
						<button type="button" class="btn btn-outline-primary px-4 btn-sm"
							onclick="location.href='list'">
							<i class="bi bi-list-ul"></i> 목록
						</button>
						<button type="button" class="btn btn-outline-warning px-4 btn-sm"
							onclick="location.href='updateform?num=${dto.num}'">
							<i class="bi bi-pencil-square"></i> 수정
						</button>
						<button type="button" class="btn btn-outline-danger px-4 btn-sm"
							onclick="del(${dto.num})">
							<i class="bi bi-trash"></i> 삭제
						</button>
						<button type="button" class="btn btn-success px-4 btn-sm"
							onclick="location.href='addform'">
							<i class="bi bi-plus-circle"></i> 상품 추가
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
    function del(num) {
        if(confirm("정말로 이 상품을 삭제하시겠습니까?")) {
            location.href="delete?num=" + num;
        }
    }
</script>
</body>
</html>