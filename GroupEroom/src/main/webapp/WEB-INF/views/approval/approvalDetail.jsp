<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문서 상세보기</title>
<link href="resources/css/approvalDetail.css" rel="stylesheet">
 <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sideBar.jsp"></jsp:include>

	<section id="main-content">
		<section class="wrapper site-min-height detail-wrapper">
			<h3>
				<i class="fa fa-angle-right"></i> 문서 상세보기
			</h3>
			<div class="row">
				<div class="col-md-12">
					<div class="content-panel">
						<h4>
							<i class="fa fa-angle-right"></i> 결재번호 ${approval.approvalNo }
						</h4>
						<br>
						<!-- #############소스 적용 중############### -->
						<div class="panel-body">
							<div class="header-title">
								<div class="fl">
									<span>결재문</span>
								</div>
								<div class="fr">
								<c:if test="${approval.approvalFirstId == loginUserId && approval.approvalFirstCheck == 'N'}">
									<c:url var="compleBtn" value="compleBtn.do">
										<c:param name="approvalNo" value="${approval.approvalNo }"></c:param>
										<c:param name="approvalFirstId" value="${approval.approvalFirstId }"></c:param>
										<c:param name="approvalSecondId" value="${approval.approvalSecondId }"></c:param>
										<c:param name="approvalState" value="C"></c:param>
									</c:url>
									<c:url var="compleBtn1" value="compleBtn.do">
										<c:param name="approvalNo" value="${approval.approvalNo }"></c:param>
										<c:param name="approvalState" value="R"></c:param>
									</c:url>
									<button type="button" onclick="location.href='${compleBtn }'" class="btn btn-success">승인</button>
									<button type="button" onclick="location.href='${compleBtn1 }'" class="btn btn-danger">반려</button>
								</c:if>
								
								<c:if test="${approval.approvalFirstCheck == 'Y' && approval.approvalSecondId == loginUserId && approval.approvalSecondCheck == 'N' }">
									<c:url var="compleBtn" value="compleBtn.do">
										<c:param name="approvalNo" value="${approval.approvalNo }"></c:param>
										<c:param name="approvalFirstId" value="${approval.approvalFirstId }"></c:param>
										<c:param name="approvalSecondId" value="${approval.approvalSecondId }"></c:param>
										<c:param name="approvalState" value="C"></c:param>
									</c:url>
									<c:url var="compleBtn1" value="compleBtn.do">
										<c:param name="approvalNo" value="${approval.approvalNo }"></c:param>
										<c:param name="approvalState" value="R"></c:param>
									</c:url>
									<button type="button" onclick="location.href='${compleBtn }'" class="btn btn-success">승인</button>
									<button type="button" onclick="location.href='${compleBtn1 }'" class="btn btn-danger">반려</button>
									</c:if>
								</div>
							</div>
							<p class="header-line"></p>
							<div class="mail-header row">
								<div class="col-md-4">
									<table class="table approvalDetail-table">
										<h4>기안자 정보</h4>
										<tr>
											<th>성명</th>
											<td>${approval.memberName }</td>
										</tr>
										<tr>
											<th>부서</th>
											<td>${approval.memberDept }</td>
										</tr>
										<tr>
											<th>직급</th>
											<td>${approval.memberJob }</td>
										</tr>
									</table>
								</div>
								<div class="col-md-4">
									<table class="table approvalDetail-table">
										<h4>문서 정보</h4>
										<tr>
											<th>문서번호</th>
											<td>${approval.approvalNo }</td>
										</tr>
										<tr>
											<th>문서종류</th>
											<c:if test="${approval.approvalType == 'Cooperation' }">
												<td>협조문</td>
											</c:if>
											<c:if test="${approval.approvalType == 'costs' }">
												<td>교통비지출내역서</td>
											</c:if>
											<c:if test="${approval.approvalType == 'overtime' }">
												<td>연장근무신청서</td>
											</c:if>
										</tr>
										<tr>
											<th>작성일</th>
											<td>${approval.approvalDate }</td>
										</tr>
									</table>
								</div>
								<div class="col-md-4">
									<table class="table approvalDetail-table">
										<h4>결재 정보</h4>
										<tr>
											<th></th>
											<th>중간 결재자</th>
											<th>최종 결재자</th>
										</tr>
										<tr>
											<th>성명</th>
											<td>${approval.approvalFirstName }</td>
											<td>${approval.approvalSecondName }</td>
										</tr>
										<tr>
											<th>부서</th>
											<td>${approval.approvalFirstDept }</td>
											<td>${approval.approvalSecondDept }</td>
										</tr>
										<tr>
											<th>직급</th>
											<td>${approval.approvalFirstJob }</td>
											<td>${approval.approvalSecondJob }</td>
										</tr>
										<tr>
											<th>승인</th>
											<td>${approval.approvalFirstCheck }</td>
											<td>${approval.approvalSecondCheck }</td>
										</tr>
									</table>
								</div>

							</div>
							<div class="mail-sender">
								<div class="row">
									<div class="contents">
										<span>${approval.approvalContents }</span>
									</div>
								</div>
							</div>
							<div>
								<p>
									<span class="file-title"> 
										<i class="fa fa-paperclip"></i> 첨부파일
									</span> 
									<div class="file-contents">
										<c:forEach var="file" items="${approvalFile }">
											<a class="file" href="/resources/approvalFiles/${file.reNameFileName }" download>${file.originalFileName}</a>
										</c:forEach>
									</div>
								</p>
							</div>
							<!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$댓글$$$$$$$$$$$$$$$$$$$$$$$$$$$$ -->
							<!-- <li id="" class="ub-content">
											<div class="cmt-info-clear">
												<a class="profile-image"> <img
													src="resources/approvalFiles/uo-danro.jpg">
												</a>
												<div class="comment-content">
													<div class="profile-info">
														<span class="profile-name">이혜성</span> 
														<span class="comment-time">2021-02-12</span> 
														<span>수정</span> 
														<span>삭제</span>
													</div>
													<p class="text">123dsadsadad123dsa</p>
												</div>
											</div>
										</li> -->
							<!-- 댓글등록 -->
							<div class="comment-wrap">
								<div class="comment-count">
									전체 댓글 <span class="count"></span>개
								</div>
								<div class="comment-box">
									<ul class="cmt-list">

									</ul>
								</div>
							</div>
							<div class="card mb-2">
								<div class="card-body">
									<ul class="list-group list-group-flush">
										<li class="list-group-item">
											<div></div> 
											<c:if test="${(approval.memberId == loginUserId && approval.approvalState == 'N') || (approval.memberId == loginUserId && approval.approvalState == 'N') || (approval.approvalFirstId == loginUserId && approval.approvalState == 'N') || (approval.approvalFirstId == loginUserId && approval.approvalState == 'I') || (approval.approvalSecondId == loginUserId && approval.approvalState == 'N') || (approval.approvalSecondId == loginUserId && approval.approvalState == 'I') }">
											<textarea class="form-control" id="cmtContents"
												rows="3" placeholder="댓글을 입력하세요."></textarea>
											<div align="right" style="margin-top: 2px">
												<button class="btn btn-sm btn-theme03" id="cmtSubmit">등록</button>
											</div>
											</c:if>
										</li>
									</ul>
								</div>
								<div class="bottom-btnbox">
									<div class="fl">
										<button onclick="history.back(-1)" class="btn btn-theme03">목록으로</button>
									</div>
									<div class="fr">
										<c:if test="${approval.memberId == loginUserId.toString() && approval.approvalState == 'N' }">
											<c:url var="deleteBtn" value="approvalDelete.do"> 
												<c:param name="approvalNo" value="${approval.approvalNo }"></c:param>
												<c:param name="approvalState" value="D"></c:param>
											</c:url>
											<button onclick="location.href='${deleteBtn}'"
												class="btn btn-theme04">삭제</button>
										</c:if>
									</div>
								</div>
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
				<!-- You are NOT allowed to delete the credit link to TemplateMag with free
                            version. You can delete the credit link only if you bought the pro version. Buy
                            the pro version with working PHP/AJAX contact form:
                            https://templatemag.com/dashio-bootstrap-admin-template/ Licensing information:
                            https://templatemag.com/license/ -->
				Created with Dashio template by <a href="https://templatemag.com/">TemplateMag</a>
			</div>
			<a href="index.html#" class="go-top"> <i class="fa fa-angle-up"></i>
			</a>
		</div>
	</footer>
	<!--footer end-->
	</section>

	<script>
		$(document).ready(function() {
			getCommentList();
		});

		/* 댓글 등록  */
		$("#cmtSubmit").click(function() {
			const approvalNo = '${approval.approvalNo}'
			const cmtContents = $('#cmtContents').val();

			$.ajax({
				url : 'replyRegister.do',
				type : 'post',
				data : {
					"approvalNo" : approvalNo,
					"cmtContents" : cmtContents
				},
				success : function(success) {
					const cmtContents = $('#cmtContents').val("");
					getCommentList();
				},
				error : function() {
				}
			})
		});

		/* 댓글 리스트  */
		function getCommentList() {
			const approvalNo = '${approval.approvalNo}'

			$.ajax({
				url : "replyList.do",
				type : "post",
				data : {
					"approvalNo" : approvalNo
				},
				dataType : "json",
				success : function(data) {
					const $ul = $(".cmt-list");
					const $li = $("<li class='ub-content'>");
					const $div1 = $("<div class='cmt-info-clear'>");
					const $a = $("<a class='profile-image'>");
					const $img = $("<img src=''>");
					const $div2 = $("<div class='comment-content'>");
					/* 댓글 갯수  */
					const $count = $(".count");
					$count.html(data.length);
					var html = "";
					if (data.length > 0) {
						for ( var i in data) {
							html += "<li class='ub-content'>";
							html += "<div class='cmt-info-clear'>";
							html += "<div class='comment-content'>";
							html += "<input type='hidden' class='cmtNo' name='cmtNo' value='" + data[i].cmtNo + "'/>";
							html += "<div class='profile-info'>";
							html += "<span class='profile-name'>"
							html += data[i].memberName;
							html += "</span>";
							html += "<span class='profile-job'>";
							html += data[i].memberJob;
							html += "</span>";
							html += "<span class='comment-tile'>";
							html += moment(data[i].enrollDate).format('YYYY-MM-DD HH:mm');
							html += "</span>";
							if(${loginUserId } == data[i].memberId) {
								html += "<span class='comment-delete' onclick='deleteComment("+ data[i].approvalNo +','+ data[i].cmtNo +");'>";
								html += "삭제";
								html += "</span>";
							}
							html += "</div>";
							html += "<p class='text'>";
							html += data[i].cmtContents;
							html += "</p>";
							html += "</div>";
							html += "</div>";
							html += "</li>";

							$ul.html(html);
						}
					}else {
						$ul.html("");
					}
				},
				error : function() {
	
				}
			});
		}
		
		/* 댓글 삭제  */
		function deleteComment(approvalNo, cmtNo){
			$.ajax({
				url: 'replyDelete.do',
				type: 'get',
				data: {
					"approvalNo" : approvalNo, 
					"cmtNo" : cmtNo
				},
				success: function(data) {
					getCommentList();
				}
				
			});
		}
		
	</script>
</body>
</html>