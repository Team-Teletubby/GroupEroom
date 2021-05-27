<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원등록</title>
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
	<jsp:include page="../common/header.jsp"></jsp:include>
   <jsp:include page="../common/sideBar.jsp"></jsp:include>
   
       <section id="main-content">
      <section class="wrapper">
   <h1 align="center">사원등록</h1>
   <div class="centerText">
      <form action="memberRegister.do" method="post">
         <table width="650" cellspacing="5">
            <tr>
               <td>* 부서</td>
            <!--    <td><input class="form-control" type="text" name="memberDept"></td> -->
           <td><select name="memberDept">
								<option value="인사관리">인사관리</option>
								<option value="IT개발">IT개발</option>
								<option value="영업">영업</option>
								<option value="재무" selected="selected">재무</option></td>
            </tr>
            <tr>
               <td>* 직급</td>
               <!-- <td><input class="form-control" type="text" name="memberJob"></td> -->
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
            </tr>
            <tr>
               <td>* 이름</td>
               <td><input class="form-control" type="text" name="memberName"></td>
            </tr>
            <tr>
               <td>* 주민등록 번호</td>
               <td><input class="form-control" type="text" name="memberRrn"></td>
            </tr>
            <tr>
               <td>* 폰번호</td>
               <td><input class="form-control" type="text" name="memberPhone"></td>
            </tr>
            <tr>
               <td>우편번호</td>
               <td>
                  <input type="text" name="post"  size="6" class="postcodify_postcode5" value="">
                  <button type="button" id="postcodify_search_button">검색</button>
               </td>
            </tr>
            <tr>
               <td>도로명 주소</td>
               <td><input type="text" name="address1" class="postcodify_address" value="" ></td>
            </tr>
            <tr>
               <td>상세 주소</td>
               <td><input type="text" name="address2" class="postcodify_extra_info" value="" ></td>
            </tr>
             <tr>
               <td>은행</td>
               <td><input type="text" class="form-control" name="bank"></td>
            </tr>
             <tr>
               <td>계좌번호</td>
               <td><input type="text" class="form-control" name="bankAccount" placeholder="-넣고 오류난다고 하지 않기"></td>
            </tr>
             <tr>
               <td>이메일</td>
               <td><input type="email" class="form-control" name="memberEmail"></td>
            </tr>
			
            <tr>
               <td colspan="2" align="center">
                  <!-- <button onclick="return validate();">가입하기</button> -->
                  <input type="submit" value="사원등록">
                  <button type="button" onclick="location.href='index.do';">홈으로</button>
               </td>
            </tr>
         </table>
      </form>
   </div>
   </section>
   </section>
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