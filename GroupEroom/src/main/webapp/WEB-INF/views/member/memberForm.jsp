<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>사원등록</title>
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
				<i class="fa fa-angle-right"></i>사원등록
			</h3>
			<div class="col-lg-12">
				<div class="form-panel">
					<div class="form" style="margin: 20px 200px 0px 200px">
						<form class="cmxform form-horizontal style-form" id="signupForm"
							method="post" action="memberRegister.do"
							enctype="multipart/form-data">
							<div class="form-group ">
								<label for="firstname" class="control-label col-lg-2">*
									부서</label>

								<div class="col-lg-10">
									<select class="form-control" name="memberDept"
										style="width: 95%;">

										<option value="인사관리">인사관리</option>
										<option value="IT개발">IT개발</option>
										<option value="영업">영업</option>
										<option value="재무" selected="selected">재무</option>
									</select>
								</div>
							</div>
							<div class="form-group ">
								<label for="lastname" class="control-label col-lg-2">*
									직급</label>
								<div class="col-lg-10">

									<select class="form-control" name="memberJob"
										style="width: 95%;">
										<option value="사원">사원</option>
										<option value="주임">주임</option>
										<option value="대리">대리</option>
										<option value="과장">과장</option>
										<option value="차장">차장</option>
										<option value="부장">부장</option>
										<option value="전무">전무</option>
										<option value="대표" selected="selected">대표</option>
									</select>
								</div>
							</div>
							<div class="form-group ">
								<label for="username" class="control-label col-lg-2">*
									이름</label>
								<div class="col-lg-10">
									<input class="form-control" type="text" name="memberName"
										style="width: 95%;">
								</div>
							</div>
							<div class="form-group ">
								<label for="password" class="control-label col-lg-2">*
									주민등록번호</label>
								<div class="col-lg-10">

									<input class="form-control" type="text" name="Rrn1"
										style="width: 300px; display: inline;" id="memberRrn1"
										placeholder="앞자리 6자리" maxlength="6" /> -<input
										class="form-control" type="text" name="Rrn2"
										style="width: 300px; display: inline;" id="memberRrn2"
										placeholder="뒷자리 7자리" maxlength="7">
									<div class="check_font" id="memberRrn3"></div>

								</div>
							</div>
							<div class="form-group ">
								<label for="confirm_password" class="control-label col-lg-2">*
									폰번호 </label>
								<div class="col-lg-10">
									<input class="form-control" type="text" name="memberPhone"
										style="width: 95%;" id="memberPhone"
										placeholder="숫자 11자리 입력 (-) 미포함">
									<div class="check_font" id="phone_check"></div>

								</div>
							</div>
							<div class="form-group ">
								<label for="email" class="control-label col-lg-2"> 우편번호</label>
								<div class="col-lg-10">
									<input type="text" name="post" size="6"
										class="postcodify_postcode5 form-control" id="addressForm"
										style="width: 89%; display: inline; background-color: white"
										readonly>
									<button type="button" id="postcodify_search_button"
										style="display: inline-block" class="btn btn-theme04">검색</button>
								</div>
							</div>
							<div class="form-group ">
								<label for="agree" class="control-label col-lg-2 col-sm-3">
									도로명주소 </label>
								<div class="col-lg-10 col-sm-9">
									<input type="text" name="address1"
										class="postcodify_address form-control" readonly
										style="background-color: white; width: 95%;">
								</div>
							</div>
							<div class="form-group ">
								<label for="newsletter" class="control-label col-lg-2 col-sm-3">
									상세주소 </label>
								<div class="col-lg-10 col-sm-9">
									<input type="text" name="address2"
										class="postcodify_extra_info form-control" style="width: 95%;">

								</div>
							</div>
							<div class="form-group ">
								<label for="newsletter" class="control-label col-lg-2 col-sm-3">
									은행 </label>
								<div class="col-lg-10 col-sm-9">
									<select class="form-control" name="bank" style="width: 95%;">


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
									<input type="text" class="form-control" name="bankAccount"
										placeholder="(-) 빼고 입력해주세요" style="width: 95%;">
								</div>
							</div>
							<div class="form-group ">
								<label for="newsletter" class="control-label col-lg-2 col-sm-3">
									이메일 </label>
								<div class="col-lg-10 col-sm-9">
									<input type="text" class="form-control" id="memberEmail"
										name="email1" style="width: 300px; display: inline;">@<input
										type="text" class="form-control" value="teletubby.co.kr"
										readonly name="email2"
										style="width: 300px; display: inline; background-color: white">
									<br> <span class="guide ok">이 이메일은 사용 가능 합니다.</span> <span
										class="guide error">이 이메일은 사용 할 수 없습니다.</span>
								</div>
							</div>
							<div class="form-group ">
								<label for="formFile" class="control-label col-lg-2 col-sm-3">
									프로필사진 </label> <input type="file" id=formFile name="uploadFile">
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
									<button class="btn btn-theme" type="submit" value="사원등록">사원등록</button>
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
  	
  		
       $("#memberEmail").on("keyup", function() {
    	  
          var memberEmail = $("#memberEmail").val();
         $.ajax({
            url : "emChk.do",
            data : { "memberEmail" : memberEmail },
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
   
      }); 
         var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
         
 
         $('#memberPhone').blur(function(){
        	 
     		if(phoneJ.test($(this).val())){
     			console.log(phoneJ.test($(this).val()));
     			$("#phone_check").text('');
     		} else {
     			$('#phone_check').text('휴대폰번호를 확인해주세요 :)');
     			$('#phone_check').css('color', 'red');
     		}
         
     	});  
////////////////////////////////////////////////////
		var Rrn1 = $('#memberRrn1');
		var Rrn2 = $('#memberRrn2');
     	$('#memberRrn1').on("blur", function() {
            ////  ok
     		if(Rrn1.val() == "")
            {
               
     			alert("주민등록번호 앞자리를 입력해 주세요");
            }

            //주민번호 앞자리(mJumin1)가 6자리가 안 될 경우 
            if(Rrn1.val().length < 6)
            {
            	
                alert("주민등록번호 앞자리를 정확히 입력해 주세요");
            }
      	 });
     	
     	$('#memberRrn2').on("blur", function() {
     		
	         
	       
	         //주민번호 뒷자리(mJumin2)에 공백을 제거하고도 아무 입력이 되지않았을 경우 
	       
	         if(Rrn2.val()== "" )
	         {
	             alert("주민등록번호 뒷자리를 입력해 주세요");
	             
	             
	         }
	     
	         //주민번호 뒷자리(mJumin2)가 7자리가 안 될 경우 
	         if(Rrn2.val().length < 7)
	         {
	        	
	             alert("주민등록번호 뒷자리를 정확히 입력해 주세요");
	             
	         }

         	 //올바른 주민등록번호가 입력되는지 검사
       		 var total = 0;
	         var cnt = 2;
	         for (var i = 0; i < mJuminNumber.length - 1; i++) {
	             if (cnt > 9) {
	                 cnt = 2;
	             }
	             total += parseInt(mJuminNumber.charAt(i)) * cnt;
	             cnt++;
	         }

	         var check = (11 - (total % 11)) % 10;
	
	         if(parseInt(check) != parseInt(mJuminNumber.charAt(12)))
	         {
	             alert("잘못된 주민등록번호 입니다.");
	             Rrn1.val() = "";
	             Rrn2.val() = "";
	             
	             return false;
	          } 
 
   	 });
     	
   </script>
</body>
</html>