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
<link href="resources/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--external css-->
<link href="resources/js/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
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
								<a href="mailComposeView.do" class="btn btn-compose"><i
									class="fa fa-pencil"></i>메일쓰기</a>
								<ul class="nav nav-pills nav-stacked mail-nav">
									<li><a href="inboxListView.do"> <i class="fa fa-inbox"></i>Inbox</a></li>
									<li><a href="sentListView.do"> <i class="fa fa-envelope-o"></i>Send Mail </a></li>
									<li class="active"><a href="trashListView.do"> <i class="fa fa-trash-o"></i>Trash
									</a></li>
								</ul>
							</div>
						</section>
					</div>
					<div class="col-sm-9">
						<section class="panel">
							<header class="panel-heading wht-bg">
								<h4 class="gen-case">
									Inbox
									<!-- <form action="#" class="pull-right mail-src-position">
										<div class="input-append">
											<input type="text" class="form-control "
												placeholder="Search Mail">
										</div>
									</form> -->
								</h4>
							</header>
							<form action="trashListView.do" method="GET">
								<div class="panel-body minimal">
									<div class="mail-option">
										<!-- 리스트 상단버튼 -->
										<div class="btn-group">
											<a data-original-title="Delete" data-placement="top"
												data-toggle="dropdown" class="btn mini tooltips" id="chkDelete" onclick="deleteValue();">
												 <i class="fa fa-trash-o"></i>
											</a>
										</div>
										<!-- ################# 페이징 ################# -->
										<ul class="unstyled inbox-pagination">
											<li><span>${pi.currentPage } / ${pi.maxPage }</span></li>
											<!-- 이전 -->
											<c:url var="before" value="trashListView.do">
												<c:param name="page" value="${pi.currentPage - 1 }"></c:param>
											</c:url>
											<c:if test="${pi.currentPage <= 1 }">
												<li><a class="np-btn"><i
														class="fa fa-angle-left  pagination-left"></i></a></li>
											</c:if>
											<c:if test="${pi.currentPage > 1 }">
												<li><a class="np-btn" href="${before }"><i
														class="fa fa-angle-left  pagination-left"></i></a></li>
											</c:if>
											<!-- 다음 -->
											<c:url var="after" value="trashListView.do">
												<c:param name="page" value="${pi.currentPage + 1 }"></c:param>
											</c:url>
											<c:if test="${pi.currentPage >= pi.maxPage }">
												<li><a class="np-btn"><i
														class="fa fa-angle-right pagination-right"></i></a></li>
											</c:if>
											<c:if test="${pi.currentPage < pi.maxPage }">
												<li><a class="np-btn" href="${after }"><i
														class="fa fa-angle-right pagination-right"></i></a></li>
											</c:if>
										</ul>
										<!-- ################# 본문 ################# -->
										<div class="table-inbox-wrap ">
											<table class="table table-inbox table-hover">
												<tbody>
													<c:forEach items="${ mailList }" var="mail">
														<tr class="">
															<td class="inbox-small-cells">
																<input type="checkbox" class="mail-checkbox" name="deleteYn" value="${mail.mailNo}">
															</td>
															<td class="view-message" name="mailNo" hidden>${mail.mailNo}</td>
															<c:if test="${mail.readCount >= 1}">
																<td class="view-message" name="readCount"><i class="fa fa-envelope-open"></i>
															</c:if>
															<c:if test="${mail.readCount <= 0}">
																<td class="view-message" name="readCount"><i class="fa fa-envelope"></i></td>
															</c:if>
															<td class="view-message" name="senderName">${mail.senderName}</td>
															<td class="view-message" name="mailTilte">
																<c:url var="mailDetail" value="mailDetailView.do">
																	<c:param name="mailNo" value="${mail.mailNo }"></c:param>
																</c:url> <a href="${mailDetail }">${mail.mailTitle}</a>
															</td>
															<c:if test="${not empty trashlist.note_orgfilename}">
																<td class="view-message  inbox-small-cells"><i class="fa fa-paperclip"></i></td>
															</c:if>
															<c:if test="${empty trashlist.note_orgfilename}">
																<td class="view-message  inbox-small-cells"></td>
															</c:if>
															<td class="view-message  inbox-small-cells"><i class="fa fa-paperclip"></i></td>
															<td class="view-message  text-right">${mail.sentDate}</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
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
				<a href="inbox.html#" class="go-top"> <i class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer>
		<!--footer end-->
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="resources/js/jquery/jquery.min.js"></script>
	<script src="resources/js/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="resources/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="resources/js/jquery.scrollTo.min.js"></script>
	<script src="resources/js/jquery.nicescroll.js" type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="resources/js/common-scripts.js"></script>
	<!--script for this page-->
	
	<!-- 체크박스로 삭제하기 -->
	<script>
		function deleteValue() {
			var cnt = $("input[name='deleteYn']:checked").length;
			var arr = new Array();
			$("input[name='deleteYn']:checked").each(function() {
				arr.push($(this).attr('value'));
			});
			if(cnt == 0) {
				alert("선택된 메일이 없습니다.");
			}
			else{
				$.ajax = {
						type: "POST",
						url: "deleteSelectedMail.do",
						data: "mailNo=" + arr + "&CNT=" + cnt,
						dataType: "json",
						success: function(jdata){
							if(jdata != 1) {
								alert("삭제 오류");
							}
							else {
								alert("삭제 성공");
							}
						},
						error:function(){alert("서버통신 오류")};
				};
			}
		}
	</script>



</body>

</html>
