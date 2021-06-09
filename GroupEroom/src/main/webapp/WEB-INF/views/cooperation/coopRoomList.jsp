<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page buffer="1000kb"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>협업관리</title>

<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Bootstrap core CSS -->
<link href="resources/js/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!--external css-->
<link href="resources/js/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/style-responsive.css" rel="stylesheet">

</head>

<body>
	<section>
	<!-- Header start-->
	<jsp:include page="../common/header.jsp"></jsp:include>
	<!-- sidebar start-->
	<jsp:include page="../common/sideBar.jsp"></jsp:include>
	<!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper site-min-height">
			<!-- page start-->
			<div class="chat-room mt">
				<aside class="mid-side">
					<div class="chat-room-head">
						<h3>협업관리</h3>
					</div>
					<div class="room-desk">
						<h4 class="pull-left">DEPARTMENT</h4>
						<form action="coopListView.do">
							<c:forEach items="${ coList }" var="coopRoom">
								<div class="room-box">
									<h5 class="text-primary">
										<c:url var="coopDetail" value="coopDetailView.do">
											<c:param name="roomNo" value="${ coopRoom.roomNo }"></c:param>
										</c:url>
											<a href="${ coopDetail }" name="roomName">${ coopRoom.roomName }</a>
									</h5>
									<p></p>
									<p>
										<span class="text-muted">Leader :</span> ${ coopRoom.roomAdmin } 
									</p>
								</div>
							</c:forEach>
						</form>
					</div>
				</aside>
			</div>
			<!-- page end-->
		</section>
		<!-- /wrapper -->
	</section>
	<!-- /MAIN CONTENT -->
	<!--main content end-->
	<!--footer start-->
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
			<a href="inbox.html#" class="go-top"> <i class="fa fa-angle-up"></i>
			</a>
		</div>
	</footer>
	<!--footer end-->
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="resources/js/jquery/jquery.min.js"></script>
	<script src="resources/js/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery.nicescroll.js" type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="resources/js/common-scripts.js"></script>
	<!--script for this page-->
	<script>
		if (window.self == window.top) {
			(function(i, s, o, g, r, a, m) {
				i['GoogleAnalyticsObject'] = r;
				i[r] = i[r] || function() {
					(i[r].q = i[r].q || []).push(arguments)
				}, i[r].l = 1 * new Date();
				a = s.createElement(o), m = s.getElementsByTagName(o)[0];
				a.async = 1;
				a.src = g;
				m.parentNode.insertBefore(a, m)
			})(window, document, 'script',
					'//www.google-analytics.com/analytics.js', 'ga');
			ga('create', 'UA-55234356-6', 'auto');
			ga('send', 'pageview');
		}
	</script>
</body>

</html>
