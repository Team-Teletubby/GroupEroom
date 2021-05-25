<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/style2.css" rel="stylesheet">

<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sideBar.jsp"></jsp:include>

	<section id="main-content">
		<section class="wrapper">
			<h3>
				<i class="fa fa-angle-right"></i> 자유게시판
			</h3>
			<div class="row">
				<div class="col-md-12">
					<div class="content-panel">
						<h4>
							<i class="fa fa-angle-right"></i> ${ fBoard.fBoardNo }번 글 상세보기
						</h4>
						<br>
						<div class="panel-body">
							<div class="mail-header row">
								<div class="col-md-8">
									<p name="fBullet">${fBoard.fBullet }</p>
									<h4 class="pull-left" name="fBoardTitle">${fBoard.fBoardTitle }</h4>
								</div>
							</div>
							<div class="mail-sender">
								<div class="row">
									<div class="col-md-8">
										<span>작성자</span> <strong name="fWriter">${fBoard.fWriter }</strong>
									</div>
									<div class="col-md-8">
										<span>작성일자</span> <strong name="enrollDate">${fBoard.enrollDate }</strong>&nbsp;&nbsp;&nbsp;|&nbsp;
										<span>조회수</span> <strong name="hits">${fBoard.hits }</strong>
										<span hidden>글번호</span> <strong name="fBoardNo" hidden>${fBoard.fBoardNo }</strong>
									</div>
								</div>
							</div>
							<div>
								<div name="fBoardContents" height="500">${ fBoard.fBoardContents }
								</div>
							</div>
							<div class="attachment-mail">
								<p>
									<span><i class="fa fa-paperclip"></i> 첨부파일 </span> <a href="#">Download all attachments</a>
								</p>
								<ul>
										<<%-- c:forEach item="${fileList }" var="fBoardFile">
											<c:param name="fBoardNo" value="${fBoard.fBoardNo}"></c:param>
											<ul>${fBoardFile.originalFilename }</ul>
										</c:forEach> --%>
								</ul>
							</div>
							<!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$댓글$$$$$$$$$$$$$$$$$$$$$$$$$$$$ -->
							<div
								style="padding: 10px; border: 1px solid lightgrey; font-size: 15px">

								<table style="width: 100%" id="cmttb">
									<thead>
										<tr>
							<!-- 댓글 갯수 및 조회 -->
											<td colspan="2"><b id="cmtCount"></b></td>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
							<br>
							<!-- 댓글등록 -->
							<div class="card mb-2">
								<div class="card-header bg-light">
									<i class="fa fa-comment fa"></i> REPLY
								</div>
								<div class="card-body">
									<ul class="list-group list-group-flush">
										<li class="list-group-item"><textarea
												class="form-control" id="cmtContents"
												rows="3" placeholder="댓글을 입력하세요."></textarea>
											<div align="right" style="margin-top: 2px">
												<button class="btn btn-sm btn-theme03" id="cmtSubmit">POST</button>
											</div></li>
									</ul>
								</div>
								<!-- 댓글조회 -->
								<br>
								<br>
								<br>
								<div class="button" align="center">
									<button onclick="location.href='fBoardListView.do'"
										class="btn btn-theme03">목록으로</button>
									<c:if test="${LoginUser.memberId==fBoard.memberId }">
									<c:url var="fModify" value="fBoardModifyView.do">
										<c:param name="fBoardNo" value="${fBoard.fBoardNo }"></c:param>
									</c:url>
									<c:url var="fDelete" value="fBoardDelete.do">
										<c:param name="fBoardNo" value="${fBoard.fBoardNo }"></c:param>
									</c:url>
									<button onclick="location.href='${fModify}'"
										class="btn btn-theme02">수정</button>
									<button onclick="location.href='${fDelete}'"
										class="btn btn-theme04">삭제</button>
									</c:if>
								</div>
							</div>
						</div>
				</div>
			</div>
		</section>
	</section>
	
	<script>
		$(function() {
			getCmtList();
			$("#cmtSubmit").on("click", function() {
				var fBoardNo = '${fBoard.fBoardNo }';
				var cmtContents = $("#cmtContents").val();
				$.ajax({
					url : "fbCmtAdd.do",
					type : "post",
					data : { "fBoardNo" : fBoardNo, "cmtContents" : cmtContents},
					success : function(data) {
						if(data == "success") {
							// 댓글 불러오기
							getRCmtList();
							// 작성 후 내용 초기화
							$("#cmtContents").val("");
						}else {
							alert("댓글 등록 실패..");
						}
					},
					error : function() {
						
					}
				});
			});
		});
		
		function getCmtList() {
			var fBoardNo = '${fBoard.fBoardNo}'
			$.ajax({
				url : "fbCmtList.do",
				type : "get",
				data : {"fBoardNo" : fBoardNo},
				dataType : "json",
				success : function(data) {
					var $tableBody = $("#cmttb tbody");
					$tableBody.html(""); //비워주기 후 추가
					var $tr;
					var $memberId;
					var $cmtContents;
					var $enrollDate;
					var $btnArea;
					$("#cmtCount").text("댓글 (" + data.length + ")"); // 댓글 개수 표시
					if(data.length > 0) {
						for(var i in data) {
							$tr = $("<tr>"); /* tr태그가 만들어짐 */
							$memberId = $("<td width='100'>").text(data[i].cmtWriter);
							$enrollDate = $("<td width='100'>").text(data[i].enrollDate);
							$btnArea = $("<td>")
							.append("<a href='#' id='modfiy-btn' onclick='fbCmtModify(this,"+fBoardNo+","+data[i].cmtNo+",\""+data[i].cmtContents+"\");'>수정 </a>") //수정버튼 만들기			
							.append("<a href='#' onclick='fbCmtDelete("+fBoardNo+","+data[i].cmtNo+");'> 삭제</a>"); //삭제버튼 만들기
							$cmtContents = $("<td>").text(data[i].cmtContents);
							$tr.append($memberId);
							$tr.append($cmtContents);
							$tr.append($enrollDate);
							$tr.append($btnArea); //수정,삭제버튼 만들기
							$tableBody.append($tr);
						}
					}
				},
				error : function(data) {
					
				}
			});
		}
		
		//수정버튼 관련 태그
		function fbCmtModify(obj, fBoardNo, cmtNo, cmtContents) {
			$trModify = $("<tr>");
			$trModify.append("<td colspan='2'><input type='text'class='form-control' id='modifyCmt' size='50' value='"+cmtContents+"'></td>");
			$trModify.append("<td align='right'><button class='btn btn-theme02' onclick='modifyCmtCommit("+fBoardNo+","+cmtNo+")'>수정완료</button></td>");
			$(obj).parent().parent().after($trModify);
		}
		function modifyCmtCommit(fBoardNo, cmtNo) {
			var modifiedContent = $("#modifyCmt").val();
			/* console.log(modifiedContent); */
 			$.ajax({
				url : "fbCmtModify.do",
				type : "post",
				data : { 
					"fBoardNo" : fBoardNo , 
					"cmtNo" : cmtNo, 
					"cmtContents" : modifiedContent 
				},
				success : function() {
					if(data == "success") {
						getCmtList();
					} else{
						alert("댓글 수정 실패!");
					}
				},
				error : function() {
					alert("서버 통신 실패!");
				}
			});
		}
		
		//삭제버튼 관련 태그
		function fbCmtDelete(fBoardNo, cmtNo) {
			var con_test = confirm("삭제하시겠습니까?");
			if(con_test == true) {
				alert("삭제되었습니다.");
			}else if(con_test == false) {
				return false;
			}
			$.ajax({
				url : "fbCmtDelete.do",
				type : "get",
				data : { "fBoardNo" : fBoardNo, "cmtNo" : cmtNo},
				success : function(data) {
					if(data == "success") {
						getCmtList();
					}else {
						alert("댓글 조회 실패!");
					}
				},
				error : function() {
					
				}
			});
		}
	
	</script>
</body>
</html>