<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/style2.css" rel="stylesheet">
<meta charset="UTF-8">
<title>공지사항</title>

<script>
$(document).ready(function(){
	$("#delete-btn").on("click", function () {
			if(confirm("게시글을 삭제하시겠습니까?")==false){
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
        <h3><i class="fa fa-angle-right"></i>공지사항</h3>
        <div class="row">
          <div class="col-md-12">
            <div class="content-panel">
              <h4><i class="fa fa-angle-right"></i> 공지글</h4>
                <hr>
                <div style="margin:0px 100px 50px 100px; padding:20px; border:1px solid lightgray">
					<h3>#${notice.noticeNo }번글:${notice.noticeTitle }</h3><br>
					<div style="font-size:15px">
					<span style="align:left">작성자 : ${notice.memberName }</span>
					<span style="float:right">작성일 : ${notice.enrollDate} 조회수 : ${notice.hits }</span>
					</div>
					<div style="padding:50px; border:1px solid lightgrey; font-size:15px">${notice.noticeContents }</div>
					<i class="fa fa-paperclip"></i>첨부 파일 : <a href="/resources/noticeFiles/${notice.renameFileName }" download>${notice.originalFileName}</a><br><br>
					
					
				
				<br><br><br>
				<c:if test="${LoginUser.memberId==notice.memberId }">
					<div align="right">
						<c:url var="noticeModify" value="noticeModifyView.do">
							<c:param name="noticeNo" value="${notice.noticeNo }"></c:param>
						</c:url>
							<a href="${noticeModify }" class="btn btn-theme03">수정</a>
						
						<c:url var="noticeDelete" value="noticeDelete.do">
							<c:param name="noticeNo" value="${notice.noticeNo }"></c:param>
							<c:param name="renameFileName" value="${notice.renameFileName }"></c:param>
						</c:url>
							<a href="${noticeDelete }" class="btn btn-theme02" id="delete-btn">삭제</a>
					</div><br>
				</c:if>
					
					<div align="center">
						<a href="noticeListView.do" class="btn btn-default">목록</a>
					</div>
				</div>
            </div>
          </div>
        </div>
       </section>
      </section>
      
     
    
</body>
<jsp:include page="../common/footerScript.jsp"></jsp:include>
</html>