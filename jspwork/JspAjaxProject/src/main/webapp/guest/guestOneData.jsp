<%@page import="org.json.simple.JSONObject"%>
<%@page import="netscape.javascript.JSObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="guest.GuestDto"%>
<%@page import="guest.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String num = request.getParameter("num");
request.setCharacterEncoding("utf-8");

GuestDao dao = new GuestDao();
GuestDto dto = dao.getData(num);
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

JSONObject ob = new JSONObject();
ob.put("num", dto.getNum());
ob.put("nickname", dto.getNickname());
ob.put("content", dto.getContent());
ob.put("emot", dto.getEmot());
ob.put("writeday", sdf.format(dto.getWriteday()));

dao.updateGuest(dto);
%>
<%=ob.toString()%>