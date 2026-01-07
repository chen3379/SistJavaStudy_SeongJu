<%@page import="memanswer.AnswerDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String idx = request.getParameter("idx");
AnswerDao dao = new AnswerDao();
String memo = dao.getMemo(idx);

JSONObject ob = new JSONObject();
ob.put("memo", memo);

out.print(ob.toString());
%>