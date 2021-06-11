<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/duotone.css" integrity="sha384-R3QzTxyukP03CMqKFe0ssp5wUvBPEyy9ZspCB+Y01fEjhMwcXixTyeot+S40+AjZ" crossorigin="anonymous"/>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/fontawesome.css" integrity="sha384-eHoocPgXsiuZh+Yy6+7DsKAerLXyJmu2Hadh4QYyt+8v86geixVYwFqUvMU8X90l" crossorigin="anonymous"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) response.setHeader("Cache-Control", "no-cache"); %>
	<section id="container">
		<!-- 헤더 시작 -->
		<jsp:include page="./common/header.jsp"></jsp:include>
		<!-- 헤더 끝 -->
		<!-- 사이드바 시작 -->
		<jsp:include page="./common/sideBar.jsp"></jsp:include>
		<!-- 사이드바 끝  -->
		<!-- **********************************************************************************************************************************************************
        메인 콘텐츠
        *********************************************************************************************************************************************************** -->
		<!-- 메인 콘텐츠 -->
		<section id="main-content">
			<section class="wrapper">
				<div class="row">
					<div class="col-lg-9 main-chart">
						<div class="border-head"></div>
						<div class="row">
							<!-- 내 정보 -->
							<div class="col-md-4 mb">
								<div class="myinfo pn">
									<p class="centered" id="myinfo-head">
										<img src="/resources/memberproFile/${member.renameFileName }" class="img-circle" width="120" height="120">
									</p>
									<p id="myinfo-name">${member.memberName } ${member.memberJob }</p>
									<p id="myinfo-department">${member.memberDept } 부서</p>
									<div class="myinfo-approval">
										<a href="suspenseBoard.do">
											<span class="myinfo-span">결제할 문서</span>
											<span class="badge bg-warning">${approvalTypeCount } </span> 							
										</a>
									</div>
									<div class="myinfo-mail">
										<a href="#">
											<span class="myinfo-span">받은 메일</span> 
											<span class="badge bg-warning">3</span>																	
										</a>
									</div>
								</div>
							</div>
							<!-- 내 정보 끝 -->
							<!-- 공지사항 -->
							<div class="col-md-8 mb">
								<div class="message-p pn">
									<div class="message-header">
										<span>공지사항</span> <span class="more"><a href="noticeListView.do">더보기</a></span>
									</div>
									<div class="row">
										<table class="table table-hover workplace-board">
											<thead>
											</thead>
											<tbody>
												<!-- for문 적어야하는 곳 (6개까지) -->
												<c:forEach var="item" items="${noticeList }" varStatus="num">
												<tr>
													<!-- 데이터 넣는 곳 -->
													<td class="text-center" style="width: 50%">${item.noticeTitle }</td>
													<td class="text-center">관리자</td>
													<td class="text-center">${item.enrollDate }</td>
												</tr>
												</c:forEach>
											<tbody>
										</table>
									</div>
								</div>
							</div>
							<!-- 공지사항 끝 -->
						</div>
						<div class="row mt">
							<!-- 메일 -->
							<div class="col-md-4 col-sm-4 mb">
								<div class="grey-panel pn donut-chart" id="mail-wrap">
									<div class="grey-title">
										<span>메일</span> <span class="more"><a href="inboxListView.do">더보기</a></span>
									</div>
									<div class="service-header">
										<div class="service-header-left">
											<span>전체메일</span>										
										</div>
										<div class="service-header-right">
											<span><a href="mailComposeView.do">메일쓰기</a></span>										
										</div>
									</div>
									<div class="mail-body" id="mail-reception">
										<div class="timeline-wrap">
											<ul class="list-timeline">
												<!-- 데이터 넣는 곳  -->
												<li class="itme-timeline">
													<div class="timeline-info">
														<a href="#" class="info-area">
															<div class="title-box">
																<em class="mail-title">안녕하세요 여러부우우운</em>
															</div>
															<div class="dsc-box">
																<div class="dsc-box-inner">
																	<span class="dsc-time">4시간전</span>
																	<span class="dsc">잡코리아 | 스마트매치</span>
																</div>
															</div>
														</a>
													</div>
												</li>
												<!-- 데이터 넣는 곳 끝  -->
															<!-- 데이터 넣는 곳  -->
												<li class="itme-timeline">
													<div class="timeline-info">
														<a href="#" class="info-area">
															<div class="title-box">
																<em class="mail-title">1안녕하세요 여러부우우운</em>
															</div>
															<div class="dsc-box">
																<div class="dsc-box-inner">
																	<span class="dsc-time">4시간전</span>
																	<span class="dsc">잡코리아 | 스마트매치</span>
																</div>
															</div>
														</a>
													</div>
												</li>
												<!-- 데이터 넣는 곳 끝  -->
															<!-- 데이터 넣는 곳  -->
												<li class="itme-timeline">
													<div class="timeline-info">
														<a href="#" class="info-area">
															<div class="title-box">
																<em class="mail-title">안녕하세요 여러부우우운</em>
															</div>
															<div class="dsc-box">
																<div class="dsc-box-inner">
																	<span class="dsc-time">4시간전</span>
																	<span class="dsc">잡코리아 | 스마트매치</span>
																</div>
															</div>
														</a>
													</div>
												</li>
												<!-- 데이터 넣는 곳 끝  -->
															<!-- 데이터 넣는 곳  -->
												<li class="itme-timeline">
													<div class="timeline-info">
														<a href="#" class="info-area">
															<div class="title-box">
																<em class="mail-title">안녕하세요 여러부우우운</em>
															</div>
															<div class="dsc-box">
																<div class="dsc-box-inner">
																	<span class="dsc-time">4시간전</span>
																	<span class="dsc">잡코리아 | 스마트매치</span>
																</div>
															</div>
														</a>
													</div>
												</li>
												<!-- 데이터 넣는 곳 끝  -->
											</ul>
										</div>
									</div>
								</div>
							</div>
							<!-- 메일 끝-->
							<!-- 결재 -->
							<div class="col-md-8 mb">
								<div class="message-p pn">
									<div class="message-header">
										<span>전자결재</span> <span class="more"><a href="">더보기</a></span>
									</div>
									<div class="row">
										<ul class="approval-menu ul-menu">
											<!-- id값 넣어줘야 함  -->
											<li>진행함</li>
											<li>미결함</li>
											<li>완료함</li>
											<li>반려함</li>
										</ul>
										<!-- 진행함 -->
										<table class="table table-hover workplace-board">
											<thead>
											</thead>
											<tbody>
												<tr>
													<!-- 데이터 넣는 곳 -->
													<td class="text-center" style="width: 50%">${item.noticeTitle }</td>
													<td class="text-center">관리자</td>
													<td class="text-center">${item.enrollDate }</td>
												</tr>
											<tbody>
										</table>
										<!-- 미결함 -->
										<!-- 완료함 -->
										<!-- 반려함 -->
									</div>
								</div>
								<!-- 공지사항 끝 -->
							</div>
						</div>
						<div class="row">
							<!-- 날씨 -->
							<div class="col-md-4 mb">
								<div class="weather pn">
									<i class="fa fa-cloud fa-4x"></i>
									<h2>11º C</h2>
									<h4>서울 특별시</h4>
								</div>
							</div>
							<!-- 날씨 끝 -->
							<!-- 사내 게시판 -->
							<div class="col-md-8 mb">
								<div class="message-p pn">
									<div class="message-header">
										<span>자유 게시판</span> <span class="more"><a href="">더보기</a></span>
									</div>
									<div class="row">
										<table class="table table-hover workplace-board">
											<thead>
											</thead>
											<tbody>
												<!-- for문 적어야하는 곳 (6개까지) -->
												<tr>
													<!-- 데이터 넣는 곳 -->
													<td class="text-center" style="width: 50%">안녕하세요</td>
													<td class="text-center">김아무개 사원</td>
													<td class="text-center">2021.05.10 11:46</td>
												</tr>
												<tr>
													<!-- 데이터 넣는 곳 -->
													<td class="text-center" style="width: 50%">안녕하세요</td>
													<td class="text-center">김아무개 사원</td>
													<td class="text-center">2021.05.10 11:46</td>
												</tr>
												<tr>
													<!-- 데이터 넣는 곳 -->
													<td class="text-center" style="width: 50%">안녕하세요</td>
													<td class="text-center">김아무개 사원</td>
													<td class="text-center">2021.05.10 11:46</td>
												</tr>
												<tr>
													<!-- 데이터 넣는 곳 -->
													<td class="text-center" style="width: 50%">안녕하세요</td>
													<td class="text-center">김아무개 사원</td>
													<td class="text-center">2021.05.10 11:46</td>
												</tr>
												<tr>
													<!-- 데이터 넣는 곳 -->
													<td class="text-center" style="width: 50%">안녕하세요</td>
													<td class="text-center">김아무개 사원</td>
													<td class="text-center">2021.05.10 11:46</td>
												</tr>
												<tr>
													<!-- 데이터 넣는 곳 -->
													<td class="text-center" style="width: 50%">안녕하세요</td>
													<td class="text-center">김아무개 사원</td>
													<td class="text-center">2021.05.10 11:46</td>
												</tr>
											<tbody>
										</table>
									</div>
								</div>
							</div>
							<!-- 사내 게시판 끝 -->
						</div>
						<div class="row"></div>
						<div class="row"></div>
					</div>
					<!-- **********************************************************************************************************************************************************
              사이드 콘텐츠
              *********************************************************************************************************************************************************** -->
					<!-- 집무 현황 -->
					<div class="col-lg-3 ds">
						<h4 class="centered mt">집무 현황</h4>
						<!-- 이 부분이 콘텐츠 하나임 -->
						<c:forEach items="${memberExecutives }" var="executives" >
							<c:if test="${executives.memberJob eq '대표' }">
							<input type="hidden" id="memberId1" value=${executives.memberId }>
						<div class="desc">
							<div class="thumb">
								<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
							</div>
							<div class="details">
								<p>
									<!-- 시간 -->
									<!-- <muted>10분전</muted> -->
									<span class="details-name">${executives.memberName } ${executives.memberJob }</span><span class="state">부재중</span>
									<i class="fa fa-refresh" aria-hidden="true"></i> <br />
								</p>
								<ul class="details-menu">
									<li><input type="radio" id="reportable1"
										name="employee-status1" value="reportable"> <label
										for="reportable1">보고가능</label></li>
									<li><input type="radio" id="conference1"
										name="employee-status1" value="conference"> <label
										for="conference1">회의중</label></li>
									<li><input type="radio" id="absence1"
										name="employee-status1" value="absence"> <label
										for=absence1"">부재중</label></li>
								</ul>
							</div>
						</div>
						</c:if>
						<c:if test="${executives.memberJob eq '부서장' }">
						<input type="hidden" id="memberId2" value=${executives.memberId }>
						<div class="desc">
							<div class="thumb">
								<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
							</div>
							<div class="details">
								<p>
									<!-- 시간 -->
									<!-- <muted>10분전</muted> -->
									<span class="details-name">${executives.memberName } ${executives.memberJob }</span> <span class="state">부재중</span>
									<i class="fa fa-refresh" aria-hidden="true"></i> <br />
								</p>
								<ul class="details-menu">
									<li><input type="radio" id="reportable2"
										name="employee-status2" value="reportable"> <label
										for="reportable2">보고가능</label></li>
									<li><input type="radio" id="conference2"
										name="employee-status2" value="conference"> <label
										for="conference2">회의중</label></li>
									<li><input type="radio" id="absence2"
										name="employee-status2" value="absence"> <label
										for=absence2"">부재중</label></li>
								</ul>
							</div>
						</div>
						</c:if>
						</c:forEach>
						<!-- 집무현황 끝 -->
						<!-- 일정 -->
						<h4 class="centered mt">일정</h4>
						<!-- First Member -->
						<div class="desc">
							<div class="thumb">
								<img class="img-circle" src="img/ui-divya.jpg" width="35px"
									height="35px" align="">
							</div>
							<div class="details">
								<p>
									<a href="#">DIVYA MANIAN</a><br />
									<muted>Available</muted>
								</p>
							</div>
						</div>
						<!-- Second Member -->
						<div class="desc">
							<div class="thumb">
								<img class="img-circle" src="img/ui-sherman.jpg" width="35px"
									height="35px" align="">
							</div>
							<div class="details">
								<p>
									<a href="#">DJ SHERMAN</a><br />
									<muted>I am Busy</muted>
								</p>
							</div>
						</div>
						<!-- Third Member -->
						<div class="desc">
							<div class="thumb">
								<img class="img-circle" src="img/ui-danro.jpg" width="35px"
									height="35px" align="">
							</div>
							<div class="details">
								<p>
									<a href="#">DAN ROGERS</a><br />
									<muted>Available</muted>
								</p>
							</div>
						</div>
						<!-- Fourth Member -->
						<div class="desc">
							<div class="thumb">
								<img class="img-circle" src="img/ui-zac.jpg" width="35px"
									height="35px" align="">
							</div>
							<div class="details">
								<p>
									<a href="#">Zac Sniders</a><br />
									<muted>Available</muted>
								</p>
							</div>
						</div>
						<!-- CALENDAR-->
						<div id="calendar" class="mb">
							<div class="panel green-panel no-margin">
								<div class="panel-body">
									<div id="date-popover" class="popover top"
										style="cursor: pointer; disadding: block; margin-left: 33%; margin-top: -50px; width: 175px;">
										<div class="arrow"></div>
										<h3 class="popover-title" style="disadding: none;"></h3>
										<div id="date-popover-content" class="popover-content"></div>
									</div>
									<div id="my-calendar"></div>
								</div>
							</div>
						</div>
						<!-- / calendar -->
					</div>
					<!-- /col-lg-3 -->
				</div>
				<!-- /row -->
			</section>
		</section>
		<!-- footer -->
		<footer class="site-footer">
			<div class="text-center">
				<p>
					&copy; Copyrights <strong>Dashio</strong>. All Rights Reserved
				</p>
				<div class="credits">
					<!--
            You are NOT allowed to delete the credit link to TemplateMag with free version.
            You can delete the credit link only if you bought the pro version.
            Buy the pro version with working PHP/AJAX contact form: https://templatemag.com/dashio-bootstrap-admin-template/
            Licensing information: https://templatemag.com/license/
          -->
					Created with Dashio template by <a href="https://templatemag.com/">TemplateMag</a>
				</div>
				<a href="index.html#" class="go-top"> <i class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer>
		<!--footer end-->
	</section>
	<script>
		$('document').ready(function() {
			showStatus();
		
		});
		
		// 첫번째 input창에 대해서
		$('input[name=employee-status1]').change(function() {
			sessionId = ${member.memberId };
			memberId1 =	$('#memberId1').val();
			
			if(sessionId == memberId1) {
				// ajax로 상태값 변경
				$.ajax({
					url: 'changeCeoStatus.do',
					type: 'post',
					data: {
						"memberId" : memberId1,
						"status" : $('input[name=employee-status1]:checked').val()
					},
					dataType: 'json',
					success: function() {
					}
				});
			}
		});
		
		$('input[name=employee-status2]').change(function() {
			sessionId = ${member.memberId };
			memberId2 = $('#memberId2').val();
			
			if(sessionId == memberId2) {
				// ajax로 상태값 변경
				$.ajax({
					url: 'changeCeoStatus.do',
					type: 'post',
					data: {
						"memberId" : memberId2,
						"status" : $('input[name=employee-status2]:checked').val()
					},
					dataType: 'json',
					success: function() {
					}
					
				});
			}
		});
		
		function showStatus() {
			$.ajax({
				url: "showStatus.do",
				type: 'post',
				data: {
					"memberDept" : '${member.memberDept}'
				},
				dataType: 'json',
				success: function(data) {
					console.log(data)
					if(data[0].status == 'reportable') {
						$('#reportable1').prop("checked", true);
					}else if(data[0].status == 'conference') {
						$('#conference1').prop("checked", true);
					}else if(data[0].status == 'absence') {
						$('#absence1').prop("checked", true);
					}
					
					if(data[1].status == 'reportable') {
						$('#reportable2').prop("checked", true);
					}else if(data[1].status == 'conference') {
						$('#conference2').prop("checked", true);
					}else if(data[1].status == 'absence') {
						$('#absence2').prop("checked", true);
					}
					
				}
			});
			
		}
		
	</script>
	
</body>
</html>