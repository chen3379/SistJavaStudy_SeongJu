<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//프론트에서 보낸 데이터 읽어오기

//프론트형태로 만들어서 front로 보내기
String img=request.getParameter("img");
String imgName=request.getParameter("imgName");
String like =request.getParameter("like");


JSONObject ob=new JSONObject();
ob.put("img", img);
ob.put("imgName", imgName);
ob.put("like",like);

%>
<%=ob.toString()%>