<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section id="container">
		<!-- 헤더 시작 -->
		<jsp:include page="../common/header.jsp"></jsp:include>
		<!--헤더 끝-->
		<!--사이드바 시작-->
		<jsp:include page="../common/sideBar.jsp"></jsp:include>
		<div id="wrapper">
        	<div id="loading"></div>
        	<div id="calendar"></div>
        </div>
</body>
</html>