<%@page import="java.io.File"%>
<%@page import="memguest.MemGuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String num = request.getParameter("num");
int currentPage=Integer.parseInt(request.getParameter("currentPage"));
MemGuestDao dao = new MemGuestDao();

//게시글을 지우기 전에(db 삭제) 업로드한 이미지 삭제
String imgName = dao.getOneData(num).getPhoto();
//업로드 경로
String uploadPath=getServletContext().getRealPath("/save");

//파일생성
File file=new File(uploadPath+"\\"+imgName);

//파일삭제
if(file.exists()) //파일이 존재하면
  file.delete(); //파일 삭제
dao.deleteGuest(num);

response.sendRedirect("guestList.jsp?currentPage="+currentPage);
%>