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
<title>메일</title>

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
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sideBar.jsp"></jsp:include>
	<section id="container">
		<!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<!-- page start-->
				<div class="row mt">
					<div class="col-sm-3">
						<section class="panel">
							<div class="panel-body">
								<a href="ComposeMailView.do" class="btn btn-compose"><i
									class="fa fa-pencil"></i>메일쓰기</a>
								<ul class="nav nav-pills nav-stacked mail-nav">
									<li class="active"><a href="inboxListView.do"> <i
											class="fa fa-inbox"></i>Inbox
									</a></li>
									<li><a href="sentListView.do"> <i
											class="fa fa-envelope-o"></i>Send Mail
									</a></li>
									<li><a href="trashListView.do"> <i
											class="fa fa-trash-o"></i>Trash
									</a></li>
								</ul>
							</div>
						</section>
					</div>
					<div class="col-sm-9">
						<section class="panel">
						  <header class="panel-heading wht-bg">
							<h4 class="gen-case">
								Compose Mail
								<form action="#" class="pull-right mail-src-position">
								  <div class="input-append">
									<input type="text" class="form-control " placeholder="Search Mail">
								  </div>
								</form>
							  </h4>
						  </header>
						  <div class="panel-body">
							<div class="compose-btn pull-right">
							  <button type="submit" class="btn btn-theme btn-sm"><i class="fa fa-check"></i> Send</button>
							  <button type="reset" class="btn btn-sm"><i class="fa fa-times"></i> 취소 </button>
							</div>
							<div class="compose-mail">
							  <form role="form-horizontal" action="composeMail.do" method="post">
								<div class="form-group">
								  <label for="to" class="receiver" name="receiver" required>To:</label>
								  <input type="text" tabindex="1" name="receiverId" class="form-control">
								  <div class="compose-options">
									<a onclick="$(this).hide(); $('#cc').parent().removeClass('hidden'); $('#cc').focus();" href="javascript:;" style="display: none;">Cc</a>
								  </div>
								</div>
								<div class="form-group">
								  <label for="cc" name="cc">Cc:</label>
								  <input type="text" tabindex="2" name="ccId" class="form-control">
								</div>
								<div class="form-group">
								  <label for="subject" class="mailTitle" required>메일제목:</label>
								  <input type="text" tabindex="1" name="mailTitle" class="form-control">
								</div>
								<div class="compose-editor">
									<textarea id="summernote" name="mailContents"></textarea>
									<input type="file" class="default">
								</div>
								<div class="compose-btn">
								  <button type="submit" class="btn btn-theme btn-sm"><i class="fa fa-check"></i> Send</button>
								  <button type="reset" class="btn btn-sm"><i class="fa fa-times"></i> Discard</button>
								</div>
							  </form>
							</div>
						  </div>
						</section>
					  </div>
				</div>
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
				<a href="mailDetailView.do#" class="go-top"> <i
					class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer>
		<!--footer end-->
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="lib/jquery/jquery.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="lib/jquery.dcjqaccordion.2.7.js"></script>
	<script src="lib/jquery.scrollTo.min.js"></script>
	<script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="lib/common-scripts.js"></script>
	<!--script for this page-->
	
	<!-- summerNote -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script>
		// =============== 썸머 노트 ====================
		$('#summernote').summernote({
			height : 400, // set editor height
			minHeight : null, // set minimum height of editor
			maxHeight : null, // set maximum height of editor
			focus : true,
			lang : 'ko-KR' // 기본 메뉴언어 US->KR로 변경
		});
	</script>


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