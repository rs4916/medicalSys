<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>查看患者信息</title>
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
        <form action="#" method="get">
            <table>
                <tr>
                    <td colspan="2"><b>管理员:${user.name}</b></td>
                </tr>
                <tr>
                    <td colspan="2"><b>ID:${user.id}</b></td>
                </tr>
                <tr>
                    <td colspan="2" align="center" width="20px" style="font-size: 25px;margin-bottom: 10px;"><b>病人详情</b></td>
                </tr>
                <tr>
                    <td>姓名：</td>
                    <th><input type="text" name="name" id="name" value="${patient.name}" readonly><br></th>
                </tr>
                <tr>
                    <td>年龄:</td>
                    <th><input type="text" name="age" id="age" value="${patient.id}" readonly></th>
                </tr>
                <tr>
                    <td>生日:</td>
                    <th><input type="text" name="birthday" id="birthday" value="${patient.birthday}" readonly></th>
                </tr>
                <tr>
                    <td>余额:</td>
                    <th><input type="text" name="balance" id="balance" value="${patient.balance}" readonly ></th>
                </tr>
                <tr>
                    <td>地址:</td>
                    <th><input type="text" name="address" id="address" value="${patient.address}" readonly></th>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="button" class="btn btn-default" onclick="backAndFresh()"
                               style="margin-top: 10px; border-radius:6px; background-color:rgb(0,206,209)" value="返回">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>