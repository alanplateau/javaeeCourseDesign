/*
 * Copyright(c)2002-2019
 *    项目名称:ARS55version
 *    文件名称:City.js
 *    Date:2019/12/25 下午7:50
 *    Author:高源
 */

/*
 * *
 *  * @author  高源
 *  * @date  ${DATE} ${TIME}
 *  * @version 1.0
 *
 */

var target;
$(document).ready(function(){
    $("#ui-city-unit").hide();
    $("#single-formCity").focus(function(){
        $("#ui-city-unit").css({"top":"295px","left":"5.9%"});
        $("#ui-city-unit").show();//增加位置的修正
        target="#single-formCity";
    });
    $("#single-toCity").focus(function(){
        $("#ui-city-unit").css({"top":"295px","left":"27.2%"});
        $("#ui-city-unit").show();
        target="#single-toCity";
    });
    $(".ui-city-link").click(function(){
        $(target).val($(this).text());
        $("#ui-city-unit").hide();
    });

    //选中abcde
    $("#index1").click(function () {
        for(var i=1;i<=5;i++){
            if($("#index"+i).hasClass("ui-tab-on")){
                $("#index"+i).removeClass("ui-tab-on");
            }
            if($(".tab"+i).hasClass("ui-content-on")){
                $(".tab"+i).removeClass("ui-content-on");
            }
        }
        $("#index1").addClass("ui-tab-on");
        $(".tab1").addClass("ui-content-on");
    });

    //选中fghij
    $("#index2").click(function () {
        for(var i=1;i<=5;i++){
            if($("#index"+i).hasClass("ui-tab-on")){
                $("#index"+i).removeClass("ui-tab-on");
                console.log("index"+i);
            }
            if($(".tab"+i).hasClass("ui-content-on")){
                $(".tab"+i).removeClass("ui-content-on");
            }
        }
        $("#index2").addClass("ui-tab-on");
        $(".tab2").addClass("ui-content-on");
    });

    $("#index3").click(function () {
        for(var i=1;i<=5;i++){
            if($("#index"+i).hasClass("ui-tab-on")){
                $("#index"+i).removeClass("ui-tab-on");
            }
            if($(".tab"+i).hasClass("ui-content-on")){
                $(".tab"+i).removeClass("ui-content-on");
            }
        }
        $("#index3").addClass("ui-tab-on");
        $(".tab3").addClass("ui-content-on");
    });

    $("#index4").click(function () {
        for(var i=1;i<=5;i++){
            if($("#index"+i).hasClass("ui-tab-on")){
                $("#index"+i).removeClass("ui-tab-on");
            }
            if($(".tab"+i).hasClass("ui-content-on")){
                $(".tab"+i).removeClass("ui-content-on");
            }
        }
        $("#index4").addClass("ui-tab-on");
        $(".tab4").addClass("ui-content-on");
    });

    $("#index5").click(function () {
        for(var i=1;i<=5;i++){
            if($("#index"+i).hasClass("ui-tab-on")){
                $("#index"+i).removeClass("ui-tab-on");
            }
            if($(".tab"+i).hasClass("ui-content-on")){
                $(".tab"+i).removeClass("ui-content-on");
            }
        }
        $("#index5").addClass("ui-tab-on");
        $(".tab5").addClass("ui-content-on");
    });


    // $("#single-formCity").blur(function(){
    //     setTimeout(function(){
    //         $("#ui-city-unit").hide();
    //     }, 300);
    // });
    //
    // $("#single-toCity").blur(function(){
    //     setTimeout(function(){
    //         $("#ui-city-unit").hide();
    //     }, 300);
    // });
});