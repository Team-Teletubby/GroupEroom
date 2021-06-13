<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 결과</title>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/style2.css" rel="stylesheet">
<link href="resources/js/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<script
	src=https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js></script>

<style>
#msg {
	border: 1px solid lightgray;
	margin: 0px 100px 50px 100px;
	-webkit-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
	-moz-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
	-o-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
	box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
	-webkit-transition: all 0.5s ease-in;
	-moz-transition: all 0.5s ease-in;
	-o-transition: all 0.5s ease-in;
	-ms-transition: all 0.5s ease-in;
	transition: all 0.5s ease-in;
}
</style>
<script>
	$(document).ready(
			function() {
				var startDate = moment("${survey.startDate}").format(
						"YYYY-MM-DD");
				var endDate = moment("${survey.endDate}").format("YYYY-MM-DD");
				$("#date").html(
						"<i class='fa fa-calendar'></i> 투표 기간 : " + startDate
								+ " ~ " + endDate);

				$("#complete").on("click", function() {
					alert("투표가 완료되었습니다.");
				});
			});
</script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sideBar.jsp"></jsp:include>
	<section id="main-content">
		<section class="wrapper">
			<h3>
				<i class="fa fa-angle-right"></i>투표
			</h3>
			<div class="row">
				<div class="col-md-12">
					<div class="form-panel">
						<h4>
							<i class="fa fa-angle-right"></i>투표 결과
						</h4>
						<hr>
						<br>
						<div id="msg">
							<div align="center">
								<p style="font-size: 30px; padding: 20px 20px 0px 20px">
									<i class="fa fa-angle-double-left"></i> ${survey.surveyTitle }
									<i class="fa fa-angle-double-right"></i>
								</p>
								<br>
								<p style="font-size: 20px;">
									<i class="fa fa-bullhorn"></i> ${survey.surveyObject }
								</p>
								<br>
								<p id="date"></p>
								<c:if test="${survey.showName == 'Y' }">
									<p>
										<i class="fa fa-check" style="color: #FCB322"></i>해당 투표는 <span
											style="font-weight: bold; font-size: 14px; color: #55a630">실명</span>으로
										진행됩니다.
									</p>
								</c:if>
								<c:if test="${survey.showName == 'N' }">
									<p>
										<i class="fa fa-check" style="color: #FCB322"></i>해당 투표는 <span
											style="font-weight: bold; font-size: 14px; color: #ed5565">익명</span>으로
										진행됩니다.
									</p>
								</c:if>

								<c:if test="${survey.showResult == 'Y' }">
									<p>
										<i class="fa fa-check " style="color: #FCB322"></i>해당 투표 결과는 <span
											style="font-weight: bold; font-size: 14px; color: #55a630;">투표
											대상 모두가 </span>볼 수 있습니다.
									</p>
								</c:if>
								<c:if test="${survey.showResult == 'N' }">
									<p>
										<i class="fa fa-check " style="color: #FCB322"></i>해당 투표 결과는 <span
											style="font-weight: bold; font-size: 14px; color: #ed5565">작성자</span>에게만
										공개됩니다.
									</p>
								</c:if>
							</div>


							<hr
								style="border: 1px solid; color: #4ECDC4; background: #4ECDC4">
							<!-- ==================결과 나오는 곳================== -->

							<table style="width:100%">
								<tr>
									<td align="center" style="width:50%">
										<p style="font-size: 20px">
											<i class="fa fa-quora"></i>.${survey.surveyQuestion }
										</p> <c:choose>
											<c:when
												test="${sessionScope.LoginUser.memberId != survey.memberId and survey.showResult == 'N' }">
												<p style="font-size: 20px">
													<br>
													<i class="fa fa-exclamation-triangle" style="color: red;"></i>해당
													투표 결과는 투표 작성자만 확인할 수 있습니다.
												</p>
											</c:when>
											<c:otherwise>
												<p style="font-size: 20px">총 참여자 수 : ${totalCount }</p>
												<br>
												<div>
													<c:forEach var="result" items="${resultCount}"
														varStatus="status">
														<c:choose>
															<c:when test="${status.count == '1' }">
																<p style="font-size: 20px; color: #ac92ec">
																	<i class="fa fa-check-circle"></i>${result.itemValue} :
																	${result.count } 표<br>
															</c:when>

															<c:otherwise>
																<p>
																	*${result.itemValue} : ${result.count } 표 <br>
															</c:otherwise>
														</c:choose>
														<c:if test="${survey.showName == 'Y' }">
															<i class="fa fa-users"></i>
															<c:forEach var="resultAll" items="${resultAll }"
																varStatus="status">
																<c:if test="${result.itemValue == resultAll.itemValue}">
																	<span>${resultAll.memberName }, </span>
			              										</c:if>
															</c:forEach>
														</c:if>
														</p>
													</c:forEach>
												</div>
											</c:otherwise>
										</c:choose>
									</td>
									
									
									<!--========= 투표 결과 바========== -->
									<td align="center" style="padding:50px; border-left:1px solid lightgray">
						 			<div>
						             <div class="showback">
						              <h4>투표 결과</h4>
										<c:choose>
											<c:when test="${sessionScope.LoginUser.memberId != survey.memberId and survey.showResult == 'N' }">
											</c:when>
											<c:otherwise>
												<c:forEach var="bar" items="${resultCount }">
									              <c:set var="per" value="${bar.count/totalCount*100}"/>
									              <div class="progress" style="height:25px">
									                <div class="progress-bar progress-bar-warning" aria-valuemax="100" style="width:${per}%">
									                <span style="font-size:15px; line-height:25px;">${bar.itemValue }</span>
									                </div><span style="font-size:15px; line-height:25px;"><fmt:formatNumber value="${per }" pattern="0"/>%</span>
									              </div>
									             </c:forEach><br>
									              <p align="right">*비율은 소수점 1자리에서 반올림 되었습니다.</p>
											</c:otherwise>
										</c:choose>
						            </div>
						           </div>
								</td>
								</tr>
							</table>
							<br>
							<div align="center"><a style="color:gray"href="surveyList.do" class="btn btn-default">목록으로</a></div><br><br>
						</div>

					</div>
				</div>
				<!--id=msg end====  -->


			</div>
		</section>
	</section>












</body>
</html>