<%@page import="org.json.simple.JSONObject"%>
<%@page import="myboard.BoardAnswerDao"%>
<%@page import="myboard.BoardAnswerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String idx = request.getParameter("idx");
BoardAnswerDao dao = new BoardAnswerDao();
BoardAnswerDto dto = dao.getAnswerData(idx);

JSONObject ob = new JSONObject();
ob.put("idx", dto.getIdx());
ob.put("nickname", dto.getNickname());
ob.put("comment", dto.getComment());
%>
<%=ob.toString()%>