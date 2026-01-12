<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <!DOCTYPE html>
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
<%
//프로젝트경로
String root = request.getContextPath();
%>
<body>
	<a href="<%=root%>">메인</a>
	<a href="<%=root%>/index.jsp?main=member/memberForm.jsp">회원가입</a>
	<a href="<%=root%>/index.jsp?main=guest/guestList.jsp">방명록</a>
	<a href="<%=root%>/index.jsp?main=board/boardList.jsp">회원게시판</a>
	<a href="<%=root%>/index.jsp?main=map/loadMap.jsp">오시는길</a>
	<a href="<%=root%>/index.jsp?main=login/loginForm.jsp">로그인</a>
</body>
</html> --%>
<!DOCTYPE html>
<html class="csstransforms no-csstransforms3d csstransitions">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Responsive Drop Down Menu jQuery CSS3 Using Icon Symbol</title>
<%
//프로젝트경로
String root = request.getContextPath();
%>
<link rel="stylesheet" type="text/css"
	href="<%=root%>/menu/css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="<%=root%>/menu/css/menu.css">

<script type="text/javascript" src="<%=root%>/menu/js/jquery.js"></script>
<script type="text/javascript" src="<%=root%>/menu/js/function.js"></script>

</head>
<body>
	<!-- <div
		style="background: #0099cc; font-size: 22px; text-align: center; color: #FFF; font-weight: bold; height: 100px; padding-top: 50px;">Responsive
		Drop Down Menu jQuery CSS3 Using Icon Symbol</div> -->
	<div id="wrap">
		<header>
			<div class="inner relative">
				<a class="logo" href="#"></a>
				<a id="menu-toggle" class="button dark" href="#"><i
					class="icon-reorder"></i></a>
				<nav id="navigation">
					<ul id="main-menu">
						<li class="current-menu-item"><a href="<%=root%>/">Home</a></li>
						<li class="parent"><a href="<%=root%>/index.jsp?main=board/boardList.jsp">게시판</a>
							<ul class="sub-menu">
								<li><a href="<%=root%>/index.jsp?main=member/memberForm.jsp"><i class="icon-wrench"></i>회원가입</a></li>
								<li><a href="<%=root%>/index.jsp?main=board/boardList.jsp"><i class="icon-credit-card"></i>
										회원게시판</a></li>
								<li><a href="<%=root%>/index.jsp?main=guest/guestList.jsp"><i class="icon-gift"></i>회원방명록</a></li>
								<li><a class="parent" href="#"><i class="icon-file-alt"></i>
										스마트게시판</a>
									</li>
							</ul></li>
						<li><a href="<%=root%>/index.jsp?main=login/loginForm.jsp">로그인</a></li>
						<li class="parent"><a href="#">쇼핑몰</a>
							<ul class="sub-menu">
								<li><a href="#">쇼핑몰입고 </a></li>
								<li><a href="#">쇼핑몰목록 </a></li>

							</ul></li>
						<li><a href="<%=root%>/index.jsp?main=map/loadMap.jsp">오시는길</a></li>
					</ul>
				</nav>
				<div class="clear"></div>
			</div>
		</header>
	</div>
</body>
</html>