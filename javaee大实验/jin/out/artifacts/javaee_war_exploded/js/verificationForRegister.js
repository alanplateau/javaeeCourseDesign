/*
 * Copyright(c)2002-2019
 *    项目名称:ARS55version
 *    文件名称:verificationForRegister.js
 *    Date:2019/12/27 上午11:42
 *    Author:高源
 */
/*
 * Copyright(c)2002-2019
 *    项目名称:ARS55version
 *    文件名称:verificationJs.js
 *    Date:2019/12/26 下午5:03
 *    Author:高源
 */

function callAction() {
    var phoneNumber=$("#account").val();
    console.log(phoneNumber);
    window.location.href="/jin_war_exploded/sendMessageForRegisterAction?phoneNumber="+phoneNumber;
}

$(document).ready(function () {
    $("#sendVerification").click(function () {
        console.log(1);
        callAction();
    })
})

