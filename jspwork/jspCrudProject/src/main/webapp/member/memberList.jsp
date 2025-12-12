<%@page import="java.text.SimpleDateFormat"%>

<%@page import="member.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>title</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<!-- function funcDel(num) {
	
	if(confirm("정말 삭제하시겠어요?"))
	location.href="delete.jsp?num="+num;


 -->




</head>


<%
MemberDao dao = new MemberDao();
List<MemberDto> list = dao.selectMember();
%>

<body>
	<div style="margin: 50px 100px;">
		<button class="btn btn-outline-success"
			onclick="location='addForm.jsp'" type="button">
			<i class="bi bi-pencil-square"></i>회원 등록
		</button>
		<br> <br>
		<table class="table table-bordered">
			<caption align="top">
				<b>회원 목록 조회</b>
			</caption>
			<tr class="table-primary" align="center">
				<th width="60">번호</th>
				<th width="80">이름</th>
				<th width="170">연락처</th>
				<th width="110">운전면허</th>
				<th width="120">직업</th>
				<th width="170">가입일</th>
				<th width="140">편집</th>

			</tr>
			<%
			for (int i = 0; i < list.size(); i++) {
			    MemberDto dto = list.get(i);
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
			%>
			<tr align="center">
				<td align="center"><%=i + 1%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getHp()%></td>
				<td><%=dto.getDriver()%></td>
				<td><%=dto.getJob()%></td>
				<td><%=sdf.format(dto.getWriteday())%></td>
				<td>
					<button type="button" class="btn btn-outline-info btn-sm"
						onclick="location='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button>
					<button type="button" class="btn btn-outline-danger btn-sm"
						onclick="if(confirm('정말 삭제하시겠습니까?')) location='delete.jsp?num=<%=dto.getNum()%>'">삭제</button>
						<%-- <!-- onclick="<%=funcDel(dto.getNum())%>" --> --%>
				</td>
			</tr>
			<%
			}
			%>


		</table>
	</div>
</body>
</html>