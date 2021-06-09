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
<link href="resources/css/mailCompose.css" rel="stylesheet">

<title>메일</title>
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
				<!-- 				<form action="#" class="pull-right mail-src-position">
								  <div class="input-append">
									<input type="text" class="form-control " placeholder="Search Mail">
								  </div>
								</form> -->
							  </h4>
						  </header>
						  <div class="panel-body">
							<div class="compose-mail">
							  <form action="composeMail.do" method="post" enctype="multipart/form-data">
							  <!-- 받는사람(클릭 시 모달창 오픈) -->
								<div class="form-group">
								 <label for="to" class="receiver" name="receiver">To:</label><input type="hidden" name="receiverId" id="receiverId">
								 <input type="text" tabindex="1" id="receiverName" name="receiverName" class="form-control" data-toggle="modal" data-target="#myModal">
								 </div>
							  <!-- 참조자(모달창에서 값 같이 받아옴 -->
								<div class="form-group">
			                      <label for="cc" class="cc">Cc:</label><input type="hidden" name="ccId" id="ccId">
			                      <input type="text" tabindex="2" id="ccName" name="ccName" class="form-control" data-toggle="modal" data-target="#myModal">
			                    </div>
			                  <!-- 제목 -->
								<div class="form-group">
								  <label for="subject" class="mailTitle">제목:</label>
								  <input type="text" tabindex="1" name="mailTitle" class="form-control" required>
								</div>
							  <!-- 내용 -->
								<div class="compose-editor">
									<textarea id="summernote" name="mailContents"></textarea>
									<input type="file" multiple="true" class="form-control" id="formFile" name="uploadFile">
								</div>
								<div class="compose-btn right">
								  <button type="submit" class="btn btn-theme btn-sm"><i class="fa fa-check"></i> 보내기</button>
								  <button type="reset" class="btn btn-sm" onclick="location.href='inboxListView.do'"><i class="fa fa-times"></i> 취소</button>
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

	<!-- Modal -->
	<div class="modal fade bd-example-modal-lg" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true" style="display: none;">
		<!-- 사용자 지정부분 : id명 -->
		<div class="modal-dialog modal-lg">
			<!-- Modal content -->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<!-- Modal Title -->
					<h4 class="modal-title" id="myModalLabel">주소록</h4>
				</div>
				<div class="modal-body">
					<!-- 1. 부서 선택하기 -->
					<div class="department-select-form">
						<table>
							<tr>
								<th>부서 선택</th>
							</tr>
							<tr>
								<td><a href="#"><li value="1" class="DepartmentName">인사관리</li></a></td>
							</tr>
							<tr>
								<td><a href="#"><li value="2" class="DepartmentName">영업</li></a></td>
							</tr>
							<tr>
								<td><a href="#"><li value="3" class="DepartmentName">재무</li></a></td>
							</tr>
							<tr>
								<td><a href="#"><li value="4" class="DepartmentName">IT개발</li></a></td>
							</tr>
						</table>
					</div>
					<table class="departmember-table">
						<tr>
							<td>
								<table align="center" width="400" cellspacing="0" id="rtb">
									<thead>
										<tr class="rtb-tr-1st">
											<th>선택</th>
											<th width="100">부서</th>
											<th width="100">직급</th>
											<th width="100">사원명</th>
											<th width="100">사번</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</td>
							<td>
								
							</td>
						</tr>
						<tr>
						</tr>
					</table>
					<div class="mail-add-form">
						<a href="#">
							<li class="receiver">받는 사람</li>
						</a>
						<a href="#">
							<li class="cc">참조</li>
						</a>
					</div>
					<div class="mail-text-form">
						<textarea class="receiverTextArea"></textarea>
						<textarea class="ccTextArea"></textarea>
					</div>
					<!-- 사용자 지정 부분3 : 텍스트 이미지 -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="button" id="save-btn" class="btn btn-primary save" data-dismiss="modal">선택완료</button>
				</div>
			</div>
		</div>
	</div>


	<!-- js placed at the end of the document so the pages load faster -->
	<script src="resources/js/jquery/jquery.min.js"></script>
	<script src="resources/js/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="resources/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="resources/js/jquery.scrollTo.min.js"></script>
	<script src="resources/js/jquery.nicescroll.js" type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="resources/js/common-scripts.js"></script>
	<!--script for this page-->
	<script type="text/javascript">
	    //wysihtml5 start	
	    $('.wysihtml5').wysihtml5();
	    //wysihtml5 end
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
	<script type="text/javascript" src="/resources/js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="/resources/js/gritter-conf.js"></script>
	
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
	
	<!-- 받는 이 리스트 가져오기 -->
	<script>
	//모달창
	$(document).ready(function() {
		$("li.DepartmentName").each(function() {
			$(this).click(function() {
				const depType = $(this).val();
				console.log(depType);
				/* 부서 클릭 시 해당 부서의 멤버 목록 가져오기 */
				$.ajax({
					url : "deptMember.do",
					type : "post",
					data : { "depType" : depType },
					dataType : "json",
					success : function(data) {
						var tableBody = $("#rtb tbody");
						tableBody.html("");
						var html = "";
						var $tr;
						var $checkbox;
						var $rMemberId;
						var $rMemberName;
						var $rMemberJob;
						var $rMemberDept;
						
						if(data.length > 0) {
							for(var i in data) {
								$tr = $("<tr>");
								$checkBox = $("<td><input type='checkbox' name='member'>");
								$rMemberId = $("<td width='100' align='center' id='memberId'>").text(data[i].memberId);
								$rMemberName = $("<td width='100' align='center' id='memberName'>").text(data[i].memberName);
								$rMemberJob = $("<td width='50' align='center' id='memberJob'>").text(data[i].memberJob);
								$rMemberDept = $("<td width='100' align='center' id='memberDept'>").text(data[i].memberDept);
								
								$tr.append($checkBox);
								$tr.append($rMemberDept);
								$tr.append($rMemberJob);
								$tr.append($rMemberName);
								$tr.append($rMemberId);
								
								tableBody.append($tr);
							}
						}
					},
					error : function() {
						alert("실패");
					}
				});
			});
		});
		
		/* 받는 사람 값을 저장할 객체 */
		const mailMembers = {};
		
		/* 받는사람 클릭 시 */
		$(".receiver").click(function() {
			const rcvTdArr = checked();
			mailMembers.receive = rcvTdArr;
			
			$(".receiverTextArea").html(mailMembers.receive.dept + ", " + mailMembers.receive.job + ", " + mailMembers.receive.name + ", " + mailMembers.receive.id);
		});
		
		/* 참조자 클릭 시 */
		$(".cc").click(function() {
			const ccTdArr = checked();
			mailMembers.cc = ccTdArr;
			
			$(".ccTextArea").html(mailMembers.cc.dept + ", " + mailMembers.cc.job + ", " + mailMembers.cc.name + ", " + mailMembers.cc.id);
		});
		
		/* 선택완료 */
		$(".save"). click(function() {
			
			//각 id에 선택값 넣어주기
			$("#receiverName").val(mailMembers.receive.name);
			$("#receiverId").val(mailMembers.receive.id);
			$("#ccName").val(mailMembers.cc.name);
			$("#ccId").val(mailMembers.cc.id);			
			
			//배열 내부요소 삭제
			mailMembers.pop();
			
			$("#modal").modal('hide');
		});
		
		/* 체크박스 정보 가져오기 */
		function checked(){
			const checked = $("input:checkbox[name='member']:checked");
	      		
	      		// 선택한 checkbox를 감싸고 있는 tr 선택
	      		const tr = checked.parent().parent();
	      		// td의 값들을 넣을 배열
	      		const tdObj = {};
	
	      		// 위에서 찾은 tr내에 있는 모든 td 선택
	      		var td = tr.children();
	      		
	      		tdObj.dept = td.eq(1).text();
	      		tdObj.job = td.eq(2).text();
	      		tdObj.name = td.eq(3).text();
	      		tdObj.id = td.eq(4).text();
	 				
	      		// 체크박스 해제
	      		$("input:checkbox[name='member']").prop("checked",false);
	      		
	      		return tdObj;
	      		
	      };
	      	
	      /* 배열의 특정 요소를 가지고 있는 객체 찾기 */
	      function findObj(element, value) {
	      		if(element.Id === value) {
	      			return true;
	      		}
	      };
	});
	</script>

</body>
</html>