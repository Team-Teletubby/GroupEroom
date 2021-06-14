<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<style>
	@font-face {
    font-family: 'EliceDigitalBaeum_Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/EliceDigitalBaeum_Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
	* {
		font-family: EliceDigitalBaeum_Regular;
	}
</style>
</head>
<body>
	<section id="container">
		<!-- **********************************************************************************************************************************************************
            TOP BAR CONTENT & NOTIFICATIONS
            *********************************************************************************************************************************************************** -->
		<!--header start-->
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right"
					data-original-title="Toggle Navigation"></div>
			</div>
			<!--logo start-->
			<a href="index.do" class="logo"><b>GROUP<span>E</span>ROOM</b></a>
			<!--logo end-->
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" href="login.jsp">Logout</a></li>
				</ul>
			</div>
	
			<div class="flipTimer">
														<div class="hours"></div>
														<div class="minutes"></div>
														<div class="seconds"></div>
													</div>
		</header>
	</section>
</body>
</html>