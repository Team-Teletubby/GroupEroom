<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문서 상세보기</title>
<link href="css/approvalDetail.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sideBar.jsp"></jsp:include>

	<section id="main-content">
                <section class="wrapper site-min-height">
                    <h3>
                        <i class="fa fa-angle-right"></i>
                        문서 상세보기
                    </h3>
                    <div class="row">
                        <div class="col-md-11">
                            <div class="content-panel">
                                <h4>
                                    <i class="fa fa-angle-right"></i>
                                    결재번호 ${approval.approvalNo }
                                </h4>
                                <br>
                                <!-- #############소스 적용 중############### -->
                                <div class="panel-body">
                                    <div class="header-title">
                                        <div class="fl">
                                            <span>결재문</span>
                                        </div>
                                        <div class="fr">      
                                            <button type="button" class="btn btn-success">승인</button>
                                            <button type="button" class="btn btn-danger">반려</button>
                                        </div>
                                    </div>
                                    <div class="mail-header row">
                                        <div class="col-md-4">
                                            <table>
                                                <h4>기안자 정보</h4>
                                                <tr>
                                                    <th>성명</th>
                                                    <td>dasd</td>
                                                </tr>
                                                <tr>
                                                    <th>부서</th>
                                                    <td>재무</td>
                                                </tr>
                                                <tr>
                                                    <th>직급</th>
                                                    <td>왕</td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="col-md-4">
                                            <table>
                                                <h4>문서 정보</h4>
                                                <tr>
                                                    <th>문서번호</th>
                                                    <td>2131231</td>
                                                </tr>
                                                <tr>
                                                    <th>문서종류</th>
                                                    <td>협조문</td>
                                                </tr>
                                                <tr>
                                                    <th>작성일</th>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="col-md-4">
                                            <table>
                                                <h4>결재 정보</h4>
                                                <tr>
                                                    <th></th>
                                                    <th>중간 결재자</th>
                                                    <th>최종 결재자</th>
                                                </tr>
                                                <tr>
                                                    <th>성명</th>
                                                </tr>
                                                <tr>
                                                    <th>부서</th>
                                                </tr>
                                                <tr>
                                                    <th>직급</th>
                                                </tr>
                                                <tr>
                                                    <th>승인</th>
                                                </tr>
                                            </table>
                                        </div>

                                    </div>
                                    <div class="mail-sender">
                                        <div class="row">
                                            <div class="col-md-8">
                                                <h3>협조 부탁드립니다.</h3>
                                                <span>내용</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div>
                                        <p>
                                            <span>
                                                <i class="fa fa-paperclip"></i>
                                                첨부파일
                                            </span>
                                            <a href="#">Download all attachments</a>
                                        </p>
                                    </div>
                                    <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$댓글$$$$$$$$$$$$$$$$$$$$$$$$$$$$ -->
                                    <!-- 댓글등록 -->
                                    <div class="card mb-2">
                                        <div class="card-body">
                                            <ul class="list-group list-group-flush">
                                                <li class="list-group-item">
                                                    <div>
                                                        dsadadasdas
                                                    </div>
                                                    <textarea
                                                        class="form-control"
                                                        id="cmtContents"
                                                        rows="3"
                                                        placeholder="댓글을 입력하세요."></textarea>
                                                    <div align="right" style="margin-top: 2px">
                                                        <button class="btn btn-sm btn-theme03" id="cmtSubmit">등록</button>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <!-- 댓글조회 -->
                                        <div>
                                            <table align="center" width="500" border="1" cellspacing="0" id="cmttb">
                                                <thead>
                                                    <tr>
                                                        <td colspan="3">
                                                            <b id="cmtCount"></b>
                                                        </td>
                                                    </tr>
                                                </thead>
                                                <tbody></tbody>
                                            </table>
                                        </div>
                                        <br>
                                        <br>
                                        <br>
                                        <div class="bottom-btnbox">
                                            <div class="fl">
                                                <button onclick="location.href='fBoardListView.do'" class="btn btn-theme03">목록으로</button>
                                            </div>
                                            <div class="fr">
                                                <button onclick="location.href='${fModify}'" class="btn btn-theme02">수정</button>
                                                <button onclick="location.href='${fDelete}'" class="btn btn-theme04">삭제</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </section>
                <!-- footer -->
                <footer class="site-footer">
                    <div class="text-center">
                        <p>
                            &copy; Copyrights
                            <strong>Dashio</strong>. All Rights Reserved
                        </p>
                        <div class="credits">
                            <!-- You are NOT allowed to delete the credit link to TemplateMag with free
                            version. You can delete the credit link only if you bought the pro version. Buy
                            the pro version with working PHP/AJAX contact form:
                            https://templatemag.com/dashio-bootstrap-admin-template/ Licensing information:
                            https://templatemag.com/license/ -->
                            Created with Dashio template by
                            <a href="https://templatemag.com/">TemplateMag</a>
                        </div>
                        <a href="index.html#" class="go-top">
                            <i class="fa fa-angle-up"></i>
                        </a>
                    </div>
                </footer>
                <!--footer end-->
            </section>
</body>
</html>