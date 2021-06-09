<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 등록</title>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/style2.css" rel="stylesheet">
<link href="resources/js/font-awesome/css/font-awesome.css" rel="stylesheet" />


<script>
$(document).ready(function(){
	var clickCount = 1;
	 $(document).on('change','.answer-count',function(event) {
		var answerCount = $(event.target).val();
		var answerArea =$(event.target).parent().siblings().last();
			answerArea.html("");
		for(i = 0; i < answerCount; i++) {
			answerArea.append("<label>"+(i+1)+") 답변 </label><br><input type='text' class='form-control answer'>");
		}
		answerArea.append("<hr style='border:1px solid lightgray'; background:'lightgray'>");
	 });
	 
	 $("#add-question").on("click", function () {
		clickCount++;
		if(clickCount > 5 ){
			alert("질문은 최대 5개까지 가능합니다.");
			return false;
		}
		var $questionArea = $("#question-area");
		var $div = $("<div class='question-form'>");
		var $span = $("<span><i class='fa fa-edit'> 답변 개수 </i> ");
		var $select = $("<select name='answer-count' class='answer-count'>");
		var $option = $("<option>선택</option><option value='1'>1개</option><option value='2'>2개</option><option value='3'>3개</option><option value='4'>4개</option><option value='5'>5개</option>");
		var $question = $("<br> *"+clickCount+"번째 질문 <input type='text' class='form-control question'>");
		var $answerArea = $("<div class='answer-area'>")
		$select.append($option);
		$span.append($select);
		$div.append($span);
		$div.append($question);
		$div.append($answerArea);
		$questionArea.append($div);
	});
	 
	 $("#reg-survey").on("click", function () {
		 alert($("input:radio[name='showName']:checked").val());
		 alert($("input:radio[name='showResult']:checked").val());
		 alert($("#target").val())
		 alert($("#startDate").val());
		 alert($("#endDate").val());
		 alert($("#surveyTitle").val());
		 alert($("#surveyObject").val());
		 var question = [];
		 var answer = [];
		 
		 for(i = 0; i<$(".question").length; i++ ){
		 	question.push($(".question").eq(i).val());
		 }
		 	console.log(question);
		 for(j = 0; j<$(".answer").length; i++){
			 answer.push($(".answer").eq(j).val());
		 }
		 	console.log(answer);
		 
		/*  $.ajax({
			
		});   */
	 });
	 
	 
});


</script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sideBar.jsp"></jsp:include>
	<section id="main-content">
      <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i>설문조사</h3>
        <div class="row">
          <div class="col-md-12">
            <div class="form-panel" >
              <h4><i class="fa fa-angle-right"></i> 설문조사 등록</h4><br>
              <div style="margin:0px 100px 0px 100px">
              <table class="table">
              	<tr>
              		<td>실명 / 익명</td>
              		<td><input type="radio" name="showName" value="realName">실명 <input type="radio" name="showName" value="anonymous">익명</td>
              	</tr>
              	<tr>
              		<td>설문 결과</td>
              		<td>
              		<span>공개는 설문 참여자에게 설문 결과를 공개합니다. 비공개는 설문 작성자만 설문 결과 조회 가능합니다.</span><br>
              		<input type="radio" name="showResult" value="public">공개 <input type="radio" name="showResult" value="private">비공개
              		</td>
              	</tr>
              	<tr>
              		<td>대상</td>
              		<td>
	              		<select id="target">
	              			<option selected>전체</option>
	              			<option>인사</option>
	              			<option>재무</option>
	              			<option>IT</option>
	              			<option>영업</option>
	              		</select>
              		</td>
              	</tr>
              	<tr>
              		<td>설문 기간</td>
              		<td>
              			<input type="date" id="startDate"> ~ 
              			<input type="date" id="endDate">
              		</td>
              	</tr>
              	<tr>
					<td>제목</td>              	
					<td><input type="text" id="surveyTitle"></td>              	
              	</tr>
              	<tr>
              		<td>취지</td>
              		<td><textarea rows="" cols="" id="surveyObject"></textarea></td>
              	</tr>
              </table>
              <hr style="border : 1px solid; color:#4ECDC4; background:#4ECDC4">
          </div>
          
          
          <!--===================== 질문 구역 ===============================  -->
            <div id="question-area" style="margin:0px 100px 50px 100px">
	            <p><i class="fa fa-check"></i> 질문은 최대 10문항까지 추가 가능합니다.
	            	<span style="float:right"><button id="add-question" class="btn btn-theme btn-sm"><i class="fa fa-plus"></i> 질문 추가</button></span>
	            </p>
		            <div class="question-form">
		            	<span> <i class="fa fa-edit">답변 개수</i> 
		            		<select class="answer-count" name="answer-count" >
		            			<option value="0">선택</option>
		            			<option value="1">1개</option>
		            			<option value="2">2개</option>
		            			<option value="3">3개</option>
		            			<option value="4">4개</option>
		            			<option value="5">5개</option>
		            		</select>
		            	</span><br>
		            	*1번째 질문<input type="text" class="form-control question">
			            <div class="answer-area">
			            	<!-- 답변개수만큼 나올거다 -->
			            </div>
			         </div>
            </div>
            <button id="reg-survey">등록</button>
            
        </div>
        </div>
      </div>
    </section>
  </section>












</body>
</html>