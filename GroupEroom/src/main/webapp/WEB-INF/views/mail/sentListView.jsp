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
								<a href="mailComposeView.do" class="btn btn-compose" style="color:white"><i class="fa fa-pencil"></i>메일쓰기</a>
								<ul class="nav nav-pills nav-stacked mail-nav">
									<li><a href="inboxListView.do"> <i class="fa fa-inbox"></i>받은메일함</a></li>
									<li class="active"><a href="sentListView.do"> <i class="fa fa-envelope-o"></i>보낸메일함</a></li>
									<li><a href="trashListView.do"> <i class="fa fa-trash-o"></i>휴지통</a></li>
								</ul>
							</div>
						</section>
					</div>
					<div class="col-sm-9">
						<section class="panel">
							<header class="panel-heading wht-bg">
								<h4 class="gen-case">보낸메일함</h4>
							</header>
							<form action="sentListView.do" method="GET">
								<div class="panel-body minimal">
									<div class="mail-option">
										<div class="chk-all">
											<input type="checkbox" id="reportChkBox" name="checkAll">
										</div>
										<div class="btn-group">
											<a data-original-title="Delete" data-placement="top" data-toggle="dropdown" href="#" class="btn mini tooltips">
												<i class="fa fa-trash-o"></i>
											</a>
										</div>
										<!-- ################# 페이징 ################# -->
										<ul class="unstyled inbox-pagination">
											<li><span>${pi.currentPage } / ${pi.maxPage + 1 }</span></li>
											<!-- 이전 -->
											<c:url var="before" value="sentListView.do">
												<c:param name="page" value="${pi.currentPage - 1 }"></c:param>
											</c:url>
											<c:if test="${pi.currentPage <= 1 }">
												<li><a class="np-btn"><i class="fa fa-angle-left  pagination-left"></i></a></li>
											</c:if>
											<c:if test="${pi.currentPage > 1 }">
												<li><a class="np-btn" href="${before }"><i class="fa fa-angle-left  pagination-left"></i></a></li>
											</c:if>
											<!-- 다음 -->
											<c:url var="after" value="sentListView.do">
												<c:param name="page" value="${pi.currentPage + 1 }"></c:param>
											</c:url>
											<c:if test="${pi.currentPage >= pi.maxPage }">
												<li><a class="np-btn"><i class="fa fa-angle-right pagination-right"></i></a></li>
											</c:if>
											<c:if test="${pi.currentPage < pi.maxPage }">
												<li><a class="np-btn" href="${after }"><i class="fa fa-angle-right pagination-right"></i></a></li>
											</c:if>
										</ul>
										<!-- ################# 본문 ################# -->
										<div class="table-inbox-wrap ">
											<table class="table table-inbox table-hover">
												<tbody>
													<c:if test="${empty mailList }">
														<tr>
															<td class="view-message"><a>메일이 없습니다.</a></td>
														</tr>
													</c:if>
													<c:if test="${!empty mailList }">
														<c:forEach items="${ mailList }" var="mail">
															<tr class="">
																<td class="inbox-small-cells"><input type="checkbox" class="mail-checkbox" id="${ mail.mailNo }" name="chkBoxRow" value="${ mail.mailNo }"></td>
																<td class="view-message" name="mailNo" hidden>${mail.mailNo}</td>
																<c:if test="${mail.readCount >= 1}">
																	<td class="view-message" name="readCount"><i class="fa fa-envelope-open"></i>
																</c:if>
																<c:if test="${mail.readCount <= 0}">
																	<td class="view-message" name="readCount"><i class="fa fa-envelope"></i></td>
																</c:if>
																<td class="view-message" name="receiverName">${mail.receiverName}</td>
																<td class="view-message" name="mailTilte">
																	<c:url var="mailDetail" value="mailDetailView.do">
																		<c:param name="mailNo" value="${mail.mailNo }"></c:param>
																	</c:url> <a href="${mailDetail }">${mail.mailTitle}</a>
																</td>
																<td class="view-message  text-right">${mail.sentDate}</td>
															</tr>
														</c:forEach>
													</c:if>
												</tbody>
											</table>
										</div>
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
	<script class="include" type="text/javascript" src="resources/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="resources/js/jquery.scrollTo.min.js"></script>
	<script src="resources/js/jquery.nicescroll.js" type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="resources/js/common-scripts.js"></script>
	<!--script for this page-->
	<script>
		$(function() {
			var chkObj = document.getElementsByName("chkBoxRow");
			var rowCnt = chkObj.length;
			
			$("input[name='checkAll']").click(function() {
				var chk_listArr = $("input[name='chkBoxRow']");
				for (var i=0 ; i<chk_listArr.length; i++) {
					chk_listArr[i].checked = this.checked;
				}
			});
			$("input[name='chkBoxRow']").click(function() {
				if ($("input[name='chkBoxRow']:checked").length == rowCnt) {
					$("input[name='checkAll']")[0].checked = true;
				} else{
					$("input[name='checkAll']")[0].checked = false;
				}
			});
		});
		function moveToTrash() {
			var url = "moveToTrashChk.do";
			var valueArr = new Array();
			var list = $("input[name='chkBoxRow']");
			for(var i=0 ; i < list.length; i++) {
				if(list[i].checked) {
					valueArr.push(list[i].value);
				}
			}
			if (valueArr.length == 0) {
				alert("선택된 메일이 없습니다.");
			}
			else {
				var chk = confirm("정말 이동하시겠습니까?");
				$.ajax({
					url : url,
					type : 'POST',
					traditional : true,
					data : {
						valueArr : valueArr
					},
					success : function(data) {
						if(data = 1) {
							alert("이동되었습니다.");
							location.replace("mail/inboxListView")
						}
						else {
							alert("삭제 실패하였습니다.");
						}
					}
				})
			}
		}
	</script>
</body>

</html>
