<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="myshop.ShopDto"%>
<%@page import="myshop.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
  href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap"
  rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>title</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<%
ShopDao dao = new ShopDao();
List<ShopDto> list = dao.getAllSangpums();

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
NumberFormat nf = NumberFormat.getCurrencyInstance();
%>
<body>
  <div style="width: 700px; margin: 50px 100px">
    <h3 class="alert alert-info" style="text-align: center;">MyShop 전체목록출력</h3>
    <br>
    <button type="button" onclick="location='shopForm.jsp'" class="btn btn-outline-warning">상품 등록</button>
    <br> <br>
    <table class="table table-bordered">
      <tr class="table-warning" style="text-align: center;">
        <th width="60">번호</th>
        <th width="120">상품명</th>
        <th width="120">상품가격</th>
        <th width="120">입고일자</th>
        <th width="140">등록일자</th>
      </tr>
      <%
      if (list.size() == 0) {
      %>
      <tr>
        <td colspan="5" text align="center"><h6>입고된 상품이 없습니다</h6></td>
      </tr>
      <%
      } else {
      for (int i = 0; i < list.size(); i++) {
        ShopDto dto = list.get(i);
      %>
      <tr style="text-align: center; line-height: 50px">
        <td><%=i + 1%></td>
        <td><img alt="" style="height: 50px; width: 50px; margin-left:0px; cursor: pointer;"
          onclick="location='detailPage.jsp?num=<%=dto.getNum()%>'" src="../image/쇼핑몰사진/<%=dto.getPhoto()%>"> <%=dto.getSangpum()%></td>
        <td><%=nf.format(dto.getPrice())%></td>
        <td><%=dto.getIpgoday()%></td>
        <td><%=sdf.format(dto.getWriteday())%></td>
      </tr>
      <%
      }
      }
      %>

    </table>

  </div>

</body>
</html>