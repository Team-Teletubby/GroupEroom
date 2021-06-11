<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 등록</title>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/style2.css" rel="stylesheet">
<link href="resources/js/font-awesome/css/font-awesome.css" rel="stylesheet" />
<script src=https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js></script>

<script>
$(document).ready(function(){
	
	
	
	$('#answer-count').change(function(event) {
		var answerCount = $('#answer-count option:selected').val();
		var answerArea = $("#answer-area");
			answerArea.html("");
		for(i = 0; i < answerCount; i++) {
			answerArea.append("<label>"+(i+1)+") 답변 </label><br><input type='text' class='form-control items'>")
		}
	 });
	 
	 $("#reg-survey").on("click", function () {
		var showName = $("input:radio[name='showName']:checked").val();
		var showResult = $("input:radio[name='showResult']:checked").val();
		var surveyTitle = $("#surveyTitle").val();
		var surveyObject = $("#surveyObject").val();
		var surveyQuestion = $("#surveyQuestion").val();
		var target = $("#target").val();
		var startDate = moment($("#startDate").val()).format("YYYY-MM-DD");
		var endDate = $("#endDate").val();
		var surveyAnswers = "";
		for(i = 0; i <$(".items").length; i++){
			surveyAnswers += $(".items").eq(i).val() + ",";
		} 
		surveyAnswers = surveyAnswers.slice(0,-1);
		if(surveyTitle==""){
			alert("제목을 입력해주세요.");
			$("#surveyTitle").focus();
			return false;
		}else if(startDate==""){
			alert("시작 일을 설정해주세요.");
			$("#startDate").focus();
			return false;
		}else if(endDate==""){
			alert("종료 일을 설정해주세요.");
			$("#endDate").focus();
			return false;
		}else if(surveyQuestion==""){
			alert("질문을 작성해 주세요.")
			$("#surveyQuestion").focus();
			return false;
		}
		
		
		
		 $.ajax({
				url : "regSurvey.do",
				type : "post",
				data : { 
					"showName" : showName,
					"showResult" : showResult,
					"surveyTitle" : surveyTitle,
					"surveyObject" : surveyObject,
					"surveyQuestion" : surveyQuestion,
					"surveyAnswers" : surveyAnswers,
					"target" : target,
					"startDate" : startDate,
					"endDate" : endDate
				},
				success : function(data) {
					if(data == "success") {
						alert("성공");
						window.location.href = "surveyList.do";
					}else {
						alert("실패..");
					}
				},
				error : function() {
					alert("통신오류");
				}
		}); 
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
              <h4><i class="fa fa-angle-right"></i>투표 등록</h4><br>
              <div style="margin:0px 100px 0px 100px">
              <table class="table">
              	<tr>
              		<td>실명 / 익명</td>
              		<td><input type="radio" name="showName" value="Y" checked>실명 <input type="radio" name="showName" value="N">익명</td>
              	</tr>
              	<tr>
              		<td>설문 결과</td>
              		<td>
              		<span>공개는 설문 참여자에게 설문 결과를 공개합니다. 비공개는 설문 작성자만 설문 결과 조회 가능합니다.</span><br>
              		<input type="radio" name="showResult" value="Y" checked>공개 <input type="radio" name="showResult" value="N">비공개
              		</td>
              	</tr>
              	<tr>
              		<td>대상</td>
              		<td>
	              		<select id="target" class="form-control" style="width:40%">
	              			<option selected>전체</option>
	              			<option>인사관리</option>
	              			<option>재무</option>
	              			<option>IT개발</option>
	              			<option>영업</option>
	              		</select>
              		</td>
              	</tr>
              	<tr>
              		<td>설문 기간</td>
              		<td>
              			<input type="date" id="startDate" class="form-control" style="width:40%; float:left">
              			<span style="float:left; padding : 10px 10px 0px 10px"> ~ </span>
              			<input type="date" id="endDate" class="form-control" style="width:40%; float:left">
              		</td>
              	</tr>
              	<tr>
					<td>제목</td>              	
					<td><input type="text" id="surveyTitle" class="form-control"></td>              	
              	</tr>
              	<tr>
              		<td>취지</td>
              		<td><textarea rows="" cols="" id="surveyObject" class="form-control"></textarea></td>
              	</tr>
              </table>
              <hr style="border : 1px solid; color:#4ECDC4; background:#4ECDC4">
          </div>
          
          
          <!--===================== 질문 구역 ===============================  -->
            <div id="question-area" style="margin:0px 100px 50px 100px">
	            <p><i class="fa fa-check"></i> 선택지는 최대 12개까지 추가 가능합니다.
	            </p>
		            <div class="question-form">
		            	<span> <i class="fa fa-edit">답변 개수</i> 
		            		<select id="answer-count" name="answer-count" >
		            			<option value="0">선택</option>
		            			<option value="1">1개</option>
		            			<option value="2">2개</option>
		            			<option value="3">3개</option>
		            			<option value="4">4개</option>
		            			<option value="5">5개</option>
		            			<option value="6">6개</option>
		            			<option value="7">7개</option>
		            			<option value="8">8개</option>
		            			<option value="9">9개</option>
		            			<option value="10">10개</option>
		            			<option value="11">11개</option>
		            			<option value="12">12개</option>
		            		</select>
		            	</span><br>
		            	*질문<input type="text" class="form-control" id="surveyQuestion">
			            <div id="answer-area">
			            	<!-- 답변개수만큼 나올거다 -->
			            </div>
			         </div>
            </div>
            <div align="center">
            <button id="reg-survey" class="btn btn-theme"><i class="fa fa-plus"></i>등록</button>
            </div>
        </div>
        </div>
      </div>
    </section>
  </section>












</body>
</html>