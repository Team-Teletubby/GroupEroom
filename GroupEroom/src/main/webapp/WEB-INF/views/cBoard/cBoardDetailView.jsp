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
<title>동호회 게시판</title>

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
        <h3><i class="fa fa-angle-right"></i>게시판</h3>
        <div class="row">
          <div class="col-md-12">
            <div class="content-panel">
              <h4><i class="fa fa-angle-right"></i> 동호회 게시판</h4>
                <hr>
                <div style="margin:0px 100px 50px 100px; padding:20px; border:1px solid lightgray">
					<h3>#${cBoard.cBoardNo }_${cBoard.cBoardTitle }</h3><br>
					<div style="font-size:15px">
					<span style="align:left">작성자 : ${cBoard.memberName }</span>
					<span style="float:right">작성일 : ${cBoard.enrollDate} 조회수 : ${cBoard.hits }</span>
					</div>
					<div style="padding:50px; border:1px solid lightgrey; font-size:15px">${cBoard.cBoardContents }</div>
					첨부 파일 : ${cBoard.originalFileName}<br><br>
					<div style="padding:10px; border:1px solid lightgrey; font-size:15px">
					
					<table style="width:100%" id="rtb">
						<thead>
							<tr>
								<!-- 댓글 갯수 -->
								<td colspan="2"><b id="rCount"></b></td>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
					</div><br>
					
					
					<table style="width:100%">
						<tr>
							<td style="width:90%">
								<textarea class="form-control" style="width:100%" id="rContent" name="comment" required></textarea>
							</td>
							<td style="width:10%" align="right">
								<button class="btn btn-theme" id="rSubmit">등록하기</button>
							</td>
						</tr>
					</table>
				<br><br><br>
				<c:if test="${LoginUser.memberId==cBoard.memberId }">
					<div align="right">
						<c:url var="cBoardModify" value="cBoardModifyView.do">
							<c:param name="cBoardNo" value="${cBoard.cBoardNo }"></c:param>
						</c:url>
							<a href="${cBoardModify }" class="btn btn-theme02">수정</a>
						
						<c:url var="cBoardDelete" value="cBoardDelete.do">
							<c:param name="cBoardNo" value="${cBoard.cBoardNo }"></c:param>
							<c:param name="renameFileName" value="${cBoard.renameFileName }"></c:param>
						</c:url>
							<a href="${cBoardDelete }" class="btn btn-theme04" id="delete-btn">삭제</a>
					</div><br>
				</c:if>
					
					<div align="center">
						<a href="cBoardListView.do" class="btn btn-default">목록</a>
					</div>
				</div>
            </div>
          </div>
        </div>
       </section>
      </section>
      
      <script>
		$(function() {
			getReplyList();
			$("#rSubmit").on("click", function() {
				var boardNo = '${cBoard.cBoardNo }';
				var rContent = $("#rContent").val();
				$.ajax({
					url : "cBoardAddReply.do",
					type : "post",
					data : { "cBoardNo" : boardNo , "replyContent" : rContent},
					success : function(data) {
						if(data == "success") {
							// 댓글 불러오기
							getReplyList();
							// 작성 후 내용 초기화
							$("#rContent").val("");
						}else {
							alert("댓글 등록 실패..");
						}
					},
					error : function() {
						
					}
				});
			});
		});
		
		function getReplyList() {
			var boardNo = '${cBoard.cBoardNo }';
			var loginUser = '${LoginUser.memberId}';
			$.ajax({
				url : "cBoardReply.do",
				type : "get",
				data : { "cBoardNo" : boardNo },
				dataType : "json",
				success : function(data) {
					// db에 있는 데이터를 json형태로 가져와서
					// 댓글 목록 테이블의 tbody에 넣어주어야 함.
					//console.log(data);
					// tbody에 필요한 tr, td 태그를 만들면서
					// 데이터를 tbody에 꽂아줄 것임.
					var $tableBody = $("#rtb tbody");
					$tableBody.html(""); // 비워주기
					var $tr;
					var $rWriter;
					var $rContent;
					var $rCreateDate;
					var $btnArea;
					$("#rCount").text("댓글 (" + data.length + ")"); // 댓글 갯수 표시
					if(data.length > 0) {
						for(var i in data) {
							$tr = $("<tr>");
							$rWriter = $("<td>").text(data[i].memberName);
							$rContent = $("<td>").text(data[i].replyContent);
							$rCreateDate = $("<td align='right'>").text(data[i].rCreateDate);
							if(data[i].memberId == loginUser){
								$btnArea = $("<td align='right'>")
								.append("<a href='#' id='modfiy-btn' onclick='modifyReply(this,"+boardNo+","+data[i].replyNo+",\""+data[i].replyContent+"\");'>수정 </a>")							
								.append("<a href='#' onclick='removeReply("+boardNo+","+data[i].replyNo+");'> 삭제</a>");
							}else {
								$btnArea = $("<td align='right'>")
							}
							$tr.append($rWriter);
							$tr.append($rContent);
							$tr.append($rCreateDate);
							$tr.append($btnArea);
							$tableBody.append($tr);
						}
					}
				},
				error : function() {
					
				}
			});
		}
		
		function modifyReply(obj, boardNo, replyNo, replyContent) {
			/* $("#modify-btn").css(display,none); */
			$trModify = $("<tr>");
			$trModify.append("<td></td>");
			$trModify.append("<td colspan='2'><input type='text'class='form-control' id='modifyReply' size='50' value='"+replyContent+"'></td>");
			$trModify.append("<td align='right'><button class='btn btn-theme02' onclick='modifyReplyCommit("+boardNo+","+replyNo+")'>수정완료</button></td>");
			$(obj).parent().parent().after($trModify);
		}
		function modifyReplyCommit(boardNo, replyNo) {
			var modifiedContent = $("#modifyReply").val();
			$.ajax({
				url : "cBoardModifyReply.do",
				type : "post",
				data : { 
					"cBoardNo" : boardNo , 
					"replyNo" : replyNo, 
					"replyContent" : modifiedContent 
				},
				success : function(data) {
					if(data == "success") {
						getReplyList();
					}else{
						alert("댓글 수정 실패!");
					}
				},
				error : function() {
					alert("서버 통신 실패!");
				}
			});
			
		}
		
		function removeReply(boardNo, replyNo) {
			var con_test = confirm("댓글을 삭제하시겠습니까?");
			if(con_test == true){
			    alert("삭제 되었습니다.")
			}
			else if(con_test == false){
			   return false;
			}
			$.ajax({
				url : "cBoardDeleteReply.do",
				type : "get",
				data : { "cBoardNo" : boardNo, "replyNo" : replyNo },
				success : function(data) {
					if(data == "success"){
						getReplyList();
					}else {
						alert("댓글 조회 실패!");
					}
				},
				error : function() {
					
				}
			});
		}
      </script>
</body>
<jsp:include page="../common/footerScript.jsp"></jsp:include>
</html>