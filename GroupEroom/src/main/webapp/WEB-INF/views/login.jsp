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
</head>
<body>
	<div class="content-box">
		<div class="content">
			<div class="title-logo-box">
				<p>EROOM</p>
				<!--<img src="asset/image/logo.png" alt="ë¡ê³ ">-->
			</div>
			<div class="login-form">
				<form action="login.do" method="post" name="form2">
					<font color="red">${msg }</font>
					<div class="id_Out_Box">
						<div class="inputBox">
							<input type="text" name="memberId" class="text-field" id="Id">
							<label for="id">아이디</label>
						</div>
					</div>
					<div class="password_Out_Box">
						<div class="inputBox">
							<input type="password" name="memberPwd" class="text-field"
								id="Password"> <label for="password">비밀번호</label>
						</div>
					</div>
					<input type="submit" value="로그인" class="submit-btn" onclick="input_check()">
				</form>
			</div>
			<p id="question">이슈 발생 시, 담당 부서 관리자에게 문의해주시기 바랍니다.</p>
		</div>
	</div>
	<script src="resources/js/login.js">
	</script>
</body>
</html>