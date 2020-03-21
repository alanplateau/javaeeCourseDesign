function testFlight(data) {
    console.log(data.id);
    selectID=data.id;
    a = document.getElementById(selectID).getElementsByTagName("a");
    var result=new Array();
    for(var i=0;i<a.length;i++){
        result.push(a[i].innerHTML);
    }
    console.log(result);
    document.getElementById("input-flightId").setAttribute("value",result[0]);
    document.getElementById("input-departureTime").setAttribute("value",result[1]);
    document.getElementById("input-arrivalTime").setAttribute("value",result[2]);
    $("#input-airplaneId").val(result[3]);
    $('#input-departureAirport option:contains(' + result[4] + ')').each(function(){
        if ($(this).text() == result[4]) {
            $(this).attr('selected', true);
        }
    });
    $('#input-arrivalAirport option:contains(' + result[5] + ')').each(function(){
        if ($(this).text() == result[5]) {
            $(this).attr('selected', true);
        }
    });
    document.getElementById("input-firstClassTicket").setAttribute("value",result[6]);
    document.getElementById("input-businessClassTicket").setAttribute("value",result[7]);
    document.getElementById("input-economyClassTicket").setAttribute("value",result[8]);
    document.getElementById("input-firstClassTicketPrice").setAttribute("value",result[9]);
    document.getElementById("input-businessClassTicketPrice").setAttribute("value",result[10]);
    document.getElementById("input-economyClassTicketPrice").setAttribute("value",result[11]);
    var modal = $('#flightDetailModal');
    modal.modal('toggle');
}
function submitFun(act)
{
    var flightInfo=document.getElementsByName("flightInfo");
    console.log(flightInfo);
    if(act=="del"){
        flightInfo[0].setAttribute('action','adminAction.action?method=delFlight');
        flightInfo[0].submit();
    }
    if(act=="alt"){
        flightInfo[0].setAttribute('action','adminAction.action?method=altFlight');
        flightInfo[0].submit();
    }
    if(act=="load"){
        flightInfo[0].setAttribute('action','adminAction.action?method=loadFlight');
        flightInfo[0].submit();
    }

}
function submitFun2(act)
{
    var flightInfo2=document.getElementsByName("flightInfo2");
    console.log(flightInfo2);
    if(act=="add"){
        flightInfo2[0].setAttribute('action','adminAction.action?method=addFlight');
        flightInfo2[0].submit();
    }
    if(act=="load"){
        flightInfo2[0].setAttribute('action','adminAction.action?method=loadFlight');
        flightInfo2[0].submit();
    }
}


