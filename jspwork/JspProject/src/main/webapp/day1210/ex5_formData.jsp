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
</head>
<body>
	<form action="ex5_action.jsp">
		<table class="table table-bordered" style="width: 550px;">
			<tr>
				<th class="table-primary">사원명</th>
				<td colspan="4"><input type="text" name="s_name"
					style="width: 100px"></td>
			</tr>
			<tr>
				<th class="table-primary">해외근무여부</th>
				<td colspan="4"><input type="checkbox" name="cbarea">가능</td>
			</tr>
			<tr>
				<th class="table-primary">입사일자</th>
				<td colspan="4"><input type="date" name="ipsaday"
					style="width: 100px"></td>
			</tr>
			<tr>
				<th class="table-primary">가장좋았던 점심메뉴(택1)</th>
				<td><input type="radio" value="중식" name="menu" checked="checked">중식&nbsp;
					<input type="radio" value="한식" name="menu">한식&nbsp; <input
					type="radio" value="양식" name="menu">양식&nbsp; <input
					type="radio" value="일식" name="menu">일식&nbsp;</td>
			</tr>
			<tr>
				<th class="table-primary">가능언어</th>
				<td><input type="checkbox" value="영어" name="lang">영어&nbsp;
					<input type="checkbox" value="프랑스어" name="lang">프랑스어&nbsp;
					<input type="checkbox" value="중국어" name="lang">중국어&nbsp; <input
					type="checkbox" value="일본어" name="lang">일본어&nbsp;</td>
			</tr>
			<tr>
				<th class="table-primary">받고싶은 명절선물</th>
				<td><select name="gift">
						<option value="../image/logoImg/acc01.png">시계</option>
						<option value="../image/logoImg/acc03.png">향수</option>
						<option value="../image/logoImg/icon03.png">게임기</option>
						<option value="../image/jquery_img/money.png">현금</option>
				</select></td>
			</tr>
			<tr>
				<th class="table-primary">배경색선택</th>
				<td><input type="color" name="bgColor" value="#ffcccc"></td>
			</tr>

			<tr>

				<td colspan="2" align="center"><button type="submit"
						class="btn btn-primary" style="width: 140px;">사원투표전송</button></td>
			</tr>


		</table>

	</form>

</body>
</html>