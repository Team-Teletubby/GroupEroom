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

	<section id="main-content">
		<section class="wrapper">
			<div class="searchbox">

				<h1 align="center">사원 목록</h1>
				<div class="centerText">

					<table border="1" width="650px" cellspacing="5">
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
									<td>
										<c:url var="memberDetailView" value="memberDetail.do">
											<c:param name="memberId" value="${row.memberId}"></c:param>
										</c:url> <a href="${memberDetailView }">${row.memberId}</a>
									</td>
									<td>${ row.memberDept }</td>
									<td>${row.memberJob }</td>
									<td>${row.memberName }</td>
									<td>${row.memberPhone }</td>
								</tr>
						</tbody>
						</c:forEach>
						</section>
						</section>
						</div>

					</table>


					<div align="center">
						<form action="memberSearch.do" method="get">
							<select name="searchCondition">
								<option value="all"
									<c:if test="${search.searchCondition == 'all' }">selected</c:if>>전체</option>
								<option value="name"
									<c:if test="${search.searchCondition == 'name' }">selected</c:if>>이름</option>
								<option value="dept"
									<c:if test="${search.searchCondition == 'dept' }">selected</c:if>>부서</option>
								<option value="job"
									<c:if test="${search.searchCondition == 'job' }">selected</c:if>>직급</option>
							</select> <input type="text" name="searchValue"
								value="${search.searchValue }"> <input type="submit"
								value="검색">
						</form>
					</div>
</body>
</html>