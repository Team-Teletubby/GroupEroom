<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script></script>
<!-- í °í ¸ api -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Abel&family=Rajdhani:wght@300&display=swap"
	rel="stylesheet">
<link rel="shortcut icon" href="asset/image/fv.ico">
<!-- ì ¤í  ì ¼ì  í ¸ -->
<link rel="stylesheet" href="resources/css/reset.css" />
<link rel="stylesheet" href="resources/css/index.css" />
<!-- jQuery -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>EROOM11</title>
</head>
<body>
	<div class="content-box">
		<div class="content">
			<div class="title-logo-box">
				<p>EROOM</p>
				<!--<img src="asset/image/logo.png" alt="ë¡ ê³ ">-->
			</div>
			<div class="login-form">
				<form action="login.do" method="post" name="f1">
					<font color="red">${msg }</font>
					<div class="id_Out_Box">
						<div class="inputBox">
							<input type="text" name="memberId" class="text-field" id="Id">
							<label for="memberid">아이디</label>
						</div>
					</div>
					<div class="password_Out_Box">
						<div class="inputBox">
							<input type="password" name="memberPwd" class="text-field"
								id="Password"> <label for="memberPwd">비밀번호</label>
						</div>
					</div>
					<input type="button" value="로그인" class="submit-btn"
						onclick="loginChk()">
				</form>
			</div>
			<p id="question">이슈 발생 시, 담당 부서 관리자에게 문의해주시기 바랍니다.</p>
		</div>
	</div>
	<script>

	const id_Login_Box = document.querySelector('.id_Out_Box');
	const password_Login_Box =  document.querySelector('.password_Out_Box');
	const login_Id_Input_Box = document.querySelector('#Id');
	const login_Password_Input_Box = document.querySelector('#Password');


	login_Id_Input_Box.addEventListener('keyup', function(){
		console.log("움직인다");
	    if(!login_Id_Input_Box.value == ''){
	        id_Login_Box.classList.add('existence');  
	    }else{  
	        id_Login_Box.classList.remove('existence');  
	    }
	});

	login_Password_Input_Box.addEventListener('keyup', function(){
	    if(!login_Password_Input_Box.value == ''){
	        password_Login_Box.classList.add('existence');  
	    }else{  
	        password_Login_Box.classList.remove('existence');  
	    }
	});
	 

	function loginChk() {
		var f1 = document.f1;
		var memberId = f1.memberId.value;
		var memberPwd = f1.memberPwd.value;
		
		if(!memberId || !memberPwd) {
		alert("아이디와 비밀번호를 확인해주세요.");	
		}else { 
			f1.submit();
		}
		}

	
	
	
	</script>
</body>
</html>