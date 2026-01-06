<%@page import="memguest.MemGuestDto"%>
<%@page import="memguest.MemGuestDao"%>
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
#preview {
	position: absolute;
	left: 600px;
	top: 100px;
}
</style>
</head>
<script type="text/javascript">
  $(function() {

    $("i.file").click(function() {
      //id photo를 강제 클릭한 이벤트
      $("#photo").trigger("click");
    });
  });

  function readURL(input) {
    // 파일이 선택되었고, 파일 객체가 존재하는지 확인
    if (input.files && input.files[0]) {
      var reader = new FileReader();

      reader.onload = function(e) {

        $('#preview').attr('src', e.target.result);
      };

      reader.readAsDataURL(input.files[0]);
    }
  }
</script>
<body>
  <%
  //세션으로부터 로그인한 사람의 아이디 얻기
  String id = (String) session.getAttribute("idok");
  int currentPage = Integer.parseInt(request.getParameter("currentPage"));
  String num = request.getParameter("num");
  MemGuestDao dao = new MemGuestDao();
  MemGuestDto dto = dao.getOneData(num);

  //로그인한 상태인지?
  String loginok = (String) session.getAttribute("loginok");

  if (loginok != null) {
  %>

  <!-- 이미지 preview -->
  <%
  if (dto.getPhoto().equals("no")) {
  %>
  <img id="preview">
  <%
  } else {
  %>
  <img id="preview" src="../save/<%=dto.getPhoto()%>">
  <%
  }
  %>
  <div style="margin: 50px 100px; width: 500px;">
    <form action="updateAction.jsp" method="post" enctype="multipart/form-data">
      <input type="hidden" name="myid" value="<%=id%>">
      <input type="hidden" name="num" value="<%=num%>">
      <input type="hidden" name="currentPage" value="<%=currentPage%>">
      <table class="table table-bordered">
        <caption align="top">
          <b>회원방명록(<%=id%>)
          </b>
        </caption>
        <tr height="150">
          <td class="input-group">
            <b>사진을 선택해주세요(1개)</b>&nbsp; <i class="bi bi-images file" style="cursor: pointer;"></i>
            <input type="file" name="photo" value="<%=dto.getPhoto()%>" id="photo" style="display: none;"
              onchange="readURL(this)">
            <br>
            <textarea name="content" style="width: 400px; height: 100px;" class="form-control" required="required"><%=dto.getContent()%></textarea>
            <button type="submit" class="btn btn-secondary" style="width: 80px; height: 100px;">수정</button>
          </td>
        </tr>
      </table>
    </form>
  </div>
  <%
  }
  %>
</body>
</html>