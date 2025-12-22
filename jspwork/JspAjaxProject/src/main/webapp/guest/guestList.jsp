<%@page import="java.text.SimpleDateFormat"%>
<%@page import="guest.GuestDao"%>
<%@page import="guest.GuestDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
GuestDao dao = new GuestDao();
List<GuestDto> list = dao.getAllGuest();
%>

<div>
  <table class="table table-bordered">
    <caption align="top">
      <b>Guest 목록</b>
    </caption>
    <tr class="table-warning" align="center">
      <th width="80">번호</th>
      <th width="80">작성자</th>
      <th width="200">인사말</th>
      <th width="100">이모티콘</th>
      <th width="200">작성일자</th>
    </tr>
    <%
    for (int i = 0; i < list.size(); i++) {
      GuestDto dto = list.get(i);
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
    %>
    <tr align="center">
      <td align="center">
        <%=list.size()-i%>
      </td>
      <td>
        <%=dto.getNickname()%>
      </td>
      <td>
        <%=dto.getContent()%>
      </td>
      <td>
        <img width='30' src="<%=dto.getEmot()%>">
      </td>
      <td>
        <%=sdf.format(dto.getWriteday())%>
      </td>
    </tr>
    <%
    }
    %>
  </table>
</div>