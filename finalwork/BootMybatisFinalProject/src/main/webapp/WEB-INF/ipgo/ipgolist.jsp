<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
<jsp:include page="../../layout/title.jsp"></jsp:include>


<div class="alert alert-info"><b>${totalCount }개의 상품이 입고중입니다</b></div>

<table class="table table-bordered" style="width: 800px;">
   <caption align="top">
      <span style="float: right;">
         <button type="button" class="btn btn-secondary"
         onclick="location.href='ipgoform'">상품추가</button>
      </span>
   </caption>
   
   
   <c:forEach var="dto" items="${list }">
      <tr>
         <td width="400" rowspan="4" align="center" valign="middle">
            <c:if test="${dto.photoname!='no' }">
              <c:forTokens var="pho" items="${dto.photoname }" delims="," begin="0" end="0">
                 <img alt="" src="../ipgosave/${pho }" style="width: 100px;">
              </c:forTokens>
            </c:if>
           
         </td>
         <td>상품명: ${dto.sangpum }</td>
      </tr>
      <tr>
         <td>가격: <fmt:formatNumber value="${dto.price }" type="currency"/> </td>
      </tr>
      <tr>
        <td>입고일자: <fmt:formatDate value="${dto.ipgoday }" pattern="yyyy년 MM월  dd일"/> </td>
      </tr>
      <tr>
        <td>
          <button>수정</button>
          <button>삭제</button>
        </td>
      </tr>
     
   </c:forEach>
   
   
   
   
</table>
</div>
</body>
</html>