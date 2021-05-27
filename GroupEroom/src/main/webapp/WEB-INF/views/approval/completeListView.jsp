<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전자결재 - 완료함</title>
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
			<section class="wrapper site-min-height">
				<h3>
					<i class="fa fa-angle-right"></i> 전자결재
				</h3>
				<div class="row">
					<div class="col-md-12">
						<div class="content-panel">
							<h4>
								<i class="fa fa-angle-right"></i> 완료함
							</h4>
							<hr>
							<c:if test="${aList != null }">
							<table class="table table-hover">
								<thead>
									<tr>
										<th width="8%">문서번호</th>
										<th width="8%">유형</th>
										<th>문서제목</th>
										<th width="8%">기안자</th>
										<th width="8%">중간 결재자</th>
										<th width="8%">최종 결재자</th>
										<th width="8%">상태</th>
										<th width="8%">기안일자</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${aList }" var="approval">
										<tr>
											<td>${approval.approvalNo }</td>
											<c:if test="${approval.approvalType == 'Cooperation' }">
												<td>협조문</td>
											</c:if>
											<td><a href="approvalDetail.do?approvalNo=${approval.approvalNo }">${approval.approvalTitle }</a></td>
											<td>${approval.memberName }</td>
											<td>${approval.approvalFirstName }</td>
											<td>${approval.approvalSecondName }</td>
											<td>결재 승인</td>
											<td>${approval.approvalDate }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div align="center">
								<div class="btn-group">
									<!-- 이전 -->
									<c:url var="before" value="cBoardListView.do">
										<c:param name="page" value="${pi.currentPage - 1 }"></c:param>
									</c:url>
									<c:if test="${pi.currentPage <= 1 }">
										<button type="button" class="btn btn-default">이전</button>
									</c:if>
									<c:if test="${pi.currentPage > 1 }">
										<a href="${before }" class="btn btn-default">이전</a>&nbsp;
									</c:if>
									<!-- 페이지 -->
									<c:forEach var="p" begin="${pi.startPage }"
										end="${pi.endPage }">
										<c:url var="pagination" value="cBoardListView.do">
											<c:param name="page" value="${p }"></c:param>
										</c:url>
										<c:if test="${p eq pi.currentPage }">
											<button type="button" class="btn btn-default btn-theme">${p }</button>

										</c:if>
										<c:if test="${p ne pi.currentPage }">
											<a href="${pagination }" class="btn btn-default">${p }</a>&nbsp;
										</c:if>
									</c:forEach>
									<!-- 다음 -->
									<c:url var="after" value="cBoardListView.do">
										<c:param name="page" value="${pi.currentPage + 1 }"></c:param>
									</c:url>
									<c:if test="${pi.currentPage >= pi.maxPage }">
										<button type="button" class="btn btn-default">다음</button>
									</c:if>
									<c:if test="${pi.currentPage < pi.maxPage }">
										<a href="${after }" class="btn btn-default">다음</a>&nbsp;
									</c:if>
								</div>
							</div>
						</c:if>
						<c:if test="${aList == null }">
						
						</c:if>
						</div>
					</div>
				</div>
			</section>
		</section>
</body>
</html>