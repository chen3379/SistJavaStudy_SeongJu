<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>title</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>

<div style="width: 600px; margin: 100px 150px;">
    <form action="addProc.jsp" method="post" name="frm">
      <table class="table table-bordered">
      <caption align="top"><a>상품입고등록</a></caption>
        <tr>
          <th style="text-align: center;" class="table-secondary" width="100">상품명</th>
          <td ><input type="text" name="sangpum" class="form-control" style="width: 120px;" required="required"></td>
        </tr>
        <tr>
          <th style="text-align: center;" class="table-secondary" width="100">상품사진</th>
          <td> <input type="file" name="photo" class="form-control" style="width: 200px;" required="required"></td>
        </tr>
        <tr>
          <th style="text-align: center;" class="table-secondary" width="100">상품가격</th>
          <td><input type="number" name="price" class="form-control" pattern="[0~9]" style="width: 120px;" required="required"></td>
        </tr>
        <tr>
          <th style="text-align: center;" class="table-secondary" width="100">입고일자</th>
          <td><input type="date" name="ipgoday" class="form-control" style="width: 120px;" required="required"></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><button type="submit" class="btn btn-outline-info" style="width: 100px">등록</button>
            <button type="button" class="btn btn-outline-info" style="width: 100px" onclick="location='shopList.jsp'">목록</button>
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>