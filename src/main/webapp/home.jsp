<%@ page import="zrs.pojo.User" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>系统主页</title>
    <link rel="stylesheet" type="text/css" href="/css/home.css">
</head>

<body>
    <header>
        <div class="main">
            <ul>
                <h3 style="color: #ffffff; margin-bottom: 10px;">管理员:${user.name}</h3>
                <h4 style="color: #ffffff" class="two">ID:${user.id}</h4>
            </ul>
            <ul>
                <li class="active"><a href="/doctor?method=queryAll">医生</a></li>
                <li class="active"><a href="/patient?method=queryAll">病人</a></li>
                <li class="active"><a href="/medicine?method=queryAll">药品</a></li>
                <li class="active"><a href="page/register/addRegister.jsp">挂号</a></li>
                <li class="active"><a href="page/pay/pay.jsp">缴费</a></li>
                <li class="active"><a href="/register?method=queryAll">查看病历</a></li>
                <li class="active">
                    <form action="/logout" method="post">
                        <input class="button_box" type="submit" name="submit" value="点我注销">
                    </form>
                </li>
            </ul>
        </div>
        <div class="title">
            <h1>
                <span style="color: crimson;">Welcome </span> to
                <span style="color: crimson;">the </span>Homepage
            </h1>
        </div>
    </header>
</body>
</html>