﻿<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/1
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台登录</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">

    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="js/img_ver.js"></script>

    <style>
        body{
            background-color: pink;
        }
        .bxs-row {
            margin-bottom:12px;
        }
        .logo-box {
            width:404px;
            margin:120px auto;
            border:1px solid #e5e5e5;
            border-radius:4px;
            box-shadow:0 4px 18px rgba(0,0,0,0.2);
            position:relative;
            overflow:hidden;
            height:360px;
        }
        .login {
            position:absolute;
            width:320px;left:0;
            top:0;
            padding: 42px 42px 36px;
            transition:all 0.8s;
        }
        .username,.password,.btn {
            height: 44px;
            width: 100%;
            padding: 0 10px;
            border: 1px solid #9da3a6;
            background: #fff;
            text-overflow: ellipsis;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            -khtml-border-radius: 4px;
            border-radius: 4px;
            -webkit-box-shadow: none;
            -moz-box-shadow: none;
            box-shadow: none;
            color: #000;
            font-size: 1em;
            font-family: Helvetica,Arial,sans-serif;
            font-weight: 400;
            direction: ltr;
            font-size:13px;
        }
        .submit {
            background-color: #0070ba;
            color:#fff;
            border:1px solid #0070ba;
        }
        .submit:hover {
            background-color:#005ea6;
        }
        .verBox {
            position:absolute;
            width:100%;
            text-align:center;
            left:404px;
            top:0;
            opacity:0;
            transition:all 0.8s;
            padding-top:55px;
        }
        .err {
            margin:12px 0 0;
            line-height:12px;
            height:12px;
            font-size:12px;
            color:red;
        }
    </style>

</head>
<body>

<div class="logo-box">
    <div class="login" style="">
        <div class="bxs-row" style="text-align:center;">
            <img id="logo" src="images/logo.jpg" style="width:72px;"><span class="tips" style="color:red;">忍住不哭来段口技</span>
        </div>
        <div class="bxs-row">
            <input type="text" id="account" class="username" placeholder="用户名">
            <p class=" err err-username"></p>
        </div>
        <div class="bxs-row">
            <input type="password" id="pwd" class="password" placeholder="密码">
            <p class="err err-password"></p>
        </div>
        <div class="bxs-row">
            <input type="submit" class="submit btn" value="登录">
        </div>
    </div>
    <div class="verBox">
        <div id="imgVer" style="display:inline-block;"></div>
    </div>
</div>
<script>
    imgVer({
        el:'$("#imgVer")',
        width:'260',
        height:'116',
        img:[
            'images/ver.png',
            'images/ver-1.png',
            'images/ver-2.png',
            'images/ver-3.png'
        ],
        success:function () {
            var account = $("#account").val();
            var pwd = $("#pwd").val()
            $.ajax({
                url:"/loginServlet?modName=adminLogin",
                type:"post",
                dataType:"text",
                data:"account="+account+"&pwd="+pwd,
                success:function (data) {
                    if (data=="登录成功"){
                        location.href="pages/adminMenu.html";
                    }else {
                        $(".login").css({
                            "left":"0",
                            "opacity":"1"
                        });
                        $(".verBox").css({
                            "left":"404px",
                            "opacity":"0"
                        });
                        $(".tips").html('你是不是不知道账号密码！？？？');
                        $("#logo").attr("src",'images/login-err.png')
                    }

                },
                error:function () {
                    alert('网络错误')
                }
            })


        },
        error:function () {
            //alert('错误什么都不执行')
        }
    });
    $(".submit").on('click',function () {
        if($(".username").val() == '') {
            // $(".err-username").html('杂种！！你用户名呢！？？？');
            $(".tips").html('老兄！！你用户名呢！？？？');
            $("#logo").attr("src",'images/null-username.jpg')
        } else if($(".password").val() == '') {
            // $(".err-password").html('畜生！！你密码呢！？？？');
            $(".tips").html('老兄！！你密码呢！？？？');
            $("#logo").attr("src",'images/null-password.jpg')
        } else {
            $(".login").css({
                "left":"-404px",
                "opacity":"0"
            });
            $(".verBox").css({
                "left":"0",
                "opacity":"1"
            })
        }
    })
</script>

</body>
</html>