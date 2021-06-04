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
                <div class="form-group" align="right">
                <form action="cBoardSearch.do" method="get" class="form-inline" role="form">
                <select class="form-control" name="searchCondition">
                	<option value="ALL">전체</option>
                	<option value="C_BOARD_TITLE">제목</option>
                	<option value="C_BOARD_CONTENTS">내용</option>
                	<option value="MEMBER_NAME">작성자</option>
                </select>
                <input type="text" name="searchValue" style="width:100px" class="form-control" value="${search.searchValue }">
                <input type="submit" value="검색" class="btn btn-theme">
                </form>
                </div>
                
              <table class="table table-hover">
                <thead>
                  <tr>
                    <th>#</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                  </tr>
                </thead>
                <tbody>
					<c:forEach items="${cBoardList }" var="cBoard">
						<tr>
							<td>${cBoard.cBoardNo }</td>
							<td>
							<c:url var="cBoardDetail" value="cBoardDetail.do">
								<c:param name="cBoardNo" value="${cBoard.cBoardNo }"></c:param>
							</c:url>
							<a href="${cBoardDetail}">${cBoard.cBoardTitle }</a>
							</td>
							<td>${cBoard.memberName }</td>
							<td>${cBoard.enrollDate }</td>
							<td>${cBoard.hits }</td>
						</tr>
					</c:forEach>
               </tbody>
            </table>
            <div align="center">
            <div class="btn-group">
						<!-- 이전 -->
						<c:url var="before" value="cBoardSearch.do">
							<c:param name="page" value="${pi.currentPage - 1 }"></c:param>
							<c:param name="searchCondition" value="${search.searchCondition }"></c:param>
							<c:param name="searchValue" value="${search.searchValue }"></c:param>
						</c:url>
						<c:if test="${pi.currentPage <= 1 }">
							<button type="button" class="btn btn-default">이전</button>
						</c:if>
						<c:if test="${pi.currentPage > 1 }">
							<a href="${before }" class="btn btn-default">이전</a>&nbsp;
						</c:if>
						
					<!-- 페이지 -->
					<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
						<c:url var="pagination" value="cBoardSearch.do">
							<c:param name="page" value="${p }"></c:param>
							<c:param name="searchCondition" value="${search.searchCondition }"></c:param>
							<c:param name="searchValue" value="${search.searchValue }"></c:param>
						</c:url>
						<c:if test="${p eq pi.currentPage }">
						<button type="button" class="btn btn-default btn-theme">${p }</button>
							
						</c:if>
						<c:if test="${p ne pi.currentPage }">
							<a href="${pagination }" class="btn btn-default">${p }</a>&nbsp;
						</c:if>
					</c:forEach>
				
				
				<!-- 다음 -->
				<c:url var="after" value="cBoardSearch.do">
					<c:param name="page" value="${pi.currentPage + 1 }"></c:param>
					<c:param name="searchCondition" value="${search.searchCondition }"></c:param>
					<c:param name="searchValue" value="${search.searchValue }"></c:param>
				</c:url>
				<c:if test="${pi.currentPage >= pi.maxPage }">
					<button type="button" class="btn btn-default">다음</button>
				</c:if>
				<c:if test="${pi.currentPage < pi.maxPage }">
					<a href="${after }" class="btn btn-default">다음</a>&nbsp;
				</c:if>
			</div>
			</div>
              <div align="right">
              	<a href="#" class="btn btn-theme02">글 쓰기</a>
              </div>
            </div>
          </div>
        </div>
       </section>
      </section>
</body>
<jsp:include page="../common/footerScript.jsp"></jsp:include>
</html>