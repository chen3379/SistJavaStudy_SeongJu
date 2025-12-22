<%@page import="guest.GuestDao"%>
<%@page import="guest.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name=request.getParameter("nickname");
String cont=request.getParameter("content");
String emot=request.getParameter("emot");


GuestDto dto=new GuestDto();

dto.setNickname(name);
dto.setContent(cont);
dto.setEmot(emot);


GuestDao dao=new GuestDao();
dao.insertGuest(dto);
%>
