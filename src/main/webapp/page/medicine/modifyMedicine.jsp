<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改药物信息</title>
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
    <form action="/medicine?method=updateMedicine&id=${medicine.id}" method="post">
        <table>
            <tr>
                <td colspan="2"><b>管理员：${user.name}</b></td>
            </tr>
            <td></td>
                <td colspan="2"><b>ID：${user.id}</b></td>
            </tr>
            <tr>
                <td colspan="2" align="center" width="20px" style="font-size: 25px;margin-bottom: 10px;"><b>药品修改</b></td>
            </tr>
            <tr>
                <td><b>名&nbsp;&nbsp;称：</b></td>
                <th><input type="text" name="name" id="name" value="${medicine.name}"></th>
            </tr>
            <tr>
                <td><b>功&nbsp;&nbsp;效：</b></td>
                <th><input type="text" name="function" id="function" value="${medicine.function}"></th>
            </tr>
            <tr>
                <td><b>生产日期：</b></td>
                <th><input type="text" name="date_of_manufacture" id="date_of_manufacture" value="${medicine.date_of_manufacture}"></th>
            </tr>
            <tr>
                <td><b>产&nbsp;&nbsp;地：</b></td>
                <th><input type="text" name="address" id="address" value="${medicine.address}"></th>
            </tr>
            <tr>
                <td><b>忌&nbsp;&nbsp;讳：</b></td>
                <th><input type="text" name="taboo" id="taboo" value="${medicine.taboo}"></th>
            </tr>
            <tr>
                <td><b>价&nbsp;&nbsp;格：</b></td>
                <th><input type="text" name="price" id="price" value="${medicine.price}"></th>
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