<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 상세 조회</title>
</head>
<body>
	<!-- 헤더 시작 -->
	<jsp:include page="../common/header.jsp"></jsp:include>
	<!-- 헤더 끝 -->
	<jsp:include page="../common/sideBar.jsp"></jsp:include>
	<section id="main-content">
		<section class="wrapper">
		<h3><i class="fa fa-angle-right"></i>인사관리</h3>
			<div class="row">
			 <div class="col-md-12">
            <div class="form-panel" >
            <h4><i class="fa fa-angle-right"></i>사원 상세 조회</h4>
					
							
						
				<%-- <div align="center">
						<table>
							<tr><td>비밀번호</td><td>${memberOne.memberPwd }</td></tr>
							<tr><td>주민등록번호</td><td>${memberOne.memberRrn }</td></tr>
							<tr><td>폰번호</td><td>${memberOne.memberPhone }</td></tr>
							<tr><td>이메일</td><td>${memberOne.memberEmail }</td></tr>
							<tr><td>주소</td><td>${memberOne.memberAddr }</td></tr>
							<tr><td>은행</td><td>${memberOne.bank }</td></tr>
							<tr><td>계좌번호</td><td>${memberOne.bankAccount }</td></tr>
							<tr><td>퇴사여부</td><td>${memberOne.quitYn }</td></tr>
							<tr><td>퇴사날짜</td><td>${memberOne.quitDate }</td></tr>
						</table>
					
				</div>	 --%>
				
						
						
						
						
						
				<div class="showback" style="width: 800px; margin: 0px auto; border:1px solid lightgray " >
				<h3 align="center" style="background-color: white; margin:10px 255px 0px 255px;"><i class="fa fa-address-card-o"></i>  ${memberOne.memberName} ${memberOne.memberJob} 상세보기</h3>
				<hr style="border : 1px solid; color:#4ECDC4; background:#4ECDC4">	
				<div>
				
					<div align="center" style="float:left; width:50%; ">
						<img src="/resources/memberproFile/${memberOne.renameFileName }" style="width:150px; height:150px; text-align:center; border-radius:50%"/>
					</div>		
					<div style="float:left; width:50%;">
					<br><br>
						<table style="width:100%; font-size:15px;">
							<tr><td>사번</td><td>${memberOne.memberId }</td></tr>
							<tr><td>부서</td><td>${memberOne.memberDept }</td></tr>
							<tr><td>직급</td><td>${memberOne.memberJob }</td></tr>
							<tr><td>이름</td><td>${memberOne.memberName }</td></tr>
						</table>
					</div>
				</div><br><br><br><br><br><br><br><br><br>
				
				
				
				
              <div class=" form" style="margin: 20px 100px 0px 100px; height:auto;" >
                <form class="cmxform form-horizontal style-form" id="commentForm" method="get" >
                  <div class="form-group ">
                    <label for="cemail" class="control-label col-lg-2">비밀번호</label>
                    <div class="col-lg-10">
                      <input class="form-control " id="cemail" type="text" name="memberPwd" value="****" readonly>
                    </div>
                  </div>
                  <div class="form-group ">
                    <label for="curl" class="control-label col-lg-2">부서</label>
                    <div class="col-lg-10">
                      <input class="form-control " id="curl" type="url" name="memberDept" value="${memberOne.memberDept }" readonly>
                    </div>
                  </div>
                   <div class="form-group ">
                    <label for="curl" class="control-label col-lg-2">직급</label>
                    <div class="col-lg-10">
                      <input class="form-control " id="curl" type="url" name="memberJob" value="${memberOne.memberJob }" readonly>
                    </div>
                  </div>
                  <div class="form-group ">
                    <label for="curl" class="control-label col-lg-2">이름</label>
                    <div class="col-lg-10">
                      <input class="form-control " id="curl" type="url" name="memberName" value="${memberOne.memberName }" readonly>
                    </div>
                  </div>
                  <div class="form-group ">
                    <label for="curl" class="control-label col-lg-2">주민등록번호</label>
                    <div class="col-lg-10">
                      <input class="form-control " id="curl" type="url" name="memberRrn" value="${memberOne.memberRrn }" readonly>
                    </div>
                  </div>
                  <div class="form-group ">
                    <label for="curl" class="control-label col-lg-2">폰번호</label>
                    <div class="col-lg-10">
                      <input class="form-control " id="curl" type="url" name="memberPhone" value="${memberOne.memberPhone }" readonly>
                    </div>
                  </div>
                  <div class="form-group ">
                    <label for="curl" class="control-label col-lg-2">이메일</label>
                    <div class="col-lg-10">
                      <input class="form-control " id="curl" type="url" name="memberEmail" value="${memberOne.memberEmail }" readonly>
                    </div>
                  </div>
                  <div class="form-group ">
                    <label for="curl" class="control-label col-lg-2">주소</label>
                    <div class="col-lg-10">
                      <input class="form-control " id="curl" type="url" name="memberAddr" value="${memberOne.memberAddr }" readonly>
                    </div>
                  </div>
                  <div class="form-group ">
                    <label for="curl" class="control-label col-lg-2">은행</label>
                    <div class="col-lg-10">
                      <input class="form-control " id="curl" type="url" name="bank" value="${memberOne.bank }" readonly>
                    </div>
                  </div>
                  <div class="form-group ">
                    <label for="curl" class="control-label col-lg-2">계좌번호</label>
                    <div class="col-lg-10">
                      <input class="form-control " id="curl" type="url" name="bankAccount" value="${memberOne.bankAccount }" readonly>
                    </div>
                  </div>
                  <div class="form-group ">
                    <label for="curl" class="control-label col-lg-2">퇴사여부</label>
                    <div class="col-lg-10">
                      <input class="form-control " id="curl" type="url" name="quitYn" value="${memberOne.quitYn }" readonly>
                    </div>
                  </div>
                  <div class="form-group ">
                    <label for="curl" class="control-label col-lg-2">퇴사날짜</label>
                    <div class="col-lg-10">
                      <input class="form-control " id="quitdate" type="date" name="quitDate" value="${memberOne.quitDate }" readonly>
                    </div>
                  </div>
                  <div class="form-group">
                    <div align="center">
                       <c:url var="mModify" value="info.do">
							<c:param name="memberId" value="${memberOne.memberId }"></c:param>
						</c:url>
                   		 <a href="${mModify } " class="btn btn-theme02" style="color:white"><i class="fa fa-edit"></i> 수정</a>
                    </div>
                  </div>
                </form>
              </div>
            </div>
            <br><br><br><br>
            
            <!--end form panel -->
				</div>
				</div>
				
			</div>
		</section>
	</section>
</body>
</html>