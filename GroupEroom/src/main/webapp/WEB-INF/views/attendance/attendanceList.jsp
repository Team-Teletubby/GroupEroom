<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근태관리</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/style2.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/js/bootstrap-datepicker/css/datepicker.css" />
  <link rel="stylesheet" type="text/css" href="resources/js/bootstrap-daterangepicker/daterangepicker.css" />
  <link rel="stylesheet" type="text/css" href="resources/js/bootstrap-timepicker/compiled/timepicker.css" />
  <link rel="stylesheet" type="text/css" href="resources/js/bootstrap-datetimepicker/datertimepicker.css" />
<style>
	.circle{
	border-radius:100px;
	background:#f4f4f4;
	width:33%;
	height:100px;
	text-align:center;
	line-height:100px;
	float:left;
	font-weight:bold;
	font-size:15px;
	}
</style>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/sideBar.jsp"></jsp:include>
    <section id="main-content">
      <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i>근태관리</h3>
        <div class="row">
          <div class="col-md-12">
            <div class="form-panel">
            <p>함께 한지 12838일째</p>
            
            <div style="width:100%">
            	<div class="circle">
            	부여 연차
            	</div>
            	<div class="circle" style="background:#ffc247;" >
            	잔여 연차
            	</div>
            	<div class="circle">
            	사용 연차
            	</div>
            </div>	
            	<br><br><br><br><br><br><br><br><br><br>
            	<div>
            	<h4><i class="fa fa-angle-right"></i>연차 신청</h4>
            	<form action="">
            		<table class="table">
            		<tr>
            			<th>종류</th>
            			<th>시작 일자</th>
            			<th>종료 일자</th>
            			<th>사유</th>
            			<th></th>
            		</tr>
            			<tr>
            				<td>
            					<select class="form-control" name="holidayType">
			            			<option value="연차">연차</option>
			            			<option value="오후 반차">오후 반차</option>
			            			<option value="오전 반차">오전 반차</option>
			            			<option value="경조사">경조사</option>
			            		</select>
            				</td>
            				<td>
            					<div style="margin: 0 50px 0 0;" data-date-viewmode="years" data-date-format="yyyy-mm-dd" data-date="${now }" class="input-append date dpYears">
			                      <input type="text" size="16" class="form-control" name="startDate">
			                      <span class="input-group-btn add-on">
			                        <button class="btn btn-theme" type="button"><i class="fa fa-calendar"></i></button>
			                       </span>
			                    </div>
            				</td>
            				<td>
            					<div style="margin: 0 50px 0 0;" data-date-viewmode="years" data-date-format="yyyy-mm-dd" data-date="${now }" class="input-append date dpYears">
			                      <input type="text" size="16" class="form-control" name="endDate">
			                      <span class="input-group-btn add-on">
			                        <button class="btn btn-theme" type="button"><i class="fa fa-calendar"></i></button>
			                       </span>
                    			</div>
            				</td>
            				<td>
            				<input type="text" placeholder="사유" class="form-control" name="reason">
            				</td>
            				<td>
            					<input type="submit" class="btn btn-theme02" style="float:left;" value="등록/승인">
            				</td>
            			</tr>
            		</table>
            	</form>
            	</div>



<!-- ===========================근태 리스트=================================== -->
		<br><br>
				<h4><i class="fa fa-angle-right"></i>연차 조회</h4>
				<table class="table">
				    <tr>
            			<th>종류</th>
            			<th>시작 일자</th>
            			<th>종료 일자</th>
            			<th>사유</th>
            		</tr>
				</table>
	
            </div>
           </div>
         </div>
       </section>
    </section>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="lib/jquery.scrollTo.min.js"></script>
  <script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <script src="lib/common-scripts.js"></script>
  <!--script for this page-->
  <script src="lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script type="text/javascript" src="resources/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
  <script type="text/javascript" src="resources/js/bootstrap-daterangepicker/date.js"></script>
  <script type="text/javascript" src="resources/js/bootstrap-daterangepicker/daterangepicker.js"></script>
  <script type="text/javascript" src="resources/js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
  <script type="text/javascript" src="resources/js/bootstrap-daterangepicker/moment.min.js"></script>
  <script src="resources/js/advanced-form-components.js"></script>
</body>
</html>