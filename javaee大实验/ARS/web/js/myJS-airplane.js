function testAirplane(data) {
    console.log(data.id);
    selectID=data.id;
    a = document.getElementById(selectID).getElementsByTagName("a");
    var result=new Array();
    for(var i=0;i<a.length;i++){
        result.push(a[i].innerHTML);
    }
    console.log(result);
    document.getElementById("input-airplaneId").setAttribute("value",result[0]);
    document.getElementById("input-airplaneType").setAttribute("value",result[1]);
    document.getElementById("input-firstClassSeats").setAttribute("value",result[2]);
    document.getElementById("input-economyClassSeats").setAttribute("value",result[3]);
    document.getElementById("input-businessClassSeats").setAttribute("value",result[4]);
    var modal = $('#airplaneDetailModal');
    modal.modal('toggle');
}
function submitFun(act)
{
    var airplaneInfo=document.getElementsByName("airplaneInfo");
    console.log(airplaneInfo);
    if(act=="del"){
        airplaneInfo[0].setAttribute('action','adminAction.action?method=delAirplane');
        airplaneInfo[0].submit();
    }
    if(act=="alt"){
        airplaneInfo[0].setAttribute('action','adminAction.action?method=altAirplane');
        airplaneInfo[0].submit();
    }
    if(act=="load"){
        airplaneInfo[0].setAttribute('action','adminAction.action?method=loadAirplane');
        airplaneInfo[0].submit();
    }
}

function submitFun2(act)
{
    var airplaneInfo2=document.getElementsByName("airplaneInfo2");
    console.log(airplaneInfo2);
    if(act=="add"){
        airplaneInfo2[0].setAttribute('action','adminAction.action?method=addAirplane');
        airplaneInfo2[0].submit();
    }
    if(act=="load"){
        airplaneInfo2[0].setAttribute('action','adminAction.action?method=loadAirplane');
        airplaneInfo2[0].submit();
    }
}



