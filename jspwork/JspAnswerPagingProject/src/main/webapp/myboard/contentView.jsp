<%@page import="java.text.SimpleDateFormat"%>
<%@page import="myboard.BoardDto"%>
<%@page import="myboard.BoardDao"%>
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
span {
	color: gray;
	font-size: 0.7em;
}

button {
	size: 30px;
}

.bi-trash {
	cursor: pointer;
}
</style>
<script type="text/javascript">
  $(function() {
    var num = $("#num").val();

    alist();

    $("div.uform").hide();

    $("#btnSend").click(function() {
      var nickname = $("#nickname").val();
      var comment = $("#comment").val();

      if (nickname == "" || comment == "") { //비동기 방식에서 null 체크
        alert("정보를 입력해주세요");
        return;
      }

      $.ajax({
        type : "post",
        url : "../myboardanswer/insertAnswer.jsp", //동일 패키지인지 경로 확인 필요
        dataType : "html",
        data : {
          "nickname" : nickname,
          "comment" : comment,
          "num" : num
        },
        success : function() {

          //입력 초기화
          $("#nickname").val("");
          $("#comment").val("");

          alist();

        }

      })

    })

    //댓글삭제
    $(document).on("click", "i.bi-trash", function() {
      var idx = $(this).attr("idx");

      $.ajax({
        type : "post",
        url : "../myboardanswer/deleteAnswer.jsp",
        dataType : "html",
        data : {
          "idx" : idx
        },
        success : function() {
          alist();
        }
      })

    })

    //댓글수정
    $(document).on("click", "i.bi-pencil-square", function() {

      $("div.uform").show();
      $("div.aform").hide();

      var idx = $(this).attr("idx");
      $("#idx").val(idx);

      $.ajax({
        type : "get",
        url : "../myboardanswer/dtoAnswer.jsp",
        dataType : "json",
        data : {
          "idx" : idx
        },
        success : function(res) {
          $("#unickname").val(res.nickname);
          $("#ucomment").val(res.comment);
          alist();
        }
      })

    })

    //최종수정
    $("#btnUSend").click(function() {

      var idx = $("#idx").val();
      var nickname = $("#unickname").val();
      var comment = $("#ucomment").val();
      $.ajax({
        type : "post",
        url : "../myboardanswer/updateAnswer.jsp",
        dataType : "html",
        data : {
          "idx":idx,
          "nickname":nickname,
          "comment":comment
        },
        success : function() {

          alist();

          $("div.uform").hide();
          $("div.aform").show();
        }
      })

    })

    //댓글목록
    function alist() {

      var num = $("#num").val();

      $.ajax({
        type : "get",
        url : "../myboardanswer/listAnswer.jsp",
        dataType : "json",
        data : {
          "num" : num
        },
        success : function(res) {
          $("b.acount>span").text(res.length);
          var s = "";
          $.each(res, function(i, e) {
            s += "<div>";
            s += "<i class='bi bi-person-circle'></i>" + e.nickname + ": " + e.comment;
            s += "&nbsp;&nbsp;&nbsp;<span>" + e.writeday + "</span>";
            s += "<i class='bi bi-pencil-square' idx="+e.idx+"></i>";
            s += "<i class='bi bi-trash' idx="+e.idx+"></i>";
            s += "</div>";
          })
          $("div.alist").html(s);
        }
      })
    }

  })
</script>
</head>
<%
String num = request.getParameter("num");

BoardDao dao = new BoardDao();
dao.updateReadcount(num);
BoardDto dto = dao.getOneData(num);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
  <div style="margin: 50px 100px;">
    <table class="table table-bordered" style="width: 500px;">
      <caption align="top">
        <b style="font-size: 1.2em;"><%=dto.getSubject()%></b>
      </caption>
      <tr>
        <td>
          <input type="hidden" id="num" value="<%=num%>">
          <b>작성자: <%=dto.getWriter()%></b><br> <span class="day"><%=sdf.format(dto.getWriteday())%></span>&nbsp;&nbsp;
          <span>조회수: &nbsp;<%=dto.getReadcount()%></span>
        </td>
      </tr>
      <tr height="200">
        <td>
          <pre><%=dto.getContent()%></pre>
        </td>
      </tr>
      <tr>
        <td>
          <b class="acount">댓글 <span><%=0%></span></b>
          <div class="alist">댓글목록</div>
          <!-- 입력폼 -->
          <div class="aform input-group">
            <input type="text" id="nickname" class="form-control" style="width: 100px;" placeholder="닉네임">
            <input type="text" id="comment" class="form-control" style="width: 250px;" placeholder="댓글을 입력하세요">
            <button type="button" id="btnSend" class="btn btn-info">저장</button>
          </div>
          <!-- 수정폼 -->
          <div class="uform input-group">
            <input type="hidden" id="idx">
            <input type="text" id="unickname" class="form-control" style="width: 100px;" placeholder="닉네임 수정">
            <input type="text" id="ucomment" class="form-control" style="width: 250px;" placeholder="댓글을 수정하세요">
            <button type="button" id="btnUSend" class="btn btn-info">수정</button>
          </div>
        </td>
      </tr>
      <tr>
        <td>
          <button class="btn btn-outline-success" onclick="location='insertForm.jsp'">글쓰기</button>
          <button class="btn btn-outline-primary" type="button" onclick="location='updatePassForm.jsp?num=<%=num%>'">수정</button>
          <button class="btn btn-outline-warning" type="button" onclick="location='deletePassForm.jsp?num=<%=num%>'">삭제</button>
          <button class="btn btn-outline-info" onclick="location='boardList.jsp'">목록</button>
        </td>
      </tr>
    </table>
  </div>
</body>
</html>