<%@page import="intro.IntroDao"%>
<%@page import="intro.IntroDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>title</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String name=request.getParameter("name");
String birthday=request.getParameter("birthday");
String hp=request.getParameter("hp1")+"-"+request.getParameter("hp2")+"-"+request.getParameter("hp3");
String hometown=request.getParameter("hometown");
String[] hobby=request.getParameterValues("hobby");
String num=request.getParameter("num");
String hb="";
if(hobby==null)
    hb="no";
else{
    for(int i=0;i<hobby.length;i++){
  hb+=hobby[i]+",";
    }
    hb=hb.substring(0,hb.length()-1);
}
String mbti=request.getParameter("mbti");
String free=request.getParameter("free");

IntroDto dto=new IntroDto();

dto.setNum(num);
dto.setName(name);
dto.setHp(hp);
dto.setHometown(hometown);
dto.setHobby(hb);
dto.setMbti(mbti);
dto.setFree(free);
dto.setBirthday(birthday);

IntroDao dao=new IntroDao();
dao.updateIntro(dto);

response.sendRedirect("detailPage.jsp");
%>
</body>
</html>