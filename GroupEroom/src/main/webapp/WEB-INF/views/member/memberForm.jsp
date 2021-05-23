<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   <jsp:include page="../common/sideBar.jsp"></jsp:include>
   <h1 align="center">사원등록</h1>
   <div class="centerText">
      <form action="memberRegister.do" method="post">
         <table width="650" cellspacing="5">
            <tr>
               <td>* 부서</td>
               <td><input type="text" name="memberDept"></td>
            </tr>
            <tr>
               <td>* 직급</td>
               <td><input type="text" name="memberJob"></td>
            </tr>
            <tr>
               <td>* 이름</td>
               <td><input type="text" name="memberName"></td>
            </tr>
            <tr>
               <td>* 주민등록 번호</td>
               <td><input type="text" name="memberRrn"></td>
            </tr>
            <tr>
               <td>* 폰번호</td>
               <td><input type="text" name="memberPhone"></td>
            </tr>
            <tr>
               <td>우편번호</td>
               <td>
                  <input type="text" name="post" class="postcodify_postcode5" size="6">
                  <button type="button" id="postcodify_search_button">검색</button>
               </td>
            </tr>
            <tr>
               <td>도로명 주소</td>
               <td><input type="text" name="address1" class="postcodify_address"></td>
            </tr>
            <tr>
               <td>상세 주소</td>
               <td><input type="text" name="address2" class="postcodify_extra_info"></td>
            </tr>
             <tr>
               <td>은행</td>
               <td><input type="text" name="Bank"></td>
            </tr>
             <tr>
               <td>계좌번호</td>
               <td><input type="text" name="Account"></td>
            </tr>
             <tr>
               <td>이메일</td>
               <td><input type="email" name="memberEmail"></td>
            </tr>

            <tr>
               <td colspan="2" align="center">
                  <!-- <button onclick="return validate();">가입하기</button> -->
                  <input type="submit" value="사원등록">
                  <button type="button" onclick="location.href='index';">홈으로</button>
               </td>
            </tr>
         </table>
      </form>
   </div>
<!--    <script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
   <script>
      $(function() {
         $("#postcodify_search_button").postcodifyPopUp();
      });
      
      $("#userId").on("blur", function() {
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
         
      });
   </script> -->
</body>
</html>