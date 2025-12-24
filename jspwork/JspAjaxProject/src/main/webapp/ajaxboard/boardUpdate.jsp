<%@page import="ajaxboard.AjaxDao"%>
<%@page import="ajaxboard.AjaxDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String writer = request.getParameter("uwriter");
String subject = request.getParameter("usubject");
String content = request.getParameter("ucontent");
String avata = request.getParameter("uavata");
String num = request.getParameter("unum");

AjaxDto dto = new AjaxDto();

dto.setWriter(writer);
dto.setSubject(subject);
dto.setContent(content);
dto.setAvata(avata);
dto.setNum(num);

AjaxDao dao = new AjaxDao();
dao.updateAjax(dto);
%>