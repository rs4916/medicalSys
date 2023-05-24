<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>医生列表</title>
    <style>
        body {
            background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)), url("/images/pageBackground.jpg");
            height: 100vh;
            background-size: cover;
            background-position: center;
        }
        * {
            margin: 0;
            padding: 0;
        }
        a {
            text-decoration: none;
        }
        a:hover {
            color: pink;
        }
        div {
            width: 1000px;
            height: 500px;
            margin: 100px auto;
            overflow: hidden;
        }
        .one {
            height: 30px;
            margin-left: 30px;
        }
        .ten {
            margin: 20px 175px;
        }
        input {
            margin-left: 350px;
            margin-top: 10px;
        }
    </style>
</head>

<body>
    <h2><a href="../../home.jsp">返回系统主页</a></h2>
    <div>
        <div class="ten">
            <table border="1" cellspacing="0" class="one" width="700" style="background-color:rgb(245,255,250)">
                <tr>
                    <td colspan="2" align="center"><b>管理员：${user.name}</b></td>
                    <td colspan="2" align="center"><b>ID：${user.id}</b></td>
                </tr>
                <tr>
                    <th width="100">患者</th>
                    <th width="100">医生</th>
                    <th width="100">药物</th>
                    <th width="100">管理员</th>
                    <th width="100">创建时间</th>
                    <th width="100">是否付款</th>
                </tr>
                <c:forEach var="register" items="${registerList}">
                <tr align="center">
                    <td>${register.patient.name}</td>
                    <td>${register.doctor.name}</td>
                    <td>${register.medicine.name}</td>
                    <td>${register.user.name}</td>
                    <td>${register.creation_time}</td>
                    <td>${register.is_payment}</td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>