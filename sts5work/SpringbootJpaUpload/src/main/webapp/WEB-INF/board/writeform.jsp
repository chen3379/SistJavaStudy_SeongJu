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
<div style="margin: 30px 50px; width: 600px;">
    <form action="write" method="post" enctype="multipart/form-data">
        <table class="table table-bordered">
            <caption class="alert alert-danger" align="top">게시글 등록</caption>
            <tr>
                <th width="100" class="table-info">작성자</th>
                <td>
                    <input type="text" name="writer" class="form-control" required>
                </td>
            </tr>
            <tr>
                <th width="100" class="table-info">제목</th>
                <td>
                    <input type="text" name="subject" class="form-control" required>
                </td>
            </tr>
            <tr>
                <th width="100" class="table-info">내용</th>
                <td>
                    <textarea name="content" class="form-control" style="height: 100px;" required></textarea>
                </td>
            </tr>
            <tr>
                <th width="100" class="table-info">사진</th>
                <td>
                    <input type="file" name="upload" class="form-control" multiple="multiple">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" class="btn btn-outline-info">등록</button>
                    <button type="button" class="btn btn-outline-info" onclick="history.back()">목록</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>