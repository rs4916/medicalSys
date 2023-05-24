<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>缴费中心</title>
    <style>
        body {
            background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)), url("/images/pageBackground.jpg");
            height: 100vh;
            background-size: cover;
            background-position: center;
        }
        div {
            width: 300px;
            height: 100px;
            margin: auto;
        }
        .submitBtn {
            margin-top: 20px;
            margin-left: 70px;
        }
    </style>
    <script>
        function backAndFresh(){
            var url = document.referrer;
            window.location = url;
        }
    </script>
</head>

<body>
    <%--<%
        String errInfo = (String) request.getAttribute("noPayList");
        if(errInfo != null){
    %>
    <script type="javascript" language="JavaScript">
        alert("<%=errInfo%>");
        // window.location='pay.jsp';
    </script>
    <%
        }
    %>--%>

    <h2><a href="../../home.jsp">返回系统主页</a></h2>
    <br><br><br><br><br>
    <br><br><br><br><br>
    <div>
        <h3>管理员:${user.name}</h3>
        <h4 class="two">ID:${user.id}</h4>
        <h3 align="center">缴费中心</h3>
        <form action="/register?method=getNoPayList" method="post">
            <b>病人id：</b>&nbsp;<input type="text" name="pid" id="pid"><br>
            <input type="submit" class="submitBtn" value="查看缴费列表"
                   style="width: 100px; border-radius:6px; background-color:rgb(0,206,209)">&nbsp;&nbsp;
            <input type="button" class="btn btn-default" onclick="backAndFresh()" value="返回"
                   style="margin-top: 10px; border-radius:6px; background-color:rgb(0,206,209)">
        </form>
    </div>
</body>
</html>