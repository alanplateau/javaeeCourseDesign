<%--
  Created by IntelliJ IDEA.
  User: 13345
  Date: 2019/12/24
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@taglib prefix="s" uri="/struts-tags" %>
</head>
<body>
hello
<s:iterator value="#session.flights" var="flight">
<%--    <s:property value="%{#flight.departureTime}"/>--%>
<%--    <s:property value="%{getText('{0,date,yyyy-MM-dd HH:mm}',{})}"--%>
    <s:date name="%{#flight.departureTime}" format="yyyy-MM-dd HH:mm"/>
    <s:property value="%{#flight.flightId}"/>
    <s:property value="%{#flight.arrivalTime}"/>
    <s:property value="%{#flight.airplane.airplaneID}"/>
    <s:property value="%{#flight.departureAirport.airportName}"/>
    <s:property value="%{#flight.arrivalAirport.airportName}"/>
    <s:property value="%{formatDouble(#flight.ticketInfo.firstClassTicketPrice)}"/>
</s:iterator>
</body>
</html>
