<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<!-- include libraries(jQuery, bootstrap) -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet"> 
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/js/summernote-ko-KR.js"></script>
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
			<div class="row"></div>
			<div class="row">
				<div class="col-md-12">
					<div class="content-panel">
						<h4>
							<i class="fa fa-angle-right"></i> 게시글 작성
						</h4>
						<br>
						<form action="fBoardRegister.do" method="post" enctype="multipart/form-data">
							<fieldset>
								<label for="exampleInputEmail1" class="form-label mt-4">말머리 구분</label>
								<div class="form-group">
							        <label class="form-check-label">
							          <input type="radio" class="form-check-input" name="fBullet" id="bullet1" value="일반" checked="">
							          일반&nbsp;&nbsp;
							        </label>
							        <label class="form-check-label">
							          <input type="radio" class="form-check-input" name="fBullet" id="bullet2" value="경조사">
							          경조사
							        </label>
							    </div>
							    <div class="form-group">
							      <label for="exampleTextarea" class="form-label mt-4">제목</label>
							      <textarea class="form-control" id="title" rows="1" name="fBoardTitle"></textarea>
							    </div>
						
							    <div class="form-group">
							      <label for="exampleTextarea" class="form-label mt-4">내용</label>
							      <textarea class="summernote" id="contents" name="editordata"></textarea>
							    </div>
							    <div class="form-group">
							      <label for="formFile" class="form-label mt-4">첨부파일</label>
							      <input class="form-control" type="file" id="formFile">
							    </div>
							   <br><br>
							   <div align="center">
							   	<button type="submit" class="btn btn-theme03"><i class="fa fa-check"></i> 등록</button>&nbsp;&nbsp;
							    <button type="reset" class="btn btn-theme04"><i class="fa fa-times"></i> 취소</button>
							   </div>

							  </fieldset>	
						</form>
					</div>
				</div>
			</div>
		</section>
	</section>
	
	<script>
		$('.summernote').summernote({
			height : 150,
			lang : "ko-KR"
		});
	</script>
</body>
</html>