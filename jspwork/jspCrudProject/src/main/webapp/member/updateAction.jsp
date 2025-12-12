<%@page import="member.MemberDao"%>
<%@page import="member.MemberDto"%>
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
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String driver = request.getParameter("driver");
	String job = request.getParameter("job");
	String num = request.getParameter("num");

	MemberDto dto = new MemberDto();

	//수정된 값을 다시 dto에 set
	dto.setName(name);
	dto.setHp(hp);
	if(driver==null) driver="미보유";
	dto.setDriver(driver);
	dto.setJob(job);
	dto.setNum(num);

	MemberDao dao = new MemberDao();
	dao.updateMember(dto);

	response.sendRedirect("memberList.jsp");
	%>
<!-- 자바빈즈로 구현 -->

<%-- 
<%
request.setCharacterEncoding("utf-8");

%>
<!-- useBean은 new로 객체생성과 동일 -->
<jsp:useBean id="dao" class="member.MemberDao"/>
<jsp:useBean id="dto" class="member.MemberDto"/>

<jsp:setProperty property="*" name="dto"/>

<%
if(request.getParameter("driver")==null) driver="미보유";
dto.setDriver(driver);
dao.updateMember(dto);
response.sendRedirect("memberList.jsp");
%>

 --%>

















</body>
</html>