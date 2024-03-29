<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
#msg{
border:1px solid lightgray;
margin:0px 100px 50px 100px;
-webkit-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
 -moz-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
 -o-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
 box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
 -webkit-transition: all 0.5s ease-in;
 -moz-transition: all 0.5s ease-in;
 -o-transition: all 0.5s ease-in;
 -ms-transition: all 0.5s ease-in;
 transition: all 0.5s ease-in;
}
</style>
<script>
$(document).ready(function(){
	 var today = moment(new Date()).format("YYYYMMDD");
	 var end = moment("${survey.endDate}").format("YYYYMMDD");
	 var start = moment("${survey.startDate}").format("YYYYMMDD");
	 var diffAfter = today-end;
	 var diffBefore = start-today;
	 if(diffAfter>0) {
		 $("#info").html("<span style='font-size:20px'><i class='fa fa-exclamation-triangle' style='color:red'></i>투표 기간이 지났습니다.</span><br><br><a style='color:white'class='btn btn-theme02' href='surveyList.do'>목록으로</a>");
	 }else if(diffBefore > 0){
		 $("#info").html("<span style='font-size:20px'><i class='fa fa-exclamation-triangle' style='color:red'></i> "+diffBefore+"일 후 투표 가능합니다.</span><br><br><a style='color:white'class='btn btn-theme02' href='surveyList.do'>목록으로</a>");
	 }
	 var startDate = moment("${survey.startDate}").format("YYYY-MM-DD");
	 var endDate = moment("${survey.endDate}").format("YYYY-MM-DD");
	 $("#date").html("<i class='fa fa-calendar'></i> 투표 기간 : " + startDate + " ~ " + endDate);
	 
	 $("#complete").on("click", function(){
		 var check = $("input:radio[name='itemValue']:checked").val();
		 if(check == null){
			 alert("항목을 선택해 주세요.");
			 return false;
		 }else {
			 if(confirm("투표 하시겠습니까?")==false){
					return false;
			}
		 }
	 });
	 
	 $("#delete").on("click", function(){
		if(confirm("삭제하시겠습니까?")== false) {
			return false;
		}
	 }); 
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
              <h4><i class="fa fa-angle-right"></i>투표 하기</h4><hr><br>
              <div id="msg">
              	<div align="center" >
              		<p style="font-size:30px; padding: 20px 20px 0px 20px"><i class="fa fa-angle-double-left"></i> ${survey.surveyTitle } <i class="fa fa-angle-double-right"></i> </p><br>
              		<p style="font-size:20px;"><i class="fa fa-bullhorn"></i> ${survey.surveyObject }</p><br>
              		<p id="date"></p>
              	<c:if test="${survey.showName == 'Y' }">
              		<p><i class="fa fa-check" style="color:#FCB322"></i>해당 투표는 <span style="font-weight:bold; color:yellowgreen">실명</span>으로 진행됩니다.</p>
              	</c:if>
              	<c:if test="${survey.showName == 'N' }">
              		<p><i class="fa fa-check" style="color:#FCB322"></i>해당 투표는 <span style="font-weight:bold; color:red">익명</span>으로 진행됩니다.</p>
              	</c:if>
              	
              	<c:if test="${survey.showResult == 'Y' }">
              		<p><i class="fa fa-check " style="color:#FCB322"></i>해당 투표 결과는 <span style="font-weight:bold; color:yellowgreen">투표대상 모두가 </span>볼 수 있습니다.</p>
              	</c:if>
              	<c:if test="${survey.showResult == 'N' }">
              		<p><i class="fa fa-check " style="color:#FCB322"></i>해당 투표 결과는 <span style="font-weight:bold; color:red">작성자</span>에게만 공개됩니다.</p>
              	</c:if>
              		<hr style="border : 1px solid; color:#4ECDC4; background:#4ECDC4">
              		<div>
              			
              		</div>
              		
              		
              		<p style="font-size:20px"><i class="fa fa-quora"></i>.${survey.surveyQuestion }</p>
              		<form action="surveyComplete.do" method="post">
              		<p>
              			<c:forTokens items="${survey.surveyAnswers }" delims="," var="answer" varStatus="status">
              				<input type="hidden" value="${survey.surveyNo }" name="surveyNo">
              				<span style="padding: 20px"><input type="radio" name="itemValue" value="${answer }">${answer }</span>
              				
              			</c:forTokens>
              		</p><br>
              		<p id="info">
	              		<c:choose>
	              			<c:when test="${check == 0 }">
		              			<button type="submit" id="complete" class="btn btn-theme02"><i class="fa fa-pencil"></i> 투표 하기</button><br><br>
		              			<i class="fa fa-exclamation-triangle" style="color:red"></i>투표는 수정할 수 없으니 신중히 선택해 주세요.
		              		</c:when>
		              		<c:otherwise>
		              			<span class="btn btn-theme03"><i class="fa fa-check"></i> 투표완료</span>
		              			<span><a style="color:white" href="resultSurvey.do?surveyNo=${survey.surveyNo }" class="btn btn-danger"><i class="fa fa-pie-chart "></i>결과보기</a></span>
		              			<br><br>
		              			<i class="fa fa-exclamation-triangle" style="color:red"></i>이미 참여하셨습니다.<br><br><br>
		              			<a style="color:white"href="surveyList.do" class="btn btn-theme02">목록</a>
		              		</c:otherwise>
              			</c:choose>
              		</p>
              		</form>
              	</div><br>
              	<div align="right" style="margin:10px">
		            <c:if test="${sessionScope.LoginUser.memberId == survey.memberId }">
		         	  <a id="delete" href="deleteSurvey.do?surveyNo=${survey.surveyNo }" class="btn btn-danger" style="color:white;">삭제</a>
		          	</c:if>
		        </div>
         	  </div>
         	 
          
        </div>
        </div>
      </div>
    </section>
  </section>












</body>
</html>