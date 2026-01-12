<%@page import="data.dao.MemberDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
MemberDao dao = new MemberDao();
int check = dao.getIdCheck(id);
JSONObject ob = new JSONObject();
ob.put("count", check);
%><%=ob.toString()%>