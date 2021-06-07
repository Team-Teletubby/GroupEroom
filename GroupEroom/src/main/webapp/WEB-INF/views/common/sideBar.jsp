<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap core CSS -->
<link href="resources/js/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- icon css -->

<link href="resources/js/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
	
<!-- Style css  -->
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/timer/flipTimer.css">
<!-- <link rel="stylesheet" href="resources/css/timer/demo.css"> -->

<!-- SummerNote CDN  -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css"
	rel="stylesheet">

<!-- jQuery -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- bootstrap js -->
<script src="resources/js/bootstrap/js/bootstrap.min.js"></script>

<!-- etc... -->
</head>
<body>
	<section id="container">
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu" id="nav-accordion">
					<!-- 프로필 이미지 -->
					<p class="centered">
						<a href="profile.html"><img src="img/ui-sam.jpg"
							class="img-circle" width="80"></a>
					</p>
					<!-- 프로필 이름 -->
					<h5 class="centered">이혜성 사원</h5>
					<!-- 홈 메뉴 -->
					<li class="mt"><a class="active" href="index.html"> <i
							class="fa fa-dashboard"></i> <span>홈</span>
					</a></li>
					<!-- 전자결재 메뉴 -->
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-desktop"></i> <span>전자결재</span>
					</a>
						<ul class="sub">
							<li><a href="general.html">전자결재홈</a></li>
							<li><a href="approvalWriteView.do">결재문 작성</a></li>
							<li><a href="progressBoard.do">진행함</a></li>
							<li><a href="suspenseBoard.do">미결함</a></li>
							<li><a href="completeBoard.do">완료함</a></li>
							<li><a href="rejectBoard.do">반려함</a></li>
						</ul></li>
					<!-- 메일 메뉴 -->
					<li>
						<a href="inboxListView.do"> 
							<i class="fa fa-envelope"></i>
							<span>메일 </span> 
							<!-- <span class="label label-theme pull-right mail-info">2</span> -->
						</a>
					</li>
					<!-- 일정관리 메뉴 -->
					<li class="sub-menu"><a href="javascript:;">
					 <i class="fa fa-calendar"></i> <span>일정관리</span></a>
						<ul class="sub">
							<li><a href="calendarListView.do">나의 일정</a></li>
							<li><a href="todoList.do">할 일</a></li>
						</ul>
					</li>
					<!-- 예약 메뉴 -->
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-clock-o"></i> <span>예약관리</span>
					</a>
						<ul class="sub">
							<li><a href="bkListView.do">예약관리 홈</a></li>
							<li><a href="bkRegisterView.do">회의실 예약하기</a></li>
						</ul></li>
					<!-- 근태관리 메뉴 -->
					<li class="sub-menu"><a href="javascript:;"> 
					<i class="fa fa-suitcase"></i> <span>근태관리</span>
					</a>
						<ul class="sub">
							<li><a href="attendanceList.do">근태관리 홈</a></li>
						</ul>
					</li>
					<!-- 협업 메뉴 -->
					<li><a href="inbox.html"> <i class="fa fa-puzzle-piece"></i> <span>협업관리
						</span>
					</a></li>
					<!-- 게시판 메뉴 -->
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-list-alt"></i> <span>게시판</span>
					</a>
						<ul class="sub">
							<li><a href="noticeListView.do">공지사항</a></li>
							<li><a href="fBoardListView.do">자유게시판</a></li>
							<li><a href="cBoardListView.do">동호회게시판</a></li>
						</ul></li>
							<!-- 인사관리 메뉴 -->
					<c:if test="${sessionScope.LoginUser.memberDept == '인사관리'}">
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-users"></i> <span>인사관리</span>
					</a>
						<ul class="sub">
							<li><a href="memberList.do">사원목록</a></li>
							<li><a href="enrollView.do">사원등록 </a></li>
						</ul>
						</li>
						</c:if>
						<!-- 채팅  -->
					<li>
						<a href="#" onclick="javascript:openWin();"> 
							<i class="fa fa-comments-o"></i>
							<span>메신저 </span> 
						</a>
					</li>
					<!-- 설문조사 -->
					<li>
						<a href="surveyList.do" onclick="javascript:;"> 
							<i class="fa fa-tasks"></i>
							<span>설문조사 </span> 
						</a>
					</li>
				</ul>
			</div>
		</aside>
	</section>
	<script>
	// =============== 시간 ====================
	   	$(document).ready(function(){
			$('.flipTimer').flipTimer({ direction: 'up' });
		});
	
	   	function openWin(){ 
		  	window.open("room.do", "채팅", "width=500, height=517, toolbar=no, menubar=yes, scrollbars=no, resizable=no" ); 
		}
	</script>
	<!-- 스크롤, 사이드바 등 설정  -->
	<script src="resources/js/timer/jquery.flipTimer.js"></script>
	<script class="include" type="text/javascript"
		src="resources/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="resources/js/jquery.scrollTo.min.js"></script>
	<script src="resources/js/jquery.sparkline.js"></script>
	<script src="resources/js/common-scripts.js"></script>
</body>
</html>