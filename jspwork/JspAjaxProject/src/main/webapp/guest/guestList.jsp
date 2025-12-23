<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="guest.GuestDao"%>
<%@page import="guest.GuestDto"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
GuestDao dao = new GuestDao();
List<GuestDto> list = dao.getAllGuest();

JSONArray arr = new JSONArray();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

JSONObject ob = new JSONObject();
for (GuestDto dto : list) {
  ob.put("num", dto.getNum());
  ob.put("nickname", dto.getNickname());
  ob.put("content", dto.getContent());
  ob.put("emot", dto.getEmot());
  ob.put("writeday", sdf.format(dto.getWriteday()));
  arr.add(ob);
}
%>
<%=arr.toString()%>