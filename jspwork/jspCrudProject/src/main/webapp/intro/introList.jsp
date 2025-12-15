<%@page import="intro.IntroDto"%>
<%@page import="java.util.List"%>
<%@page import="intro.IntroDao"%>
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
IntroDao dao = new IntroDao();
List<IntroDto> list = dao.getAllIntros();
%>
<body>

	<div style="width: 700px; margin: 100px 200px;">

		<h1 class="alert alert-info">
			<b>자기소개</b>
		</h1>

		<table class="table table-bordered">
			<tr class="table-secondary">
				<th width="80">번호</th>
				<th width="100">이름</th>
				<th width="180">생년월일</th>
				<th width="180">연락처</th>
				<th width="150">자세히보기</th>
			</tr>

			<%
			if (list.size() == 0) {
			%>
			<tr>
				<td colspan="5" align="center">
					<h3>현재 자기소개 데이터가 없습니다</h3>
				</td>
			</tr>

			<%
			} else {
			for (int i = 0; i < list.size(); i++) {
			    IntroDto dto = list.get(i);
			%>
			<!-- 리스트 열별로 출력 -->
			<tr>
				<td align="center"><%=i + 1%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getBirthday()%></td>
				<td><%=dto.getHp()%></td>
				<td><button type="button" class="btn btn-primary"
						onclick="location='detailPage.jsp?num=<%=dto.getNum()%>'">자세히보기</button></td>
			</tr>

			<%
			}
			}
			%>
		</table>
		<button class="btn btn-outline-info"
			onclick="location='addFormIntro.jsp'">자기소개하기</button>

	</div>
</body>
</html>