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
<style>
    body {
        background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
        min-height: 100vh;
        font-family: 'Nanum Myeongjo', serif;
    }
    .write-container {
        max-width: 800px;
        margin: 80px auto;
        background: rgba(255, 255, 255, 0.8);
        backdrop-filter: blur(10px);
        padding: 40px;
        border-radius: 30px;
        box-shadow: 0 10px 30px rgba(0,0,0,0.05);
    }
    .form-floating > .form-control:focus {
        border-color: #0d6efd;
        box-shadow: 0 0 0 0.25rem rgba(13, 110, 253, 0.1);
    }
    .input-group-text {
        background-color: transparent;
        border-right: none;
    }
    .form-control {
        border-left: none;
        background-color: transparent;
    }
    .btn-submit {
        background: #000;
        color: #fff;
        border-radius: 50px;
        padding: 12px 30px;
        transition: all 0.3s;
    }
    .btn-submit:hover {
        background: #333;
        transform: translateY(-2px);
    }
</style>
</head>
<body>

<div class="container">
    <div class="write-container">
        <h2 class="text-center mb-5 fw-bold" style="letter-spacing: -1px;">게시글 등록</h2>
        
        <form action="add" method="post" enctype="multipart/form-data">
            <div class="mb-5">
                <input type="text" name="subject" class="form-control form-control-lg border-0 border-bottom rounded-0 px-0" 
                       style="font-size: 2rem; font-weight: 800;" placeholder="제목을 입력하세요" required>
            </div>

            <div class="row g-4 mb-4">
                <div class="col-md-6">
                    <div class="input-group">
                        <span class="input-group-text border-0 border-bottom rounded-0"><i class="bi bi-person"></i></span>
                        <input type="text" name="writer" class="form-control border-0 border-bottom rounded-0" placeholder="작성자 이름">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="input-group">
                        <span class="input-group-text border-0 border-bottom rounded-0"><i class="bi bi-lock"></i></span>
                        <input type="password" name="pass" class="form-control border-0 border-bottom rounded-0" placeholder="비밀번호">
                    </div>
                </div>
            </div>

            <div class="mb-4">
                <textarea name="content" class="form-control border-0 p-3" rows="10" 
                          style="background: rgba(255,255,255,0.5); border-radius: 20px;" placeholder="내용 입력"></textarea>
            </div>

            <div class="mb-5">
                <label class="form-label small text-muted"><i class="bi bi-paperclip"></i> 이미지 첨부</label>
                <input type="file" name="upload" multiple="multiple" class="form-control form-control-sm">
            </div>

            <div class="d-flex justify-content-between align-items-center">
                <a href="list" class="text-decoration-none text-muted"><i class="bi bi-arrow-left"></i> 목록</a>
                <button type="submit" class="btn btn-submit">등록</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>