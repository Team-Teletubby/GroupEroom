<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
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
							<i class="fa fa-angle-right"></i> 게시글리스트
						</h4>
						<br>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>말머리</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${ fList }" var="fBoard">
									<tr>
										<td>${ fBoard.fBoardNo }</td>
										<td>${ fBoard.fBullet }</td>
										<td>
										<c:url var="fBoardDetail" value="fBoardDetail.do">
												<c:param name="fBoardNo" value="${fBoard.fBoardNo}"></c:param>
											</c:url> 
										<a href="${fBoardDetail }">${fBoard.fBoardTitle }</a></td>
										<td>${fBoard.fWriter }</td>
										<td>${fBoard.enrollDate }</td>
										<td>${fBoard.hits }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!-- ##############페이징 처리################# -->
						<div align="center">
							<div class="btn-group">
								<!-- 이전 -->
								<c:url var="before" value="fBoardListView.do">
									<c:param name="page" value="${pi.currentPage - 1 }"></c:param>
								</c:url>
								<c:if test="${pi.currentPage <= 1 }">
									<button type="button" class="btn btn-default" disabled><i class="fa fa-caret-left"></i> 이전</button>
								</c:if>
								<c:if test="${pi.currentPage > 1 }">
									<a href="${before }" class="btn btn-default"><i class="fa fa-caret-left"></i> 이전</a>&nbsp;
								</c:if>

								<!-- 페이지 -->
								<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
									<c:url var="pagination" value="fBoardListView.do">
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
								<c:url var="after" value="fBoardListView.do">
									<c:param name="page" value="${pi.currentPage + 1 }"></c:param>
								</c:url>
								<c:if test="${pi.currentPage >= pi.maxPage }">
									<button type="button" class="btn btn-default" disabled>다음 <i class="fa fa-caret-right"></i></button>
								</c:if>
								<c:if test="${pi.currentPage < pi.maxPage }">
									<a href="${after }" class="btn btn-default">다음 <i class="fa fa-caret-right"></i></a>&nbsp;
								</c:if>
							</div>
						</div>
					</div>
				</div>
				<div align="right">
					<button onclick="location.href='fBoardWriteView.do'" class="btn btn-theme03">글쓰기</button>
				</div>
			</div>
		</section>
	</section>
</body>
</html>