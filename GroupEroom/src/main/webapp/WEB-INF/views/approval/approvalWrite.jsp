<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>GER</title>
<link href="resources/css/approvalWrite.css" rel="stylesheet">
</head>
<body>
	<section id="container">
		<!-- 헤더 시작 -->
		<jsp:include page="../common/header.jsp"></jsp:include>
		<!--헤더 끝-->
		<!--사이드바 시작-->
		<jsp:include page="../common/sideBar.jsp"></jsp:include>
		<!-- **********************************************************************************************************************************************************
        메인 콘텐츠
        *********************************************************************************************************************************************************** -->
		<!-- 메인 콘텐츠 -->
		<section id="main-content">
			<section class="wrapper">
				<div class="row">
					<div class="col-lg-12 main-chart">
						<div class="border-head"></div>
						<div class="col-md-11 mb">
							<div class="write-Wrap">
								<p>결재 기안하기</p>
								<form>
									<div class="write-form">
										<p>기본 설정</p>
										<div id="Document-type">
											<table id="table">
												<tr>
													<th>문서 종류</th>
													<td class="document-select"><select>
															<option value="">문서 선택</option>
															<option value="Cooperation">협조문</option>
															<option value="">양식2</option>
															<option value="">양식3</option>
													</select></td>
													<th>기안자</th>
													<td>이혜성</td>
												</tr>
											</table>
										</div>
										<span class="approval-line-title">결재선</span>
										<!-- 아래에서 data-toggle과 data-target 속성에서 data-toggle에는 modal 값을 data-target속성에는
                                        모달 창 전체를 감싸는 div의 id 이름을 지정하면 된다. -->
										<button type="button" data-toggle="modal"
											data-target=".bd-example-modal-lg">모달 창 열기</button>

										<table class="table">
											<tr>
												<th>구분</th>
												<th>사번</th>
												<th>이름</th>
												<th>부서</th>
												<th>직급</th>
											</tr>
											<tr>
												<th>결재자1</th>
												<td align="center">
													<input type="text" readOnly id="midApprovalId" name="midApprovalId" >
												</td>
												<td align="center">
													<input type="text" readOnly id="midApprovalName" name="midApprovalName">
												</td>
												<td align="center">
													<input type="text" readOnly id ="midApprovalDept" name="midApprovalDept">
												</td>
												<td align="center">
													<input type="text" readOnly id="midApprovalJob" name="midApprovalJob">
												</td>
											</tr>
											<tr>
												<th>결재자2</th>
												<td align="center">
													<input type="text" readOnly id="finApprovalId" name="finApprovalId">
												</td>
												<td align="center">
													<input type="text" readOnly id="finApprovalName" name="finApprovalName">
												</td>
												<td align="center">
													<input type="text" readOnly id="finApprovalDept" name="finApprovalDept">
												</td>
												<td align="center">
													<input type="text" readOnly id="finApprovalJob" name="finApprovalJob">
												</td>
											</tr>
										</table>
										<span>제목</span> 
										<input type="text" name="approvalTitle">
										<div id="summernote"></div>
										<input type="submit" value="기안 제출하기">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</section>
		</section>
		<!-- footer -->
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
				<a href="index.html#" class="go-top"> <i class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer>
		<!--footer end-->
	</section>
	<!-- Modal -->
	<div class="modal fade bd-example-modal-lg" role="dialog" tabindex="-1"
		aria-labelledby="myLargeModalLabel">
		<!-- 사용자 지정 부분① : id명 -->
		<div class="modal-dialog modal-lg">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- 모달 title -->
					<h4 class="modal-title">모달 창 타이틀</h4>
				</div>
				<div class="modal-body">
					<!-- ======= 부서 목록 ======= -->
					<table class="table">
						<tr>
							<td>
								<ul>
									<span>부서 이름</span>
									<li value="1" class="DepartmentName">인사관리팀</li>
									<li value="2" class="DepartmentName">IT개발팀</li>
									<li value="3" class="DepartmentName">재무팀</li>
								</ul>
							</td>
							<td>
								<table align="center" width="350" border="1" cellspacing="0"
									id="rtb">
									<thead>
										<tr>
											<th>선택</th>
											<th width="100">사번</th>
											<th width="100">사원명</th>
											<th width="50">직급</th>
											<th width="100">부서</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</td>

							<td>
								<ul>
									<li><sapn class="midApproval"> 중간결재자 </sapn></li>
									<li><span class="finApproval"> 최종결재자 </span></li>
								</ul>
							</td>
							<td>
								<div>
									<textarea class="midApprovalTextArea">1</textarea>
								</div>
								</div> <textarea class="finApprovalTextArea">2</textarea>
								</div>
							</td>
						</tr>
						<tr>

						</tr>
					</table>
					<!-- 사용자 지정 부분③ : 텍스트 메시지 -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary save">Save changes</button>

				</div>
			</div>
		</div>
	</div>
	<!-- 썸머노트 CDN -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script>
		// =============== 썸머 노트 ====================
		// 불러오기
		$('#summernote')
				.summernote(
						'code',
						'<h2 style="text-align: center; "><b>업무 협조문</b></h2><h5 style="text-align: center; "><br></h5><p style="text-align: left; margin-left: 50px;">1. 귀 부서의 무궁한 발전을 기원합니다.</p><p style="text-align: left; margin-left: 50px;">2. 오래과 같이 업무 협조를 요청하오니 적극 협조하여 주시기 바랍니다.</p><p style="text-align: left; margin-left: 50px;"><br></p><p style="text-align: center; margin-left: 50px;">- 아&nbsp; &nbsp; 래 -</p><p style="text-align: center; margin-left: 50px;"><br></p><h5 style="text-align: left; margin-left: 50px;"><b>1. 취 지&nbsp;</b></h5><h5 style="text-align: left; margin-left: 50px;"><b><br></b></h5><h5 style="text-align: left; margin-left: 50px;"><b>2. 협조사항&nbsp;</b></h5><h5 style="text-align: left; margin-left: 50px;"><b><br></b></h5><h5 style="text-align: left; margin-left: 50px;"><b>3. 협조 불이행 조치사항</b></h5><h5 style="text-align: left; margin-left: 50px;"><b><br></b></h5><h5 style="text-align: left; margin-left: 50px;"><b>4. 시행일</b></h5><h5 style="text-align: left; margin-left: 50px;"><b><br></b></h5><h5 style="text-align: left; margin-left: 50px;"><b>5. 문의</b></h5><h5 style="text-align: left; margin-left: 50px;"><b><br></b></h5><h5 style="text-align: left; margin-left: 50px;"><b><br></b></h5>');

		// 초기화
		$('#summernote').summernote({
			height : 400, // set editor height
			minHeight : null, // set minimum height of editor
			maxHeight : null, // set maximum height of editor
			focus : true,
			lang : 'ko-KR' // 기본 메뉴언어 US->KR로 변경
		});
		
        $(document).ready(function() {
        	
      
        	$("li.DepartmentName").each(function() {
        		$(this).click(function() {
        			const depType = $(this).val();
        			
        			/* 클릭한 부서 멤버 목록 가져오기 */
        			$.ajax({
        				url : "departmentMember.do",
        				type : "post",
        				data : { "depType" : depType },
        				dataType : "json",
        				success : function(data) {
        						var tableBody = $("#rtb tbody");
        						tableBody.html("");
        						var html = "";
        						var $tr;
        						var $checkBox;
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
        							$tr.append($rMemberId);
        							$tr.append($rMemberName);
        							$tr.append($rMemberJob);
        							$tr.append($rMemberDept);
        							
        							tableBody.append($tr);
        						}
        					}
        				},
        				error : function(){
        					alert("실패..");	
        				}
        			});
        		});
        	});
        	
        	// 중간결재자/최종결재자 값 저장할 객체
        	const approvalMembers = new Array(); 
        	
        	/* 중간결재자 클릭할 경우 */
        	$(".midApproval").click(function() {
				const midTdArr = checked();
        		approvalMembers.push(midTdArr);
        		$(".midApprovalTextArea").html(approvalMembers[0]);
        	});
        	
        	/* 최종결재자 클릭할 경우 */
        	$(".finApproval").click(function() {
        		const finTdArr = checked();
        		approvalMembers.push(finTdArr);
        		$(".finApprovalTextArea").html(approvalMembers[1]);
        	});
        	
        	/* 선택 완료를 클릭할 경우 */
        	$(".save").click(function() {
        		$("#midApprovalId").val(approvalMembers[0][0]);
        		$("#midApprovalName").val(approvalMembers[0][1]);
        		$("#midApprovalDept").val(approvalMembers[0][2]);
        		$("#midApprovalJob").val(approvalMembers[0][3]);
        		
        		$("#finApprovalId").val(approvalMembers[1][0]);
        		$("#finApprovalName").val(approvalMembers[1][1]);
        		$("#finApprovalDept").val(approvalMembers[1][2]);
        		$("#finApprovalJob").val(approvalMembers[1][3]);
        	});
        	
        	/* 선택한 체크 박스의 멤버 정보 가져오는 메소드 */
        	function checked(){
				const checked = $("input:checkbox[name='member']:checked");
        		
        		// 선택한 checkbox를 감싸고 있는 tr 선택
        		const tr = checked.parent().parent();
        		// td의 값들을 넣을 배열
        		const tdArr = new Array();
        		// 문자
        		var str = "";
        		// 위에서 찾은 tr내에 있는 모든 td 선택
        		var td = tr.children();
        		
        		td.each(function(index) {
        			tdArr.push(td.eq(index+1).text());
        		});
        		return tdArr
        	};
        });
        
	</script>
</body>
</html>
