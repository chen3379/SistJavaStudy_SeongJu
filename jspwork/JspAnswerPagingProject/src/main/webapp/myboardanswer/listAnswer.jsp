<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="myboard.BoardAnswerDao"%>
<%@page import="myboard.BoardAnswerDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String num = request.getParameter("num");

BoardAnswerDao dao = new BoardAnswerDao();
List<BoardAnswerDto> list = dao.getAllAnswer(num);

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
JSONArray arr = new JSONArray();
for (BoardAnswerDto dto : list) {
  JSONObject ob = new JSONObject();
  ob.put("idx", dto.getIdx());
  ob.put("num", dto.getNum());
  ob.put("nickname", dto.getNickname());
  ob.put("comment", dto.getComment());
  ob.put("writeday", sdf.format(dto.getWriteday()));
  arr.add(ob);
}
%>
<%=arr.toString()%>