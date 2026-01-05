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
<style type="text/css">
.logform {
	margin: 200px 200px;
	width: 400px;
}
</style>
</head>
<%
//세션으로부터 아이디와 체크값 얻는다
String myid = (String) session.getAttribute("idok");
String saveid = (String) session.getAttribute("saveok");

boolean save = true;
if (saveid == null) {
  myid = ""; //아이디 저장 체크 안하면 아이디 없다
  save = false; //체크하지 않았을 때는 false 그 이외에는 초기값이 true이므로 true
}
%>
<body>
  <div class="logform">
    <h2>회원로그인</h2>
    <form action="loginAction.jsp" method="post">
      <input type="text" name="id" class="form-control" style="width: 200px;" placeholder="로그인할 아이디" required="required"
        value="<%=myid%>">
      <br>
      <input type="text" name="pass" class="form-control" style="width: 200px;" placeholder="로그인할 비밀번호"
        required="required">
      <br>
      <button type="submit" class="btn btn-outline-success" style="width: 200px;">로그인</button>
      <br>
      <input type="checkbox" name="save" <%=save ? "checked" : ""%>>
      아이디저장
    </form>
  </div>
</body>
</html>