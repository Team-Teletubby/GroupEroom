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
					
					
				<!-- <script src="resources/vendor/js/jquery.min.js"></script> -->
				<script src="resources/vendor/js/bootstrap.min.js"></script>
				<script src="resources/vendor/js/moment.min.js"></script>
				<script src="resources/vendor/js/fullcalendar.min.js"></script>
				<script src="resources/vendor/js/ko.js"></script>
				<script src="resources/vendor/js/select2.min.js"></script>
				<script src="resources/vendor/js/bootstrap-datetimepicker.min.js"></script>
				<script src="resources/js/main.js"></script>
				<script src="resources/js/addEvent.js"></script>
				<script src="resources/js/editEvent.js"></script>
				<script src="resources/js/etcSetting.js"></script>
				<script src="resources/js/focus.js"></script>
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
	
	</script>
</body>
</html>