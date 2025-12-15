<%@page import="intro.IntroDto"%>
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
<body>

	<%
	String num = request.getParameter("num");
	IntroDao dao = new IntroDao();
	IntroDto dto = dao.getOneIntro(num);
	%>
	<div style="margin: 100px 100px; width: 500px;">
		<h2 class="alert alert-warning"><%=dto.getName()%>님의 자기소개
		</h2>
		<br>
		<br>
		<h4>
		<b>생년월일: </b> <%=dto.getBirthday() %>
		</h4>
		<h4>
		<b>연락처: </b> <%=dto.getHp() %>
		</h4>
		<h4>
		<b>출신지역: </b> <%=dto.getHometown()%>
		</h4>
		<h4>
		<b>취미: </b> <%=dto.getHobby().equals("no")?"취미가 없습니다":dto.getHobby()%>
		</h4>
		<h4>
		<b>MBTI: </b> <%=dto.getMbti() %>
		</h4>
		<h4>
		<b>하고싶은말: </b> <%=dto.getFree() %>
		</h4>
		<h4>
		<b>작성일: </b> <%=dto.getWriteday() %>
		</h4>
		<br><br>
		<button type="button" class="btn btn-warning" onclick="location='updateFormIntro.jsp?num=<%=dto.getNum()%>'">수정</button>
		<button type="button" class="btn btn-danger" onclick="location='deleteFormIntro.jsp?num=<%=dto.getNum()%>'">삭제</button>
	</div>

</body>
</html>