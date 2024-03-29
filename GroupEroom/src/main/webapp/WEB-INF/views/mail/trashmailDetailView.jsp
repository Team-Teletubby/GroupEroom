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
								<a href="mailComposeView.do" class="btn btn-compose" style="color:white"><i class="fa fa-pencil"></i>메일쓰기</a>
								<ul class="nav nav-pills nav-stacked mail-nav">
									<li><a href="inboxListView.do"> <i class="fa fa-inbox"></i>받은메일함</a></li>
									<li><a href="sentListView.do"> <i class="fa fa-envelope-o"></i>보낸메일함</a></li>
									<li><a href="trashListView.do"> <i class="fa fa-trash-o"></i>휴지통</a></li>
								</ul>
							</div>
						</section>
					</div>
					<div class="col-sm-9">
						<section class="panel">
							<header class="panel-heading wht-bg">
								<h4 class="gen-case">메일 상세보기</h4>
							</header>
							<form action="mailDetailView.do" method="post">
								<div class="panel-body ">
									<div class="mail-header row">
										<div class="col-md-8">
											<h4 class="pull-left" name="mailTitle">${mail.mailTitle }</h4>
											<a id=mailNo name="mailNo" hidden>${mail.mailNo }</a>
										</div>
										<div class="col-md-4">
											<div class="compose-btn pull-right">
												<button class="btn btn-sm tooltips"
													data-original-title="Return" data-toggle="tooltip" data-placement="top" onclick="return();">
													<i class="fa fa-reply"></i>
												</button>
												<button class="btn btn-sm tooltips"
													data-original-title="Trash" data-toggle="tooltip" data-placement="top" onclick="delete();">
													<i class="fa fa-trash-o"></i>
												</button>
											</div>
										</div>
									</div>
									<div class="mail-sender">
										<div class="row">
											<div class="col-md-8">
												<div>
													보낸 사람 : <strong name="senderName">${mail.senderName }</strong><br>
													받는 사람 : <strong name="receiverName">${mail.receiverName }</strong>&nbsp;
												</div>
											</div>
											<div class="col-md-4">
												<p class="date" name="sentDate">${mail.sentDate }</p>
											</div>
										</div>
										</div>
										<div class="view-mail" name="mailContents" style="min-height:300px">
											${mail.mailContents }</div>
										<div class="attachment-mail">
											<p>
												<span><i class="fa fa-paperclip"></i> 첨부파일</span> 
											</p>
											<ul>
												<c:if test="${!empty mailFile.originalFilename }">
													<c:forEach items="${ mFileList }" var = "file">
														<li>
															${file.originalFilename}
														</li>
													</c:forEach>
												</c:if>
											</ul>
										</div>
									</div>
							</form>
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
	<!-- 메일함으로 재이동 -->
	<script>
		function return() {
			var chk = confirm("메일을 다시 이동하시겠습니까?");
			var url = 'returnToMailbox.do?mailNo='+${mail.mailNo};
			$.ajax({
				url : url,
				type : 'POST',
				traditional : true,
				data : {
					mailNo : ${mail.mailNo}
				},
				success : function(data) {
					if(data = 1) {
						alert("이동되었습니다.");
						location.replace("mail/trashmailDetailView")
					}
					else {
						alert("이동 실패하였습니다.");
					}
				}
			})
		}
	</script>
	<!-- 완전삭제 -->
	<script>
		function delete() {
			var chk = confirm("메일을 정말 삭제하시겠습니까?");
			if (chk) {
				location.href='deleteMail.do?mailNo='+${mail.mailNo};
			}
		}
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