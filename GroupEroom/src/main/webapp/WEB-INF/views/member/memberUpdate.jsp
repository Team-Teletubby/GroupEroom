<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보수정</title>
<style type="text/css">
   .centerText table {
      margin : auto;
   }
   span.guide {
      display : none;
      font-size : 12px;
      top : 12px;
      right : 10px;
   }
   span.ok{color:green}
   span.error{color:red}
</style>
</head>
<body>
   <!-- 헤더 시작 -->
		<jsp:include page="../common/header.jsp"></jsp:include>
		<!-- 헤더 끝 -->
   <jsp:include page="../common/sideBar.jsp"></jsp:include>
  <section id="main-content">
      <section class="wrapper">
   <h1 align="center">사원정보수정</h1>
   <div class="centerText">
      <form action="memberModify.do" method="post">
         <table width="650" cellspacing="5">
         	<tr>
               <td>* 사번</td>
				<td><input type="text" name="memberId" value="${memberOne.memberId }" readonly></td>
			</tr>
      		<tr> 
      			<td>* 부서 </td>
							<td><select name="memberDept">
								<option value="인사관리">인사관리</option>
								<option value="IT개발">IT개발</option>
								<option value="영업">영업</option>
								<option value="재무" selected="selected">재무</option></td>
							</select>
						<%-- 	<td><input type="text" name="memberDept" value="${memberOne.memberDept }"></td> --%>
            <tr>
               <td>* 직급</td>
               <td><select name="memberJob" size="1">
								<option value="사원">사원</option>
								<option value="주임">주임</option>
								<option value="대리">대리</option>
								<option value="과장">과장</option>
								<option value="차장">차장</option>
								<option value="부장">부장</option>
								<option value="전무">전무</option>
								<option value="대표" selected="selected">대표</option></td>
							</select>
              <%--  <td><input type="text" name="memberJob" value="${memberOne.memberJob }"></td> --%>
            </tr>
            <tr>
               <td>* 이름</td>
               <td><input type="text" name="memberName" value="${memberOne.memberName }"></td>
            </tr>
            <tr>
               <td>* 주민등록 번호</td>
               <td><input type="text" name="memberRrn" value="${memberOne.memberRrn }"></td>
            </tr>
            <tr>
               <td>* 폰번호</td>
               <td><input type="text" name="memberPhone" value="${memberOne.memberPhone }"></td>
            </tr>
            
            <c:forTokens items="${memberOne.memberAddr }" delims="," var="addr" varStatus="status">
            <c:if test="${status.index eq 0 }">
            <tr>
               <td>우편번호</td>
               <td>
                  <input type="text" name="post"  size="6" class="postcodify_postcode5" value="${addr }">
                  <button type="button" id="postcodify_search_button">검색</button>
               </td>
            </tr>
           
            </c:if>
            <c:if test="${status.index eq 1}">
            <tr>
               <td>도로명 주소</td>
               <td><input type="text" name="address1" class="postcodify_address" value="${addr }" ></td>
            </tr>
            </c:if>
            <c:if test="${status.index eq 2}">
            <tr>
               <td>상세 주소</td>
               <td><input type="text" name="address2" class="postcodify_extra_info" value="${addr }" ></td>
            </tr>
            </c:if>
          </c:forTokens>
             <tr>
               <td>은행</td>
               <td><input type="text" name="bank" value="${memberOne.bank }"></td>
            </tr>
             <tr>
               <td>계좌번호</td>
               <td><input type="text" name="bankAccount" value="${memberOne.bankAccount }"></td>
            </tr>
             <tr>
               <td>이메일</td>
               <td><input type="email" name="memberEmail" value="${memberOne.memberEmail }"></td>
            </tr>
             <tr>
               <td>퇴사여부</td>
               <td><input type="radio" name="quitYn" value="Y" checked>Y <input type="radio" name="quitYn" value="N" checked>N</td>
            </tr>
            <tr>
               <td colspan="2" align="center">
                  <!-- <button onclick="return validate();">가입하기</button> -->
                  <input type="submit" value="정보수정">
                  <button type="button" onclick="location.href='index.do';">홈으로</button>
               </td>
            </tr>
         </table>
      </form>
      </section>
      </section>
   </div>
    <script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
    <script>
      $(function() {
         $("#postcodify_search_button").postcodifyPopUp();
      });
      
     /*  $("#userId").on("blur", function() {
         var userId = $("#userId").val();
         $.ajax({
            url : "dupId.kh",
            data : { "userId" : userId },
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
         
      }); */
   </script> 
</body>
</html>