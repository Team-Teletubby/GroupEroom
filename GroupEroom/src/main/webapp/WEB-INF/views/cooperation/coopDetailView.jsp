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

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

 <!-- Font Awesome JS -->
 <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" 
 	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
 <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" 
 	integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>

<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Bootstrap core CSS -->
<link href="resources/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--external css-->
<link href="resources/js/font-awesome/css/font-awesome.css" rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/style-responsive.css" rel="stylesheet">

</head>

<body>
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
						<h3>Cooperation Room : ${ roomNo }</h3>
					</div>
					<div>
						<c:forEach items="${ coopList }" var="coopList">
							<div class="group-rom">
								<div class="first-part odd">${ coopList.memberName }</div>
								<c:if test="${ !empty coopList.renameFilename } != null">
									<i class=" fa fa-paperclip"></i>
								</c:if>
								<div class="second-part" id="OpenBtn" onclick="w3_open()">${ coopList.coContents }</div>
								<div class="third-part">${ coopList.enrollDate }</div>
								
								<!-- 수정,삭제버튼 -->
								<c:if test="${ LoginUser.memberId == coopList.memberId}">
									<c:url var="coModify" value="coopModify.do">
										<c:param name="roomNo" value="${ coopList.roomNo }"></c:param>
										<c:param name="coNo" value="${ coopList.coNo }"></c:param>
										<c:param name="renameFilename" value="${ coopList.renameFilename }"></c:param>
									</c:url>
									<c:url var="coDelete" value="coopDelete.do">
										<c:param name="roomNo" value="${ coopList.roomNo }"></c:param>
										<c:param name="coNo" value="${ coopList.coNo }"></c:param>
										<c:param name="renameFilename" value="${ coopList.renameFilename }"></c:param>
									</c:url>
									<button type="button" class="btn btn-round btn-warning btn-xs" onclick="location.href='${ coModify }'">
										<i class="fa fa-times" id="OpenBtn"></i>
									</button>
									<button type="button" class="btn btn-round btn-danger btn-xs" onclick="location.href='${ coDelete }'">
										<i class="fa fa-times"></i>
									</button>
								</c:if>
							</div>
						</c:forEach>
					</div>
					<!-- 등록화면 -->
					<footer style="position:absolute; z-index:3;">
						<form action="coopRegister.do?roomNo=${ roomNo }" method="post" enctype="multipart/form-data">
							<div class="chat-txt">
								<input type="text" class="form-control" id="coContents" name="coContents" placeholder="내용을 입력하세요" required>
							</div>
							<div class="btn-group hidden-sm hidden-xs">
								<!-- <input type="file" class="btn btn-white" name="uploadFile"> --><i class=" fa fa-paperclip"></i>
							</div>
							<button type="submit" class="btn btn-theme">등록</button>
						</form>
					</footer>
					<!-- 댓글창 -->
					<div class="w3-sidebar w3-bar-block w3-animate-right" style="width:400px;right:0; display:none;" id="mySidebar">
					  <button class="w3-bar-item w3-button w3-large" onclick="w3_close()">Close &times;</button>
					  <aside class="right-side">
			            <div class="invite-row">
			            		<c:forEach items="${ coopList }" var="coopList">
								<div class="group-rom">
									<div class="first-part odd">${ coopList.memberName }</div>
									<c:if test="${ !empty coopList.renameFilename } != null">
										<i class=" fa fa-paperclip"></i>
									</c:if>
									<div class="second-part" id="OpenBtn" onclick="w3_open()">${ coopList.coContents }</div>
									<div class="third-part">${ coopList.enrollDate }</div>
								</div>
							</c:forEach>
			            </div>
			            <ul class="chat-available-user">
			              <li>
			                <a href="chat_room.html">
			                  <img class="img-circle" src="img/friends/fr-02.jpg" width="32">
			                  Paul Brown
			                  <span class="text-muted">1h:02m</span>
			                  </a>
			              </li>
			              <li>
			                <a href="chat_room.html">
			                  <img class="img-circle" src="img/friends/fr-05.jpg" width="32">
			                  David Duncan
			                  <span class="text-muted">1h:08m</span>
			                  </a>
			              </li>
			              <li>
			                <a href="chat_room.html">
			                  <img class="img-circle" src="img/friends/fr-07.jpg" width="32">
			                  Laura Smith
			                  <span class="text-muted">1h:10m</span>
			                  </a>
			              </li>
			              <li>
			                <a href="chat_room.html">
			                  <img class="img-circle" src="img/friends/fr-08.jpg" width="32">
			                  Julia Schultz
			                  <span class="text-muted">3h:00m</span>
			                  </a>
			              </li>
			              <li>
			                <a href="chat_room.html">
			                  <img class="img-circle" src="img/friends/fr-01.jpg" width="32">
			                  Frank Arias
			                  <span class="text-muted">4h:22m</span>
			                  </a>
			              </li>
			            </ul>
			          </aside>
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
	<script class="include" type="text/javascript" src="resources/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="resources/js/jquery.scrollTo.min.js"></script>
	<script src="resources/js/jquery.nicescroll.js" type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="resources/js/common-scripts.js"></script>
	
	<!--script for this page-->
	
	<!-- 댓글 -->
	<script>
		function w3_open() {
		  document.getElementById("mySidebar").style.display = "block";
		  document.getElementById("myOverlay").style.display = "block";
		}
		
		function w3_close() {
		  document.getElementById("mySidebar").style.display = "none";
		  document.getElementById("myOverlay").style.display = "none";
		}
</script>
	
	

</body>
</html>
