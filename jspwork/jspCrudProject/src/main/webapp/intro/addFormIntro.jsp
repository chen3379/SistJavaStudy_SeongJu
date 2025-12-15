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
<script type="text/javascript">
	function goFocus(hp) {
		if (hp.value.length == 4)
			frm.hp3.focus();

	}
</script>
</head>
<body>
	<div style="width: 600px; margin: 100px 150px;">
		<form action="addActionIntro.jsp" method="post" name="frm">
			<table class="table table-bordered">
				<tr>
					<th style="text-align: center;" class="table-secondary">이름</th>
					<td><input type="text" name="name" class="form-control"
						style="width: 120px;" required="required"></td>
				</tr>
				<tr>
					<th style="text-align: center;" class="table-secondary">생년월일</th>
					<td><input type="date" name="birthday" class="form-control"
						style="width: 200px;" required="required" value="2000-01-01"></td>
				</tr>
				<tr>
					<th style="text-align: center;" class="table-secondary">전화번호</th>
					<td class="input-group mb-3"><select size="1" name="hp1"
						class="form-control" style="width: 80px;">
							<option value="02">02</option>
							<option value="010">010</option>
							<option value="017">017</option>
							<option value="032">032</option>
							<option value="019">019</option>
					</select> <b>&nbsp;-&nbsp;</b> <input type="text" name="hp2"
						class="form-control" style="width: 120px;" required="required"
						onkeyup="goFocus(this)"> <b>&nbsp;-&nbsp;</b> <input
						type="text" name="hp3" class="form-control" style="width: 120px;"
						required="required"></td>

				</tr>
				<tr>
					<th style="text-align: center;" class="table-secondary">출신지역</th>
					<td><label><input type="radio" name="hometown"
							value="서울" checked="checked">서울&nbsp;</label> <label><input
							type="radio" name="hometown" value="경기">경기&nbsp;</label> <label><input
							type="radio" name="hometown" value="강원">강원&nbsp;</label> <label><input
							type="radio" name="hometown" value="제주">제주&nbsp;</label> <label><input
							type="radio" name="hometown" value="경상">경상&nbsp;</label> <label><input
							type="radio" name="hometown" value="전라">전라&nbsp;</label></td>

				</tr>

				<tr>
					<th style="text-align: center;" class="table-secondary">취미</th>
					<td><label><input type="checkbox" name="hobby"
							value="영화감상" checked="checked">영화감상&nbsp;</label> <label><input
							type="checkbox" name="hobby" value="등산">등산&nbsp;</label>
						<label><input type="checkbox" name="hobby" value="축구">축구&nbsp;</label>
						<label><input type="checkbox" name="hobby" value="요리">요리&nbsp;</label>
						<label><input type="checkbox" name="hobby" value="게임">게임&nbsp;</label>
						<label><input type="checkbox" name="hobby" value="그림">그림&nbsp;</label>
					</td>

				</tr>
				<tr>
					<th style="text-align: center;" class="table-secondary">MBTI</th>
					<td><select name="mbti" class="form-control">
							<option value="ESTP">ESTP</option>
							<option value="ENFJ">ENFJ</option>
							<option value="ESTJ">ESTJ</option>
							<option value="ISTJ">ISTJ</option>
							<option value="INFP">INFP</option>
							<option value="ISFJ">ISFJ</option>
					</select></td>
				</tr>

				<tr>
					<th style="text-align: center;" class="table-secondary">하고싶은말</th>
					<td><textarea style="width: 400px; height: 80px;"
							name="free" required="required" placeholder="자신의 성향이나 성격등을 자유롭게 말해보아요~~~"></textarea></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><button type="submit" class="btn btn-info"
							style="width: 100px">작성완료</button>
							<button type="button" class="btn btn-info"
							style="width: 100px"onclick="location='introList.jsp'">뒤로가기</button>
							</td>
				</tr>

			</table>
		</form>

	</div>
</body>
</html>