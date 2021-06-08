<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>사원 등록 완료</title>

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
			<div class="row" style="background-color: white;">
				<h2 align="center">사원 등록 완료</h2>

				<p style="text-align: center;">
					<img src="/resources/memberproFile/${selectOne.renameFileName }"
						width="150" height="150" text-align=center />
				</p>
				<h2 align="center" style="font-size: 28px";>${selectOne.memberName }</h2>

				<h1 align="center" style="font-size: 28px";>${selectOne.memberDept}/
					${selectOne.memberJob}</h1>
				<br>
				<br>
				<h2 align="center">사원번호 : ${selectOne.memberId }</h2>

				<br>
				<br>

				<div style="text-align: center;">
					<button class="btn btn-theme04" type="button"
						onclick="location.href='index.do';">확인</button>
				</div>
			</div>
		</section>
	</section>

</body>
</html>