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
<title>공지 사항</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sideBar.jsp"></jsp:include>

	<section id="main-content">
		<section class="wrapper">
			<h3>
				<i class="fa fa-angle-right"></i> 공지사항
			</h3>
			<div class="row">
			<div class="col-md-12">
			<div class="content-panel">
			<h4><i class="fa fa-angle-right"></i> 게시글리스트</h4>
						<br> <br> <br>
						<div class="form-group" align="center">
							<form action="fBoardSearch.do" method="get" class="form-inline"
								role="form">
								<select class="form-control" name="searchCondition">
									<option value="ALL">전체</option>
									<option value="NOTICE_TITLE">제목</option>
									<option value="NOTICE_CONTENTS">내용</option>
									<option value="MEMBER_NAME">작성자</option>
								</select> <input type="text" name="searchValue" style="width: 200px"
									class="form-control"> <input type="submit" value="검색"
									class="btn btn-theme">
							</form>
						</div>
						
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${ nList }" var="notice">
									<tr>
										<td>${ notice.noticeNo }</td>
										
										<td><c:url var="noticeDetail" value="noticeDetail.do">
												<c:param name="noticeNo" value="${notice.noticeNo}"></c:param>
											</c:url> <a href="${noticeDetail }">${notice.noticeTitle }</a>&nbsp;&nbsp;
											</td>
										<td>${notice.noticeWriter }</td>
										<td>${notice.enrollDate }</td>
										<td>${notice.hits }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
							<div align="right">
											
						
</body>
</html>