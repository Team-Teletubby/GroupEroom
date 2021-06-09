<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할 일</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/style2.css" rel="stylesheet">
<link href="resources/css/to-do.css" rel="stylesheet">
<link href="resources/js/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sideBar.jsp"></jsp:include>
	<section id="main-content">
		<section class="wrapper">
			<h3>
				<i class="fa fa-angle-right"></i>할 일 목록
			</h3>
			<div class="row mt">
				<div class="col-md-12">
					<section class="task-panel tasks-widget">
						<div class="panel-heading">
							<div class="pull-left">
								<h5>
									<i class="fa fa-tasks"></i> 할 일
								</h5>
							</div>
						</div>
						<br>
						<hr>
						<div class="panel-body">
							<div class="task-content">
								<ul class="task-list" id="ul-todo">
									<!-- =============== -->
								</ul>
							</div>
							<hr>
							<div class=" add-task-row">
								<table style="width: 100%">
									<tr>
										<td>
										<input value="1" type="radio" class="btn-check" name="todoPriority" id="danger-outlined" autocomplete="off" checked>
										<label style="border:solid 1px;"class="btn btn-outline-danger" for="danger-outlined">아주높음</label>
										
										<input value="2" type="radio" class="btn-check" name="todoPriority" id="warning-outlined" autocomplete="off">
										<label style="border:solid 1px" class="btn btn-outline-warning" for="warning-outlined">높음</label>
										
										<input value="3" type="radio" class="btn-check" name="todoPriority" id="normal-outlined" autocomplete="off" >
										<label style="border:solid 1px" class="btn btn-outline-info" for="normal-outlined">보통</label>
										
										<input value="4" type="radio" class="btn-check" name="todoPriority" id="success-outlined" autocomplete="off" >
										<label style="border:solid 1px" class="btn btn-outline-success" for="success-outlined">낮음</label>
										
										</td>
										<td><textarea name="todoContents" id="todoContents" class="form-control" cols="100"></textarea></td>
										<td align="center"><a id="regTodo"
											class="btn btn-theme02">추가</a></td>
									</tr>
								</table>
							</div>
						</div>
						<!-- <table id="test">
						
						</table> -->
					</section>
				</div>
				<!-- /col-md-12-->
			</div>
		</section>
	</section>



	<script>
		$(function() {
			getTodoList();
			$("#regTodo").on("click", function() {
				var todoPriority = $("input:radio[name='todoPriority']:checked").val();
				var todoContents = $("#todoContents").val();
				$.ajax({
					url : "todoRegister.do",
					type : "post",
					data : { "todoContents" : todoContents , "todoPriority" : todoPriority},
					success : function(data) {
						if(data == "success") {
							getTodoList();
						}else {
							alert("실패..");
						}
					},
					error : function() {
						
					}
				});
			});
		});
		
		
		/* 할 일 목록 출력=============  */
		function getTodoList() {
			$.ajax({
				url : "todoListView.do",
				type : "get",
				dataType : "json",
				success : function(data) {
					var $ul = $("#ul-todo");
					$ul.html("");
					if(data.length>0){
						for(var i in data) {
							$li = $("<li>");
							
							$div1 = $("<div class='task-title'>");
							
							if(data[i].todoPriority == 1){
								$priority = $("<span style='margin:0 5px 0 0' class='badge bg-important'>").text("매우 높음 ");
							}else if(data[i].todoPriority == 2){
								$priority = $("<span style='margin:0 5px 0 0' class='badge bg-warning'>").text("높음 ");
							}else if(data[i].todoPriority == 3){
								$priority = $("<span style='margin:0 5px 0 0' class='badge bg-theme'>").text("보통 ");
							}else if(data[i].todoPriority == 4){
								$priority = $("<span class='badge' style='background: yellowgreen; margin:0 5px 0 0'>").text("낮음 ");
							}
							
							if(data[i].todoState == 'Y'){
								$contents = $("<span style='color:lightgray; text-decoration:line-through' class='task-title-sp'>").text(data[i].todoContents);
							}else {
								$contents = $("<span class='task-title-sp'>").text(data[i].todoContents);
							}
							
							$div2 = $("<div class='pull-right hidden-phone'>");
							$btn1 = $("<button onclick='updateState("+data[i].todoNo+")'class='btn btn-success btn-xs' style='margin:2px'><i class='fa fa-check'></i>");
							$btn2 = $("<button onclick='modifyForm(this,"+data[i].todoNo+","+data[i].todoPriority+","+"\""+data[i].todoContents+"\")'class='btn btn-primary btn-xs'style='margin:2px'><i class='fa fa-pencil'></i>");
							$btn3 = $("<button onclick='removeTodo("+data[i].todoNo+")' class='btn btn-danger btn-xs'style='margin:2px'><i class='fa fa-trash-o'></i>");
							
							$li.append($div1);
							$div1.append($priority);
							$div1.append($contents);
							$div1.append($div2);
							$div2.append($btn1);
							$div2.append($btn2);
							$div2.append($btn3);
							$ul.append($li);
						}
					}
				},
				error : function() {
					
				}
			});
		}
		
		/* 삭제=============  */
		function removeTodo(todoNo){
			$.ajax({
				url : "removeTodo.do",
				type : "get",
				data : {"todoNo" : todoNo },
				success : function(data) {
					if(data == "success") {
						getTodoList();
					}else {
						alert("삭제실패");
					}
				},
				error : function() {
					
				}
				
			});
		}
		
		
		/* 완료로 업데이트=============  */
		function updateState(todoNo) {
 			$.ajax({
				url : "updateState.do",
				type : "get",
				data : {"todoNo" : todoNo },
				success : function(data) {
					if(data == "success") {
						getTodoList();
					}else {
						alert("완료실패");
					}
				},
				error : function() {
					
				}
			});
		}
		
		
		/* 수정 폼 나오기=============  */
		function modifyForm(obj,todoNo, todoPriority, todoContents){
			$contents = $("<input id='modifyText' onblur='modifyTodo("+todoNo+","+"\""+todoContents+"\")' style='width:80%; border:0px; outline-style: none;' type='text' value='"+todoContents+"'>");
			$(obj).parent().after($contents);
			$(obj).parent().parent().children().eq(1).remove();
			$(obj).parent().remove();
		}
		
		/* 수정 하기=============  */
		function modifyTodo(todoNo, todoContents){
			todoContents = $("#modifyText").val();
			$.ajax({
				url : "updateTodo.do",
				type : "post",
				data : {
						"todoNo" : todoNo,
						"todoContents" : todoContents
						/* "todoPriority": todoPriority, */
						},
				success : function(data) {
					if(data == "success"){
						getTodoList();
					}else if(data =="fail"){
						alert("실패");
					}
				}
			});
		}
	</script>













</body>
</html>