<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改患者信息</title>
    <style>
        body {
            background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)), url("/images/pageBackground.jpg");
            height: 100vh;
            background-size: cover;
            background-position: center;
        }
        div {
            width: 300px;
            height: 400px;
            margin: auto;

        }
        table {
            margin-left: 30px;
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
<div>
    <br><br><br><br><br>
    <br><br><br><br><br>
    <form action="/patient?method=updatepatient&id=${patient.id}" method="post">
        <table>
            <tr>
                <td colspan="2"><b>管理员：${user.name}</b></td>
            </tr>
            <tr>
                <td colspan="2"><b>ID：${user.id}</b></td>
            </tr>
            <tr>
                <td colspan="2" align="center" width="20px" style="font-size: 25px;margin-bottom: 10px;"><b>病人修改</b></td>
            </tr>
            <tr>
                <td><b>姓&nbsp;&nbsp;名：</b></td>
                <th><input type="text" name="name" id="name" value="${patient.name}"><br></th>
            </tr>
            <tr>
                <td><b>年&nbsp;&nbsp;龄：</b></td>
                <th><input type="text" name="age" id="age" value="${patient.age}"></th>
            </tr>
            <tr>
                <td><b>生&nbsp;&nbsp;日：</b></td>
                <th><input type="text" name="birthday" id="birthday" value="${patient.birthday}"></th>
            </tr>
            <tr>
                <td><b>余&nbsp;&nbsp;额：</b></td>
                <th><input type="text" name="balance" id="balance" value="${patient.balance}"></th>
            </tr>
            <tr>
                <td><b>地&nbsp;&nbsp;址：</b></td>
                <th><input type="text" name="address" id="address" value="${patient.address}"></th>
            </tr>
            <tr>
                <td align="right"><input type="submit" value="提交"
                                         style="margin-top: 10px; border-radius:6px; background-color:rgb(0,206,209)"></td>
                <td colspan="2" align="left">
                    <input type="button" class="btn btn-default" onclick="backAndFresh()" value="返回"
                           style="margin-top: 10px; border-radius:6px; background-color:rgb(0,206,209)">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>

</html>