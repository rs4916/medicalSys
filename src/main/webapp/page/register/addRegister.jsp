<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加患者</title>
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
    <h2><a href="../../home.jsp">返回系统主页</a></h2>
    <div>
        <br><br><br><br><br>
        <br><br><br><br><br>
        <form action="/register?method=add" method="post">
            <table>
                <tr>
                    <td colspan="2"><b>管理员:${user.name}</b></td>
                </tr>
                <tr>
                    <td colspan="2"><b>ID:${user.id}</b></td>
                </tr>
                <tr>
                    <td colspan="2" align="center" width="20px" style="font-size: 25px;margin-bottom: 10px;"><b>患者挂号</b></td>
                </tr>
                <tr>
                    <td><b>医生ID：</b></td>
                    <th><input type="text" name="did" id="did"><br></th>
                </tr>
                <tr>
                    <td><b>患者ID：</b></td>
                    <th><input type="text" name="pid" id="pid"></th>
                </tr>
                <tr>
                    <td><b>药物ID：</b></td>
                    <th><input type="text" name="mid" id="mid"></th>
                </tr>
                <tr>
                    <td><input type="submit" value="提交"
                               style="margin-top:10px; border-radius:6px; background-color:rgb(0,206,209)">
                    </td>
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