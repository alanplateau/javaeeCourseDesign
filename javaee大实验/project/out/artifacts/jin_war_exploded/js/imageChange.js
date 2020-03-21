var currentImg=1;

function nextI() {
    currentImg+=1;
    if(currentImg>6)currentImg=1;
    $(".imageChange").css({"background":"url('img/imageChange/travel"+currentImg+".jpg')"})
}


$(document).ready(function () {

    $(".flex-control-nav li a").click(function () {
        var index=this.getAttribute("data-id");
        $(".imageChange").css({"background":"url('img/imageChange/travel"+index+".jpg')"})
        currentImg=index;
    })
    setInterval("nextI()",3000);
    
})