<%@page import="mysql_myteam.TeamDto"%>
<%@page import="mysql_myteam.TeamDao"%>
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
String num = request.getParameter("num");
TeamDao dao = new TeamDao();
TeamDto dto = dao.selectOne(num);
%>
<body>

	<div style="width: 500px; margin: 50px 100px;">
		<form action="updateAction.jsp" method="post">
			<table class="table table-bordered">
				<caption align="top">
					<b>Team 멤버 수정</b>
				</caption>
				<tr>
					<th width="100" class="table-success">회원명</th>
					<td><input type="text" name="name" class="form-control"
						value="<%=dto.getName()%>" required="required"
						style="width: 120px;"></td>
				</tr>
				<tr>
					<th width="100" class="table-success">주소</th>
					<td><input type="text" name="addr" class="form-control"
						value="<%=dto.getAddr()%>" required="required"
						style="width: 120px;"></td>
				</tr>
				<tr>
					<th width="100" class="table-success">결혼여부</th>
					<td><input type="checkbox" name="marry"
						value="기혼" <%="기혼".equals(dto.getMarry())? "checked":""%>>&nbsp;기혼</td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="hidden" name="num"
						value="<%=dto.getNum()%>">
						<button type="submit" class="btn btn-outline-info">등록</button>
						<button type="button" class="btn btn-outline-success"
							onclick="location='teamList.jsp'">목록</button></td>
				</tr>





			</table>
		</form>
	</div>
</body>
</html>