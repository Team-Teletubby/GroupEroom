<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
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
			<div class="nav notify-row" id="top_menu">
				<!--  notification start -->
				<ul class="nav top-menu">
					<!-- notification dropdown start-->
					<li id="header_notification_bar" class="dropdown"><a
						data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
							<!-- 알림 시작 --> <i class="fa fa-bell-o"></i> <!-- 알림 갯수 --> <span
							class="badge bg-warning">3</span>
					</a>
						<ul class="dropdown-menu extended notification">
							<div class="notify-arrow notify-arrow-yellow"></div>
							<li>
								<p class="yellow">알림</p>
							</li>
							<li>
								<div>
									<a href="index.html#"> <strong>안녕하세요 안녕하세요 안녕하세요
											안녕하세요 안녕하세요</strong>게시물에 댓글이 달렸습니다.
										<div>
											<span class="small italic">4분전</span>
										</div>
									</a>
								</div>
							</li>
							<li>
								<div>
									<a href="index.html#"> <strong>결재해주세요 제발 제발~~</strong>게시물에
										댓글이 달렸습니다.
										<div>
											<span class="small italic">50분전</span>
										</div>
									</a>
								</div>
							</li>
							<li>
								<div>
									<a href="index.html#"> <strong>오늘은 불금입니다~~ 야근해요!</strong>게시물에
										댓글이 달렸습니다.
										<div>
											<span class="small italic">1시간 30분전</span>
										</div>
									</a>
								</div>
							</li>
							<li><a href="index.html#">더보기</a></li>
						</ul>
					</li>
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