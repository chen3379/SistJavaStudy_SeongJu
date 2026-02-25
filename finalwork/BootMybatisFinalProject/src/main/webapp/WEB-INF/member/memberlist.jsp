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
		//전체삭제 체크박스 선택/해제
		$("#allcheck").click(function() {

			//체크값 얻기
			var chk=$(this).is(":checked");
/* 			console.log(chk); */
			
			//얻은 체크를 글 앞의 체크에 일괄전달
			$(".del").prop("checked",chk);
		})
		
		$("#deletebtn").click(function(){

			var cnt = $(".del:checked").length;
			
			if(cnt==0){

				alert("최소 한 개는 선택해주세요");
				return;
			}
			
			$(".del:checked").each(function(i,elt){

				var num=$(this).attr("num");
				//alert(num);
				
				$.ajax({

					type : "get",
					dataType : "html",
					url : "delete",
					data : {
						"num" : num
					},
					success:function(){

						location.reload();
					}
				
				})

			
			})
		
		})

	})
</script>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<jsp:include page="../../layout/title.jsp"></jsp:include>
	<div class="container">
		<!-- 번호 회원명 아이디 이메일 -->
		<table class="table table-bordered" style="width: 700px;">
			<caption align="top">
				<b>회원목록(총 ${count }명의 회원이 있습니다)</b>
			</caption>
			<tr align="center" class="table-secondary">
				<th width="60">번호</th>
				<th width="110">회원명</th>
				<th width="140">아이디</th>
				<th width="180">이메일</th>
				<th width="80"><input type="checkbox" id="allcheck"></th>
			</tr>
			<c:forEach items="${list }" var="dto" varStatus="i">
				<tr align="center">
					<td>${i.count}</td>
					<td><a href="myinfo?num=${dto.num }"
						style="text-decoration: none; color: black;">${dto.name }</a></td>
					<td>${dto.id}</td>
					<td>${dto.email}</td>
					<td><input type="checkbox" class="del" num=${dto.num }></td>
				</tr>
			</c:forEach>
		</table>
		<button type="button" id="deletebtn">Delete</button>
	</div>
</body>
</html>