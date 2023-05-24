<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加医生</title>
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

        h4 {
            margin-left: 30px;
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
    <form action="/doctor?method=addDoctor" method="post">
        <table>
            <tr>
                <td colspan="2"><b>管理员:${user.name}</b></td>
            </tr>
            <tr>
                <td colspan="2"><b>ID:${user.id}</b></td>
            </tr>
            <tr>
                <td colspan="2" align="center" width="20px" style="font-size: 25px;margin-bottom: 10px;"><b>添加医生</b></td>
            </tr>
            <tr>
                <td><b>姓名：</b></td>
                <th><input type="text" name="name" id="name"><br></th>
            </tr>
            <tr>
                <td><b>年龄：</b></td>
                <th><input type="text" name="age" id="age"></th>
            </tr>
            <tr>
                <td><b>生日：</b></td>
                <th><input type="text" name="birthday" id="birthday" placeholder="例：1900-01-01"></th>
            </tr>
            <tr>
                <td><b>资历：</b></td>
                <th><input type="text" name="seniority" id="seniority"></th>
            </tr>
            <tr>
                <td><b>职务：</b></td>
                <th><input type="text" name="post" id="post"></th>
            </tr>
            <tr>
                <td><input type="submit" value="提交"
                           style="margin-top: 10px; border-radius:6px; background-color:rgb(0,206,209)"></td>
                <td><input type="button" class="btn btn-default" onclick="backAndFresh()" value="返回"
                           style="margin-top: 10px; border-radius:6px; background-color:rgb(0,206,209)"></td>
            </tr>
        </table>
    </form>
</div>
</body>

</html>