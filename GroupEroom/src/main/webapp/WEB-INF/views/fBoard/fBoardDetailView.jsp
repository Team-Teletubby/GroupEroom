<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sideBar.jsp"></jsp:include>

	<section id="main-content">
		<section class="wrapper">
			<h3>
				<i class="fa fa-angle-right"></i> 자유게시판
			</h3>
			<div class="row">
				<div class="col-md-12">
					<div class="content-panel">
						<h4>
							<i class="fa fa-angle-right"></i> ${ fBoard.fBoardNo }번 글 상세보기
						</h4>
						<br>
						<!-- #############소스 적용 중############### -->
						<div class="panel-body">
							<div class="mail-header row">
								<div class="col-md-8">
									<p name="fBullet">${fBoard.fBullet }</p>
									<h4 class="pull-left" name="fBoardTitle">${fBoard.fBoardTitle }</h4>
								</div>
							</div>
							<div class="mail-sender">
								<div class="row">
									<div class="col-md-8">
										<span>작성자</span> <strong name="fWriter">${fBoard.fWriter }</strong>
									</div>
									<div class="col-md-8">
										<span>작성일자</span> <strong name="fWriter">${fBoard.enrollDate }</strong>&nbsp;&nbsp;&nbsp;|&nbsp;
										<span>조회수</span> <strong name="fWriter">${fBoard.hits }</strong>
									</div>
								</div>
							</div>
							<div>
								<div name="fBoardContents" height="500">${ fBoard.fBoardContents }
								</div>
							</div>
							<div class="attachment-mail">
								<p>
									<span><i class="fa fa-paperclip"></i> 첨부파일 </span> <a href="#">Download
										all attachments</a>
								</p>
								<ul>
								</ul>
							</div>
							<div class="compose-btn pull-left">
								<button onclick="location.href='fBoardListView.do'" class="btn btn-theme03">목록으로</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</section>
</body>
</html>