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
					<h3>${cBoard.cBoardTitle }</h3><br>
					<div style="font-size:15px">
					<span style="align:left">작성자 : ${cBoard.memberName }</span>
					<span style="float:right">작성일 : ${cBoard.enrollDate} 조회수 : ${cBoard.hits }</span>
					</div>
					<div style="padding:50px; border:1px solid lightgrey; font-size:15px">${cBoard.cBoardContents }</div>
					첨부 파일 : ${cBoard.originalFile }<br><br>
					<div style="padding:10px; border:1px solid lightgrey; font-size:15px">
						<table id="rtb">
							<thead>
								<tr>
									<td colspan="2"><b id="rCount"></b>댓글 목록</td>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div><br>
					<table style="width:100%">
						<tr>
							<td style="width:90%">
								<textarea class="form-control" style="width:100%" id="" name="comment" required></textarea>
							</td>
							<td style="width:10%" align="right">
								<button class="btn btn-theme">등록하기</button>
							</td>
						</tr>
					</table><br><br><br>
					

					<div align="right">
						<a href="" class="btn btn-theme02">수정</a>
						<a href="" class="btn btn-theme04"">삭제</a>
					</div><br>
					
					<div align="center">
						<a href="cBoardListView.do" class="btn btn-default">목록</a>
					</div>
				</div>
            </div>
          </div>
        </div>
       </section>
      </section>
</body>
<jsp:include page="../common/footerScript.jsp"></jsp:include>
</html>