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
              <div class="second-part">${ coopList.coContents }</div>
              <div class="third-part">${ coopList.enrollDate }</div>
              <c:url var="coDelete" value="coopDelete.do	">
              	<c:param name="roomNo" value="${ coopList.roomNo }"></c:param>
              	<c:param name="coNo" value="${ coopList.coNo }"></c:param>
				<c:param name="renameFilename" value="${ coopList.renameFilename }"></c:param>
              </c:url>
              <button type="button" class="btn btn-round btn-warning btn-xs"
              			onclick="location.href='#'"><i class="fa fa-times"></i></button>
              <button type="button" class="btn btn-round btn-danger btn-xs"
              			onclick="location.href='${ coDelete }'"><i class="fa fa-times"></i></button>
            </div>
            </c:forEach>
			</div>
            <!-- 등록화면 -->
            <footer>
	            <form action="coopRegister.do?roomNo=${ roomNo }" method="post" enctype="multipart/form-data">
	              <div class="chat-txt">
	                <input type="text" class="form-control" id="coContents" name="coContents">
	              </div>
	              <div class="btn-group hidden-sm hidden-xs">
	                <input type="file" class="btn btn-white" name="uploadFile"><i class=" fa fa-paperclip"></i>
	              </div>
	              <button type="submit" class="btn btn-theme">등록</button>
	            </form>
            </footer>
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
	

</body>
</html>
