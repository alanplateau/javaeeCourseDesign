<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
  <base href="<%=basePath%>">

  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>经办业务员登录页</title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
  <!-- CSS Files -->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
  <link href="assets/css/now-ui-kit.css?v=1.1.0" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="assets/css/demo.css" rel="stylesheet" />
  <!-- Canonical SEO -->
  <link rel="canonical" href="" />
  <!--  Social tags      -->
  <meta name="keywords" content="">
  <meta name="description" content="">



</head>

<body class="login-page sidebar-collapse">
<!-- Navbar -->
<nav class="navbar navbar-expand-lg bg-primary fixed-top navbar-transparent " color-on-scroll="400">
  <div class="container">
  </div>
</nav>
<!-- End Navbar -->
<div class="page-header" filter-color="primary">
  <div class="page-header-image" style="background-image:url(assets/img/bg1.jpg)"></div>
  <div class="container">
    <div class="col-md-4 content-center">
      <div class="card card-login card-plain">
        <div class="header header-primary text-center">

          <h2 >经办人登录页面</h2>
        </div>
        <form class="form" action="OperatorLogin" method="post">
          <div class="input-group form-group-no-border input-lg">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons users_circle-08"></i>
                                </span>
            <input type="text" class="form-control" placeholder="账号..." name="user.account">
          </div>
          <div class="input-group form-group-no-border input-lg">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons text_caps-small"></i>
                                </span>
            <input type="password" class="form-control" placeholder="密码..." name="user.password" />
          </div>
          <div>
            <input type="submit" class="btn btn-primary btn-round btn-lg btn-block" value="登录"/>
          </div>

        </form>

      </div>
    </div>
  </div>
</div>
</body>
<!--   Core JS Files   -->
<script src="assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="assets/js/plugins/bootstrap-switch.js"></script>
<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
<!--  Plugin for the DatePicker, full documentation here: https://github.com/uxsolutions/bootstrap-datepicker -->
<script src="assets/js/plugins/bootstrap-datepicker.js" type="text/javascript"></script>
<!-- Share Library etc -->
<script src="assets/js/plugins/jquery.sharrre.js" type="text/javascript"></script>
<!-- Control Center for Now Ui Kit: parallax effects, scripts for the example pages etc -->
<script src="assets/js/now-ui-kit.js?v=1.1.0" type="text/javascript"></script>

</html>