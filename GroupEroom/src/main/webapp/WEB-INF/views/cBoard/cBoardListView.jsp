<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
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
							<td>${cBoard.cBoardTitle }</td>
							<td>${cBoard.memberName }</td>
							<td>${cBoard.enrollDate }</td>
							<td>${cBoard.hits }</td>
						</tr>
					</c:forEach>
                </tbody>
              </table>
              
            </div>
          </div>
        </div>
       </section>
      </section>
</body>
</html>