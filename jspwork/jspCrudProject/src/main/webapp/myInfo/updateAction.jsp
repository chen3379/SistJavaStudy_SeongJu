<%@page import="myInfo.MyInfoDao"%>
<%@page import="myInfo.MyInfoDto"%>
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
	//수정메서드 받아서 처리 후 목록으로 이동

	//인코딩
	request.setCharacterEncoding("utf-8");

	//데이터 읽기
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String num = request.getParameter("num");

	//입력데이터를 dto로 묶어서(dto에 set)
	MyInfoDto dto = new MyInfoDto();
	dto.setName(name);
	dto.setAddr(addr);
	dto.setNum(num);

	//update메서드에 전달
	MyInfoDao dao = new MyInfoDao();
	dao.updateMyInfo(dto);

	//목록으로 간다..주소값이 바뀜
	response.sendRedirect("infoList.jsp");
	%>

</body>
</html>