<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: jinjiaobo
  Date: 2019/12/24
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>工大航空</title>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/topBar.css">
    <link rel="stylesheet" type="text/css" href="css/FlightSearch.css">
    <link rel="stylesheet" type="text/css" href="css/City.css">
    <link rel="stylesheet" type="text/css" href="css/FlightInfo.css">
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
    <script language="JavaScript" type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script language="JavaScript" type="text/javascript" src="js/City.js"></script>
</head>
<body>
<div class="page">
    <div  style="width: 1050px;">
        <div class="wrapper">
            <div class="header-con">
                <h1 class="logo">
                    <a href="index.html">工大航空</a>
                </h1>
                <div class="header-right">
                    <div class="header-search">
                        <div class="search-bd">
                            <input type="text" class="search-input" id="search-input"
                                   value="" placeholder="搜索车票/餐饮/常旅客/相关规章" auto-complete="new-password">
                        </div>
                        <a class="search-btn" href="javascript:;">
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </a>
                    </div>
                    <ul class="header-menu">
                        <li id="J-header-login" class="menu-item menu-login">
                            <a name="g_href" data-type="2" data-href="resources/login.html" data-redirect="Y"
                               href="javascript:;">登录</a>
                            <a name="g_href" data-type="2" data-href="regist/init" data-redirect="Y" href="javascript:;"
                               class="ml">注册</a>
                        </li>
                        <li id="J-header-logout" style="display: none;" class="menu-item menu-nav menu-login">
                            您好，<a name="g_href" data-type="2" data-href="view/index.html" data-redirect="Y"
                                  href="javascript:;" class="txt-primary menu-nav-my-hd"></a>
                            &nbsp;|&nbsp;<a class="logout" href="javascript:;">退出</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="nav-box">
            <ul class="nav">
                <li class="nav-item nav-item-w1">
                    <a href="" class="nav-hd">首页</a>
                </li>
                <li class="nav-item nav-item-w1">
                    <a href="" class="nav-hd">车票</a>
                </li>
                <li class="nav-item nav-item-w1 active">
                    <a href="personalInformation.html" class="nav-hd">个人信息</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="h40"></div>
    <div id="main" style="width: 1050px">
        <!--目录-->
        <div id="left" style="width: 15%; float: left">
            <h4 style="font-weight: bold">个人中心</h4>
            <a target="_top" href="personalInformation.jsp" style="color: black; margin-left: 10px; margin-top: 5px;">个人信息</a>
            <br>
            <div style="height: 5px"></div>
            <a target="_top" href="favoriteContacts.jsp" style="color: black; margin-left: 10px; margin-top: 5px;">常用联系人</a>
            <h4 style="font-weight: bold">订单中心</h4>
            <a target="_top" href="untraveledOrders.jsp" style="color: black; margin-left: 10px; margin-top: 5px;">未出行订单</a>
            <br>
            <a target="_top" href="traveledOrders.jsp" style="color: black; margin-left: 10px; margin-top: 5px;">历史订单</a>
        </div>

        <!--具体内容-->
        <div id="right" style="width: 85%; height: auto; float: left;">
            <div style="border: 1px solid #DEDEDE;">
                <h4>增加常用联系人</h4>
                <form class="form-horizontal" role="form" action="savePassenger.action">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <s:textfield class="form-control" name="passenger.name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">身份证</label>
                        <div class="col-sm-10">
                            <s:textfield class="form-control" name="passenger.idCard"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">身份类型</label>
                        <div class="col-sm-10">
                            <s:select class="form-control" list="{'成年','学生'}" value="passenger.identifyType"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="reset" class="btn btn-default">重置</button>
                            <button type="submit" class="btn btn-default">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
