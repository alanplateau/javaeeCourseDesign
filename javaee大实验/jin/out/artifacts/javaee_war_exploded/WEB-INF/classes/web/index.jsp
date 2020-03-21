<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%--
  ~ Copyright(c)2002-2019
  ~    项目名称:ARS55version
  ~    文件名称:index.jsp
  ~    Date:2019/12/25 下午7:50
  ~    Author:高源
  --%>

<%--
  ~ /**
  ~  * @author  高源
  ~  * @date  ${DATE} ${TIME}
  ~  * @version 1.0
  ~  */
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

    <script language="javascript" type="text/javascript" src="js/timeDisabled.js"></script>
    <script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
    <script language="JavaScript" type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script language="JavaScript" type="text/javascript" src="js/City.js"></script>
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
    <!--    搜索航班-->
    <div class="zls-search">
        <div class="h40"></div>
        <div class="flight-inquires">
            <div class="fi-content">
                <div class="fi-contentBox fi-clearfix">
                    <div class="fi-content-tab fi-clearfix">
                        <div id="tab_single" class="tab-single fic-tab z-tabChecked" otype="button"
                             otitle="预订流程-航班选择-单程">单程
                        </div>
                        <div id="tab_round" class="tab-round fic-tab " otype="button" otitle="预订流程-航班选择-往返">
                            往返
                        </div>
                    </div>
                    <div class="fi-flightInfo" id="zls-search-form">
                        <form action="flightSearchAction.action" method="get">
                            <div class="fI-single fI-table fI-tabChecked">
                                <!--                            出发城市，到达城市等文字描述-->
                                <div class="fI-thead">
                                    <div class="fI-tr">
                                        <div class="fI-td">出发城市</div>
                                        <div class="fI-td">到达城市</div>
                                        <div class="fI-td">出发日期</div>
                                        <div class="fI-single-th fI-td">返回日期</div>
                                    </div>
                                </div>
                                <div class="fI-tbody">
                                    <div class="fI-tr">
                                        <div class="fI-td">
                                            <div class="fi-tds fi-tds-formCity">
                                                <div class="fi-tds-icon">
                                                    <div class="searchIcon searchIcon-from-fight"></div>
                                                </div>
                                                <div class="fi-tds-text">
                                                    <div class="ui-input-unit"><input type="text" placeholder=""
                                                                                      id="single-formCity"
                                                                                      value="全拼/简拼/汉字"
                                                                                      name="fromCity"
                                                                                      class="input-formCity ui-city-input"
                                                                                      autocomplete="off"
                                                                                      style="color: rgb(0, 0, 0);"
                                                                                      readonly="readonly">
                                                        <div class="input-helper ui-city-helper"><span
                                                                class="ui-ico ico-city "></span></div>
                                                    </div>
                                                    <%--                                                <input type="hidden" id="single-formCityCode" name="single-formCityCode"--%>
                                                    <%--                                                       value="SHA" class="input-formCity">--%>
                                                    <div class="searchIcon searchIcon-location"></div>
                                                </div>
                                                <div class="fi-tds-change"></div>
                                            </div>
                                        </div>
                                        <div class="fI-td">
                                            <div class="fi-tds fi-tds-toCity">
                                                <div class="fi-tds-icon">
                                                    <div class="searchIcon searchIcon-to-fight"></div>
                                                </div>
                                                <div class="fi-tds-text">
                                                    <div class="ui-input-unit"><input type="text" placeholder=""
                                                                                      id="single-toCity"
                                                                                      value="全拼/简拼/汉字"
                                                                                      name="toCity"
                                                                                      class="input-toCity ui-city-input"
                                                                                      autocomplete="off"
                                                                                      style="color: rgb(0, 0, 0);"
                                                                                      readonly="readonly">
                                                        <div class="input-helper ui-city-helper"><span
                                                                class="ui-ico ico-city "></span></div>
                                                    </div>
                                                    <%--                                                <input type="hidden" id="single-toCityCode" name="single-toCityCode"--%>
                                                    <%--                                                       value="CAN" class="input-toCity">--%>
                                                    <div class="searchIcon searchIcon-location"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="fI-td">
                                            <div class="fi-tds fi-tds-calender">
                                                <div class="fi-tds-icon">
                                                    <div class="searchIcon searchIcon-calender"></div>
                                                </div>
                                                <div class="fi-tds-text">
                                                    <div class="ui-input-unit">
                                                        <input type="text" class="choose-date ui-calendar-input"
                                                               readonly=""
                                                               id="single-formCalender" value=""
                                                               name="departureTime"
                                                               autocomplete="off"
                                                               readonly="readonly"
                                                               style="color: rgb(0, 0, 0); "
                                                               onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd',minDate:['#F{getToday()}'],maxDate:['#F{getLastDay()}']})">
                                                        <div class="input-helper ui-calendar-helper"><span
                                                                class="weekday"></span><span
                                                                class="ui-ico ico-calendar"></span></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="fI-td fI-td-last">
                                            <div class="fi-tds fi-tds-calender">
                                                <div class="fi-tds-icon">
                                                    <div class="searchIcon searchIcon-calender"></div>
                                                </div>
                                                <div class="fi-tds-text" style="background-color:#ebebe4"><input type="" class="choose-date calender-false" readonly="" id="" value="" name="" autocomplete="off" disabled="" otype="button" otitle="预订流程-航班选择-单程-返回日期">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="fi-search">
                                <button id="search-submit" otype="button" otitle="预订流程-航班选择-立即查询">立即查询
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--航班信息-->
    <div class="zls-flightInfoShow zls-scroll-space" data-index="0">
        <div class="zls-scroll zls-scroll-action">
            <div class="zls-fltitle">
                <div>单程：</div>
                <div class="dep" id="getDepCity0"><s:property value="fromCity"/></div>
                <div class="arrow"><i></i></div>
                <div class="arr" id="getArrCity0"><s:property value="toCity"/></div>
                <div class="psnnum">时间:
                    <span><s:date name="departureTime" format="yyyy"/> </span>年
                    <span><s:date name="departureTime" format="MM"/></span>月
                    <span><s:date name="departureTime" format="dd"/></span>日
                    <span><s:date name="departureTime" format="EEE"/></span>
                </div>
            </div>
            <div class="zls-filter-buy">
                <div class="zls-buy"><a
                        href="https://www.csair.com/cn/czadscale/2016/20160315/20150513.html?WT.inner_id=gw-jgbz-cxjg"
                        target="_blank"><i></i>价格保障 买贵全赔</a></div>
            </div>
            <div class="zls-flight-head">
                <div class="fligthL zls-headL">
                    <ul>
                        <li class="first"><span>航班信息</span></li>
                        <li><span otype="button" otitle="预订流程-航班选择-起飞时间" class="orderClick">起飞时间<div class="sequence"
                                                                                                     data-index="5"><i
                                class="up"></i><i class="down"></i></div></span></li>
                        <li><span otype="button" otitle="预订流程-航班选择-到达时间" class="orderClick">到达时间<div class="sequence"
                                                                                                     data-index="6"><i
                                class="up"></i><i class="down"></i></div></span></li>
                    </ul>
                </div>
                <div class="flightR zls-headR">
                    <ul>
                        <li>
                        <span otype="button" otitle="预订流程-航班选择-头等舱" class="orderClick">头等舱
                            <div class="sequence" data-index="0">
                                <i class="up"></i><i class="down"></i>
                            </div></span></li>
                        <li>
                        <span otype="button" otitle="预订流程-航班选择-公务舱" class="orderClick">商务舱
                            <div class="sequence" data-index="1">
                                <i class="up"></i><i class="down used"></i>
                            </div></span></li>
                        <li>
                        <span otype="button" otitle="预订流程-航班选择-明珠经济舱" class="orderClick">经济舱
                            <div class="sequence" data-index="2">
                                <i class="up"></i><i class="down"></i>
                            </div></span></li>
                        <li><span otype="button" otitle="预订流程-航班选择-经济舱" class="orderClick">预定</span>
                            <!--                        <div class="sequence" data-index="3">-->
                            <!--                            <i class="up"></i><i class="down"></i>-->
                            <!--                        </div></span>-->
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <s:if test="#session.flights.isEmpty()">
            <div>
                暂无所需航班
            </div>
        </s:if>
        <s:else>
            <div class="zls-flight">
                <ul class="zls-flg-ui">
                    <s:iterator value="#session.flights" var="flight">
                        <li class="zls-flight-cell">
                            <div class="fligthL">
                                <div class="zls-flgno">
                                    <div class="zls-flgno-info">
                                        <i></i>
                                        <s:property value="%{#flight.flightId}"/>
                                        <div class="zls-flgplane tooltip-trigger" data-plane="738"
                                             data-tip-class="plane-show"
                                             data-direction="br">
                                            <s:property value="%{#flight.airplane.airplaneId}"/>
                                            <s:property value="%{#flight.airplane.airplaneType}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="zls-flgtime zls-flgtime-r zls-flgtime-dep">
                                    <s:date name="%{#flight.departureTime}" format="HH:mm"/>
                                    <div class="zls-flplace">
                                        <s:property value="%{#flight.departureAirport.airportName}"/>
                                    </div>
                                </div>
                                <div class="zls-flg-during zls-trans-info">
                                    <div class="zls-flg-dir"><i></i></div>
                                    <div class="zls-flg-time"><i></i>2h35m</div>
                                </div>
                                <div class="zls-flgtime zls-flgtime-arr">
                                    <s:date name="%{#flight.arrivalTime}" format="HH:mm"/>
                                    <div class="zls-flplace">
                                        <s:property value="%{#flight.arrivalAirport.airportName}"/>
                                    </div>
                                </div>
                                <div class="zls-flgother">
                                    <div class="zls-meal tooltip-trigger" data-tip-class="food-show"></div>
                                </div>
                            </div>
                            <div class="fligthR">
                                <ul>
                                    <li data-cabin="0" class="zls-cabin-cell ">
                                        <s:property value="%{formatDouble(#flight.ticketInfo.firstClassTicketPrice)}"/>￥
                                        <div class="zls-lessSeat">
                                        <span>
                                        <s:property value="%{#flight.ticketInfo.firstClassTicket}"/>张
                                        </span>
                                        </div>
                                    </li>
                                    <li data-cabin="1" otype="button" class="zls-cabin-cell">
                                        <s:property
                                                value="%{formatDouble(#flight.ticketInfo.businessClassTicketPrice)}"/>￥
                                        <div class="zls-lessSeat">
                                        <span>
                                            <s:property value="%{#flight.ticketInfo.businessClassTicket}"/>张
                                        </span>
                                        </div>
                                    </li>
                                    <li data-cabin="2" otype="button" class="zls-cabin-cell"
                                        data-value="1620">
                                        <s:property
                                                value="%{formatDouble(#flight.ticketInfo.economyClassTicketPrice)}"/>￥
                                        <div class="zls-lessSeat">
                                        <span>
                                            <s:property value="%{#flight.ticketInfo.economyClassTicket}"/>张
                                        </span>
                                        </div>
                                    </li>
                                    <s:form action="findUsingFlight" method="GET">
                                        <s:hidden value="%{#flight.flightId}" name="flight.flightId"/>
                                        <li data-cabin="3" otype="button" class="zls-cabin-cell"
                                            data-value="1590">
                                            <button class="check-button">预定</button>
                                        </li>
                                    </s:form>
                                </ul>
                            </div>
                        </li>
                    </s:iterator>
                </ul>
            </div>
        </s:else>

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
