<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/sideBar.jsp"></jsp:include>
<section id="main-content">
		<section class="wrapper">
			<h3>
				<i class="fa fa-angle-right"></i>공지사항
			</h3>
			<div class="row"></div>
			<div class="row">
				<div class="col-md-12">
					<div class="content-panel">
						<h4>
							<i class="fa fa-angle-right"></i> 공지글 수정
						</h4>
						<br>
						<form action="noticeModify.do" method="post" enctype="multipart/form-data">
						<input type="hidden" value="${notice.noticeNo }" name="noticeNo">
							    <div class="form-group">
							      <label class="form-label mt-4">제목</label>
							      <textarea class="form-control" id="title" rows="1" name="noticeTitle">${notice.noticeTitle}</textarea>
							    </div>
						
							    <div class="form-group">
							      <label class="form-label mt-4">내용</label>
							      <textarea id="summernote" name="noticeContents">${notice.noticeContents}</textarea>
							    </div>
							    <div>
							      <label for="formFile" class="form-label mt-4">첨부파일:${notice.originalFileName}</label>
							     	<input type="file" id="formFile" name="reloadFile">
							    </div>
							   <br><br>
							   <div align="center">
							   	<button type="submit" class="btn btn-theme02"><i class="fa fa-check"></i> 수정</button>&nbsp;&nbsp;
							    <button type="reset" class="btn btn-theme03"><i class="fa fa-times"></i> 취소</button>
							   </div>

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


		
	</script>

</body>
</html>