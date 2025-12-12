<%@page import="myInfo.MyInfoDto"%>
<%@page import="myInfo.MyInfoDao"%>
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
</head>
<%
String num=request.getParameter("num");
MyInfoDao dao=new MyInfoDao();
MyInfoDto dto=dao.getOneData(num);

%>
<body>
	<form action="updateAction.jsp" method="post">
		<table class="table table-bordered" style="width: 400px;">
			<tr>
			<th width="100" class="table-warning">이름</th>
			<td>
			<input type="text" name="name" class="form-control" value="<%=dto.getName() %>" required="required" style="width: 120px;">
			</td>
			</tr>
			<tr>
			<th width="100" class="table-warning">주소</th>
			<td>
			<input type="text" name="addr" class="form-control" value="<%=dto.getAddr() %>" required="required" style="width: 250px;">
			</td>
			</tr>
			<tr>
			<td colspan="2" align="center">
			<input type="hidden" name="num" value="<%=num%>"> 
			<!-- form 안에 num값을 전달해야하므로 input으로 num을 전달 후 type hidden으로 안 보이게 처리-->
			<button type="submit" class="btn btn-warning">수정</button>
			<button type="button" class="btn btn-success" onclick="location.href='./infoList.jsp'">목록</button>
			</td>
			</tr>
			
		</table>


	</form>
</body>
</html>