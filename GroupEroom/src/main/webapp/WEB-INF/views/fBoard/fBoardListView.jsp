<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
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
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th width="300">제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${ fList } var="fBoard">
									<tr>
										<td align="center">${ fBoard.fBoardNo }</td>
										<td align="center"><c:url var="fBoardDetail"
												value="fBoardDetail.do">
												<c:param name="fBoardNo" value="${fBoard.fBoardNo}"></c:param>
											</c:url> <a href="${fBoardDetail }">${fBoard.fBoardTitle }</a></td>
										<td align="center">${fBoard.memberId }</td>
										<td align="center">${fBoard.enrollDate }</td>
										<td align="center">${fBoard.hits }</td>
									</tr>
								</c:forEach>

						<div class="span6">
							<div class="dataTables_paginate paging_bootstrap pagination">
								<ul>
									<li class="prev disabled"><a href="#">← Previous</a></li>
									<li class="active"><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li class="next"><a href="#">Next → </a></li>
								</ul>
							</div>
						</div>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</section>
	</section>
</body>
</html>