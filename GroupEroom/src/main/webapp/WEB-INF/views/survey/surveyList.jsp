<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 목록</title>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/style2.css" rel="stylesheet">
<link href="resources/js/font-awesome/css/font-awesome.css" rel="stylesheet" />
<script src=https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js></script>
<style>
/* .poll{
	border:1px solid lightgray;
	padding:5px;
	border-radius : 10px;
	width:100%;
-webkit-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
 -moz-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
 -o-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
 box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
 -webkit-transition: all 0.5s ease-in;
 -moz-transition: all 0.5s ease-in;
 -o-transition: all 0.5s ease-in;
 -ms-transition: all 0.5s ease-in;
 transition: all 0.1s ease-in;
	
} */
.showback:hover{
	background:#fafaff;
	font-weight: bold;
	color:#22242a; transition:0.2s;
	box-shadow:0px 0px 10px 0px #4ECDC4 ;
}
#go{ color: white; }
</style>
<script>
$(document).ready(function(){
	
});
</script>
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
              	<div class="showback" >
              	<table style="width:100%";>
              	<tr>
              		<td style="width:60%;">
	              		<p style="font-size:20px">#${list.surveyNo }_
	              			<span>${list.surveyTitle }</span>
	              		</p>
	              		<p><i class="fa fa-edit"></i> 작성자 : ${list.memberName}</p>
	              		<p><i class="fa fa-users"> 투표 대상 : ${list.target }</i></p>
	              		<p>
	              			<span class="date"><i class="fa fa-calendar-o">기간 : 
	              			<c:set var = "startDate" value = "${fn:substring(list.startDate, 0, 10)}" />
	              			<c:set var = "endDate" value = "${fn:substring(list.endDate, 0, 10)}" />
	              			${startDate} ~ </i> ${endDate}</span>
	              		</p>
              		</td>
              		<td style="width:20%" align="right">
              				<c:url var="surveyDetail" value="surveyOne.do">
								<c:param name="surveyNo" value="${list.surveyNo}"></c:param>
							</c:url>
              			<a id="go" href="${surveyDetail }" class="btn btn-warning btn-lg"><i class="fa fa-pencil-square-o"></i>투표 하기</a>
              		</td>
              		<td style="width:20%;" align="center">
              			<c:url var="surveyResult" value="resultSurvey.do">
								<c:param name="surveyNo" value="${list.surveyNo}"></c:param>
						</c:url>
              			<a href="${surveyResult }" class="btn btn-theme04 btn-lg" style="color:white"><i class="fa fa-pie-chart "></i> 투표 결과</a>
              		</td>
              	</tr>
              	</table>
              	</div>
              	<br>
              </c:forEach>
              
              <c:if test="${empty list }">
             	<div align="center" >
					<i style="font-size:30px; margin:100px" class="fa fa-lightbulb-o"> 투표 리스트가 없습니다.</i>
             	</div>
              </c:if>
         	  </div>
          
          
        </div>
        </div>
      </div>
    </section>
  </section>












</body>
</html>