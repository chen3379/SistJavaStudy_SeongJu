<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<!-- 절대경로 -->
<c:set var="root" value="${pageContext.request.contextPath}" />
<body>
<a href="${root }"><img src="${root }/image2/title_new.png"></a>

<ul class="mymenu">
   <li>
     <a href="${root }/">Home</a>
   </li>
   <li>
     <a href="${root }/ipgo/list">상품목록</a>
   </li>
   <li>
     <a href="${root }/member/form">회원가입</a>
   </li>
   <li>
     <a href="${root }/member/list">회원목록</a>
   </li>
   <li>
     <a href="${root }/board/list">회원게시판</a>
   </li>
   <li>
     <a href="${root }/login/form">로그인</a>
   </li>
   
</ul>


</body>
</html>