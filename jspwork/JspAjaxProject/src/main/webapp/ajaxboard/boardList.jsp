
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.List"%>
<%@page import="ajaxboard.AjaxDao"%>
<%@page import="ajaxboard.AjaxDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
AjaxDao dao = new AjaxDao();
List<AjaxDto> list = dao.getAllData();

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
JSONArray arr=new JSONArray();
for (AjaxDto dto : list) {

  JSONObject ob = new JSONObject();
  ob.put("num", dto.getNum());
  ob.put("writer", dto.getWriter());
  ob.put("subject", dto.getSubject());
  ob.put("content", dto.getContent());
  ob.put("avata", dto.getAvata());
  ob.put("writeday", sdf.format(dto.getWriteday()));
  arr.add(ob);
}
%>
<%=arr.toString()%>