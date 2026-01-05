<%@page import="reboard.ReboardDto"%>
<%@page import="reboard.ReboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String currentPage = request.getParameter("currentPage");
String num = request.getParameter("num");
String writer = request.getParameter("uwriter");
String subject = request.getParameter("usubject");
String content = request.getParameter("ucontent");

ReboardDto dto = new ReboardDto();
dto.setNum(num);
dto.setWriter(writer);
dto.setSubject(subject);
dto.setContent(content);

ReboardDao dao = new ReboardDao();
dao.updateReboard(dto);

response.sendRedirect("detailPage.jsp?num=" + num + "&currentPage=" + currentPage);
%>