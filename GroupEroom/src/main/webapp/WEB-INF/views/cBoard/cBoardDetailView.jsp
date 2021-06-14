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
<style>
.msg{
border:1px solid lightgray;
padding:0px 25px 0px 25px;
-webkit-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
 -moz-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
 -o-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
 box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
 -webkit-transition: all 0.5s ease-in;
 -moz-transition: all 0.5s ease-in;
 -o-transition: all 0.5s ease-in;
 -ms-transition: all 0.5s ease-in;
 transition: all 0.5s ease-in;
}
.memberImage{
 	width: 50px;
    height: 50px; 
    border-radius: 70%;
	padding:0px;
	maring:0px;
	border:1px solid lightgray;
} 
.td1{
	margin:0px 0px 0px 0px;
	padding:0px;
}
</style>
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
                <div style="margin:0px 50px 0px 50px">
                <div class="msg">
					<h3><b>#${cBoard.cBoardNo }_${cBoard.cBoardTitle }</b></h3><br>
					<div>
						<div style="float:left; width:5%" >
						<c:if test="${null ne cBoard.memberImage}">
							<img class='memberImage' src="/resources/memberproFile/${cBoard.memberImage }">
						</c:if>
						<c:if test="${ null eq cBoard.memberImage }">
							<i style='font-size:50px; color:lightgray' class='fa fa-user-circle'></i>
						</c:if>
						</div>
						<div style="float:left; width:47%; font-size:15px"><span class="label label-warning">${cBoard.memberDept }</span><br> ${cBoard.memberName } ${cBoard.memberJob }</div>
						<div align="right" style="float:left; width:48% "><br><i class="fa fa-calendar-o"></i> 작성일 : ${cBoard.enrollDate} &nbsp; <i class="fa fa-eye"></i>조회수 : ${cBoard.hits }</div>
					</div>
					
					<br><br>
					<hr style="border : 1px solid; color:#4ECDC4; background:#4ECDC4">
					<div style="font-size:15px">${cBoard.cBoardContents }</div><br>
					<i class="fa fa-paperclip"></i>첨부 파일 : <a href="/resources/cBoardFiles/${cBoard.renameFileName }" download>${cBoard.originalFileName}</a><br><br>
				</div><br><br>
					
					<div style="padding:10px; border:1px solid lightgrey; font-size:15px">
					<table style="width:100%" id="rtb">
						<thead>
							<tr>
								<!-- 댓글 갯수 -->
								<td colspan="2"><b style='color:#4ECDC4'id="rCount"></b></td>
							</tr>
						</thead>
						<tbody>
						<!-- 댓글 나오는 칸 -->
						</tbody>
					</table>
					</div><br>
					
					
					<table style="width:100%">
						<tr>
							<td style="width:90%">
								<textarea placeholder="댓글을 입력해 주세요" class="form-control" style="width:100%" id="rContent" name="comment" required></textarea>
							</td>
							<td style="width:10%" align="right">
								<button class="btn btn-theme02" id="rSubmit"><i class="fa fa-pencil"></i> 댓글 등록</button>
							</td>
						</tr>
					</table>
				<br><br><br>
				<c:if test="${LoginUser.memberId==cBoard.memberId }">
					<div align="right">
						<c:url var="cBoardModify" value="cBoardModifyView.do">
							<c:param name="cBoardNo" value="${cBoard.cBoardNo }"></c:param>
						</c:url>
							<a href="${cBoardModify }"  style="color:white" class="btn btn-theme03"><i class="fa fa-edit"></i> 수정</a>
						
						<c:url var="cBoardDelete" value="cBoardDelete.do">
							<c:param name="cBoardNo" value="${cBoard.cBoardNo }"></c:param>
							<c:param name="renameFileName" value="${cBoard.renameFileName }"></c:param>
						</c:url>
							<a href="${cBoardDelete }" style="color:white" class="btn btn-theme04" id="delete-btn"><i class="fa fa-trash"></i> 삭제</a>
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
			var writer = '${cBoard.memberName}'
			var boardNo = '${cBoard.cBoardNo }';
			var loginUser = '${LoginUser.memberId}';
			$.ajax({
				url : "cBoardReply.do",
				type : "get",
				data : { "cBoardNo" : boardNo },
				dataType : "json",
				success : function(data) {
					var $tableBody = $("#rtb tbody");
					$tableBody.html(""); // 비워주기
					var $tr;
					var $rWriter;
					var $rContent;
					var $rCreateDate;
					var $btnArea;
					var $td;
					$("#rCount").html("<i class='fa fa-comments-o'></i> 댓글 (" + data.length + ")"); // 댓글 갯수 표시
					if(data.length > 0) {
						for(var i in data) {
							$tr = $("<tr>");
							if(data[i].step > 0){
								$td = $("<td></td>");
								if(data[i].memberImage == null){
									$rWriter = $("<td align='center' style='width:1%;'>").html("<i style='font-size:50px; color:lightgray' class='fa fa-user-circle'></i>");
									$tr.append($td);
									$tr.append($rWriter);
									if(data[i].memberName == writer ){
										$rContent = $("<td style='padding:0px 0px 0px 20px'>").html("<span style='font-weight:bold;'>"+data[i].memberName+"<span style='color:#da4453'> (작성자)</span></span><br>"+data[i].replyContent+"<br>");
									}else{
										$rContent = $("<td style='padding:0px 0px 0px 20px'>").html("<span style='font-weight:bold;'>"+data[i].memberName+"</span><br>"+data[i].replyContent+"<br>");
									}
								}else{
									$rWriter = $("<td align='center' style='width:1%'>").html("<img class='memberImage' src='/resources/memberproFile/"+data[i].memberImage+"'></td>");
									$tr.append($td);
									$tr.append($rWriter);
									if(data[i].memberName == writer){
										$rContent = $("<td style='padding:0px 0px 0px 20px'>").html("<span style='font-weight:bold'>"+data[i].memberName+"<span style='color:#da4453'> (작성자)</span></span><br>"+data[i].replyContent+"<br>");
									}else{
										$rContent = $("<td style='padding:0px 0px 0px 20px'>").html("<span style='font-weight:bold'>"+data[i].memberName+"</span><br>"+data[i].replyContent+"<br>");
									}
								}
							}else{
								if(data[i].memberImage == null){
									
									$rWriter = $("<td align='center' style='width:8%'>").html("<i style='font-size:50px; color:lightgray' class='fa fa-user-circle'></i>");
									$tr.append($rWriter);
									if(data[i].memberName == writer ){
										$rContent = $("<td colspan='2'>").html("<span style='font-weight:bold;'>"+data[i].memberName+"<span style='color:#da4453'> (작성자)</span></span><br>"+data[i].replyContent+"<br>");
									}else{
										$rContent = $("<td colspan='2'>").html("<span style='font-weight:bold;'>"+data[i].memberName+"</span><br>"+data[i].replyContent+"<br>");
									}
								}else{
									$rWriter = $("<td align='center' style='width:8%'>").html("<img class='memberImage' src='/resources/memberproFile/"+data[i].memberImage+"'></td>");
									$tr.append($rWriter);
									if(data[i].memberName == writer){
										$rContent = $("<td colspan='2'>").html("<span style='font-weight:bold'>"+data[i].memberName+"<span style='color:#da4453'> (작성자)</span></span><br>"+data[i].replyContent+"<br>");
									}else{
										$rContent = $("<td colspan='2'>").html("<span style='font-weight:bold'>"+data[i].memberName+"</span><br>"+data[i].replyContent+"<br>");
									}
								}
							}
									
									
									
									
									
							$rContent.append("<span style='font-size:10px'>"+data[i].rCreateDate+"  &nbsp&nbsp <a style='color:gray' href='#' onclick='replyChild(this,"+boardNo+","+data[i].family+","+data[i].step+")'>답글쓰기</a></span><br>");
							/* $rCreateDate = $("<td align='right' style='font-size:8px'>").text(data[i].rCreateDate); */
							if(data[i].memberId == loginUser){
								$btnArea = $("<td align='right' style='width:10%'>")
								.append("<a style='color:lightgray' href='#' id='modfiy-btn' onclick='modifyReply(this,"+boardNo+","+data[i].replyNo+",\""+data[i].replyContent+"\");'>수정 </a>")							
								.append("<a style='color:lightgray' href='#' onclick='removeReply("+boardNo+","+data[i].replyNo+");'> 삭제</a>");
							}else {
								$btnArea = $("<td align='right'>")
							}
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
		
		
		function replyChild(obj, boardNo, family, step){
			$tr = $("<tr><td></td>");
			$td = $("<td colspan='2'><input id='replyChild' type='text' class='form-control' placeholder='답글을 입력해 주세요' ></td><td align='right'><button onclick='addReplyChild("+boardNo+","+family+","+step+")' class='btn btn-theme'>답글 등록</button></td>");
			$tr.append($td);
			$(obj).parent().parent().parent().after($tr);
		}
		
		function addReplyChild(boardNo, family, step){
			var replyChild = $("#replyChild").val();
			$.ajax({
				url : "cBoardAddReplyChild.do",
				type : "post",
				data : { 
					"cBoardNo" : boardNo , 
					"family" : family, 
					"step" : step,
					"replyContent" : replyChild 
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