<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo:wght@400;700;800&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<style>
/* 배경 설정: 은은한 그라데이션 */
body {
	background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
	min-height: 100vh;
	padding: 50px 0;
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, sans-serif;
}

/* 메인 컨테이너: 종이 질감의 흰색 박스 */
.content-container {
	max-width: 850px;
	margin: 0 auto;
	background: #ffffff;
	padding: 80px 100px; /* 넉넉한 여백 */
	border-radius: 20px;
	box-shadow: 0 15px 35px rgba(50, 50, 93, 0.1), 0 5px 15px
		rgba(0, 0, 0, 0.07);
}

/* 상단 메타 정보 (날짜, 번호) */
.meta-top {
	font-size: 0.85rem;
	color: #999;
	letter-spacing: 1px;
	text-transform: uppercase;
	margin-bottom: 20px;
	font-weight: 600;
}

/* 제목 스타일: 명조체, 굵게 */
.subject-title {
	font-family: 'Nanum Myeongjo', serif;
	font-size: 2.8rem;
	font-weight: 800;
	color: #111;
	margin-bottom: 40px;
	line-height: 1.3;
	word-break: keep-all; /* 단어 단위 줄바꿈 */
	letter-spacing: -1px;
}

/* 작성자 정보 영역 */
.author-info {
	padding: 20px 0;
	border-top: 1px solid #f0f0f0;
	border-bottom: 1px solid #f0f0f0;
	margin-bottom: 60px;
}

.author-avatar {
	width: 45px;
	height: 45px;
	background-color: #2c3e50;
	color: white;
	border-radius: 50%;
	display: flex;
	align-items: center;
	justify-content: center;
	font-weight: bold;
	font-size: 1.2rem;
	margin-right: 15px;
}

/* 본문 텍스트 */
.main-text {
	font-size: 1.15rem;
	line-height: 2.1; /* 읽기 편한 줄간격 */
	color: #333;
	margin-bottom: 60px;
	white-space: pre-wrap; /* 줄바꿈/띄어쓰기 유지 */
	letter-spacing: -0.2px;
}

/* 이미지 갤러리 섹션 */
.image-gallery {
	display: flex;
	flex-direction: column;
	gap: 40px;
	margin-bottom: 60px;
	flex-direction: column;
}

.image-wrapper {
	position: relative;
	overflow: hidden;
	border-radius: 12px;
	/* box-shadow: 0 10px 30px rgba(0,0,0,0.08); */
}

.content-image {
	width: 30%;
	height: 30%;
	display: block;
	transition: transform 0.4s ease;
	display: block;
}

.content-image:hover {
	transform: scale(1.02);
}

/* 하단 버튼 영역 */
.footer-divider {
	margin: 0 0 40px;
	border-top: 2px solid #f0f0f0;
}

.btn-custom-list {
	background-color: #111;
	color: #fff;
	border: none;
	padding: 12px 40px;
	border-radius: 50px;
	font-weight: 600;
	transition: all 0.3s;
}

.btn-custom-list:hover {
	background-color: #333;
	color: #fff;
	transform: translateY(-2px);
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
}

.btn-group-action .btn {
	border-radius: 50px;
	padding: 8px 25px;
	font-size: 0.9rem;
	font-weight: 600;
}

/* 모바일 대응 */
@media ( max-width : 768px) {
	.content-container {
		padding: 40px 25px;
		margin: 0 15px;
	}
	.subject-title {
		font-size: 2rem;
	}
	.main-text {
		font-size: 1.05rem;
	}
}
</style>
</head>
<body>

	<div class="container">
		<div class="content-container">

			<div
				class="meta-top d-flex justify-content-between align-items-center">
				<span>No. ${dto.num}</span> <span> <i class="bi bi-clock"></i>
					<fmt:formatDate value="${dto.writeday}" pattern="yyyy.MM.dd HH:mm" />
				</span>
			</div>

			<h1 class="subject-title">${dto.subject}</h1>

			<div
				class="author-info d-flex justify-content-between align-items-center">
				<div class="d-flex align-items-center">

					<div>
						<span class="text-muted small">작성자</span> <span
							class="fw-bold d-block text-dark" style="font-size: 1.1rem;">${dto.writer}</span>
					</div>
				</div>
				<div class="text-muted small">
					<span class="bg-light px-3 py-1 rounded-pill"> <i
						class="bi bi-eye-fill me-1"></i> ${dto.readcount} reads
					</span>
				</div>
			</div>

			<div class="main-content-wrapper">
				<div class="main-text">${dto.content}</div>

				<c:if test="${dto.photo != 'no-image'}">
					<div class="image-gallery">
						<c:forTokens var="p" items="${dto.photo}" delims=",">
							<div class="image-wrapper">
								<a href="../photo/${p}"> <img src="../photo/${p}"
									class="content-image" alt="Article Image">
								</a>
							</div>
						</c:forTokens>
					</div>
				</c:if>
			</div>

			<!-- 댓글 -->
			<div id="aList">

				<b>댓글 ${acount }</b><br> <br>
				<c:forEach var="a" items="${aList}">
			${a.nickname }:${a.content } &nbsp; &nbsp;
			<span style="color: gray; font-size: 0.6em;"><fmt:formatDate
							value="${a.writeday }" pattern="yyyy-MM-dd" /></span>
					<i class="amod bi bi-pencil-square" style="cursor: pointer;"
						idx="${a.idx}"></i>
					<i class="adel bi bi-file-earmark-x" style="cursor: pointer;"
						idx="${a.idx}"></i>
					<br>
				</c:forEach>
			</div>
			<div class="footer-divider"></div>
			<form action="aInsert" method="post">
				<input type="hidden" name="num" value="${dto.num }"> <input
					type="hidden" name="currentPage" value="${currentPage }">
				<div class="action-buttons d-flex align-items-center">
					<input type="text" placeholder="닉네임 입력" name="nickname"
						class="form-control" style="width: 120px;"> &nbsp;<input
						type="password" placeholder="비밀번호 입력" name="pass"
						class="form-control" style="width: 120px;">
				</div>
				<br>
				<div class="action-buttons d-flex align-items-center">
					<input type="text" name="content" class="form-control"
						style="width: 500px;" placeholder="댓글 입력"> &nbsp;
					<button type="submit" class="btn btn-outline-secondary me-2">등록</button>
				</div>
				<br>
			</form>
			<div class="footer-divider"></div>

			<div
				class="action-buttons d-flex justify-content-between align-items-center">
				<div class="btn-group-action">
					<button type="button" class="btn btn-outline-secondary me-2"
						onclick="location.href='updatepassform?num=${dto.num}&currentPage=${currentPage}'">
						수정</button>
					<%-- 					<button type="button" class="btn btn-outline-secondary me-2"
						onclick="location.href='updateform?num=${dto.num}&currentPage=${currentPage}'">
						수정</button> --%>
					<button type="button" class="btn btn-outline-danger"
						onclick="location.href='deletepassform?num=${dto.num}&currentPage=${currentPage}'">
						삭제</button>
					<%-- 					<button type="button" class="btn btn-outline-danger"
						onclick="location.href='delete?num=${dto.num}&currentPage=${currentPage}'">
						삭제</button> --%>
				</div>

				<button type="button" class="btn btn-custom-list"
					onclick="location.href='list?currentPage=${currentPage}'">
					목록 돌아가기</button>
			</div>

		</div>
	</div>
<script type="text/javascript">
$(".adel").click(function() {
	
	var idx=$(this).attr("idx");
	var pass=prompt("비밀번호를 입력해주세요");
	
	if (pass==null) return;
	
	$.ajax({
		type:"get",
		url:"adelete",
		dataType:"json",
		data:{
			"idx":idx,
			"pass":pass
		},
		success: function(res) {
					if(res.check==1){
						location.reload();
					}else{
						alert("비밀번호가 틀렸습니다");
					}
						
				},
				error: function(){
					alert("서버 통신 오류");
				}
				
		
	});
});

</script></body>
</html>