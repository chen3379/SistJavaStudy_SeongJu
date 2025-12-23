<%@page import="guest.GuestDto"%>
<%@page import="guest.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String num = request.getParameter("unum");
String nickname = request.getParameter("unickname");
String content = request.getParameter("ucontent");
String emot = request.getParameter("uemot");

GuestDto dto = new GuestDto();

dto.setNum(num);
dto.setNickname(nickname);
dto.setContent(content);
dto.setEmot(emot);

GuestDao dao = new GuestDao();
dao.updateGuest(dto);
%>