<%@page import="memanswer.AnswerDao"%>
<%@page import="memanswer.AnswerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String idx = request.getParameter("idx");
String memo = request.getParameter("memo");

AnswerDto dto = new AnswerDto();
dto.setIdx(idx);
dto.setMemo(memo);

AnswerDao dao = new AnswerDao();
dao.updateMemo(dto);
%>