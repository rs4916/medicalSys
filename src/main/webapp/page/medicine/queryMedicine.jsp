<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>查看药物信息</title>
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
                <td colspan="2" align="center" width="20px" style="font-size: 25px;margin-bottom: 10px;"><b>药品详情</b></td>
            </tr>
            <tr>
                <td>名称:</td>
                <th><input type="text" name="name" id="name" value="${medicine.name}" readonly><br></th>
            </tr>
            <tr>
                <td>功效:</td>
                <th><input type="text" name="function" id="function" value="${medicine.function}" readonly></th>
            </tr>
            <tr>
                <td>生产日期:</td>
                <th><input type="text" name="date_of_manufacture" id="date_of_manufacture"  value="${medicine.date_of_manufacture}" readonly></th>
            </tr>
            <tr>
                <td>产地:</td>
                <th><input type="text" name="address" id="address" value="${medicine.address}" readonly></th>
            </tr>
            <tr>
                <td>忌讳:</td>
                <th><input type="text" name="taboo" id="taboo" value="${medicine.taboo}" readonly></th>
            </tr>
            <tr>
                <td>价格:</td>
                <th><input type="text" name="price" id="price" value="${medicine.price}" readonly></th>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" class="btn btn-default" onclick="backAndFresh()" value="返回"
                           style="margin-top: 10px; border-radius:6px; background-color:rgb(0,206,209)">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>

</html>