<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="mysql_myteam.TeamDao"%>
<%@page import="mysql_myteam.TeamDto"%>
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
<%
TeamDao dao=new TeamDao();
List<TeamDto> list= dao.selectTeam();
%>
<body>
<div style="width: 700px; margin: 50px 70px; ">
<button type="button" class="btn btn-success" onclick="location='addForm.jsp'"><i class="bi bi-pencil-square"></i>팀가입</button>
<br><br>
<table class="table table-bordered">
			<caption align="top">
				<b>팀 회원 조회</b>
			</caption>
			<tr class="table-primary" align="center">
				<th width="60">번호</th>
				<th width="80">이름</th>
				<th width="170">주소</th>
				<th width="110">결혼</th>
				<th width="170">가입일</th>
				<th width="140">편집</th>

			</tr>
			<%
			for (int i = 0; i < list.size(); i++) {
			    TeamDto dto = list.get(i);
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
			%>
			<tr align="center">
				<td align="center"><%=i + 1%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getAddr()%></td>
				<td><%=dto.getMarry()%></td>
				<td><%=sdf.format(dto.getGaipday())%></td>
				<td>
					<button type="button" class="btn btn-outline-info btn-sm"
						onclick="location='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button>
					<button type="button" class="btn btn-outline-danger btn-sm"
						onclick="if(confirm('정말 삭제하시겠습니까?')) location='deleteTeam.jsp?num=<%=dto.getNum()%>'">삭제</button>
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