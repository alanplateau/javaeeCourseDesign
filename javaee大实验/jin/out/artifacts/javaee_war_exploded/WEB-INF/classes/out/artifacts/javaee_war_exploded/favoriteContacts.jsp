<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: jinjiaobo
  Date: 2019/12/24
  Time: 12:04
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
            <a target="_top" href="personalInformation.html" style="color: black; margin-left: 10px; margin-top: 5px;">个人信息</a>
            <br>
            <div style="height: 5px"></div>
            <a target="_top" href="favoriteContacts.html" style="color: black; margin-left: 10px; margin-top: 5px;">常用联系人</a>
            <h4 style="font-weight: bold">订单中心</h4>
            <a target="_top" href="untraveledOrders.html" style="color: black; margin-left: 10px; margin-top: 5px;">未出行订单</a>
            <br>
            <a target="_top" href="traveledOrders.html" style="color: black; margin-left: 10px; margin-top: 5px;">历史订单</a>
        </div>

        <!--具体内容-->
        <div id="right" style="width: 85%; height: auto; float: left;">
            <div style="border: 1px solid #DEDEDE;">
                <div>
                    <form style="margin-top: 10px; margin-left: 5px" action="findByName.action">
                        <label>请输入乘客姓名</label>
                        <s:textfield name="passenger.name"/>
                        <button type="submit">查询</button>
                    </form>
                    <a href="addPassenger.jsp" style="color: black;">增加常用联系人</a>
                </div>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>姓名</th>
                        <th>证件类型</th>
                        <th>证件号码</th>
                        <th>核验状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <%!
                            int count = 1;
                        %>
                        <s:iterator value="passengers">
                            <td>
                                <%=count++ %>
                            </td>
                            <td>
                                <s:property value="name"/>
                            </td>
                            <td>
                                中国居民身份证
                            </td>
                            <td>
                                <s:property value="IDCard"/>
                            </td>
                            <td>
                                已通过
                            </td>
                            <td>
                                <a href="#" class="glyphicon glyphicon-remove" style="color: #000000;text-decoration:none"></a>
                            </td>
                        </s:iterator>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
