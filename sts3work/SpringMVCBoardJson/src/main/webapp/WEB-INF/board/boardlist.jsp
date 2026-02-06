<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<style>
    .post-item {
        padding: 25px 10px;
        border-bottom: 1px solid #eee;
        transition: background 0.2s;
        cursor: pointer;
    }
    .post-item:hover {
        background-color: rgba(255,255,255,0.6);
    }
    .post-num { font-size: 0.8rem; color: #aaa; margin-bottom: 5px; }
    .post-title { font-size: 1.25rem; font-weight: 700; color: #111; margin-bottom: 8px; }
    .post-meta { font-size: 0.9rem; color: #666; }
    .pagination .page-link {
        border: none;
        color: #666;
        background: none;
        margin: 0 5px;
        border-radius: 50% !important; /* 동그란 버튼 */
        width: 40px;
        height: 40px;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .pagination .page-item.active .page-link {
        background-color: #000; /* 검정색 강조 */
        color: #fff;
    }
    .pagination .page-link:hover {
        background-color: #eee;
    }
</style>
<body>
<div class="alert alert-success">
<h1><b> 총 ${totalCount }개의 게시글이 있습니다 </b></h1>
</div>
<br>
<button type="button" class="btn btn-outline-primary" onclick="location='addform'">글쓰기</button>
<div class="container mt-5" style="max-width: 800px;">
    <c:forEach var="dto" items="${list}" varStatus="status">
        <div class="post-item" onclick="location.href='content?num=${dto.num}&currentPage=${currentPage}'">
            <div class="post-num">NO. ${no - status.index}</div>
            
            <div class="post-title">
                ${dto.subject}
                <c:if test="${dto.photo != 'no-image'}">
                    <small><i class="bi bi-image text-primary ms-2"></i></small>
                </c:if> 
            </div>
            
            <div class="post-meta d-flex justify-content-between">
                <div>
                    <span class="fw-bold text-dark">${dto.writer}</span> · 
                    <fmt:formatDate value="${dto.writeday}" pattern="yyyy.MM.dd"/>
                </div>
                <div>
                    <span><i class="bi bi-eye"></i> ${dto.readcount}</span>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<div class="d-flex justify-content-center mt-5">
    <ul class="pagination">
        <c:if test="${startPage > 1}">
            <li class="page-item">
                <a class="page-link" href="list?currentPage=${startPage-1}"><i class="bi bi-chevron-left"></i></a>
            </li>
        </c:if>

        <c:forEach var="pp" begin="${startPage}" end="${endPage}">
            <li class="page-item ${currentPage == pp ? 'active' : ''}">
                <a class="page-link" href="list?currentPage=${pp}">${pp}</a>
            </li>
        </c:forEach>

        <c:if test="${endPage < totalPage}">
            <li class="page-item">
                <a class="page-link" href="list?currentPage=${endPage+1}"><i class="bi bi-chevron-right"></i></a>
            </li>
        </c:if>
    </ul>
</div>
</body>
</html>