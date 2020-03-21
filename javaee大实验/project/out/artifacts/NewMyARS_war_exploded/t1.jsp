<%@ page language="java" contentType="text/html; charset=GBK"
         pageEncoding="GBK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta name="description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <!-- Twitter meta-->
    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:site" content="@pratikborsadiya">
    <meta property="twitter:creator" content="@pratikborsadiya">
    <!-- Open Graph Meta-->
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="Vali Admin">
    <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme">
    <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin">
    <meta property="og:image" content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png">
    <meta property="og:description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <title>航班</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="app sidebar-mini rtl">
<!-- Navbar-->
<header class="app-header"><a class="app-header__logo" href="t1.jsp">经办人主页</a>
    <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">
        <!--<li class="app-search">
            <input class="app-search__input" type="search" placeholder="Search">
            <button class="app-search__button"><i class="fa fa-search"></i></button>
        </li>-->
        <!--Notification Menu-->
        <!-- User Menu-->
        <li class="dropdown"><a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu"><i class="fa fa-user fa-lg"></i></a>
            <ul class="dropdown-menu settings-menu dropdown-menu-right">
                <li><a class="dropdown-item" href="index.jsp"><i class="fa fa-sign-out fa-lg"></i> 退出登录</a></li>
            </ul>
        </li>
    </ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>

<aside class="app-sidebar">
    <div class="app-sidebar__user">
        <div>

            <p class="app-sidebar__user-name">经办人:</p>
            <p class="app-sidebar__user-designation"><s:property value="%{#session.loginUser.account}"/></p>
        </div>
    </div>
    <ul class="app-menu">

        <li><a class="app-menu__item" href="index.jsp"><i class="app-menu__icon fa fa-sign-out"></i><span class="app-menu__label">退出登录</span></a></li>


    </ul>
</aside>
<main class="app-content">
    <div class="app-title">
        <div>
            <h1><i class="fa fa-th-list"></i>航班列表        <s:a action="refresh1">刷新</s:a></h1>
        </div>
        <ul class="app-breadcrumb breadcrumb side">
            <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <table class="table table-hover table-bordered" id="sampleTable">
                    <thead>
                    <tr>
                        <th>航班编号</th>
                        <th>飞机编号</th>
                        <th>出发城市</th>
                        <th>出发机场</th>
                        <th>到达城市</th>
                        <th>到达机场</th>
                        <th>出发时间</th>
                        <th>到达时间</th>
                        <th>头等舱余票</th>
                        <th>商务舱余票</th>
                        <th>经济舱余票</th>
                        <th>详细信息</th>
                    </tr>
                    </thead>
                    <tbody>

                    <s:iterator value="#session.flightList" var="flight" >
                    <tr>
                        <td><s:property value="%{#flight.flightId}"/> </td>
                        <td><s:property value="%{#flight.airplane.airplaneId}"/> </td>
                        <td><s:property value="%{#flight.departureAirport.city.cityName}"/> </td>
                        <td><s:property value="%{#flight.departureAirport.airportName}"/> </td>
                        <td><s:property value="%{#flight.arrivalAirport.city.cityName}"/> </td>
                        <td><s:property value="%{#flight.arrivalAirport.airportName}"/> </td>
                        <td><s:property value="%{#flight.departureTime}"/> </td>
                        <td><s:property value="%{#flight.arrivalTime}"/> </td>
                        <td><s:property value="%{#flight.ticketInfo.firstClassTicket}"/> </td>
                        <td><s:property value="%{#flight.ticketInfo.businessClassTicket}"/> </td>
                        <td><s:property value="%{#flight.ticketInfo.economyClassTicket}"/> </td>
                        <td>

                            <s:form method="post" action="flightInfo">
                                <s:hidden name="flight.flightId" value="%{#flight.flightId}"></s:hidden>
                                <input type="submit" class="btn btn-info" value="航班详情"/>
                            </s:form>
                        </td>
                    </tr>
                    </s:iterator>

                </table>
            </div>
        </div>
    </div>
    </div>
</main>
<!-- Essential javascripts for application to work-->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<!-- Data table plugin-->
<script type="text/javascript" src="js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/plugins/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">$('#sampleTable').DataTable();</script>
<!-- Google analytics script-->
<script type="text/javascript">
    if(document.location.hostname == 'pratikborsadiya.in') {
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
        ga('create', 'UA-72504830-1', 'auto');
        ga('send', 'pageview');
    }
</script>
</body>
</html>
