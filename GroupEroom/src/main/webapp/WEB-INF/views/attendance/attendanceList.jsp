<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근태관리</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/style2.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/sideBar.jsp"></jsp:include>
    <section id="main-content">
      <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i>근태관리</h3>
        <div class="row">
          <div class="col-md-12">
            <div class="content-panel">
            	<div>부여 연차 : ${LoginUser.regDate } /사용 연차/ 잔여 연차</div>
            </div>
         </div>
        </div>
       </section>
    </section>
</body>
</html>