<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 부트스트랩 css -->
<link href="resources/js/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- 이모티콘 css -->
<link href="resources/js/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<!-- css  -->
<link href="resources/css/style.css" rel="stylesheet">

<!-- jQuery -->
<!-- <script src="resources/js/jquery/jquery.min.js"></script> -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- 부트스트랩 -->
<script src="resources/js/bootstrap/js/bootstrap.min.js"></script>
<!-- 기타 -->
<script class="include" type="text/javascript" src="resources/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="resources/js/jquery.scrollTo.min.js"></script>
<script src="resources/js/common-scripts.js"></script>

</head>
<body>

 <section id="container">
        <aside>
            <div id="sidebar" class="nav-collapse ">
                <!-- sidebar menu start-->
                <ul class="sidebar-menu" id="nav-accordion">
                    <!-- 프로필 이미지 -->
                    <p class="centered"><a href="profile.html"><img src="img/ui-sam.jpg" class="img-circle"
                                width="80"></a></p>
                    <!-- 프로필 이름 -->
                    <h5 class="centered">이혜성 사원</h5>
                    <!-- 홈 메뉴 -->
                    <li class="mt">
                        <a class="active" href="index.html">
                            <i class="fa fa-dashboard"></i>
                            <span>홈</span>
                        </a>
                    </li>
                    <!-- 전자결재 메뉴 -->
                    <li class="sub-menu">
                        <a href="javascript:;">
                            <i class="fa fa-desktop"></i>
                            <span>전자결재</span>
                        </a>
                        <ul class="sub">
                            <li><a href="general.html">전자결재홈</a></li>
                            <li><a href="buttons.html">결재문 작성</a></li>
                            <li><a href="panels.html">진행함</a></li>
                            <li><a href="font_awesome.html">미결함</a></li>
                            <li><a href="font_awesome.html">완료함</a></li>
                            <li><a href="font_awesome.html">반려함</a></li>
                        </ul>
                    </li>
                    <!-- 메일 메뉴 -->
                    <li>
                        <a href="mailViewList.do">
                            <i class="fa fa-envelope"></i>
                            <span>메일 </span>
                            <span class="label label-theme pull-right mail-info">2</span>
                        </a>
                    </li>
                    <!-- 일정관리 메뉴 -->
                    <li>
                        <a href="inbox.html">
                            <i class="fa fa-envelope"></i>
                            <span>일정관리 </span>
                        </a>
                    </li>
                    <!-- 예약 메뉴 -->
                    <li class="sub-menu">
                        <a href="javascript:;">
                            <i class="fa fa-cogs"></i>
                            <span>예약관리</span>
                        </a>
                        <ul class="sub">
                            <li><a href="grids.html">예약관리 홈</a></li>
                            <li><a href="calendar.html">회의실 예약하기</a></li>
                        </ul>
                    </li>
                    <!-- 근태관리 메뉴 -->
                    <li class="sub-menu">
                        <a href="javascript:;">
                            <i class="fa fa-comments-o"></i>
                            <span>근태관리</span>
                        </a>
                        <ul class="sub">
                            <li><a href="lobby.html">근태관리 홈</a></li>
                            <li><a href="chat_room.html">연차 신청</a></li>
                        </ul>
                    </li>
                    <!-- 협업 메뉴 -->
                    <li>
                        <a href="inbox.html">
                            <i class="fa fa-envelope"></i>
                            <span>협업관리 </span>
                        </a>
                    </li>
                    <!-- 게시판 메뉴 -->
                    <li class="sub-menu">
                        <a href="javascript:;">
                            <i class="fa fa-tasks"></i>
                            <span>게시판</span>
                        </a>
                        <ul class="sub">
                            <li><a href="form_component.html">공지사항</a></li>
                            <li><a href="fBoardListView.do">자유게시판</a></li>
                            <li><a href="cBoardListView.do">동호회게시판</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </aside>
    </section>
</body>
</html>