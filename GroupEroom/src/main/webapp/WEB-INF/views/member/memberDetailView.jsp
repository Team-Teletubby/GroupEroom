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
			<div class="row">
					<h1 align="center">${memberOne.memberName} ${memberOne.memberJob} 상세보기</h1>
					
							<p style="text-align: center;">	
						<img src="/resources/memberproFile/${memberOne.renameFileName }" width="150"  height="150" text-align=center/>
						</p>
				<div class="form-panel" style="width: 800px; margin: 0px auto; " >
              <div class=" form" style="margin: 20px 100px 0px 100px; height:auto;" >
                <form class="cmxform form-horizontal style-form" id="commentForm" method="get" style >
                  <div class="form-group ">
                    <label for="cname" class="control-label col-lg-2">사번</label>
                    <div class="col-lg-10">
                      <input class=" form-control" id="cname" name="memberId" minlength="2" type="text" value="${memberOne.memberId }" readonly >
                    </div>
                  </div>
                  <div class="form-group ">
                    <label for="cemail" class="control-label col-lg-2">비밀번호</label>
                    <div class="col-lg-10">
                      <input class="form-control " id="cemail" type="email" name="memberPwd" value="${memberOne.memberPwd }" readonly>
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
                    <div class="col-lg-offset-2 col-lg-10">
                       <c:url var="mModify" value="info.do">
							<c:param name="memberId" value="${memberOne.memberId }"></c:param>
						</c:url>
							
                    <a href="${mModify } " class="btn btn-theme02">수정</a>
                   
                    </div>
                  </div>
                </form>
              </div>
            </div>
				
				
			</div>
		</section>
	</section>
</body>
</html>