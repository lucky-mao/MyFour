
layui.use('layer', function() { //独立版的layer无需执行这一句
    var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
})

    $(document).ready(function() {

        $(".form").slideDown(500);

        $("#landing").addClass("border-btn");

        $("#registered").click(function() {
            $("#landing").removeClass("border-btn");
            $("#landing-content").hide(500);
            $(this).addClass("border-btn");
            $("#registered-content").show(500);

        })

        $("#landing").click(function() {
            $("#registered").removeClass("border-btn");
            $(this).addClass("border-btn");

            $("#landing-content").show(500);
            $("#registered-content").hide(500);
        })
    });
function zz(s) {
    var r = /[a-zA-Z0-9]/g;
    var re =new RegExp(r);
    if (re.test(s)){
        return true;
    }else {
        return false;
    }
}
function login() {
    var account = $("#account").val();
    var pwd = $("#pwd").val();
    if (account!=null&&pwd!=null&&account.length>=6){
        $.ajax({
            url:"/loginServlet",
            type:"post",
            dataType:"text",
            data:"modName=login"+"&account="+account+"&pwd="+pwd,
            success:function (data) {
                if (data=="登录成功"){
                    location.href="pages/menu.html";
                }else {
                    layer.open("账号或密码错误", {
                        time: 0 //不自动关闭
                        , btn: ['确定']
                        , yes: function (index) {
                            layer.close(index);
                        }
                    });
                }
            },
            error:function () {
                alert('网络错误')
            }

        })
    }
}
//用户注册
function register() {
    var rAccount = $("#rAccount").val();
    var pwd1=$("#rpwd").val();
    var pwd2=$("#rpwd2").val();
    var sex = $("input[name='sex']:checked").val();
    var education = $("#education option:selected").text();
    var major = $("#major option:selected").text();
    var phone =$("#phone").val();
    var email=$("#email").val();
    if (rAccount!=null&&pwd1!=null&&pwd2!=null&&sex!=null&&education!=null&&major!=null&&phone!=null&&email!=null){
        if (pwd1==pwd2){
            $.ajax({
                url:"/loginServlet?modName=register",
                type:"post",
                dataType:"text",
                data:"account="+rAccount+"&pwd="+pwd1+"&sex="+sex+"&education="+education+
                "&major="+major+"&phone="+phone+"&email="+email,
                success:function (data) {
                    if (data=="注册成功"){
                        layer.open("注册成功", {
                            time: 0 //不自动关闭
                            , btn: ['确定']
                            , yes: function (index) {
                                layer.close(index);
                            }
                        });
                    }else {
                        layer.open("注册失败，请核对信息", {
                            time: 0 //不自动关闭
                            , btn: ['确定']
                            , yes: function (index) {
                                layer.close(index);
                            }
                        });
                    }
                },
                error:function () {
                    alert('网络错误')
                }
            })
        }else {
            layer.open("请核对两次密码", {
                time: 0 //不自动关闭
                , btn: ['确定']
                , yes: function (index) {
                    layer.close(index);
                }
            });
        }
    }
}
//用户注册账户查询
function existence() {
    var rAccount = $("#rAccount").val();
    var re = zz(rAccount);
    if (re==true){
        if (rAccount.length<6){
            $("#rAccount").after("<a style='color: red;font-size: 10px'>请输入至少6个字符</a>")
            return false;
        }else {
            $.ajax({
                url:"/loginServlet?modName=existence",
                type:"post",
                dataType:"text",
                data:"account="+rAccount,
                success:function (data) {
                  if (data=="有"){
                      $("#rAccount").nextAll().remove();
                      $("#rAccount").after("<a style='color: red;font-size: 10px'>用户已存在</a>")
                      return false;
                  }else {
                      $("#rAccount").nextAll().remove();
                      return true;
                  }
                },
                error:function () {
                    alert('网络错误')
                }

            })
        }
    }else {
        $("#rAccount").after("<a>非法字符！</a>")
        return false;
    }
}
function pwdin() {
    var pwd1 = $("#rPwd").val();
    var pwd2 = $("#rPwd2").val();
    if (pwd1!=null&&pwd1.length>0){
        if(pwd1==pwd2){
            $("#rPwd").nextAll().remove();
            $("#rPwd2").nextAll().remove();
        }else {
            $("#rPwd").nextAll().remove();
            $("#rPwd2").nextAll().remove();
            $("#rPwd2").after("<a style='color: red;font-size: 10px'>两次密码不同！</a>")
        }
    }else {
        $("#rPwd").nextAll().remove();
        $("#rPwd2").nextAll().remove();
        $("#rPwd").after("<a style='color: red;font-size: 10px'>密码不能为空</a>")
    }
}
function pwdin2() {
    var pwd1 = $("#rPwd").val();
    var pwd2 = $("#rPwd2").val();
    if (pwd2!=null&&pwd2.length>0){
        if(pwd1==pwd2){
            $("#rPwd").nextAll().remove();
            $("#rPwd2").nextAll().remove();
        }else {
            $("#rPwd").nextAll().remove();
            $("#rPwd2").nextAll().remove();
            $("#rPwd2").after("<a style='color: red;font-size: 10px'>两次密码不同！</a>")
        }
    }
}