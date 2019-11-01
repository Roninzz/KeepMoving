/**
 * Created by lenovo on 2019/10/8.
 */

var inputCode; //获取输入的验证码
var code;//接收后台返回的验证码
var path = $("#path").val();//获取全文路径

function logincheckPhone(obj) {
    var phone = obj.value;//记录输入框的电话号码
    var regex = /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;
    if (!regex.test(phone)){
        $("#span_phone").html("请输入正确的手机号");
        document.getElementById("btn_message").disabled = true;
    }else {
        $.get(path + "/judgePhoneAct?phone=" + phone, function (data) {
            if (data == "yes") {
                //                   alert("ok");
                $("#span_phone").html("手机号不存在，请先注册");
                document.getElementById("btn_message").disabled = true;
            } else if (data == "no") {
                $("#span_phone").html("");
                document.getElementById("btn_message").disabled = false;
            }
        });
    }
}

//    ajax方式,
var intervalId;
$(function () {
    $("#btn_message").click(function () {
        var phone = $("#exampleInputName2").val(); //获取输入的手机号
        $.get(path + "/sendMsg?phone=" + phone, function (data) {
            code = data; //获取后台返回的验证码
//                console.log("后台返回的验证码为：" + code);
        });

        //点击之后禁用按钮
        document.getElementById("btn_message").disabled=true;
        //设置一个定时器,并接收其id
        intervalId = setInterval(function () {
            myTimer()
        },1000);
    });
});

//设置定时器
var second = 60;
function myTimer() {
    $("#btn_message").html(second-- + "秒");

    //当秒数为-1时，清除定时器,并让按钮变为可用状态
    if (second == -1){
        clearInterval(intervalId);  //清除定时器
        document.getElementById("btn_message").disabled=false;
        $("#btn_message").html("获取验证码");
        second = 60;

    }

}
var code1;
//登录成功转发去首页
function goIndex() {
    var phone = $("#exampleInputName2").val(); //获取输入的手机号
    inputCode = $("#exampleInputName4").val();

    //发送ajax请求到后台查看验证码是否正确
    $.get(path + '/checkCode?phone=' + phone,function (data) {
        code1 = data;
        if (code1 === "error"){
            $("#span_check").html("验证码失效，请重新发送")
        }else if (inputCode === code1){
            window.location = path + "/goIndex?phone=" + phone;
        }else {
            $("#span_check").html("验证码错误")
        }
    });


// //        console.log("前台输入的验证码为" + inputCode);
//     if (inputCode == code) {
//         window.location = path + "/goIndex?phone=" + phone;
//
//     } else {
//         $("#span_check").html("验证码错误")
//     }
}



function goRegister() {
    window.location = path + "/registerAct";
}

