function testAirport(data) {
    console.log(data.id);
    selectID=data.id;
    a = document.getElementById(selectID).getElementsByTagName("a");
    var result=new Array();
    for(var i=0;i<a.length;i++){
        result.push(a[i].innerHTML);
    }
    console.log(result);
    document.getElementById("input-airportId").setAttribute("value",result[0]);
    document.getElementById("input-airportName").setAttribute("value",result[1]);
    document.getElementById("input-city").setAttribute("value",result[2]);
    var modal = $('#airportDetailModal');
    modal.modal('toggle');
}
function submitFun(act)
{
    var airportInfo=document.getElementsByName("airportInfo");
    console.log(airportInfo);
    if(act=="del"){
        airportInfo[0].setAttribute('action','adminAction.action?method=delAirport');
        airportInfo[0].submit();
    }
    if(act=="alt"){
        airportInfo[0].setAttribute('action','adminAction.action?method=altAirport');
        airportInfo[0].submit();
    }
    if(act=="load"){
        airportInfo[0].setAttribute('action','adminAction.action?method=loadAirport');
        airportInfo[0].submit();
    }
}

function submitFun2(act)
{
    var airportInfo2=document.getElementsByName("airportInfo2");
    console.log(airportInfo2);
    if(act=="add"){
        airportInfo2[0].setAttribute('action','adminAction.action?method=addAirport');
        airportInfo2[0].submit();
    }
    if(act=="load"){
        airportInfo2[0].setAttribute('action','adminAction.action?method=loadAirport');
        airportInfo2[0].submit();
    }
}



