<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ page buffer="1000kb" %>
			<!DOCTYPE html>
			<html lang="ko">

			<head>
				<meta charset="utf-8">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<meta name="description" content="">
				<meta name="author" content="Dashboard">
				<meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
				<title>협업관리</title>

				<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

				<!-- Font Awesome JS -->
				<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
					integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
					crossorigin="anonymous"></script>
				<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
					integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
					crossorigin="anonymous"></script>

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
								<!-- 오른쪽 사이드바 -->
								<div class="w3-sidebar w3-bar-block w3-animate-right"
									style="width: 400px; right: 0; display: none;" id="mySidebar">
									<button class="w3-bar-item w3-button w3-large" onclick="w3_close()">Close
										&times;</button>
									<aside class="right-side">
										<div class="invite-row">
											<div class="group-rom">
												<div class="first-part odd">${ coop.memberName }</div>
												<div class="second-part2" id="OpenBtn"></div>
												<div class="third-part">${ coop.enrollDate }</div>
											</div>
										</div>
										<div style="padding: 10px; border: 1px solid lightgrey; font-size: 15px">
											<table style="width: 100%" id="rtb">
												<thead>
													<tr>
														<!-- 댓글 갯수 -->
														<td colspan="2"><b style='color: #4ECDC4' id="rCount"></b></td>
													</tr>
												</thead>
												<tbody>
													<!-- 댓글 나오는 칸 -->
												</tbody>
											</table>
										</div>
										<br>
										<table style="width: 100%">
											<tr>
												<td style="width: 90%" id="inputZone">
													<!-- <textarea placeholder="댓글을 입력해 주세요" 
											class="form-control" style="width: 100%" id="rContent" name="comment" required></textarea> -->
												</td>
												<td id="buttonZone" style="width: 10%" align="right">
													<%-- <button class="btn btn-theme02 btn-xs" id="rSubmit"
														onclick="submitCmt('${coop.coNo}')">
														<i class="fa fa-pencil"></i> 댓글 등록
														</button> --%>
												</td>
											</tr>
										</table>
									</aside>
								</div>
								<div class="chat-room-head">
									<h3>#${coopName }</h3>
								</div>
								<div>
									<!-- 글이 없을 경우 -->
									<c:forEach items="${ coopList }" var="coopList">
										<c:if test="${ empty coopList }">
											<div class="group-rom">
												<div class="first-part" style="height:100%"></div>
												<div class="second-part" id="OpenBtn" align="center">글이 없습니다.</div>
												<div class="third-part"></div>
											</div>
										</c:if>
										<c:if test="${ !empty coopList }">
											<input class="coNo hidden" id="coNo" value="${ coopList.coNo }" />
											<!--데이터 들어가는   -->
											<div class="group-rom">
												<c:if test="${coopList.memberName != LoginUser.memberName }">
													<span class="first-part">${ coopList.memberName }</span>
												</c:if>
												<c:if test="${coopList.memberName == LoginUser.memberName }">
													<div class="first-part odd" style="height:100%">${
														coopList.memberName }</div>
												</c:if>
												<c:if test="${ !empty coopList.renameFilename } != null">
													<i class=" fa fa-paperclip"></i>
												</c:if>
												<div class="time">${ coopList.enrollDate }</div>
												<div class="third-part">

													<!-- 수정,삭제버튼 -->
													<c:if test="${ LoginUser.memberId == coopList.memberId}">
														<c:url var="coModify" value="coopModify.do">
															<c:param name="roomNo" value="${ coopList.roomNo }">
															</c:param>
															<c:param name="coNo" value="${ coopList.coNo }"></c:param>
															<c:param name="renameFilename"
																value="${ coopList.renameFilename }"></c:param>
														</c:url>
														<c:url var="coDelete" value="coopDelete.do">
															<c:param name="roomNo" value="${ coopList.roomNo }">
															</c:param>
															<c:param name="coNo" value="${ coopList.coNo }"></c:param>
															<c:param name="renameFilename"
																value="${ coopList.renameFilename }"></c:param>
														</c:url>
														<button type="button" class="btn btn-round btn-warning btn-xs"
															onclick="location.href='${ coModify }'">
															<i class="fa fa-times" id="OpenBtn"></i>
														</button>
														<button type="button" class="btn btn-round btn-danger btn-xs"
															onclick="location.href='${ coDelete }'">
															<i class="fa fa-times"></i>
														</button>
													</c:if>
												</div>
												<c:url var="coopDetail" value="coopDetail.do">
													<c:param name="roomNo" value="${ coopList.roomNo }"></c:param>
													<c:param name="coNo" value="${ coopList.coNo }"></c:param>
												</c:url>
												<div class="second-part"
													onclick="w3_open(${coopList.coNo},'${ coopList.coContents }')"> ${ coopList.coContents }</div>
												
											</div>
											<!-- 데이터 끝나는 곳 -->
										</c:if>
									</c:forEach>
									<!-- 등록화면 -->
									<div class="group-rom last-group">
									</div>
									<footer style="width:100%">
										<form action="coopRegister.do?roomNo=${ roomNo }" method="post"
											enctype="multipart/form-data">
											<div class="chat-txt">
												<input type="text" class="form-control" id="coContents"
													name="coContents" placeholder="내용을 입력하세요" required>
											</div>
											<div class="btn-group hidden-sm hidden-xs">
												<label class="btn btn-white" for="input-file">
													<i class="fa fa-paperclip" onclick></i>
												</label>
												<input type="file" class="btn btn-white" name="uploadFile"
													id="input-file" style="display:none" />
											</div>
											<button type="submit" class="btn btn-theme">등록</button>
										</form>
									</footer>
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
					//사이드바 오픈 시
					function w3_open(coNo, coContents) {
						$('#mySidebar').css("display", "block");
						$('#myOverlay').css("display", "block");

						$('.second-part2').html("");
						$('.second-part2').html('<p>' + coContents + '</p>');
						$("#inputZone").html("<input id='rContent' type='text'>");
						var rContent = $("#rContent").val();
						$("#buttonZone").html("<button onclick='submitCmt(" + coNo + ")'>댓글등록</button>");
						getReplyList(coNo);
					}

					function w3_close() {
						$('#mySidebar').css("display", "none");
						$('#myOverlay').css("display", "none");
					}

					function submitCmt(coNo) {
						var rContent = $("#rContent").val();
						$.ajax({
							url: "coopAddReply.do",
							type: "post",
							data: {
								"coNo": coNo,
								"rContent": rContent
							},
							success: function (data) {
								if (data == "success") {
									alert("댓글이 등록되었습니다.")
									getReplyList(coNo);
									
								} else {
									alert("등록 실패하였습니다.");
								}
							},
							error: function () {
								alert("서버 통신 실패!");
							}
						});
					}
					

					function getReplyList(coNo) {
						var writer = '${LoginUser.memberName}';
						var loginUser = '${LoginUser.memberId}';
						$("#rContent").val("");
						alert(writer + coNo + loginUser);

						$.ajax({
							url: "coopReply.do",
							type: "get",
							data: { "coNo": coNo },
							dataType: "json",
							success: function (data) {
								var $tableBody = $("#rtb tbody");
								$tableBody.html(""); // 비워주기
								var $tr;
								var $rWriter;
								var $rContent;
								var $rCreateDate;
								var $btnArea;
								var $td;
								$("#cmtCount").text("댓글 (" + data.length + ")"); // 댓글 개수 표시
								if (data.length > 0) {
									for (var i in data) {
										$tr = $("<tr>"); /* tr태그가 만들어짐 */
										$memberId = $("<td width='100'>").text(data[i].writer);
										$enrollDate = $("<td width='100'>").text(data[i].enrollDate);
										$btnArea = $("<td>")
											.append("<a href='#' id='modfiy-btn' onclick='modifyReply(this," + coNo + "," + data[i].cmtNo + ",\"" + data[i].cmtContents + "\");'>수정 </a>") //수정버튼 만들기			
											.append("<a href='#' onclick='cmtDelete(" + coNo + "," + data[i].cmtNo + ");'> 삭제</a>"); //삭제버튼 만들기
										$cmtContents = $("<td>").text(data[i].cmtContents);
										$tr.append($memberId);
										$tr.append($cmtContents);
										$tr.append($enrollDate);
										$tr.append($btnArea); //수정,삭제버튼 만들기
										$tableBody.append($tr);
									}
								}
							},
							error: function (data) {
								alert("서버실패"); //삭제할 곳   
								var $tableBody = $("#rtb tbody");
								$tableBody.html(""); // 비워주기
							}
						});
					}

					//수정버튼 관련 태그
					function modifyReply(obj, coNo, cmtNo, cmtContents) {
						$trModify = $("<tr>");
						$trModify.append("<td colspan='2'><input type='text'class='form-control' id='modifyCmt' size='50' value='" + cmtContents + "'></td>");
						$trModify.append("<td align='right'><button class='btn btn-theme02' onclick='modifyCmtCommit(" + coNo + "," + cmtNo + ")'>수정완료</button></td>");
						$(obj).parent().parent().after($trModify);
					}
					//수정
					function modifyCmtCommit(coNo, cmtNo) {
						var modifiedContent = $("#modifyCmt").val();
						/* console.log(modifiedContent); */
						$.ajax({
							url: "coopModifyReply.do",
							type: "post",
							data: {
								"coNo": coNo,
								"cmtNo": cmtNo,
								"cmtContents": modifiedContent
							},
							success: function (data) {
								if (data == "success") {
									getReplyList(coNo);
								} else {
									alert("댓글 수정 실패!");
								}
							},
							error: function () {
								alert("서버 통신 실패!");
							}
						});
					}
					//삭제버튼 관련 태그
					function cmtDelete(coNo, cmtNo) {
						var con_test = confirm("삭제하시겠습니까?");
						if (con_test == true) {
							alert("삭제되었습니다.");
						} else if (con_test == false) {
							return false;
						}
						$.ajax({
							url: "coopDeleteReply.do",
							type: "get",
							data: { "coNo": coNo, "cmtNo": cmtNo },
							success: function (data) {
								if (data == "success") {
									getReplyList();
								} else {
									alert("댓글 조회 실패!");
								}
							},
							error: function () {

							}
						});
					}
				</script>



			</body>

			</html>