<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근태관리</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/style2.css" rel="stylesheet">
<link href="resources/css/to-do.css" rel="stylesheet">
<link href="resources/js/font-awesome/css/font-awesome.css" rel="stylesheet" />
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
                  <h5><i class="fa fa-tasks"></i> 할 일 </h5>
                </div>
              </div><br><hr>          
              <div class="panel-body">
                <div class="task-content">
                  <ul class="task-list">
                      <!-- =============== -->
                    <li>
                      <div class="task-title">
                        <span class="badge bg-theme">보통</span>
                        <span class="task-title-sp">Dashio - Admin Panel & Front-end Theme</span>
                        <div class="pull-right hidden-phone">
                          <button class="btn btn-success btn-xs"><i class=" fa fa-check"></i></button>
                          <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                          <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                        </div>
                      </div>
                    </li>
                    <!-- =============== -->
                    <li>
                      <div class="task-title">
                        <span class="badge bg-warning">높음</span>
                        <span class="task-title-sp">Extensive collection of plugins</span>
                        <div class="pull-right hidden-phone">
                          <button class="btn btn-success btn-xs"><i class=" fa fa-check"></i></button>
                          <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                          <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                        </div>
                      </div>
                    </li>
                    <!-- =============== -->
                    <li>
                      <div class="task-title">
                        <span class="badge bg-success">낮음</span>
                        <span class="task-title-sp">Free updates always, no extra fees.</span>
                        <div class="pull-right hidden-phone">
                          <button class="btn btn-success btn-xs"><i class=" fa fa-check"></i></button>
                          <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                          <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                        </div>
                      </div>
                    </li>
                    <!-- =============== -->
                    <li>
                      <div class="task-title">
                        <span class="badge bg-info">보통</span>
                        <span class="task-title-sp">More features coming soon</span>
                        <div class="pull-right hidden-phone">
                          <button class="btn btn-success btn-xs"><i class=" fa fa-check"></i></button>
                          <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                          <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                        </div>
                      </div>
                    </li>
                    <!-- =============== -->
                    <li>
                      <div class="task-title">
                        <span class="badge bg-important">매우 높음</span>
                        <span class="task-title-sp">Hey, seriously, you should buy this Dashboard</span>
                        <div class="pull-right">
                          <button class="btn btn-success btn-xs"><i class=" fa fa-check"></i></button>
                          <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                          <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                        </div>
                      </div>
                    </li>
                  </ul>
                </div>
                <div class=" add-task-row">
                  <a class="btn btn-success btn-sm pull-left" href="todo_list.html#">추가</a>
                </div>
              </div>
            </section>
          </div>
          <!-- /col-md-12-->
        </div>
		</section>
	</section>
















</body>
</html>