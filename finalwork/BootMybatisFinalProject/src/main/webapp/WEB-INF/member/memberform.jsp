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
<script type="text/javascript">
	$(function() {

		//버튼 누르면 사진불러오기
		$("#btnphoto").click(function() {
			$("#myphoto").trigger("click");
		})

		//사진 불러오면 미리보기
		$("#myphoto").change(function() {
			var input = this;

			if (input.files && input.files[0]) {

				var reader = new FileReader();

				reader.onload = function(e) {
					$("#showimg").attr("src", e.target.result);
				}

				reader.readAsDataURL(input.files[0]);
			}
		});

		// 아이디 중복체크
		$("#btnidcheck").click(function() {

			var myid = $("#loginid").val();
			$.ajax({
				type : "get",
				dataType : "json",
				url : "idcheck",
				data : {
					"id" : myid
				},
				success : function(res) {

					if (res.checkcount == 0) {
						$(".idsuccess").text("사용 가능한 아이디입니다");
						$(".idsuccess").css("color", "green");
					} else {
						$(".idsuccess").text("중복된 아이디입니다");
						$(".idsuccess").css("color", "red");
					}
				}

			});
		})

		//패스워드체크
		$("#pass2").keyup(function() {
			let pass = $("#pass").val();
			let pass2 = $("#pass2").val();

			if (pass == pass2) {
				$(".passsuccess").css("color", "green");
				$(".passsuccess").text("비밀번호 일치");
			} else {
				$(".passsuccess").css("color", "red");
				$(".passsuccess").text("비밀번호 불일치");
			}
		});
	});

	//submit하기 전에 호출
	function check() {

		//사진
		if ($("#myphoto").val() == '') {

			alert('사진을 넣어주세요');
			return false;
		}

		//중복체크
		if ($(".idsuccess").text() != "사용 가능한 아이디입니다") {
			alert('아아디 중복체크해주세요');
			return false;

		}
		//비밀번호체크
		if ($(".passsuccess").text() != "비밀번호 일치") {
			alert('비밀번호가 일치하지않습니다');
			return false;

		}
	}
</script>
</head>
<body>
	<div class="container" style="width: 500px;">
		<form action="insert" method="post" enctype="multipart/form-data"
			onsubmit="return check()">
			<h4>회원가입</h4>
			<div class="row">
				<div class="col-md-4">
					<input type="file" name="myphoto" id="myphoto"
						style="display: none;"> <a href="#" id="btnphoto"> <img
						id="showimg" class="img-thumbnail">
					</a>
				</div>
				<div class="col-md-8">
					<div>
						<label for="loginid" class="form-label">아이디</label>
						<div class="d-flex">
							<input type="text" class="form-control" name="id" id="loginid"
								placeholder="id입력">
							<button type="button" id="btnidcheck"
								class="btn btn-outline-danger" style="width: 120px;">중복체크</button>
						</div>
						<span class="idsuccess"></span>
					</div>
					<div class="">
						<label for="name" class="form-label">이름</label> <input type="text"
							placeholder="이름입력" name="name" id="name" class="form-control">
					</div>
					<div class="">
						<label for="pass" class="form-label">비밀번호</label> <input
							type="password" placeholder="비밀번호" name="pass" id="pass"
							class="form-control"> <input type="password"
							placeholder="비밀번호확인" id="pass2" class="form-control"> <span
							class="passsuccess"></span>
					</div>
					<div class="">
						<label for="email" class="form-label">이메일</label> <input
							type="text" placeholder="이메일입력" name="email" id="email"
							class="form-control">
					</div>
				</div>
			</div>
			<div class="mt-4 text-center">
				<button type="submit" class="btn btn-outline-success">가입</button>
			</div>
		</form>
	</div>
</body>
</html>