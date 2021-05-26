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
					<br> <br>
					<table align="center" width="450" border="1">
						<tr>
							<td>사번</td>	
							<td><input type="text" name="memberId" value="${memberOne.memberId }" readonly></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="text" name="memberPwd" value="${memberOne.memberPwd }" readonly></td>
						</tr>
						<tr>
							<td>부서</td>
							<td><input type="text" name="memberDept" value="${memberOne.memberDept }" readonly></td>
						</tr>
						<tr>
							<td>직급</td>
							<td><input type="text" name="memberJob" value="${memberOne.memberJob }" readonly></td>
						</tr>
						<tr>
							<td>이름</td>
								<td><input type="text" name="memberName" value="${memberOne.memberName }" readonly></td>
						</tr>
						<tr>
							<td>주민등록번호</td>
					<td><input type="text" name="memberRrn" value="${memberOne.memberRrn }" readonly></td>
						</tr>
						<tr>
							<td>폰번호</td>
								<td><input type="text" name="memberPhone" value="${memberOne.memberPhone }" readonly></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="text" name="memberEmail" value="${memberOne.memberEmail }" readonly></td>
						</tr>
							<tr>
							<td>주소</td>
								<td><input type="text" name="memberAddr" value="${memberOne.memberAddr }" readonly></td>
						</tr>
							<tr>
							<td>은행</td>
							<td><input type="text" name="bank" value="${memberOne.bank }" readonly></td>
						</tr>
							<tr>
							<td>계좌번호</td>
					<td><input type="text" name="bankAccount" value="${memberOne.bankAccount }" readonly></td>
						</tr>
						<tr>
               <td colspan="3" align="center">
                  <!-- <button onclick="return validate();">가입하기</button> -->
                  <c:url var="mModify" value="info.do">
							<c:param name="memberId" value="${memberOne.memberId }"></c:param>
						</c:url>
							<a href="${mModify } " class="btn btn-theme02">수정</a>
               </td>
            </tr>
					</table>
				
			</div>
		</section>
	</section>
</body>
</html>