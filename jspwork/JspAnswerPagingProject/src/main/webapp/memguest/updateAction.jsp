<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="memguest.MemGuestDto"%>
<%@page import="memguest.MemGuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//save폴더의 실제서버위치구하기
String realPath = getServletContext().getRealPath("/save");
System.out.println(realPath);

//업로드할 이미지 크기제한
int uploadSize = 1024 * 1024 * 3; //3mb

MultipartRequest multi = null;

try {
  multi =
  new MultipartRequest(request, realPath, uploadSize, "utf-8", new DefaultFileRenamePolicy());

  //입력한 데이터 읽기
  String num = multi.getParameter("num");
  String photo = multi.getFilesystemName("photo");
  System.out.println("photo=" + photo); //이미지 미선택시 null
  String content = multi.getParameter("content");
  int currentPage = Integer.parseInt(multi.getParameter("currentPage"));

  MemGuestDto dto = new MemGuestDto();
  dto.setNum(num);
  dto.setPhoto(photo == null ? "no" : photo);
  dto.setContent(content);

  MemGuestDao dao = new MemGuestDao();
  dao.updateGuest(dto);

  response.sendRedirect("guestList.jsp?currentPage=" + currentPage);
} catch (Exception e) {
  e.printStackTrace();
}
%>