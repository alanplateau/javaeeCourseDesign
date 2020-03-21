<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: jinjiaobo
  Date: 2019/12/25
  Time: 22:46
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
    <script type="text/javascript">
        window.onload = function () {
            var count = 0;
            <s:iterator value="#request.passengers">
            document.getElementById("<s:property value="name"/>").onclick = function () {
                if(document.getElementById("<s:property value="name"/>").checked) {
                    addRow("<s:property value="name"/>", "<s:property value="idCard"/>");
                } else {
                    deleteRow("<s:property value="name"/>");
                }
            };
            </s:iterator>

        };

        function deleteRow(name) {
            const myTable = document.getElementById("myTable");
            for (let i = 1; i < myTable.rows.length; i++) {
                if (myTable.rows[i].cells[3].innerHTML==="<input name=\""+name+"\" type=\"text\" value=\"中国居民身份证\" disabled=\"true\">") {
                    myTable.deleteRow(i);//删除一行
                    break;
                }
            }
        }

        function addRow(name, idCard) {
            let x;
            //向空表插入一行
            let y;
            const myTable = document.getElementById("myTable");
            const z = myTable.rows[0].cells;//如果不是空表，首先获得表格有多少列，先获取再插入新行
            const length = myTable.rows.length;
            length1 = length - 1;
            x = myTable.insertRow(length);
            for (let i = 0; i < z.length; i++) {//依次向新行插入表格列数的单元格
                y = x.insertCell(i);
                switch (i) {
                    case 0:
                        y.innerHTML = "<select><option>成人票</option></select>";
                        break;
                    case 1:
                        console.log(length);
                        console.log("orders["+length+"].idCard");
                        y.innerHTML = "<select name=\"orders["+length1+"].ticketType\"><option value='1'>头等舱</option><option value='2'>商务舱</option><option value='3'>经济舱</option></select>";
                        break;
                    case 2:
                        //姓名
                        y.innerHTML = "<input name=\"orders["+length1+"].name\" type=\"text\" value=\""+name+"\" readonly=readonly>";
                        break;
                    case 3:
                        y.innerHTML = "<input name=\""+name+"\" type=\"text\" value=\"中国居民身份证\" disabled=\"true\">";
                        break;
                    case 4:
                        //身份证
                        console.log(idCard);
                        y.innerHTML = "<input name=\"orders["+length1+"].idCard\" type=\"text\" value=\""+idCard+"\" readonly=readonly>";
                        break;
                    case 5:
                        //手机号码
                        y.innerHTML = "";
                        break;
                    case 6:
                        //删除
                        y.innerHTML = "<a href='#' onclick='deleteSome(\""+name+"\")'><span class=\"glyphicon glyphicon-remove\"></span></a>";
                        break;
                    }
                }
            }
            
            function deleteSome(name123) {
                deleteRow(name123);
                document.getElementById(name123).checked='';
            }
    </script>
</head>
<body>
<div class="page">
    <div class="header">
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
                        <s:if test="%{#session.user==null}">
                            <li id="J-header-login" class="menu-item menu-login">
                                <a name="g_href" data-type="2" data-href="resources/login.html" data-redirect="Y"
                                   href="login.jsp">登录</a>
                                <a name="g_href" data-type="2" data-href="regist/init" data-redirect="Y"
                                   href="register.jsp"
                                   class="ml">注册</a>
                            </li>
                        </s:if>
                        <s:else>
                            <li id="J-header-logout" class="menu-item menu-nav menu-login">
                                您好，<a name="g_href" data-type="2" data-href="view/index.html" data-redirect="Y"
                                      href="javascript:;" class="txt-primary menu-nav-my-hd">
                                <s:property value="%{#session.user.account}"/>
                            </a>
                                &nbsp;|&nbsp;<a class="logout" href="logOutAction.action">退出</a>
                            </li>
                        </s:else>
                    </ul>
                </div>
            </div>
        </div>
        <div class="nav-box">
            <ul class="nav">
                <li class="nav-item nav-item-w1">
                    <a name="g_href" href="index2.jsp" class="nav-hd">首页</a>
                </li>
                <li class="nav-item nav-item-w1 active">
                    <a href="index.jsp" class="nav-hd">机票</a>
                </li>
                <li class="nav-item nav-item-w1">
                    <a name="g_href" href="personalInformation.jsp" class="nav-hd">个人信息</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="h40"></div>
    <div id="main" style="width: 1050px">
        <div style="border: 1px solid #1678be;">
            <div style="background-color: #1E9FFF; color: #e5f8ff;line-height: 30px;height: 32px;padding-left: 20px;font-size: 15px;">
                航班信息
                <span class="small">（以下余票信息仅供参考）</span>
            </div>
            <div style="margin-top: 5px; margin-top: 5px; margin-left: 10px;">
                <strong style="font-size: 15px;"><s:date name="flightInfo.departureTime" format="yyyy"/>-</strong>
                <strong style="font-size: 15px;"><s:date name="flightInfo.departureTime" format="mm"/>-</strong>
                <strong style="font-size: 15px;"><s:date name="flightInfo.departureTime" format="dd"/></strong>
                (<s:date name="flightInfo.departureTime" format="EEE"/>)
                <strong style="margin-left: 5px;font-size: 15px;"><s:property value="flightInfo.flightId"/></strong>号
                <strong style="margin-left: 5px;font-size: 15px;"><s:property value="flightInfo.departureAirport.airportName"/>—</strong>
                <strong style="font-size: 15px;"><s:property value="flightInfo.arrivalAirport.airportName"/></strong>
            </div>
            <hr style="height:2px;border:none;size: 3px; border-top: 1px dotted black; margin-left: 10px; margin-right: 10px;"/>
            <div style="margin-top: 5px; margin-bottom: 5px; margin-left: 10px;">
                <span style="margin-right: 25px;">头等舱(<span style="color:#fb7403;">￥<s:property value="ticketInfo.firstClassTicketPrice"/></span>)<s:property value="ticketInfo.firstClassTicket"/>张</span>
                <span style="margin-right: 25px;">商务座(<span style="color:#fb7403;">￥<s:property value="ticketInfo.businessClassTicketPrice"/></span>)<s:property value="ticketInfo.businessClassTicket"/>张</span>
                <span style="margin-right: 25px;">经济座(<span style="color:#fb7403;">￥<s:property value="ticketInfo.economyClassTicketPrice"/></span>)<s:property value="ticketInfo.economyClassTicket"/>张</span>
            </div>
        </div>
        <div class="h40"></div>
        <div style="border: 1px solid #1678be;">
            <div>
                <div style="background-color: #1E9FFF; color: #e5f8ff;line-height: 30px;height: 32px;font-size: 15px;">
                    <span class="glyphicon glyphicon-user" style="color: #1E9FFF"></span>常用联系人
                    <span class="small">（填写说明）</span>
                </div>
                <div style="margin-left: 10px; margin-top: 5px;">
                    <s:iterator value="#request.passengers">
                        <input type="checkbox" id="<s:property value="name"/>" name="<s:property value="name"/>"
                               value="<s:property value="name"/>"><s:property value="name"/>
                    </s:iterator>
                </div>
                <hr style="height:2px;border:none; size: 3px; border-top: 1px dotted black; margin-left: 10px; margin-right: 10px;"/>
                <form class="form-horizontal" role="form" action="addOrders.action" method="post">
                    <s:hidden value="%{flight.flightId}" name="flight.flightId" />
                    <table class="table" id="myTable">
                        <thead>
                        <tr>
                            <td>票种</td>
                            <td>席别</td>
                            <td>姓名</td>
                            <td>证件类型</td>
                            <td>证件号码</td>
                            <td>手机号码</td>
                            <td>操作</td>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                    <div style="text-align:center">
                        <button type="submit" class="btn btn-default">提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
