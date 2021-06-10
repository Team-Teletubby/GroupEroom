<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>사원 목록 조회</title>
<style type="text/css">
.centerText table {
	margin: auto;
}

span.guide {
	display: none;
	font-size: 12px;
	top: 12px;
	right: 10px;
}

span.ok {
	color: green
}

span.error {
	color: red
}
</style>

</head>
<body>
	<!-- 헤더 시작 -->
	<jsp:include page="../common/header.jsp"></jsp:include>
	<!-- 헤더 끝 -->
	<!-- 사이드바 시작 -->
	<jsp:include page="../common/sideBar.jsp"></jsp:include>
	<!-- 사이드바 끝  -->
	<link rel="stylesheet" type="text/css"
		href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
	<font></font>
	<font></font>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
	<font></font>

	<section id="main-content">
		<section class="wrapper">
			<div class="col-md-12">
				<h4>
					<i class="fa fa-angle-right"></i> 사원목록
				</h4>
				<div class="content-panel" style="background-color: white; margin: 20px 0px 0px 0px">
					<hr>
					<table class="table">
						<thead>
							<tr>
								<th>사번</th>
								<th>부서</th>
								<th>직급</th>
								<th>이름</th>
								<th>폰번호</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="row" items="${mlist }">
								<tr>
									<td><c:url var="memberDetailView" value="memberDetail.do">
											<c:param name="memberId" value="${row.memberId}"></c:param>
										</c:url> <a href="${memberDetailView }">${row.memberId}</a></td>
									<td>${ row.memberDept }</td>
									<td>${row.memberJob }</td>
									<td>${row.memberName }</td>
									<td>${row.memberPhone }</td>
								</tr>
						
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			</div>
			<div align="center">
            <div class="btn-group">
						<!-- 이전 -->
						<c:url var="before" value="memberSearch.do">
							<c:param name="page" value="${pi.currentPage - 1 }"></c:param>
							<c:param name="searchCondition" value="${search.searchCondition }"></c:param>
							<c:param name="searchValue" value="${search.searchValue }"></c:param>
						</c:url>
						<c:if test="${pi.currentPage <= 1 }">
							<button type="button" class="btn btn-default">이전</button>
						</c:if>
						<c:if test="${pi.currentPage > 1 }">
							<a href="${before }" class="btn btn-default">이전</a>&nbsp;
						</c:if>
						
					<!-- 페이지 -->
					<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
						<c:url var="pagination" value="memberSearch.do">
							<c:param name="page" value="${p }"></c:param>
							<c:param name="searchCondition" value="${search.searchCondition }"></c:param>
							<c:param name="searchValue" value="${search.searchValue }"></c:param>
						</c:url>
						<c:if test="${p eq pi.currentPage }">
						<button type="button" class="btn btn-default btn-theme">${p }</button>
							
						</c:if>
						<c:if test="${p ne pi.currentPage }">
							<a href="${pagination }" class="btn btn-default">${p }</a>&nbsp;
						</c:if>
					</c:forEach>
				
				
				<!-- 다음 -->
				<c:url var="after" value="memberSearch.do">
					<c:param name="page" value="${pi.currentPage + 1 }"></c:param>
					<c:param name="searchCondition" value="${search.searchCondition }"></c:param>
					<c:param name="searchValue" value="${search.searchValue }"></c:param>
				</c:url>
				<c:if test="${pi.currentPage >= pi.maxPage }">
					<button type="button" class="btn btn-default">다음</button>
				</c:if>
				<c:if test="${pi.currentPage < pi.maxPage }">
					<a href="${after }" class="btn btn-default">다음</a>&nbsp;
				</c:if>
			</div>
			</div>
			<br><br>
			<div align="center">
				<form action="memberSearch.do" method="get" class="form-inline">
					<select name="searchCondition" class="form-control">
						<option value="all"
							<c:if test="${search.searchCondition == 'all' }">selected</c:if>>전체</option>
						<option value="name"
							<c:if test="${search.searchCondition == 'name' }">selected</c:if>>이름</option>
						<option value="dept"
							<c:if test="${search.searchCondition == 'dept' }">selected</c:if>>부서</option>
						<option value="job"
							<c:if test="${search.searchCondition == 'job' }">selected</c:if>>직급</option>
					</select> <input type="text" name="searchValue" style="width:200px" class="form-control" 
						value="${search.searchValue }"> <input type="submit"
						value="검색" class="btn btn-theme">
				</form>
			</div>
			<script type="text/javascript">
					
					</script>
</body>
</html>