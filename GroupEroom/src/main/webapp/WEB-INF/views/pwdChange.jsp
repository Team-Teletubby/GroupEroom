<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- í°í¸ api -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Abel&family=Rajdhani:wght@300&display=swap"
	rel="stylesheet">
<link rel="shortcut icon" href="asset/image/fv.ico">
<!-- ì¤íì¼ìí¸ -->
<link rel="stylesheet" href="resources/css/reset.css" />
<link rel="stylesheet" href="resources/css/index.css" />
<title>EROOM</title>
<style type="text/css">
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
</style>
</head>
<body>
	<div class="content-box">
		<div class="content">
			<div class="title-logo-box">
				<p>EROOM</p>
				<p style="font-size: 20px; color: black;">초기비밀번호 변경</p>
				<!--<img src="asset/image/logo.png" alt="ë¡ê³ ">-->
			</div>
			<div class="login-form">
				<form action="pwdChange.do" method="post">
					<input type="hidden" name="memberId" value="${memberId } ">
					<font color="red">${message }</font> <span class="guide ok"
						id=".guide.ok">비밀번호가 일치합니다.</span> <span class="guide error"
						id=".guide.error">비밀번호가 일치하지 않습니다.</span>
					<div class="password_Out_Box">
						<div class="inputBox">
							<input type="password" name="memberPwd1" class="text-field"
								id="Password1" placeholder="변경할 비밀번호"> <label for="Password1"></label>
						</div>
					</div>
					<div class="password_Out_Box">
						<div class="inputBox">
							<input type="password" class="text-field" id="Password2"
								name="memberPwd2" placeholder="변경할 비밀번호확인"> <label for="Password2" ></label>
						</div>
					</div>
					<input type="submit" value="비밀번호 변경" class="submit-btn" name="submit1" id="success">
				</form>
			</div>
			<p id="question">이슈 발생 시, 담당 부서 관리자에게 문의해주시기 바랍니다.</p>
		</div>
	</div>
	</div>

	<script>
		
	
		var memberPwd2 = document.querySelector('#Password2');
		memberPwd2.addEventListener('keyup', function() {
			
		var memberPwd1 = document.querySelector('#Password1');
		var guideOk;
		var guidError;
			if (memberPwd1.value == memberPwd2.value) {
				
				document.getElementById(".guide.error").style.display = "none";
				document.getElementById(".guide.ok").style.display = "block";
			} else {
			document.getElementById(".guide.ok").style.display = "none";
			document.getElementById(".guide.error").style.display = "block";
			}
		});

		
		var submit1 = document.querySelector('#success');
		
		submit1.addEventListener("click", function() {
			alert("변경이 완료되었습니다");
		})
		//        $.ajax({
		//           url : "pwdCheck.do",
		//           data : { "Password1" : Password1 },
		//           success : function(result) {

		//              if(result == 0) {

		//              }else{

		//              }
		//           },
		//           error : function() {
		//              console.log("전송 실패");
		//           }
		//        });
	</script>
</body>
</html>