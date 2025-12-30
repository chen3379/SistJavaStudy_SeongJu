<%@page import="myboard.BoardAnswerDao"%>
<%@page import="myboard.BoardAnswerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String nickname = request.getParameter("nickname");
String comment = request.getParameter("comment");
String num= request.getParameter("num");

BoardAnswerDto dto = new BoardAnswerDto();
dto.setNickname(nickname);
dto.setComment(comment);
dto.setNum(num);

BoardAnswerDao dao = new BoardAnswerDao();
dao.insertBoardAnswer(dto);
%>