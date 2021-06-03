<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 수정</title>
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
#form-panel {
	background: #ffffff;
	margin: 10px;
	padding: 10px;
	box-shadow: 0px 3px 2px #aab2bd;
	text-align: left;
	width: 90%;
}
</style>
<link rel="stylesheet" href="resource/css/memberForm.css">

</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sideBar.jsp"></jsp:include>


	<section id="main-content">
		<section class="wrapper">
			<h3>
				<i class="fa fa-angle-right"></i>사원 정보 수정
			</h3>
			<div class="col-lg-12">
				<div class="form-panel">
					<div class="form" style="margin: 20px 200px 0px 200px">
						<form class="cmxform form-horizontal style-form" id="signupForm"
							method="post" action="memberModify.do" enctype="multipart/form-data">
							<div class="form-group ">
								<label for="memberId" class="control-label col-lg-2">*
									사번</label>
								<div class="col-lg-10">
										<input class="form-control" type="text"
											name="memberId" style="width: 95%; background-color: white" value="${memberOne.memberId }" readonly>
								</div>
							</div>
							
							<div class="form-group ">
								<label for="firstname" class="control-label col-lg-2">*
									부서</label>

								<div class="col-lg-10">
									<select class="form-control" name="memberDept"
										style="width: 95%;">

										<option value="인사관리">인사관리</option>
										<option value="IT개발">IT개발</option>
										<option value="재무">재무</option>
										<option value="영업" selected="selected">영업</option>
									</select>
								</div>
							</div>
							<div class="form-group ">
								<label for="lastname" class="control-label col-lg-2">*
									직급</label>
								<div class="col-lg-10">

									<select class="form-control" name="memberJob"
										style="width: 95%;">
											<option value="대표">대표</option>
											<option value="주임">주임</option>
											<option value="대리">대리</option>
											<option value="과장">과장</option>
											<option value="차장">차장</option>
											<option value="부장">부장</option>
											<option value="전무">전무</option>
											<option value="사원" selected="selected">사원</option></select>
								</div>
							</div>
							<div class="form-group ">
								<label for="username" class="control-label col-lg-2">*
									이름</label>
								<div class="col-lg-10">
										<input class="form-control" type="text"
											name="memberName" style="width: 95%; background-color: white"  value="${memberOne.memberName }" readonly>
								</div>
							</div>
							<div class="form-group ">
								<label for="password" class="control-label col-lg-2">*
									주민등록번호</label>
								<div class="col-lg-10">
									
										<input class="form-control" type="text"
											name="memberRrn" style="width: 95%;  background-color: white" placeholder="(-)포함 형식에 맞게 입력해주세요" value="${memberOne.memberRrn }" readonly>

									
								</div>
							</div>
							<div class="form-group ">
								<label for="confirm_password" class="control-label col-lg-2">*
									폰번호 </label>
								<div class="col-lg-10">
									<input class="form-control" type="text"
										name="memberPhone" style="width: 95%;" placeholder="숫자 11자리 입력 (-) 포함, xxx-xxxx-xxxx" value="${memberOne.memberPhone }">
								</div>
							</div>
							<c:forTokens items="${memberOne.memberAddr }" delims="," var="addr" varStatus="status">
 							<c:if test="${status.index eq 0 }">
							<div class="form-group ">
								<label for="email" class="control-label col-lg-2"> 우편번호</label>
								<div class="col-lg-10">
										<input type="text" name="post" size="6"
											class="postcodify_postcode5 form-control" id="addressForm"
											style="width: 89%; display: inline; background-color: white" value="${addr }"
											>
											<button type="button" id="postcodify_search_button"
												style="display: inline-block" class="btn btn-theme04">검색</button>
								</div>
							</div>
							</c:if>
							<c:if test="${status.index eq 1 }">
							<div class="form-group ">
								<label for="agree" class="control-label col-lg-2 col-sm-3">
									도로명주소 </label>
								<div class="col-lg-10 col-sm-9">
									<input type="text" name="address1"
											class="postcodify_address form-control" 
											style="background-color: white; width: 95%;" value="${addr }">
								</div>
							</div>
							</c:if>
							<c:if test="${status.index eq 2  }">
							<div class="form-group ">
								<label for="newsletter" class="control-label col-lg-2 col-sm-3">
									상세주소 </label>
								<div class="col-lg-10 col-sm-9">
									<input type="text" name="address2"
											class="postcodify_extra_info form-control"
											style="width: 95%;" value="${addr }">
									
								</div>
							</div>
							</c:if>
							</c:forTokens>
							<div class="form-group ">
								<label for="newsletter" class="control-label col-lg-2 col-sm-3">
									은행 </label>
								<div class="col-lg-10 col-sm-9">
										<select class="form-control" name="bank"
											style="width: 95%;">

												<option value="국민은행">국민은행</option>
												<option value="우리은행">우리은행</option>
												<option value="하나은행">하나은행</option>
												<option value="농협">농협</option>
												<option value="신한은행">신한은행</option>
												<option value="카카오뱅크">카카오뱅크</option>
												<option value="신협은행">신협은행</option>
												<option value="케이뱅크">케이뱅크</option>
												<option value="기업은행" selected="selected">기업은행</option>
										</select>
								</div>
							</div>
							<div class="form-group ">
								<label for="newsletter" class="control-label col-lg-2 col-sm-3">
									계좌번호 </label>
								<div class="col-lg-10 col-sm-9">
										<input type="text" class="form-control"
											name="bankAccount" placeholder="-넣고 오류난다고 하지 않기"
											style="width: 95%;" value="${memberOne.bankAccount }">
								</div>
							</div>
							<div class="form-group ">
								<label for="newsletter" class="control-label col-lg-2 col-sm-3">
									이메일 </label>
								<div class="col-lg-10 col-sm-9">
										<input type="text" class="form-control" name="memberEmail"
											style="width: 300px; display: inline;" value="${memberOne.memberEmail }">
											
								</div>
							</div>
					<div class="form-group ">
								<label for="newsletter" class="control-label col-lg-2 col-sm-3">
									퇴사여부 </label>
								<div class="col-lg-10 col-sm-9">
               <input type="radio" name="quitYn" value="Y" checked>Y <input type="radio" name="quitYn" value="N" checked>N
           				</div>
           				</div>
							<div class="form-group ">
								<label for="formFile" class="control-label col-lg-2 col-sm-3">
									프로필사진 </label>
									<input type="file" id="formFile" name="reloadFile" value="${memberOne.renameFileName }">
								<div class="col-lg-10 col-sm-9">
								
							<!-- 이미지 미리보기 영역 -->
							<div id="imgViewArea" style="margin-top: 10px; display: none;">
								<img id="imgArea" style="width: 200px; height: 100px;"
									onerror="imgAreaError()" />
							</div>
							</div>
							</div>
							<!-- 	<div class="form-group ">
								<label for="newsletter" class="control-label col-lg-2 col-sm-3">
									사진 </label>
								<div class="col-lg-10 col-sm-9">
									<input type="file" id="real-input"
											class="image_inputType_file" accept="img/*" required multiple>
								</div>
							</div> -->
							<div class="form-group">
								<div align="center">
										<br>
											<!-- <button onclick="return validate();">가입하기</button> -->
											<button class="btn btn-theme" type="submit" value="정보수정">정보수정</button>
											<button class="btn btn-theme04" type="button"
												onclick="location.href='index.do';">홈으로</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- /form-panel -->
			</div>

		</section>
	</section>









	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script type="text/javascript">
      $(function() {
         $("#postcodify_search_button").postcodifyPopUp();
      });
      function readURL(input) {
  		if (input.files && input.files[0]) {
  			var reader = new FileReader();
  			reader.onload = function(e) {
  				$('#imgArea').attr('src', e.target.result); 
  			}
  			reader.readAsDataURL(input.files[0]);
  		}
  	}

  	$(":input[name='uploadFile']").change(function() {
  		if( $(":input[name='uploadFile']").val() == '' ) {
  			$('#imgArea').attr('src' , '');  
  		}
  		$('#imgViewArea').css({ 'display' : '' });
  		readURL(this);
  	});

  	// 이미지 에러 시 미리보기영역 미노출
  	function imgAreaError(){
  		$('#imgViewArea').css({ 'display' : 'none' });
  	}
  	
     /*  $("#userId").on("blur", function() {
         var userId = $("#userId").val();
         $.ajax({
            url : "dupId.kh",
            data : { "userId" : userId },
            success : function(result) {
               //console.log(result);
               if(result != 0) {
                  $(".guide.ok").hide();
                  $(".guide.error").show();
               }else{
                  $(".guide.ok").show();
                  $(".guide.error").hide();
               }
            },
            error : function() {
               console.log("전송 실패");
            }
         });
         
      }); */
   </script>
</body>
</html>