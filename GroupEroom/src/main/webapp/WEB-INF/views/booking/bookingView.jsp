<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/vendor/css/fullcalendar.min.css" />
<link rel="stylesheet" href="resources/vendor/css/bootstrap.min.css">
<link rel="stylesheet" href='resources/vendor/css/select2.min.css' />
<link rel="stylesheet"
	href='resources/vendor/css/bootstrap-datetimepicker.min.css' />

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,500,600">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

<link rel="stylesheet" href="resources/css/bookingView.css">
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
					<div id="calendar" class="calendar-form"></div>
				</div>

				<!-- 일정 추가 MODAL -->
				<div class="modal fade" tabindex="-1" role="dialog" id="eventModal">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title"></h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-xs-12">
										<label class="col-xs-4" for="edit-title">일정명</label> <input
											class="inputModal" type="text" name="edit-title"
											id="edit-title" required="required" />
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<label class="col-xs-4" for="edit-start">시작</label> <input
											class="inputModal" type="text" name="edit-start"
											id="edit-start" />
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<label class="col-xs-4" for="edit-end">끝</label> <input
											class="inputModal" type="text" name="edit-end" id="edit-end" />
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<label class="col-xs-4" for="edit-type">회의실</label> <input
											class="inputModal" type="text" name="edit-type"
											id="edit-type">
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<label class="col-xs-4" for="edit-desc">설명</label>
										<textarea rows="4" cols="50" class="inputModal"
											name="edit-desc" id="edit-desc"></textarea>
									</div>
								</div>
							</div>
							<div class="modal-footer modalBtnContainer-addEvent">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소</button>
								<button type="button" class="btn btn-primary" id="save-event">저장</button>
							</div>
							<div class="modal-footer modalBtnContainer-modifyEvent">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">닫기</button>
								<button type="button" class="btn btn-danger" id="deleteEvent">삭제</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
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
	<!-- <script src="resources/vendor/js/jquery.min.js"></script> -->
	<script src="resources/vendor/js/bootstrap.min.js"></script>
	<script src="resources/vendor/js/moment.min.js"></script>
	<script src="resources/vendor/js/fullcalendar.min.js"></script>
	<script src="resources/vendor/js/ko.js"></script>
	<script src="resources/vendor/js/select2.min.js"></script>
	<script src="resources/vendor/js/bootstrap-datetimepicker.min.js"></script>
	<script src="resources/js/bookingView/main.js"></script>
	<script src="resources/js/bookingView/addEvent.js"></script>
	<script src="resources/js/bookingView/editEvent.js"></script>
	<script src="resources/js/bookingView/etcSetting.js"></script>
	<script src="resources/js/bookingView/focus.js"></script>
</body>
</html>