<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
</head>
<body>
<form action="insert" method="post" >
  <table class="table table-bordered" style="width: 400px;">
     <caption align="top"><b>자동차정보입력</b></caption>
     <tr>
       <th class="table-info">자동차명</th>
       <td>
         <input type="text" name="carname" class="form-control"
         style="width: 120px;" required="required">
       </td>
     </tr>
     <tr>
       <th class="table-info">색상</th>
       <td>
         <input type="color" name="carcolor" class="form-control"
         style="width: 250px;">
       </td>
     </tr>
     <tr>
       <th class="table-info">가격</th>
       <td>
         <input type="text" name="carprice" class="form-control"
         style="width: 150px;" required="required">
       </td>
     </tr>
     <tr>
       <th class="table-info">구입일</th>
       <td>
         <input type="date" name="guipday" class="form-control"
         style="width: 250px;" required="required">
       </td>
     </tr>
     <tr>
       <td colspan="2" align="center">
         <button type="submit" class="btn btn-success btn-sm">DB저장</button>
       </td>
     </tr>
  </table>
</form>

</body>
</html>