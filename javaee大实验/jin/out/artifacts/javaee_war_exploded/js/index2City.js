var target2;
$(document).ready(function(){
    $("#ui-city-unit").hide();
    $("#fDepCity").focus(function(){
        $("#ui-city-unit").css({"top":"274px","left":"7.7%"});
        $("#ui-city-unit").show();//增加位置的修正
        target2="#fDepCity";
    });
    $("#fArrCity").focus(function(){
        $("#ui-city-unit").css({"top":"274px","left":"32.0%"});
        $("#ui-city-unit").show();
        target2="#fArrCity";
    });
    $(".ui-city-link").click(function(){
        console.log("target2:"+target2);
        console.log("$(this).text()"+$(this).text());
        $(target2).val($(this).text());
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


    // $("#fDepCity").blur(function(){
    //     setTimeout(function(){
    //         $("#ui-city-unit").hide();
    //     }, 300);
    // });
    //
    // $("#fArrCity").blur(function(){
    //     setTimeout(function(){
    //         $("#ui-city-unit").hide();
    //     }, 300);
    // });
});