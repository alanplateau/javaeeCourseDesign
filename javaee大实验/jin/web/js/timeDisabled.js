/*
 * Copyright(c)2002-2019
 *    项目名称:ARS55version
 *    文件名称:timeDisabled.js
 *    Date:2019/12/26 上午10:48
 *    Author:高源
 */
function CurentTime()
{
    var now = new Date();

    var year = now.getFullYear();       //年
    var month = now.getMonth() + 1;     //月
    var day = now.getDate();            //日

    var hh = now.getHours();            //时
    var mm = now.getMinutes();          //分

    var clock = year + "-";

    if(month < 10)
        clock += "0";

    clock += month + "-";

    if(day < 10)
        clock += "0";

    clock += day + " ";

    // if(hh < 10)
    //     clock += "0";
    //
    // clock += hh + ":";
    // if (mm < 10) clock += '0';
    // clock += mm;
    return(clock);
}

/*
num 获取当天多少天后的日期
*/

var today = new Date().getTime();

function getTimeByDay(num) {
    return today + 60 * 60 * 1000 * 24 * num;
}

function formatTime(time) {
    //new Date(time).toISOString()    => 2019-02-23T08:40:35.825Z
    return new Date(time).toISOString().split('T')[0];
}


function getToday() {
    return formatTime(today);
}

function getLastDay() {
    var lastDay = getTimeByDay(30);
    return formatTime(lastDay);
}

window.onload=function (ev) {
    console.log(getToday());
    console.log(getLastDay());//2019-03-23
}
