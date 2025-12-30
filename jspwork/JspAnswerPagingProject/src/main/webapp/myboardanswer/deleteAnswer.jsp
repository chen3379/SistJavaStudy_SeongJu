<%@page import="myboard.BoardAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String idx = request.getParameter("idx");

BoardAnswerDao dao = new BoardAnswerDao();
dao.deleteAnswer(idx);
%>