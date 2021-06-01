<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel=" shortcut icon" href="image/favicon.ico">

<link rel="stylesheet" href="resources/vendor/css/fullcalendar.min.css" />
<link rel="stylesheet" href="resources/vendor/css/bootstrap.min.css">
<link rel="stylesheet" href='resources/vendor/css/select2.min.css' />
<link rel="stylesheet"
	href='resources/vendor/css/bootstrap-datetimepicker.min.css' />

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,500,600">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

<link rel="stylesheet" href="resources/css/roomReservation.css">
</head>
<body>
	<section id="container">
		<jsp:include page="../common/header.jsp"></jsp:include>
		<!--헤더 끝-->
		<!--사이드바 시작-->
		<jsp:include page="../common/sideBar.jsp"></jsp:include>

		<section id="main-content">
			<section class="wrapper site-min-height">
				<div id="wrapper">
					<div id="loading"></div>
					<div id="calendar"></div>
				</div>
					<div class="time-set-wrap">
						<div class="time-set-title">
							<span>예약 가능 시간</span>
						</div>
						<div class="time-set-body">
							<div class="time-set" id="time-09s">
								<input type="hidden" name="bookingStartDate" value="9">
								<a tabindex="-1" href="#">09시</a>
							</div>
							<div class="time-set" id="time-10s">
								<input type="hidden" name="bookingStartDate" value="10">
								<a tabindex="-1" href="#">10시</a>
							</div>
							<div class="time-set" id="time-11s">
								<input type="hidden" name="bookingStartDate" value="11">
								<a tabindex="-1" href="#">11시</a>
							</div>
							<div class="time-set" id="time-12s">
								<input type="hidden" name="bookingStartDate" value="12">
								<a tabindex="-1" href="#">12시</a>
							</div>
							<div class="time-set" id="time-13s">
								<input type="hidden" name="bookingStartDate" value="13">
								<a tabindex="-1" href="#">13시</a>
							</div>
							<div class="time-set" id="time-14s">
								<input type="hidden" name="bookingStartDate" value="14">
								<a tabindex="-1" href="#">14시</a>
							</div>
							<div class="time-set" id="time-15s">
								<input type="hidden" name="bookingStartDate" value="15">
								<a tabindex="-1" href="#">15시</a>
							</div>
							<div class="time-set" id="time-16s">
								<input type="hidden" name="bookingStartDate" value="16">
								<a tabindex="-1" href="#">16시</a>
							</div>
							<div class="time-set" id="time-17s">
								<input type="hidden" name="bookingStartDate" value="17">
								<a tabindex="-1" href="#">17시</a>
							</div>
						</div>
					</div>

					<div class="contents-wrap">
						<div class="contents-body">
							<div>
								<span>회의실 </span> <select id="edit-title" name="roomNo">
									<option>--회의실 선택--</option>
									<option value="101">101호 회의실</option>
									<option value="102">102호 회의실</option>
									<option value="103">103호 회의실</option>
									<option value="201">201호 회의실</option>
									<option value="202">202호 회의실</option>
									<option value="203">203호 회의실</option>
								</select>
								<!-- <input
                        class="inputModal"
                        type="text"
                        name="edit-title"
                        id="edit-title"
                        required="required"
                        placeholder="일정명을 입력해주세요"/> -->
							</div>
							<div class="row">
								<div class="col-xs-4">
									<label class="col-xs-4" for="bookingTitle">
									예약명</label> 
									<input type="text"
										name="bookingTitle" class="" id="bookingTitle"> <label class="col-xs-4"
										for="edit-desc">설명</label>
									<textarea rows="4" cols="50" class="inputModal"
										name="bContents" id="edit-desc"></textarea>
								</div>
							</div>
						</div>
						<div class="modal-footer modalBtnContainer-addEvent">
							<button type="button">취소</button>
							<button type="button" id="save-event">저장</button>
						</div>
						<div class="modal-footer modalBtnContainer-modifyEvent">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">닫기</button>
							<button type="button" class="btn btn-danger" id="deleteEvent">삭제</button>
						</div>
					</div>
				<!-- <script src="resources/vendor/js/jquery.min.js"></script> -->
				<script src="resources/vendor/js/bootstrap.min.js"></script>
				<script src="resources/vendor/js/moment.min.js"></script>
				<script src="resources/vendor/js/fullcalendar.min.js"></script>
				<script src="resources/vendor/js/ko.js"></script>
				<script src="resources/vendor/js/select2.min.js"></script>
				<script src="resources/vendor/js/bootstrap-datetimepicker.min.js"></script>
				<script src="resources/js/roomRegister/main.js"></script>
				<script src="resources/js/roomRegister/addEvent.js"></script>
				<script src="resources/js/roomRegister/editEvent.js"></script>
				<script src="resources/js/roomRegister/etcSetting.js"></script>
				<script src="resources/js/roomRegister/focus.js"></script>
			</section>
		</section>
		<!-- footer -->
		<footer class="site-footer">
			<div class="text-center">
				<p>
					&copy; Copyrights <strong>Dashio</strong>. All Rights Reserved
				</p>
				<div class="credits">
					<!-- You are NOT allowed to delete the credit link to TemplateMag with free
                            version. You can delete the credit link only if you bought the pro version. Buy
                            the pro version with working PHP/AJAX contact form:
                            https://templatemag.com/dashio-bootstrap-admin-template/ Licensing information:
                            https://templatemag.com/license/ -->
					Created with Dashio template by <a href="https://templatemag.com/">TemplateMag</a>
				</div>
				<a href="index.html#" class="go-top"> <i class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer>
	</section>
	<script>
		$('.time-set').click(function() {

			$('.time-set').removeClass('click')
			$(this).addClass('click');

		});
	</script>
</body>
</html>