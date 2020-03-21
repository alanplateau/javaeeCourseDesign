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
            <h1><i class="fa fa-th-list"></i>航班<s:property value="%{#session.flight.flightId}"/>订单列表
                头等舱余票：<s:property value="%{#session.flight.ticketInfo.firstClassTicket}"/>
                商务舱余票：<s:property value="%{#session.flight.ticketInfo.businessClassTicket}"/>
                经济舱余票：<s:property value="%{#session.flight.ticketInfo.economyClassTicket}"/></h1>
            <h1>
                <s:if test="#session.istimeout">
                    停止售票
                </s:if>
                <s:else>
                    <s:a action="checkTicket">购票</s:a>
                </s:else>
            </h1>
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
                        <th>订单编号</th>
                        <th>订单时间</th>
                        <th>乘客姓名</th>
                        <th>乘客身份证号</th>
                        <th>机票类型</th>
                        <th>机票价格</th>
                        <th>订单状态</th>
                        <th>退票</th>
                    </tr>
                    </thead>
                    <tbody>

                    <s:iterator value="#session.orderInfoList" var="forder" >
                    <tr>
                        <td><s:property value="%{#forder.orderId}"/> </td>
                        <td><s:property value="%{#forder.orderTime}"/> </td>
                        <td><s:property value="%{#forder.name}"/> </td>
                        <td><s:property value="%{#forder.idCard}"/> </td>
                        <td>
                            <s:if test="#forder.ticketType == 1">
                                头等舱
                            </s:if>
                            <s:elseif test="#forder.ticketType == 2">
                                商务舱
                            </s:elseif>
                            <s:elseif test="#forder.ticketType == 3">
                                经济舱
                            </s:elseif>
                        </td>
                        <td>
                            <s:if test="#forder.ticketType == 1">
                                <s:property value="%{#session.flight.ticketInfo.firstClassTicketPrice}"/>
                            </s:if>
                            <s:elseif test="#forder.ticketType == 2">
                                <s:property value="%{#session.flight.ticketInfo.businessClassTicketPrice}"/>
                            </s:elseif>
                            <s:elseif test="#forder.ticketType == 3">
                                <s:property value="%{#session.flight.ticketInfo.economyClassTicketPrice}"/>
                            </s:elseif>
                        </td>
                        <td><s:property value="orderStatus"/> </td>
                        <td>
                            <s:if test="#forder.status == 1">
                                <s:form method="post" action="alterOrder">
                                    <s:hidden name="order.orderId" value="%{#forder.orderId}"></s:hidden>
                                    <s:hidden name="order.ticketType" value="%{#forder.ticketType}"></s:hidden>
                                    <s:hidden name="order.orderTime" value="%{#forder.orderTime}"></s:hidden>
                                    <s:hidden name="order.orderStatus" value="%{#forder.orderStatus}"></s:hidden>
                                    <s:hidden name="order.status" value="%{#forder.status}"></s:hidden>
                                    <s:hidden name="order.passenger.passengerId" value="%{#forder.passenger.passengerId}"></s:hidden>
                                    <s:hidden name="order.flight.flightId" value="%{#forder.flight.flightId}"></s:hidden>
                                    <s:hidden name="order.flight.departureTime" value="%{#forder.flight.departureTime}"></s:hidden>
                                    <input type="submit" class="btn btn-info" value="退票"/>
                                </s:form>
                            </s:if>
                            <s:else>
                                不可退款
                            </s:else>
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
