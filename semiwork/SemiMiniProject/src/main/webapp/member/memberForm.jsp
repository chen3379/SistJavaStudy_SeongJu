<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<style>
.container {
	max-width: 600px;
	margin-top: 30px;
}

.msg {
	font-size: 13px;
	margin-top: 5px;
}

.ok {
	color: green;
}

.fail {
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<h3 class="mb-4">
			<i class="bi bi-person-plus-fill"></i> 회원가입
		</h3>

		<form action="memberAdd.jsp" method="post"
			onsubmit="return checkSubmit()">

			<div class="mb-3">
				<label class="form-label">아이디</label>
				<div class="input-group">
					<input type="text" name="id" id="id" class="form-control"
						placeholder="아이디 입력" required>
					<button type="button" id="btnIdCheck" class="btn btn-secondary">중복확인</button>
				</div>
				<div id="idResult" class="msg"></div>
			</div>

			<div class="mb-3">
				<label class="form-label">비밀번호</label> <input type="password"
					name="pass" id="pass" class="form-control" placeholder="비밀번호"
					required>
			</div>

			<div class="mb-3">
				<label class="form-label">비밀번호 확인</label> <input type="password"
					id="pass2" class="form-control" placeholder="비밀번호 재입력" required>
				<div id="passResult" class="msg"></div>
			</div>

			<div class="mb-3">
				<label class="form-label">이름</label> <input type="text" name="name"
					class="form-control" required>
			</div>

			<div class="mb-3">
				<label class="form-label">핸드폰</label> <input type="text" name="hp"
					class="form-control" placeholder="010-0000-0000">
			</div>

			<div class="mb-3">
				<label class="form-label">이메일</label>
				<div class="input-group">
					<input type="text" id="email1" class="form-control"
						placeholder="이메일 앞부분"> <span class="input-group-text">@</span>
					<input type="text" id="email2" class="form-control"
						placeholder="직접입력"> <select id="emailSel"
						class="form-select">
						<option value="" selected disabled>선택하세요</option>
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="daum.net">daum.net</option>
						<option value="nate.com">nate.com</option>
						<option value="direct">직접입력</option>
					</select>
				</div>
				<input type="hidden" name="email" id="email">
			</div>

			<div class="mb-3">
				<label class="form-label">주소</label> <input type="text" name="addr"
					class="form-control">
			</div>

			<div class="d-grid gap-2">
				<button type="submit" class="btn btn-primary btn-lg">가입하기</button>
			</div>
		</form>
	</div>

	<script type="text/javascript">
		// 1. 아이디 중복확인 (AJAX)
		$("#btnIdCheck").click(
				function() {
					let id = $("#id").val();

					if (id == "") {
						alert("아이디를 입력해주세요.");
						return;
					}

					$.ajax({
						type : "get",
						url : "member/idCheck.jsp", // 실제 DB 확인할 파일
						data : {
							"id" : id
						},
						dataType : "json",
						success : function(res) {
							// res.count가 1이면 중복, 0이면 사용 가능
							if (res.count == 1) {
								$("#idResult").text("이미 사용중인 아이디입니다.")
										.removeClass("ok").addClass("fail");
								$("#id").val("").focus(); // 초기화
							} else {
								$("#idResult").text("사용 가능한 아이디입니다.")
										.removeClass("fail").addClass("ok");
							}
						}
					});
				});

		// 2. 비밀번호 일치 확인 (키 입력할 때마다 체크)
		$("#pass2").keyup(
				function() {
					let p1 = $("#pass").val();
					let p2 = $(this).val();

					if (p1 == p2) {
						$("#passResult").text("비밀번호가 일치합니다.").removeClass(
								"fail").addClass("ok");
					} else {
						$("#passResult").text("비밀번호가 일치하지 않습니다.").removeClass(
								"ok").addClass("fail");
					}
				});

		// 3. 이메일 도메인 선택 처리
		$("#emailSel").change(function() {
			let val = $(this).val();

			if (val == 'direct') {
				$("#email2").val("").focus(); // 직접 입력하도록 비우기
				$("#email2").attr("readonly", false); // 쓰기 가능
			} else {
				$("#email2").val(val); // 선택한 도메인 입력
				$("#email2").attr("readonly", true); // 수정 불가
			}
		});

		// 4. 폼 제출 전(submit) 최종 데이터 조합 및 유효성 검사
		function checkSubmit() {
			// 이메일 합치기 (email1 @ email2) -> hidden input에 넣기
			let e1 = $("#email1").val();
			let e2 = $("#email2").val();

			if (e1.length > 0 && e2.length > 0) {
				$("#email").val(e1 + "@" + e2);
			}

			// 아이디 중복확인 결과 체크 (선택사항: class로 체크 가능)
			// 비밀번호 불일치시 전송 막기 등 추가 가능

			return true; // true면 action으로 넘어감
		}
	</script>
</body>
</html>