<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>title</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script type="text/javascript">
	function goFocus(hp) {
		if (hp.value.length == 4)
			frm.hp3.focus();

	}
</script>
</head>
<%
 String num=request.getParameter("num");
%>
<body>
	<div style="width: 300px; margin: 300px 300px;">
<form action="deleteActionIntro.jsp" method="post">
<table class="table table-bordered">
<tr><td>
<b>삭제에 필요한<br> 비밀번호를 입력해주세요</b>
<br>
<input type="password" name="pass" required="required" class="form-control"><br>
<input type="hidden" name="num" value="<%=num%>">
<button type="submit" class="btn btn-danger" style="width: 100px;">삭제</button>
<button type="button" class="btn btn-success" onclick="location='introList.jsp'" style="width: 100px;">취소</button>
</td></tr>
</table>
</form>

</div>
</body>
</html>