/**
 * Created by lenovo on 2019/10/8.
 */

var username;  //用户名
var phone;     //手机号
var pwd;       //密码
var pwd1;       //确认密码
var path = $("#path").val();//获取全文路径

//    检验用户名begin
function checkUsername(obj) {
    username = obj.value;//获取用户名
    if (username.length == 0){
        $("#span_uname").html("用户名不能为空");
        document.getElementById("registerBtn").disabled=true;
    }else {
        $("#span_uname").html("");
        document.getElementById("registerBtn").disabled=false;
    }
}
//    检验用户名end

//检验手机号是否满足条件begin
function checkPhone(obj) {
    phone = obj.value;
    var regex = /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;

    if (phone.length == 0){
        $("#span_phone").html("手机号不能为空");
        //禁用注册按钮
        document.getElementById("registerBtn").disabled=true;
    }
    else if (!regex.test(phone)){
        $("#span_phone").html("手机号不合法");
        document.getElementById("registerBtn").disabled=true;
    }else {
        $.get(path + "/judgePhoneAct?phone=" + phone,function (data) {
            if (data == "yes"){
//                   alert("ok");
                $("#span_phone").html("");
                document.getElementById("registerBtn").disabled=false;
            }else if(data == "no"){
                $("#span_phone").html("手机号已被注册");
                document.getElementById("registerBtn").disabled=true;
            }
        });
    }
}
//检验手机号是否满足条件end

//检验密码是否满足条件begin
function checkPassword(obj) {
    pwd = obj.value;
    //
    var regex = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,10}$/;
//        if (!regex.test(pwd)){
//            $("#span_pwd").html("密码长度为6-10位");
//        }

    if(pwd.length == 0){
        $("#span_pwd").html("密码不能为空");
//            document.getElementById("error-tip2").innerText="密码不能为空";

        document.getElementById("registerBtn").disabled=true;
//            $("#registerBtn").style.cursor = "auto";
        document.getElementById("registerBtn").style.cursor="auto";
    }else if(!(regex.test(pwd))){

        $("#span_pwd").html("密码为6-10位字母和数字");
        //让注册按钮不可用
        document.getElementById("registerBtn").disabled=true;
        document.getElementById("registerBtn").style.cursor="wait";
    }else{
        $("#span_pwd").html("");
//            document.getElementById("sendButton").style.cursor="pointer";
        document.getElementById("registerBtn").disabled=false;
        document.getElementById("registerBtn").style.cursor="pointer";
    }
}
//检验密码是否满足条件end

//检验确认密码begin
function checkPassword1(obj) {
    pwd = $("#exampleInputPassword2").val();
    pwd1 = obj.value;
    if (pwd != pwd1){
        $("#span_pwd1").html("密码不一致，请重新输入");
        document.getElementById("registerBtn").disabled=true;
    }else {
        $("#span_pwd1").html("");
        document.getElementById("registerBtn").disabled=false;
    }
}
//    检验确认密码end


function register() {
    var username = $("#exampleInputName2").val(); //获取用户名
    var password = $("#exampleInputPassword1").val();  //获取密码
    var password2 = $("#exampleInputPassword2").val(); //获取确认密码
    var phone = $("#exampleInputUsername").val(); //获取手机号
    if (password != password2){
        alert("两次密码不一致，请重新输入");
    }else {
        //发送到后台
        window.location = path + "/addUserInfo?username=" + username + "&password="+password + "&phone=" + phone;
    }
}


function goLogin() {
    window.location = path + "/goLoginAct" ;
}
