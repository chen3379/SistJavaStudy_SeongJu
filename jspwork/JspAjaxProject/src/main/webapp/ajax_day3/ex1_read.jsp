<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//get방식에선 encoding 생략 가능
String name = request.getParameter("name");
String hp = request.getParameter("hp");

System.out.println("name: " + name);
System.out.println("hp: " + hp);
%>