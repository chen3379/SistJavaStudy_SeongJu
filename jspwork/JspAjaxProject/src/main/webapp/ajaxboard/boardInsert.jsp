<%@page import="ajaxboard.AjaxDao"%>
<%@page import="ajaxboard.AjaxDto"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String writer = request.getParameter("writer");
String subject = request.getParameter("subject");
String content = request.getParameter("content");
String avata = request.getParameter("avata");

AjaxDto dto = new AjaxDto();

dto.setWriter(writer);
dto.setSubject(subject);
dto.setContent(content);
dto.setAvata(avata);

AjaxDao dao = new AjaxDao();
dao.insertBoard(dto);
%>