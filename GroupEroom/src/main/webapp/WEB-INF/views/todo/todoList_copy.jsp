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
											<span class="badge bg-warning">높음</span>
											<span class="task-title-sp">할 일 1</span>
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
											<span class="task-title-sp">할일 2</span>
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
											<span class="badge bg-theme">보통</span>
											<span class="task-title-sp">할 일 3</span>
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
											<span class="badge bg-important">매우 높음</span>
											<span class="task-title-sp">할일 4</span>
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
						<table id="test">
						
						</table>
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
					alert("getTodoList 들오오");
					var $ul = $("#ul-todo");
					if(data.length>0){
						for(var i in data) {
							$tr = $("<div>");
							$contents = $("<td>").text(data[i].todoContents);
							$tr.append($contents);
							$table.append($tr);
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