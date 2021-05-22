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
								<label class="form-label mt-4">말머리 구분</label>
								<div class="form-group">
							        <label class="form-check-label">
							          <input type="radio" class="form-check-input" name="fBullet" id="fBullet" value="일반" checked="">
							          일반&nbsp;&nbsp;
							        </label>
							        <label class="form-check-label">
							          <input type="radio" class="form-check-input" name="fBullet" id="fBullet" value="경조사">
							          경조사
							        </label>
							    </div>
 							    <div class="form-group">
							      <label class="form-label mt-4">작성자</label>
							      <textarea class="form-control" id="title" rows="1" name="fWriter" readonly>${loginUser.memberName }</textarea>
							    </div>		
							    <div class="form-group">
							      <label class="form-label mt-4">제목</label>
							      <textarea class="form-control" id="title" rows="1" name="fBoardTitle"></textarea>
							    </div>
						
							    <div class="form-group">
							      <label class="form-label mt-4">내용</label>
							      <div id="summernote" name="fBoardContents"></div>
							    </div>
							    <div class="form-group">
							      <label for="formFile" class="form-label mt-4">첨부파일</label>
							      <form id="fileForm" method="post" enctype="multipart/form-data"> 
							     	<input type="file" multiple="true" class="form-control" id="formFile" name="uploadfile">
							      </form>
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
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script>
		// =============== 썸머 노트 ====================
		$('#summernote').summernote({
			height : 400, // set editor height
			minHeight : null, // set minimum height of editor
			maxHeight : null, // set maximum height of editor
			focus : true,
			lang : 'ko-KR' // 기본 메뉴언어 US->KR로 변경
		});
		
		// ============== 파일업로드 구현 ================
		var formdata = new FormData($('#fileForm')[0]);
		
		$.ajax({
			type: "POST",
			enctype: 'multipart/form-data',
			url:'/mltipartUpload.do',
			data: formData,
			processData: false,
			contentType: false,
			chche: false,
			success: function (result) {
				
			},
			error: function (e)	{
				
			}
		});
		
	</script>
</body>
</html>