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
	border-radius:50px;
	background:#dcdcdd;
	width:33%;
	height:100px;
	text-align:center;
	line-height:50px;
	float:left;
	font-weight:bold;
	font-size:15px;
	}
	
	#diffDate{
	text-align:center;
	font-size:20px;
	}
</style>

<script>
$(document).ready(function(){
	$("#reg-btn").on("click", function () {
		var restHoliday = "${restHoliday}";
		if ($("#category").val()=="--분류--") {
			alert("연차 분류를 선택해 주세요");
			return false;
		} else if($("#startDate").val() ==""){
			alert("시작일을 설정해주세요.");
			return false;
		}else if($("#endDate").val() ==""){
			alert("종료일을 설정해주세요.");
			return false;
		}else if($("#reason").val() ==""){
			alert("사유를 작성해주세요.");
			return false;
		}else if(restHoliday == 0){
			alert("연차를 모두 사용하셨습니다.");
			return false;
		}else if(restHoliday !=0){
			if(confirm("신청하시겠습니까?")==false){
				return false;
			}
		}
		});
	
	$("#cancle-btn").on("click", function(){
		if(confirm("취소하시겠습니까?")==false){
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
        <h3><i class="fa fa-angle-right"></i>근태관리</h3>
        <div class="row">
          <div class="col-md-12">
            <div class="form-panel">
            <br>
            <p id="diffDate"> <i class="fa fa-trophy"></i> 함께 한지 <span style="color:#967adc; font-weight:bold; font-size:25px">${diffDate }</span>일 째</p>
            <hr><br>
            <div style="width:100%">
            	<div class="circle">
            	부여 연차
            	<p style="font-size:40px">${totalHoliday }</p>
            	</div>
            	<div class="circle" style="background:#ffc247; color:white" >
            	잔여 연차
            	<p style="font-size:40px; color:white">${restHoliday}</p>
            	</div>
            	<div class="circle">
            	사용 연차
				<p style="font-size:40px">${usedHoliday }</p>
            	</div>
            </div>	
            	<br><br><br><br><br><br><br>
<!-- ===========================신청=================================== -->
            	<div>
            	<h4><i class="fa fa-angle-right"></i>연차 신청</h4>
            	<form action="attendanceRegister.do" method="post">
            	<input type="hidden" value="${LoginUser.memberId }" name="memberId">
            	<input type="hidden" value="${restHoliday }" name="restHoliday">
            		<table class="table">
            		<tr>
            			<th>분류</th>
            			<th>시작 일자</th>
            			<th>종료 일자</th>
            			<th>사유</th>
            			<th></th>
            		</tr>
            			<tr>
            				<td>
            					<select class="form-control" name="holidayType" id="category">
            						<option value="--분류--">--분류--</option>
			            			<option value="연차">연차</option>
			            			<option value="오후 반차">오후 반차</option>
			            			<option value="오전 반차">오전 반차</option>
			            			<option value="경조사">경조사</option>
			            		</select>
            				</td>
            				<td>
            					<div style="margin: 0 50px 0 0;" data-date-viewmode="years" data-date-format="yyyy-mm-dd" data-date="${now }" class="input-append date dpYears">
			                      <input type="text" size="16" class="form-control" name="startDate" id="startDate">
			                      <span class="input-group-btn add-on">
			                        <button class="btn btn-theme" type="button"><i class="fa fa-calendar"></i></button>
			                       </span>
			                    </div>
            				</td>
            				<td>
            					<div style="margin: 0 50px 0 0;" data-date-viewmode="years" data-date-format="yyyy-mm-dd" data-date="${now }" class="input-append date dpYears">
			                      <input type="text" size="16" class="form-control" name="endDate" id="endDate">
			                      <span class="input-group-btn add-on">
			                        <button class="btn btn-theme" type="button"><i class="fa fa-calendar"></i></button>
			                       </span>
                    			</div>
            				</td>
            				<td>
            				<input type="text" placeholder="사유" class="form-control" name="reason" id="reason">
            				</td>
            				<td>
            					<input type="submit" id="reg-btn" class="btn btn-theme02" style="float:left;" value="등록/승인">
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
            			<th>사용 일 수 </th>
            			<th>사유</th>
            			<th></th>
            		</tr>
            		
            		<c:forEach items="${atdList }" var="attendance">
						<tr>
							<td>${attendance.holidayType }</td>
							<td>${attendance.startDate }</td>
							<td>${attendance.endDate }</td>
							<td>
							${attendance.usedHoliday }
							</td>
							<td>${attendance.reason }</td>
							<td align="right">
							<c:if test="${attendance.done eq 'N'}">
								<c:url var="deleteAttendance" value="deleteAttendance.do">
									<c:param name="attendanceNo" value="${attendance.attendanceNo }"></c:param>
								</c:url>
								<a href="${deleteAttendance }" class="btn btn-sm btn-theme04" id="cancle-btn">신청취소</a>
							</c:if>
							<c:if test="${attendance.done eq 'Y'}">
								
							</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
				<c:if test="${ empty atdList }">
					<p align="center">연차 조회 결과가 없습니다. </p>
				</c:if>
	<!--================= 페이징 ==============================-->
	      <c:if test="${pi.currentPage}!=0">
	        <div align="center">
            <div class="btn-group">
						<!-- 이전 -->
						<c:url var="before" value="attendanceList.do">
							<c:param name="page" value="${pi.currentPage - 1 }"></c:param>
						</c:url>
						<c:if test="${pi.currentPage <= 1 }">
							<button type="button" class="btn btn-default">이전</button>
						</c:if>
						<c:if test="${pi.currentPage > 1 }">
							<a href="${before }" class="btn btn-default">이전</a>&nbsp;
						</c:if>
						
					<!-- 페이지 -->
					<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
						<c:url var="pagination" value="attendanceList.do">
							<c:param name="page" value="${p }"></c:param>
						</c:url>
						<c:if test="${p eq pi.currentPage }">
						<button type="button" class="btn btn-default btn-theme">${p }</button>
							
						</c:if>
						<c:if test="${p ne pi.currentPage }">
							<a href="${pagination }" class="btn btn-default">${p }</a>&nbsp;
						</c:if>
					</c:forEach>
				
				
				<!-- 다음 -->
				<c:url var="after" value="attendanceList.do">
					<c:param name="page" value="${pi.currentPage + 1 }"></c:param>
				</c:url>
				<c:if test="${pi.currentPage >= pi.maxPage }">
					<button type="button" class="btn btn-default">다음</button>
				</c:if>
				<c:if test="${pi.currentPage < pi.maxPage }">
					<a href="${after }" class="btn btn-default">다음</a>&nbsp;
				</c:if>
			</div>
			</div>
		</c:if>
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