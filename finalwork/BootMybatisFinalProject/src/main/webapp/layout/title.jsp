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
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {

		//팝업창에 있는 ajax 로그인 아이디, 비번 얻기
		$("#btnloginok").click(function() {

			var id = $("#loginid").val();
			var pass = $("#loginpass").val();

			//alert(id+","+pass);

			$.ajax({

				type : "get",
				url : "/member/login",
				dataType : "json",
				data : {
					"id" : id,
					"pass" : pass
				},
				success : function(res) {

					if (res.result == "fail") {

						alert("아이디나 비번이 맞지 않습니다");

					}else
						location.reload();
				}
			})
		})
		
		$("#btnlogout").click(function(){

			$.ajax({

				type:"get",
				url:"/member/logout",
				dataType:"html",
				success: function(res){

					location.reload();
				}

				
			
			
			})


		
		
		})


	})
</script>
<style>
body {
	background-color: #fff;
	color: #000;
}

.mymenu {
	display: flex;
	list-style: none;
	padding: 0;
	margin: 20px 0;
	justify-content: center;
}

.mymenu li {
	margin: 0 15px;
}

.mymenu li a {
	color: #000;
	text-decoration: none;
}

.title-image-container {
	text-align: center;
	margin-bottom: 20px;
}

a {
	font-weight: bold;
}
</style>
</head>
<!-- 절대경로 -->
<c:set var="root" value="${pageContext.request.contextPath}" />
<body>
	<div class="title-image-container">
		<a href="${root }"><img src="${root }/image2/title_new.png"></a>
		<c:if test="${sessionScope.loginok==null }">
			<button type="button" class="btn btn-secondary"
				onclick="location.href='${root}/login/main'">Login</button>
		</c:if>
		<c:if test="${sessionScope.loginok!=null }">
			<b>${sessionScope.myid }님 로그인 중</b>
			<button type="button" class="btn btn-secondary"
				onclick="location.href='${root}/login/main'">Logout</button>
		</c:if>

		<!-- Ajax 로그인 -->
		<c:if test="${sessionScope.loginok==null }">		
		<button type="button" class="btn btn-outline-warning" data-bs-toggle="modal"
			data-bs-target="#loginModal">Ajax 로그인</button>
		</c:if>
		<c:if test="${sessionScope.loginok!=null }">		
			<b>${sessionScope.loginname}님 로그인 중</b>
		<button type="button" class="btn btn-outline-warning" data-bs-toggle="modal"
			data-bs-target="#loginModal" id="btnlogout">Ajax 로그아웃</button>
		</c:if>


		<!-- Modal -->
		<div class="modal fade" id="loginModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<input type="text" class="form-control" style="width: 150px;"
							placeholder="로그인 아이디" id="loginid"> <input type="text"
							class="form-control" style="width: 150px;" placeholder="로그인 패스워드"
							id="loginpass">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">닫기</button>
						<button type="button" class="btn btn-primary" id="btnloginok">로그인</button>
					</div>
				</div>
			</div>
		</div>

	</div>
	<ul class="mymenu">
		<li><a href="${root }/">Home</a></li>
		<li><a href="${root }/ipgo/list">상품목록</a></li>
		<li><a href="${root }/member/form">회원가입</a></li>
		<li><a href="${root }/member/list">회원목록</a></li>
		<li><a href="${root }/board/list">회원게시판</a></li>
		<li><a href="${root }/login/main">로그인</a></li>
		<li><a href="${root }/member/myinfo">나의정보</a></li>

	</ul>


</body>
</html>