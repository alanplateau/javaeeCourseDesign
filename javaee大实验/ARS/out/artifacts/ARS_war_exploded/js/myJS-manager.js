function testManager(data) {
    console.log(data.id);
    selectID=data.id;
    a = document.getElementById(selectID).getElementsByTagName("a");
    var result=new Array();
    for(var i=0;i<a.length;i++){
        result.push(a[i].innerHTML);
    }
    console.log(result);
    document.getElementById("input-account").setAttribute("value",result[0]);
    document.getElementById("input-password").setAttribute("value",result[1]);
    document.getElementById("input-type").setAttribute("value",result[2]);
    var modal = $('#managerDetailModal');
    modal.modal('toggle');
}
function submitFun(act)
{
    var managerInfo=document.getElementsByName("managerInfo");
    console.log(managerInfo);
    if(act=="del"){
        managerInfo[0].setAttribute('action','adminAction.action?method=delManager');
        managerInfo[0].submit();
    }
    if(act=="alt"){
        managerInfo[0].setAttribute('action','adminAction.action?method=altManager');
        managerInfo[0].submit();
    }
    if(act=="load"){
        managerInfo[0].setAttribute('action','adminAction.action?method=loadManager');
        managerInfo[0].submit();
    }
}

function submitFun2(act)
{
    var managerInfo2=document.getElementsByName("managerInfo2");
    console.log(managerInfo2);
    if(act=="add"){
        managerInfo2[0].setAttribute('action','adminAction.action?method=addManager');
        managerInfo2[0].submit();
    }
    if(act=="load"){
        managerInfo2[0].setAttribute('action','adminAction.action?method=loadManager');
        managerInfo2[0].submit();
    }
}



