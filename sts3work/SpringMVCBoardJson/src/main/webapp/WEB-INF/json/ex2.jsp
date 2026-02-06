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
	<h1 class="alert alert-danger">
		<b>ex2</b>
	</h1>
	<br>
	<button type="button" id="btn2" class="btn btn-danger">Json
		데이터 출력_list2</button>
	<br>
	<div id="out"></div>
	<script type="text/javascript">
		$("#btn2").click(function() {
			$.ajax({
				dataType : "json",
				type : "get",
				url : "list2",
				success : function(res) {
					var s="";
					$.each(res, function(i, e) {
						s+= "<img src='image/Food/"+e.foodphoto+"' style='width:150px;'><br>";
						s+= e.foodname+"<br>";

					})
					$("#out").html(s); // 기존 내용을 지우고 s로 교체

				}
			})
		})
	</script>
</body>
</html>