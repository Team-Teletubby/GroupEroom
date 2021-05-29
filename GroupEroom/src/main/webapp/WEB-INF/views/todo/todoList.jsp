<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근태관리</title>
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
									<li>
										<div class="task-title">
											<span class="badge bg-theme">보통</span> <span
												class="task-title-sp">Dashio - Admin Panel &
												Front-end Theme</span>
											<div class="pull-right hidden-phone">
												<button class="btn btn-success btn-xs">
													<i class=" fa fa-check"></i>
												</button>
												<button class="btn btn-primary btn-xs">
													<i class="fa fa-pencil"></i>
												</button>
												<button class="btn btn-danger btn-xs">
													<i class="fa fa-trash-o "></i>
												</button>
											</div>
										</div>
									</li>
									<!-- =============== -->
									<li>
										<div class="task-title">
											<span class="badge bg-warning">높음</span> <span
												class="task-title-sp">Extensive collection of plugins</span>
											<div class="pull-right hidden-phone">
												<button class="btn btn-success btn-xs">
													<i class=" fa fa-check"></i>
												</button>
												<button class="btn btn-primary btn-xs">
													<i class="fa fa-pencil"></i>
												</button>
												<button class="btn btn-danger btn-xs">
													<i class="fa fa-trash-o "></i>
												</button>
											</div>
										</div>
									</li>
									<!-- =============== -->
									<li>
										<div class="task-title">
											<span class="badge" style="background: yellowgreen">낮음</span>
											<span class="task-title-sp">Free updates always, no
												extra fees.</span>
											<div class="pull-right hidden-phone">
												<button class="btn btn-success btn-xs">
													<i class=" fa fa-check"></i>
												</button>
												<button class="btn btn-primary btn-xs">
													<i class="fa fa-pencil"></i>
												</button>
												<button class="btn btn-danger btn-xs">
													<i class="fa fa-trash-o "></i>
												</button>
											</div>
										</div>
									</li>
									<!-- =============== -->
									<li>
										<div class="task-title">
											<span class="badge bg-theme">보통</span> <span
												class="task-title-sp">More features coming soon</span>
											<div class="pull-right hidden-phone">
												<button class="btn btn-success btn-xs">
													<i class=" fa fa-check"></i>
												</button>
												<button class="btn btn-primary btn-xs">
													<i class="fa fa-pencil"></i>
												</button>
												<button class="btn btn-danger btn-xs">
													<i class="fa fa-trash-o "></i>
												</button>
											</div>
										</div>
									</li>
									<!-- =============== -->
									<li>
										<div class="task-title">
											<span class="badge bg-important">매우 높음</span> <span
												class="task-title-sp">Hey, seriously, you should buy
												this Dashboard</span>
											<div class="pull-right">
												<button class="btn btn-success btn-xs">
													<i class=" fa fa-check"></i>
												</button>
												<button class="btn btn-primary btn-xs">
													<i class="fa fa-pencil"></i>
												</button>
												<button class="btn btn-danger btn-xs">
													<i class="fa fa-trash-o "></i>
												</button>
											</div>
										</div>
									</li>
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
					</section>
				</div>
				<!-- /col-md-12-->
			</div>
		</section>
	</section>



	<script>
		$(function() {
			$("#regTodo").on("click", function() {
				var todoPriority = $("input:radio[name='todoPriority']:checked").val();
				var todoContents = $("#todoContents").val();
				alert(todoPriority);
				alert(todoContents);
				$.ajax({
					url : "todoRegister.do",
					type : "post",
					data : { "todoContents" : todoContents , "todoPriority" : todoPriority},
					success : function(data) {
						if(data == "success") {
							alert("성공");
						}else {
							alert("댓글 등록 실패..");
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
				url : "todoList.do",
				type : "get",
				dataType : "json",
				success : function(data) {
					// db에 있는 데이터를 json형태로 가져와서
					// 댓글 목록 테이블의 tbody에 넣어주어야 함.
					//console.log(data);
					// tbody에 필요한 tr, td 태그를 만들면서
					// 데이터를 tbody에 꽂아줄 것임.
					var $ulTodo = $("#ul-todo");
					$ulTodo.html(""); // 비워주기
					var $li;
					var $div;
					var $priority;
					var $contents;
					var $btnArea;
					if(data.length > 0) {
						for(var i in data) {
							$li = $("<li>");
							$div = $("<div class='task-title'>");
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
	</script>













</body>
</html>