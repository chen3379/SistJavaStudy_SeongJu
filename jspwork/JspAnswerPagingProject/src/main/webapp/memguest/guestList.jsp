<%@page import="memanswer.AnswerDao"%>
<%@page import="memanswer.AnswerDto"%>
<%@page import="login.LoginDao"%>
<%@page import="memguest.MemGuestDto"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"
  integrity="sha384-G/EV+4j2dNv+tEPo3++6LCgdCROaejBqfUeNjuKAiuXbjrxilcCdDz6ZAVfHWe1Y" crossorigin="anonymous"></script>
<style type="text/css">
div #divA {
	border: 1px solid gray;
	width: 500px;
	margin-bottom: 10px;
	padding: 20px 20px;
	margin-bottom: 10px;
}

img {
	width: 80px;
}

.icon-btn {
	width: 32px;
	height: 32px;
	padding: 0;
	display: flex;
	align-items: center;
	justify-content: center;
}

.icon-btn:hover {
	background-color: #f8f9fa;
}

.title-area {
	display: flex;
	justify-content: space-between; /* 좌우 정렬 */
	align-items: center;
}

.write-day {
	color: gray;
	font-size: 0.7em;
	margin-right: 6px;
	white-space: nowrap;
}

.content {
	font-family: Dongle;
	font-size: 1.5em;
}

.comment-row {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 6px;
}

.comment-left {
	display: flex;
	gap: 8px;
}

.comment-right {
	display: flex;
	align-items: center;
	gap: 6px;
	margin-right: 6px;
	white-space: nowrap;
}
</style>
<script type="text/javascript">
  $(function() {

    $(document).on("click", ".aDelBtn", function() {

      const idx = $(this).attr("idx");

      if (!confirm("댓글을 삭제하시겠습니까?"))
        return;

      $.ajax({
        type : "get",
        dataType : "html",
        url : "../memanswer/answerDelete.jsp",
        data : {
          idx : idx
        },
        success : function() {

          swal("삭제성공", "You clicked the button!", "success").then(function() {
            location.reload();

          })

        },
        error : function() {
          alert("댓글 삭제 실패");
        }
      });

    });

    $(document).on("click", ".aUpdateBtn", function() {

      var idx = $(this).attr("idx");
      //alert(idx);

      //댓글 수정폼의 hidden idx에 idx 넣어주기
      $("#idx").val(idx);

      $.ajax({
        type : "get",
        dataType : "json",
        url : "../memanswer/answerMemo.jsp",
        data : {
          idx : idx
        },
        success : function(res) {

          $("#memo").val(res.memo);
        }
      })
      //모달창 띄우기
      $("#updateAnsModal").modal('show');

    });

    $(document).on("click", "#btnUpdate", function() {

      var idx = $("#idx").val();
      var memo = $("#memo").val();

      $.ajax({
        type : "get",
        dataType : "html",
        url : "../memanswer/answerUpdate.jsp",
        data : {
          idx : idx,
          memo: memo
        },
        success : function() {

          swal("수정성공", "You clicked the button!", "success").then(function() {
            location.reload();

          })
        }
      })
    });

  });
</script>
</head>
<%
//dao
MemGuestDao dao = new MemGuestDao();
LoginDao logindao = new LoginDao();
//총갯수
int totalCount = dao.getTotalCount(); //전체 글갯수
%>
<body>
  <jsp:include page="guestForm.jsp" />
  <hr>
  <div style="margin-left: 100px; width: 500px;">
    <b>총 <%=totalCount%>개의 방명록 글이 있습니다
    </b>
  </div>
  <%
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  int perPage = 2; //한페이지에 보여질 글갯수
  int perBlock = 2; //한블럭에 보여질 페이지갯수
  int startNum; //db에서 가져올 글의 시작번호(mysql이므로 첫글이 0, oracle은 1)
  int startPage; //각블럭당 보여질 시작페이지
  int endPage; //각블럭당 보여질 끝페이지
  int currentPage; //현재페이지
  int totalPage; //총페이지

  int no; //각페이지당 출력할 시작번호

  if (request.getParameter("currentPage") == null)
    currentPage = 1;
  else
    currentPage = Integer.parseInt(request.getParameter("currentPage"));

  totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);

  startPage = (currentPage - 1) / perBlock * perBlock + 1;
  endPage = startPage + perBlock - 1;

  if (endPage > totalPage)
    endPage = totalPage;

  startNum = (currentPage - 1) * perPage;

  no = totalCount - (currentPage - 1) * perPage;

  List<MemGuestDto> list = dao.getPagingList(startNum, perPage);
  %>
  <div style="margin: 10px 100px;" class="form">
    <button type="button" class="btn btn-secondary" onclick="location.href='../index.jsp'">처음으로</button>
  </div>
  <div style="margin: 30px 100px; width: 900px;">
    <%
    for (MemGuestDto dto : list) {
    %>
    <div id="divA">
      <div class="title-area">
        <b><%=logindao.getName(dto.getMyid())%> <span class="write-day">(<%=dto.getMyid()%>)
        </span></b> <span class="write-day"><%=sdf.format(dto.getWriteday())%></span>
      </div>
      <br>
      <br>
      <%
      if (!dto.getPhoto().equals("no")) {
      %><img src="../save/<%=dto.getPhoto()%>">
      <%
      }
      %>
      <br>
      <br>
      <pre class="content"><%=dto.getContent()%></pre>
      <br>

      <%
      String loginok = (String) session.getAttribute("loginok");
      String sessionId = (String) session.getAttribute("idok");
      if (loginok != null && sessionId.equals(dto.getMyid())) {
      %>
      <div class="d-flex justify-content-end gap-2 btn-area">
        <button type="button" onclick="location='updateForm.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>'"
          class="btn btn-outline-primary btn-sm rounded-circle icon-btn">
          <i class="bi bi-pencil"></i>
        </button>
        <button type="button" onclick="location='delete.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>'"
          class="btn btn-outline-danger btn-sm rounded-circle icon-btn">
          <i class="bi bi-trash"></i>
        </button>
      </div>
      <%
      }
      AnswerDao dao2 = new AnswerDao();
      List<AnswerDto> list2 = dao2.getAnswerList(dto.getNum());
      %>
      <div class="answer">
        <b>댓글 <%=list2.size()%></b>
      </div>
      <div class="list">
        <%
        for (AnswerDto dto2 : list2) {
        %>
        <div class="comment-row">
          <div class="comment-left">
            <b><%=logindao.getName(dto2.getMyid())%></b> <span><%=dto2.getMemo()%></span>
          </div>
          <div class="comment-right">
            <span class="write-day"><%=sdf.format(dto2.getWriteday())%></span>
            <%
            if (sessionId.equals(dto2.getMyid())) {
            %>
            <button type="button" class="btn btn-outline-primary btn-sm rounded-circle icon-btn aUpdateBtn"
              idx="<%=dto2.getIdx()%>">
              <i class="bi bi-pencil"></i>
            </button>
            <button type="button" class="btn btn-outline-danger btn-sm rounded-circle icon-btn aDelBtn"
              idx="<%=dto2.getIdx()%>">
              <i class="bi bi-trash"></i>
            </button>
            <%
            }
            %>
          </div>
        </div>

        <%
        }
        %>
        <br>
        <%
        if (loginok != null) {
        %>
        <form action="../memanswer/answerAddAction.jsp" method="post">
          <div class="input-group">
            <input type="hidden" name="myid" value="<%=sessionId%>">
            <input type="hidden" name="num" value="<%=dto.getNum()%>">
            <input type="hidden" name="currentPage" value="<%=currentPage%>">
            <input type="text" name="memo" class="form-control" required="required" placeholder="댓글을 입력하세요"
              style="width: 300px;">
            &nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-outline-primary">저장</button>
          </div>
        </form>
        <%
        }
        %>
      </div>
    </div>

    <%
    }
    %>
    <br>
    <!-- 페이지 번호 출력 -->
    <div>
      <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">

          <%
          //이전 - perBlock을 넘겼을 때 표시가 된다 (1,2,3,4,5 일 땐 previous가 표시가 안 되고 Next로 6 이후부터 표시된다)
          if (startPage > 1) {
          %>
          <li class="page-item"><a class="page-link" href="guestList.jsp?currentPage=<%=startPage - 1%>">Previous</a></li>
          <%
          }
          for (int pp = startPage; pp <= endPage; pp++) {
          if (pp == currentPage) { //현재페이지와 같을 경우 active css클래스 추가
          %>
          <li class="page-item active"><a href="guestList.jsp?currentPage=<%=pp%>" class="page-link"><%=pp%></a></li>
          <%
          } else {
          %>
          <li class="page-item"><a href="guestList.jsp?currentPage=<%=pp%>" class="page-link"><%=pp%></a></li>
          <%
          }
          }

          //다음
          if (endPage < totalPage) {
          %>
          <li class="page-item"><a class="page-link" href="guestList.jsp?currentPage=<%=endPage + 1%>">Next</a></li>
          <%
          }
          %>
        </ul>
      </nav>
    </div>
  </div>

  <!-- Modal -->
  <div class="modal fade" id="updateAnsModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="exampleModalLabel">댓글 수정</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <input type="hidden" id="idx">
          <input type="text" class="form-control" id="memo">
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
          <button type="button" class="btn btn-primary" id="btnUpdate">댓글 수정하기</button>
        </div>
      </div>
    </div>
  </div>
</body>
</html>