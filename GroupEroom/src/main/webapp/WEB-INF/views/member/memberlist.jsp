<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록 조회</title>


</head>
<body>
<!-- 헤더 시작 -->
		<jsp:include page="../common/header.jsp"></jsp:include>
		<!-- 헤더 끝 -->
		<!-- 사이드바 시작 -->
		<jsp:include page="../common/sideBar.jsp"></jsp:include>
		<!-- 사이드바 끝  -->
	<h2>사원 목록 </h2>
	<table border="1" width="700px">
	<tr>
		<th>사번</th>
		<th>부서</th>
		<th>직급</th>
		<th>이름</th>
	
	
	</tr>
	<c:forEach var="row" items="${list }">
	<tr>
		<td>${row.memberId }</td>
		<td>${row.memberDept }</td>
		<td>${row.memberJob }</td>
		<td>${row.memberName }</td>
		
	</tr>
	</c:forEach>
	</table>
</body>
</html>