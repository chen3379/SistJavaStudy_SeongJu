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
<script type="text/javascript">
	$(function() {

		$(".btnnewphoto").click(function() {
			$("#newphoto").trigger("click");

		});

		$("#newphoto").change(function() {

			var num = $(this).attr("num");
			console.log(num);

			var form = new FormData();
			//form.append("photo",$("#newphoto")[0].files[0]); //선택한 1개만 추가
			form.append("photo", this.files[0]); //선택한 1개만 추가
			form.append("num", num);

			console.dir(form);

			$.ajax({

				type : "post",
				url : "updatephoto",
				dataType : "html",
				processData : false,
				contentType : false,
				data : form,
				success : function() {

					location.reload();
				}
			})

		})

		$("#deletebtn").click(function() {

			var num = $(this).attr("num");

			$.ajax({
				type : "get",
				dataType : "html",
				url : "delete",
				data : {
					"num" : num
				},
				success : function() {

					location.href = '/member/list';
				}
			})
		})

	})
</script>
<style type="text/css">
#myimg {
	border: 1px dotted gray;
	width: 100px;
	height: 100px;
	border-radius: 100px;
	float: left;
	/* overflow: hidden; */
}

#img1 {
	width: 100px;
	height: 100px;
}

.info {
	margin: 50px 50px;
}

.info-inner {
	margin: 20px 20px;
	font-weight: bold;
	padding-left: 100px;
}
</style>
</head>
<body>
	<jsp:include page="../../layout/title.jsp"></jsp:include>
	<div class="container">
		<div class="info">
			<h4>
				<b>${dto.name }</b>님의 개인정보
			</h4>
			<div id="myimg">
				<img alt="" src="../membersave/${dto.photo }" id="img1"> <br>
				<input type="file" style="display: none;" id="newphoto"
					num="${dto.num}">
				<button type="button" num="${dto.num}" class="btnnewphoto">사진
					수정</button>
			</div>
			<div class="info-inner">
				<h6>아이디: ${dto.id }</h6>
				<h6>이메일: ${dto.email }</h6>
				<h6>
					가입일:
					<fmt:formatDate value="${dto.gaipday }" pattern="yyyy-MM-dd" />
				</h6>
				<button type="button" num="${dto.num}" id="updatebtn" onclick="location='/member/updateinfo?num=${dto.num}'">수정</button>
				<button type="button" num="${dto.num}" id="deletebtn">탈퇴</button>
			</div>
		</div>
	</div>
</body>
</html>