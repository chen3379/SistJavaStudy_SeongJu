<%@page import="memanswer.AnswerDao"%>
<%@page import="memanswer.AnswerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String num = request.getParameter("num");
String myid = request.getParameter("myid");
String memo = request.getParameter("memo");
int currentPage = Integer.parseInt(request.getParameter("currentPage"));

AnswerDto dto = new AnswerDto();
dto.setNum(num);
dto.setMyid(myid);
dto.setMemo(memo);

AnswerDao dao = new AnswerDao();
dao.insertAnswer(dto);

response.sendRedirect("../memguest/guestList.jsp?num="+num+"&currentPage=" + currentPage);
%>