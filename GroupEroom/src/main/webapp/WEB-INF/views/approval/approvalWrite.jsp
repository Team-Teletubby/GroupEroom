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
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" href="resources/css/timer/flipTimer.css">
<link rel="stylesheet" href="resources/css/timer/demo.css">
</head>
<body onload="getTime()">
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
					<div class="col-lg-11 main-chart" id="main-chart"
						style="margin-left: 70px">
						<div class="border-head"></div>
						<div class="col-md-11 mb">
							<div class="write-Wrap">
								<p>※ 결재 기안하기</p>
								<form action="approvalRegister.do" method="post"
									enctype="multipart/form-data">
									<div class="write-form">
										<p>기본 설정</p>
										<div id="document-type">
											<table class="table1">
												<tr class="tr-1st">
													<th class="css-top-line">문서 종류</th>
													<td class="document-select css-top-line">
														<select id="approvalType" name="approvalType">
															<option value="">문서 선택</option>
															<optgroup label="기안문서">
																<option value="Cooperation">협조문</option>
															</optgroup>
															<optgroup label="신청서">
																<option value="overtime">연장근무신청서</option>
																<option value="costs">교통비지출결의서</option>
															</optgroup>
														</select>
													</td>
												</tr>
												<tr class="tr-1st">
													<th class="css-bottom-line">기안자</th>
													<td class="css-bottom-line">${loginUser.memberName }/${loginUser.memberJob }/${loginUser.memberDept }</td>
												</tr>
											</table>
										</div>
										<div id="document-approval-line">
											<div id="approval-line-title">
												<span>결재선</span>
												<!-- 아래에서 data-toggle과 data-target 속성에서 data-toggle에는 modal 값을 data-target속성에는
                                        	모달 창 전체를 감싸는 div의 id 이름을 지정하면 된다. -->
												<a type="button" data-toggle="modal"
													data-target=".bd-example-modal-lg"> <i
													class="xi-plus-circle-o xi-2x"></i>
												</a>
											</div>
											<table class="table1">
												<tr class="tr-1st tr-2st">
													<th class="css-top-line">구분</th>
													<th class="css-top-line">사번</th>
													<th class="css-top-line">성명</th>
													<th class="css-top-line">직급</th>
													<th class="css-top-line">부서</th>
												</tr>
												<tr class="tr-1st" id="tr-2st">
													<th>중간 결재자</th>
													<td align="center"><input type="number"
														class="input-box" id="midApprovalId"
														name="approvalFirstId" readOnly></td>
													<td align="center"><input type="text"
														class="input-box" id="midApprovalName"
														name="midApprovalName" readOnly></td>
													<td align="center"><input type="text"
														class="input-box" id="midApprovalJob"
														name="midApprovalJob" readOnly></td>
													<td align="center"><input type="text"
														class="input-box" id="midApprovalDept"
														name="midApprovalDept" readOnly></td>
												</tr>
												<tr class="tr-1st" id="tr-2st">
													<th class="css-bottom-line">최종 결재자</th>
													<td align="center" class="css-bottom-line"><input
														type="number" class="input-box" id="finApprovalId"
														name="approvalSecondId" readOnly></td>
													<td align="center" class="css-bottom-line"><input
														type="text" class="input-box" id="finApprovalName"
														name="finApprovalName" readOnly></td>
													<td align="center" class="css-bottom-line"><input
														type="text" class="input-box" id="finApprovalJob"
														name="finApprovalJob" readOnly></td>
													<td align="center" class="css-bottom-line"><input
														type="text" class="input-box" id="finApprovalDept"
														name="finApprovalDept" readOnly></td>
												</tr>
											</table>
										</div>
										<div id="summerNote-title">
											<div>
												<span>제목</span>
											</div>
											<div id="title-input-box">
												<input type="text" name="approvalTitle">
											</div>
										</div>
										<textarea id="summernote" name="approvalContents"></textarea>
										 <div class="form-group files">
                							<label>파일첨부 </label>
											<input type="file" id="file-upload" class="file-upload-input" name="uploadFile" multiple="multiple" />
										</div> 
										<div id="submit-input-form">
										<button type="submit" class="submit-btn" id="submit">작성완료</button>
										<!-- 	<input type="submit" id="submit-input" value="기안 제출하기">						 -->				
										</div>
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
					<h4 class="modal-title">조직도</h4>
				</div>
				<div class="modal-body">
					<!-- ======= 부서 목록 ======= -->
					<div class="department-select-form">
						<table>
							<tr>
								<th>부서 목록</th>
							</tr>
							<tr>
								<td>
									<a href="#">
										<li value="1" class="DepartmentName">인사관리부서</li>									
									</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="#">								
										<li value="2" class="DepartmentName">IT개발부서</li>	
									</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="#">
										<li value="3" class="DepartmentName">재무부서</li>									
									</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="#">
										<li value="4" class="DepartmentName">영업부서</li>
									</a>
								</td>
							</tr>
						</table>
					</div>
					<table class="departmember-table">
						<tr>
							<td>
								<table align="center" width="400" cellspacing="0"
									id="rtb">
									<thead>
										<tr class="rtb-tr-1st">
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
								
							</td>
						</tr>
						<tr>
						</tr>
					</table>
					<div class="approval-add-form">
						<a href="#">
							<li class="midApproval">중간결재자</li>
						</a>
						<a href="#">
							<li class="finApproval">최종결재자</li>
						</a>
					</div>
					<div class="approval-text-form">
						<textarea class="midApprovalTextArea"></textarea>
						<textarea class="finApprovalTextArea"></textarea>
					</div>
					<!-- 사용자 지정 부분③ : 텍스트 메시지 -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="button" id="save-btn" class="btn btn-primary save"
						data-dismiss="modal">확인</button>

				</div>
			</div>
		</div>
	</div>
	<!-- 썸머노트 CDN -->
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script>
		// =============== 썸머 노트 ====================
		// 불러오기
		$('#summernote')
				.summernote(
						'code');

		// 초기화
		$('#summernote').summernote({
			height : 400, // set editor height
			minHeight : null, // set minimum height of editor
			maxHeight : null, // set maximum height of editor
			focus : true,
			lang : 'ko-KR' // 기본 메뉴언어 US->KR로 변경
		});
		
        $(document).ready(function() {
        	$('.sub-menu').eq(0).children('a').addClass("active");
        	$('.sub-menu').eq(0).children('ul').css("display", "block");
        	// =============== 문서 종류 ====================
        	$("#approvalType").change(function() {
        		// 협조문
        		if($(this).val() == "Cooperation") {
        			$('#summernote')
    				.summernote(
    						'code','<h2 style="text-align: center; "><b>업무 협조문</b></h2><h5 style="text-align: center; "><br></h5><p style="text-align: left; margin-left: 50px;">1. 귀 부서의 무궁한 발전을 기원합니다.</p><p style="text-align: left; margin-left: 50px;">2. 오래과 같이 업무 협조를 요청하오니 적극 협조하여 주시기 바랍니다.</p><p style="text-align: left; margin-left: 50px;"><br></p><p style="text-align: center; margin-left: 50px;">- 아&nbsp; &nbsp; 래 -</p><p style="text-align: center; margin-left: 50px;"><br></p><h5 style="text-align: left; margin-left: 50px;"><b>1. 취 지&nbsp;</b></h5><h5 style="text-align: left; margin-left: 50px;"><b><br></b></h5><h5 style="text-align: left; margin-left: 50px;"><b>2. 협조사항&nbsp;</b></h5><h5 style="text-align: left; margin-left: 50px;"><b><br></b></h5><h5 style="text-align: left; margin-left: 50px;"><b>3. 협조 불이행 조치사항</b></h5><h5 style="text-align: left; margin-left: 50px;"><b><br></b></h5><h5 style="text-align: left; margin-left: 50px;"><b>4. 시행일</b></h5><h5 style="text-align: left; margin-left: 50px;"><b><br></b></h5><h5 style="text-align: lef;margin-left: 50px;"><b>5. 문의</b></h5><h5 style="text-align: left; margin-left: 50px;"><b><br></b></h5><h5 style="text-align: left; margin-left: 50px;"><b><br></b></h5>');
        		}else if($(this).val() == "overtime") {
        			$('#summernote')
        			.summernote(
        					'code','<h2 style="text-align: center; "><b>연장근무 신청서</b></h2><h2 style="text-align: center; "><b><br></b></h2><h2 style="text-align: center; "><b><br></b></h2><h2 style="text-align: center; "></h2><h2 style="text-align: center; "><table class="table table-bordered" style="text-align: left; background-color: rgb(255, 255, 255); font-size: 13px;"><tbody><tr><td style="text-align: center;"><b>신청부서(팀)</b></td><td style="text-align: center;">부서(팀)</td><td style="text-align: center;"><b>연장근무신청일</b></td><td style="text-align: center;">2021년 00월 00일 (요일)</td></tr><tr><td style="text-align: center;"><b>신청자</b></td><td style="text-align: center;"><br></td><td style="text-align: center;"><b>인원</b></td><td style="text-align: center;">0명</td></tr></tbody></table></h2><ul><li style="text-align: left;"><b><br></b></li></ul><h4><ul><li style="text-align: left;"><b><span style="font-family: &quot;Arial Black&quot;;">근무자 명단</span></b></li></ul></h4><table class="table table-bordered"><tbody><tr><td style="text-align: center;"><b>성 명</b></td><td style="text-align: center;"><b>구분</b></td><td style="text-align: center;"><b>근무일자</b></td><td style="text-align: center;"><b>근무시간</b></td><td style="text-align: center;"><b>사유</b></td><td style="text-align: center;"><b>근무장소</b></td></tr><tr><td><br></td><td><br></td><td><br></td><td style="text-align: center;">18:00 ~ 00:00</td><td><br></td><td><br></td></tr><tr><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td></tr><tr><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td></tr><tr><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td></tr></tbody></table><ul><li style="text-align: left;"><b><br></b></li><li style="text-align: left;"><b><br></b></li><li style="text-align: left;"><b><br></b></li><li style="text-align: left;"><b><br></b></li><li style="text-align: left;"><b><br></b></li><li style="text-align: center;"><b>위와 같이 연장근무를 신청함.</b></li></ul>');
        			
        		}else if($(this).val() == "costs") {
        			$('#summernote')
        			.summernote(
        					'code','<h2 style="text-align: center; "><b>교통비청구서</b></h2><h2 style="text-align: center; "><b><br></b></h2><h2 style="text-align: center; "><br></h2><table class="table table-bordered"><tbody><tr><td style="text-align: center;"><b>일자</b></td><td style="text-align: center;"><b>시간</b></td><td style="text-align: center;"><b>사용자</b></td><td style="text-align: center;"><b>출발지</b></td><td style="text-align: center;"><b>목적지</b></td><td style="text-align: center;"><b>거리(km)</b></td><td style="text-align: center;"><b>용무</b></td><td style="text-align: center;"><b>금액</b></td><td style="text-align: center;"><b>교통편</b></td><td style="text-align: center;"><b>증빙유무</b></td></tr><tr><td style="text-align: center;">2021-06-04(금)</td><td style="text-align: center;">08시 00분</td><td style="text-align: center;">000</td><td style="text-align: center;">서울</td><td style="text-align: center;">부산</td><td style="text-align: center;">400</td><td style="text-align: center;">출장</td><td style="text-align: center;">200,000</td><td style="text-align: center;">KTX</td><td style="text-align: center;">O</td></tr><tr><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td></tr><tr><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td></tr><tr><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td></tr><tr><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td><td><br></td></tr></tbody></table><br><table class="table table-bordered"><tbody><tr><td style="text-align: center;"><b>총 금액</b></td><td>0원</td></tr></tbody></table><span style="color: rgb(32, 33, 36); font-family: &quot;Apple SD Gothic Neo&quot;, arial, sans-serif; font-size: 16px;"><div style="text-align: center;">※ 유류대 계산 기준 : 주행거리(km)&nbsp;<span style="text-align: center;">÷ 연비(km/L)&nbsp;</span><span style="color: rgb(77, 81, 86); font-size: 14px;">×</span><span style="text-align: center;">&nbsp;(L당 연료비/보통 휘발유)&nbsp;</span><span style="text-align: center; color: rgb(77, 81, 86); font-size: 14px;">× 150% (10원 미만 절사)</span></div></span><p style="text-align: center;"><br><br></p><p style="text-align: center;"><br><br><b>위와 같이 교통비를 지출하였음으로 상기금액을 청구함.</b></p><p style="text-align: center;"><br></p>');
        		}
        	});
			// =============== 시간 ====================
        	$('.flipTimer').flipTimer({ direction: 'up' });
      
			// =============== 결재선  ===============
        	$("li.DepartmentName").each(function() {
        		$(this).click(function() {
        			const depType = $(this).val();
        			console.log(depType);
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
        	const approvalMembers = {};
        	
        	/* 중간결재자 클릭할 경우 */
        	$(".midApproval").click(function() {
				const midTdArr = checked();
        		approvalMembers.mid = midTdArr;
        		
        		$(".midApprovalTextArea").html(approvalMembers.mid.id+", "+approvalMembers.mid.name+", "+approvalMembers.mid.dept+", "+approvalMembers.mid.job);
        	});
        	
        	/* 최종결재자 클릭할 경우 */
        	$(".finApproval").click(function() {
        		const finTdArr = checked();
        		approvalMembers.fin = finTdArr;
        		
        		$(".finApprovalTextArea").html(approvalMembers.fin.id+", "+approvalMembers.fin.name+", "+approvalMembers.fin.dept+", "+approvalMembers.fin.job);
        	});
        	
        	/* 선택 완료를 클릭할 경우 */
        	$(".save").click(function() {
        		
        		$("#midApprovalId").val(approvalMembers.mid.id);
        		$("#midApprovalName").val(approvalMembers.mid.name);
        		$("#midApprovalDept").val(approvalMembers.mid.dept);
        		$("#midApprovalJob").val(approvalMembers.mid.job);
        		
        		$("#finApprovalId").val(approvalMembers.fin.id);
        		$("#finApprovalName").val(approvalMembers.fin.name);
        		$("#finApprovalDept").val(approvalMembers.fin.dept);
        		$("#finApprovalJob").val(approvalMembers.fin.job);
        		
        		// 배열 내부 요소 삭제
        		approvalMembers.pop();
        		approvalMembers.pop();
        		
        		$("#model").modal('hide');
        	});
        	
        	/* 선택한 체크 박스의 멤버 정보 가져오는 메소드 */
        	function checked(){
				const checked = $("input:checkbox[name='member']:checked");
        		
        		// 선택한 checkbox를 감싸고 있는 tr 선택
        		const tr = checked.parent().parent();
        		// td의 값들을 넣을 배열
        		const tdObj = {};

        		// 위에서 찾은 tr내에 있는 모든 td 선택
        		var td = tr.children();
        		
        		tdObj.id = td.eq(1).text();
        		tdObj.name = td.eq(2).text();
        		tdObj.job = td.eq(3).text();
        		tdObj.dept = td.eq(4).text();
   				
        		// 체크박스 해제
        		$("input:checkbox[name='member']").prop("checked",false);
        		
        		return tdObj;
        		
        	};
        	
        	/* 배열의 특정 요소를 가지고 있는 객체 찾기 */
        	function findObj(element, value) {
        		if(element.Id === value) {
        			return true;
        		}
        	}
        });
	</script>
</body>
</html>
