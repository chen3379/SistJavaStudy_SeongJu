<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<script type="text/javascript">
  function funcdel(num) {
    if(confirm("정말 삭제하시겠습니까?"))
      location.href='deleteShop.jsp?num='+num;
    else
      alert("취소되었습니다");
  }
</script>
</head>
<body>
  <%
  String num = request.getParameter("num");
  ShopDao dao = new ShopDao();

  ShopDto dto = dao.getOneSangpum(num);

  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  NumberFormat nf = NumberFormat.getCurrencyInstance();
  %>
  <div style="margin: 50px 100px; width: 500px;">
    <button type="button" onclick="location='shopList.jsp'" class="btn btn-outline-primary">목록</button>
    <br> <br>
    <h2 class="alert alert-primary"><%=dto.getSangpum()%>&nbsp;상품정보
    </h2>
    <br>
    <div style="position: absolute; margin-left: 300px; margin-top: 30px; font-family: Dongle; font-size: 20pt;">
      <h3>
        <b>상품명: </b><%=dto.getSangpum()%></h3>
      <h3>
        <b>상품가격: </b><%=nf.format(dto.getPrice())%></h3>
      <h3>
        <b>입고일자: </b><%=dto.getIpgoday()%></h3>
      <h3>
        <b>등록일자: </b><%=sdf.format(dto.getWriteday())%></h3>
      <br>
      <br>
      <button style="width: 70px;" type="button" class="btn btn-outline-warning" onclick="location='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button>
      &nbsp;&nbsp;
      <button style="width: 70px;" type="button" class="btn btn-outline-danger" onclick="funcdel(<%=dto.getNum() %>)">삭제</button>
    </div>
    <br>
    <div style="position: absolute;">
      <img style="width: 250px; height: 300px;" alt="" src="../image/쇼핑몰사진/<%=dto.getPhoto()%>">
    </div>
  </div>

</body>
</html>