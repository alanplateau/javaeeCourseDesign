<%--
  ~ Copyright(c)2002-2019
  ~    项目名称:ARS55version
  ~    文件名称:index2.jsp
  ~    Date:2019/12/25 下午10:28
  ~    Author:高源
  --%>

<%--
  Created by IntelliJ IDEA.
  User: 13345
  Date: 2019/12/25
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
    <link rel="stylesheet" href="font/font-awesome-4.7.0/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="css/topBar.css">
    <link rel="stylesheet" type="text/css" href="css/FlightSearch.css">
    <link rel="stylesheet" type="text/css" href="css/City.css">
    <link rel="stylesheet" type="text/css" href="css/FlightInfo.css">
    <link rel="stylesheet" type="text/css" href="css/index2ImageChange.css"/>

    <script language="javascript" type="text/javascript" src="js/timeDisabled.js"></script>
    <script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
    <script language="JavaScript" type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script language="JavaScript" type="text/javascript" src="js/City.js"></script>
    <script language="JavaScript" type="text/javascript" src="js/imageChange.js"></script>
    <script language="JavaScript" type="text/javascript" src="js/index2City.js"></script>
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
                <li class="nav-item nav-item-w1 active">
                    <a name="g_href" href="index2.jsp" class="nav-hd">首页</a>
                </li>
                <li class="nav-item nav-item-w1">
                    <a href="index.jsp" class="nav-hd">机票</a>
                </li>
                <li class="nav-item nav-item-w1">
                    <a name="g_href" href="personalInformation.jsp" class="nav-hd">个人信息</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="imageChange">
        <div class="zsl-query">
            <div class="zsl-query-pos">
                <div class="zsl-query-box tab-box" style="position:relative;z-index:101;">
                    <ul class="nav-tabs">
                        <li class="flight nav-tab current" data-index="0" otype="button" otitle="首页-预订行程" data-likev-tagname="首页-预订行程">
                            <i class="fa fa-bell-o" aria-hidden="true"></i>
                            预订行程
                        </li>
                        <!--                        <li class="nav-tab" data-index="1" otype="button" otitle="首页-行程服务" data-likev-tagname="首页-行程服务"><i class="service"></i>行程服务</li>-->
                        <!--                        <li class="nav-tab" data-index="2" otype="button" otitle="首页-旅游度假" data-likev-tagname="首页-旅游度假"><i class="holiday"></i>旅游度假</li>-->
                        <!--                        <li class="nav-tab" data-index="3" otype="button" otitle="首页-移动端" data-likev-tagname="首页-移动端"><i class="mobile"></i>移动端</li>-->
                    </ul>
                    <!--预订行程start-->
                    <div class="zsl-query-con tab-pane flight tab-box">
                        <div class="query-child-con tab-pane ticket">
                            <div class="query-child-flightH roundTripChange">
                                <div class="flightCheck fl">
                                    <a href="#" class="hm-radio current" data-type="signle" data-value="1">单程</a>
                                </div>
                                <div class="flightCheck fl">
                                    <a href="#" class="hm-radio" data-value="2">往返</a>
                                </div>
                            </div>
                            <form action="flightSearchAction.action" method="get">
                                <div class="query-child-search">
                                    <div class="search-line">
                                        <div class="search-col-2 fl" style="position:relative;">
                                            <label for="fDepCity" class="search-label">出发城市</label>
                                            <div class="search-ctrls br">
                                                <div class="search-input">
                                                    <div class="search-logo dep"></div>
                                                    <div class="ui-input-unit">
                                                        <input type="text" name="fromCity" id="fDepCity" class="phInput zls-city-ipt fromcity ui-city-input" data-placeholder="全拼/简拼/汉字"
                                                               autocomplete="off" style="color: rgb(137, 137, 137);" readonly="readonly">
                                                        <div class="input-helper ui-city-helper"><span class="ui-ico ico-city "></span></div></div>
                                                    <input type="hidden" id="city1_code" name="city1_code">
                                                </div>

                                            </div>
                                            <a href="#" class="zls-city-btn"></a>
                                        </div>

                                        <div class="search-col-2 fr">
                                            <label for="fArrCity" class="search-label" style="margin-left:10px;">到达城市</label>
                                            <div class="search-ctrls br" style="margin-left:10px;">
                                                <div class="search-input">
                                                    <div class="search-logo arr"></div>
                                                    <div class="ui-input-unit">
                                                        <input type="text" name="toCity" id="fArrCity" class="phInput zls-city-ipt tocity ui-city-input"
                                                               data-placeholder="全拼/简拼/汉字" autocomplete="off" readonly="readonly" style="color: rgb(137, 137, 137);">
                                                        <div class="input-helper ui-city-helper"><span class="ui-ico ico-city "></span></div></div>
                                                    <input type="hidden" id="city2_code" name="city2_code">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="search-line">
                                        <div class="fl search-col-2">
                                            <label for="fDepDate" class="search-label">出发日期</label>
                                            <div class="search-ctrls br">
                                                <div class="search-input">
                                                    <div class="search-logo calendar"></div>
                                                    <div class="ui-input-unit">
                                                        <input type="text" name="departureTime" id="fDepDate" class="phInput zls-date-ipt fromdate ui-calendar-input"
                                                               data-placeholder="全拼/简拼/汉字" readonly="" readonly="readonly" style="color: rgb(137, 137, 137);" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd',minDate:['#F{getToday()}'],maxDate:['#F{getLastDay()}']})">
                                                        <div class="input-helper ui-calendar-helper">
<%--                                                            <span class="weekday">星期三</span>--%>
                                                            <span class="ui-ico ico-calendar"></span></div></div>
                                                </div>

                                            </div>
                                        </div>
                                        <div class="fr search-col-2 roundTrip" id="searchReturnDate">
                                            <label for="fArrDate" class="search-label" style="margin-left:10px;">返回日期</label>
                                            <div class="search-ctrls br" style="margin-left:10px;">
                                                <div class="search-input disabled">
                                                    <div class="search-logo calendar"></div>
                                                    <div class="ui-input-unit">
                                                        <input type="text" name="fArrDate" class="phInput zls-date-ipt todate ui-calendar-input"
                                                               disabled="disabled" readonly="" id="fArrDate" value="全拼/简拼/汉字" style="color: rgb(137, 137, 137);">
                                                        <div class="input-helper ui-calendar-helper"><span class="weekday">星期三</span><span class="ui-ico ico-calendar"></span></div></div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="search-line search-bottom">
                                        <!--                                    <div class="fl searchProprice">-->
                                        <!--                                        <a href="https://www.csair.com/cn/online/cki/index.shtml" target="_blank" otype="button" otitle="首页-预订行程-机票-行程服务" data-likev-tagname="首页-预订行程-机票-行程服务">-->
                                        <!--                                            <i></i>行程服务<span class="red-font">荐</span> </a>-->
                                        <!--                                    </div>-->
                                        <!--                                    <a href="#" class="fr searchBtn searchFlight" otype="button" otitle="首页-预订行程-机票-立即查询" data-likev-tagname="首页-预订行程-机票-立即查询" data-likev-info="{&quot;CS1&quot;:&quot;官网首页&quot;,&quot;CS2&quot;:&quot;航班查询&quot;}">-->
                                        <!--                                        立即查询-->
                                        <!--                                    </a>-->
                                        <button class="fr searchBtn searchFlight">立即查询</button>
                                    </div>
                                </div>
                            </form>

                        </div>

                    </div>
                    <!--预订行程end-->
                </div>
            </div>
        </div>
        <ol class="flex-control-nav flex-control-paging">
            <li><a class="" data-id="1">1</a></li>
            <li><a class="" data-id="2">2</a></li>
            <li><a class="" data-id="3">3</a></li>
            <li><a class="" data-id="4">4</a></li>
            <li><a class="" data-id="5">5</a></li>
            <li><a class="" data-id="6">6</a></li>
        </ol>
    </div>
    <div id="ui-city-unit">
        <div id="ui-city-box" class="ui-tab-bar header"><a class="ui-tab ui-tab-on" data-index="0">中国国内（含港澳台地区）</a><a
                class="ui-tab" data-index="1">国际</a><a class="ui-tab" data-index="2" style="display: none;">国际</a></div>
        <div id="ui-city-box-tab-content" class="ui-tab-box header-box">
            <div class="ui-tab-content tab0 ui-content-on">
                <div id="ui-city-area-0" class="ui-tab-bar group-lv">
                    <a class="ui-tab ui-tab-on" data-index="1" id="index1">ABCDE</a>
                    <a class="ui-tab" data-index="2" id="index2">FGHIJ</a>
                    <a class="ui-tab" data-index="3" id="index3">KLMNP</a>
                    <a class="ui-tab" data-index="4" id="index4">QRSTU</a>
                    <a class="ui-tab" data-index="5" id="index5">VWXYZ</a>
                </div>
                <div id="ui-city-area-0-tab-content" class="ui-tab-box group-lv-box">
                    <div class="ui-tab-content tab1 ui-content-on">
                        <div class="city-section">
                            <div class="letter">A</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['A']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">B</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['B']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">C</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['C']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">D</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['D']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">E</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['E']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                    </div>
                    <div class="ui-tab-content tab2">
                        <div class="city-section">
                            <div class="letter">F</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['F']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">G</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['G']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">H</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['H']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">I</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['I']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">J</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['J']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                    </div>
                    <div class="ui-tab-content tab3">
                        <div class="city-section">
                            <div class="letter">K</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['K']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">L</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['L']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">M</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['M']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">N</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['N']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">O</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['O']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">P</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['P']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                    </div>
                    <div class="ui-tab-content tab4">
                        <div class="city-section">
                            <div class="letter">Q</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['Q']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">R</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['R']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">S</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['S']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">T</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['T']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">U</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['U']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                    </div>
                    <div class="ui-tab-content tab5">
                        <div class="city-section">
                            <div class="letter">V</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['V']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">W</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['W']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">X</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['X']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">Y</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['Y']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="city-section">
                            <div class="letter">Z</div>
                            <div class="ui-city-list">
                                <s:iterator value="%{#session.cityMap['Z']}">
                                    <a class="ui-city-link " isinter="N"><s:property/></a>
                                </s:iterator>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
