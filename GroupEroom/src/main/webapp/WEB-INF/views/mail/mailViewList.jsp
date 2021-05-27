<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>Dashio - Bootstrap Admin Template</title>

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="resources/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="resources/js/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="resources/css/style.css" rel="stylesheet">
  <link href="resources/css/style-responsive.css" rel="stylesheet">
	
</head>

<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sideBar.jsp"></jsp:include>
  <section id="container">
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <!-- page start-->
        <div class="row mt">
          <div class="col-sm-3">
            <section class="panel">
              <div class="panel-body">
                <a href='mailComposeView.do'" class="btn btn-compose"><i class="fa fa-pencil"></i>메일쓰기</a>
                <ul class="nav nav-pills nav-stacked mail-nav">
                  <li class="active"><a href="inbox.html"> <i class="fa fa-inbox"></i>받은 편지함<!--<span class="label label-theme pull-right inbox-notification">3</span>--></a></li>
                  <li><a href="#"> <i class="fa fa-envelope-o"></i>보낸 편지함</a></li>
                  <li><a href="#"> <i class="fa fa-trash-o"></i>휴지통</a></li>
                </ul>
              </div>
            </section>
          </div>
          <div class="col-sm-9">
            <section class="panel">
              <header class="panel-heading wht-bg">
                <h4 class="gen-case">
                    ë°ì í¸ì§í¨
                    <form action="#" class="pull-right mail-src-position">
                      <div class="input-append">
                        <input type="text" class="form-control " placeholder="Search Mail">
                      </div>
                    </form>
                  </h4>
              </header>
              <form action="mailListView.do" method="GET">
                <div class="panel-body minimal">
                  <div class="mail-option">
                    <div class="chk-all">
                      <div class="pull-left mail-checkbox">
                        <input type="checkbox" class="">
                      </div>
                      <div class="btn-group">
                        <a data-toggle="dropdown" href="#" class="btn mini all">
                          All
                          <i class="fa fa-angle-down "></i>
                          </a>
                        <ul class="dropdown-menu">
                          <li><a href="#"> None</a></li>
                          <li><a href="#"> Read</a></li>
                          <li><a href="#"> Unread</a></li>
                        </ul>
                      </div>
                    </div>
                    <div class="btn-group">
                      <a data-original-title="Delete" data-placement="top" data-toggle="dropdown" href="#" class="btn mini tooltips">
                        <i class="fa fa-trash-o"></i>
                        </a>
                    </div>
                    <ul class="unstyled inbox-pagination">
                      <li><span>1-50 of 99</span></li>
                      <li>
                        <a class="np-btn" href="#"><i class="fa fa-angle-left  pagination-left"></i></a>
                      </li>
                      <li>
                        <a class="np-btn" href="#"><i class="fa fa-angle-right pagination-right"></i></a>
                      </li>
                    </ul>
                  </div>
                  <div class="table-inbox-wrap ">
                    <table class="table table-inbox table-hover">
                      <tbody>
                        <c:forEach items="${ mailList }" var="mail">
                          <c:if test="${mail.readCount} > 0">
                            <tr class="">
                              <td class="inbox-small-cells">
                                <input type="checkbox" class="mail-checkbox">
                              </td>
                              <!-- <td class="inbox-small-cells"><i class="fa fa-star"></i></td> -->
                              <td class="view-message  dont-show" name="" hidden><a> ${mailNo} </a></td>
                              <td class="view-message  dont-show"><a href="mail_view.html">${senderId}</a></td>
                              <td class="view-message "><a href="mail_view.html">${mailTitle}</a></td>
                              <td class="view-message  inbox-small-cells"><i class="fa fa-paperclip"></i></td>
                              <td class="view-message  text-right">${sentDate}</td>
                            </tr>
                          </c:if>
                          <c:if test="${mail.readCount} = 0">
                            <tr class="unread">
                              <td class="inbox-small-cells">
                                <input type="checkbox" class="mail-checkbox">
                              </td>
                              <!-- <td class="inbox-small-cells"><i class="fa fa-star"></i></td> -->
                              <td class="view-message  dont-show" hidden><a> ${mailNo} </a></td>
                              <td class="view-message  dont-show"><a href="mail_view.html">${senderId}</a></td>
                              <td class="view-message "><a href="mail_view.html">${mailTitle}</a></td>
                              <td class="view-message  inbox-small-cells"><i class="fa fa-paperclip"></i></td>
                              <td class="view-message  text-right">${sentDate}</td>
                            </tr>
                          </c:if>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </form>
            </section>
          </div>
        </div>
      </section>
      <!-- /wrapper -->
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
    <!--footer start-->
    <footer class="site-footer">
      <div class="text-center">
        <p>
          &copy; Copyrights <strong>Dashio</strong>. All Rights Reserved
        </p>
        <div class="credits">
          <!--
            You are NOT allowed to delete the credit link to TemplateMag with free version.
            You can delete the credit link only if you bought the pro version.
            Buy the pro version with working PHP/AJAX contact form: https://templatemag.com/dashio-bootstrap-admin-template/
            Licensing information: https://templatemag.com/license/
          -->
          Created with Dashio template by <a href="https://templatemag.com/">TemplateMag</a>
        </div>
        <a href="inbox.html#" class="go-top">
          <i class="fa fa-angle-up"></i>
          </a>
      </div>
    </footer>
    <!--footer end-->
  </section>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="resources/js/jquery/jquery.min.js"></script>
  <script src="resources/js/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="resources/js/jquery.dcjqaccordion.2.7.js"></script>
  <script src="resources/js/jquery.scrollTo.min.js"></script>
  <script src="resources/js/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <script src="resources/js/common-scripts.js"></script>
  <!--script for this page-->

</body>

</html>

