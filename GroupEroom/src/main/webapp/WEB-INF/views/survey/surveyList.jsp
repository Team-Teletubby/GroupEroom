<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	SimpleDateFormat fomatter = new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 목록</title>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/style2.css" rel="stylesheet">
<link href="resources/js/font-awesome/css/font-awesome.css" rel="stylesheet" />

<style>
.poll{
	border:5px solid #4ECDC4;
	padding:5px;
	border-radius : 10px;
	
}
.poll:hover{
	background:#fafaff;
	border:5px solid #4ECDC4;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sideBar.jsp"></jsp:include>
	<section id="main-content">
      <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i>투표</h3>
        <div class="row">
          <div class="col-md-12">
            <div class="form-panel" >
              <h4><i class="fa fa-angle-right"></i>투표 목록</h4><hr><br>
              <div style="margin:0px 100px 0px 100px">
              <c:forEach items="${list }" var="list">
              	<div class="poll">
              		<p style="font-size:20px">#${list.surveyNo }_
              		<span>
              			<c:url var="surveyDetail" value="surveyOne.do">
							<c:param name="surveyNo" value="${list.surveyNo}"></c:param>
						</c:url>
              			<a href="${surveyDetail }">${list.surveyTitle }</a>
              		</span>
              		</p>
              		<p><i class="fa fa-users"> : ${list.target }</i></p>
              		<p>
              		<span><i class="fa fa-calendar-o"> : ${list.startDate } ~ </i>
              		${list.endDate }</span>
              		</p>
              	</div><br>
              </c:forEach>
         	  </div>
          
          
        </div>
        </div>
      </div>
    </section>
  </section>












</body>
</html>