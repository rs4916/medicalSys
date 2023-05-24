<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>药品列表</title>
    <script>
        function search() {
            //要搜索的信息就拿到了
            let value = document.getElementById("fileId").value;
            window.location = "/medicine?method=select&value="+value;
        }
    </script>
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
            margin-left: 480px;
            margin-top: 10px;
        }
    </style>
</head>

<body>
    <h2><a href="../../home.jsp">返回系统主页</a></h2>
    <input type="text" class="fileId" id="fileId" placeholder="请输入医生姓名">&nbsp;&nbsp;
    <button onclick="search()" style="width:50px; margin-left:15px; border-radius:6px; background-color:rgb(0,206,209)">查询</button>&nbsp;&nbsp;
    <a href="/page/medicine/addMedicine.jsp">
        <input type="submit" value="添加" style="width:50px; margin-left:20px; border-radius:6px; background-color:rgb(0,206,209)">
    </a>
    <div>
        <div class="ten">
            <table border="1" cellspacing="0" class="one" width="750" style="background-color:rgb(245,255,250)">
                <tr>
                    <td colspan="2" align="center"><b>管理员：${user.name}</b></td>
                    <td colspan="2" align="center"><b>ID：${user.id}</b></td>
                </tr>
                <tr>
                    <th width="100">名称</th>
                    <th width="100">功效</th>
                    <th width="100">生产日期</th>
                    <th width="100">生产地址</th>
                    <th width="100">忌讳</th>
                    <th width="100">价格</th>
                    <th>操作</th>
                </tr>

                <c:forEach var="medicine" items="${medicineList}">
                <tr align="center">
                    <td>${medicine.name}</td>
                    <td>${medicine.function}</td>
                    <td>${medicine.date_of_manufacture}</td>
                    <td>${medicine.address}</td>
                    <td>${medicine.taboo}</td>
                    <td>${medicine.price}</td>
                    <td>
                        <a href="/medicine?method=query&id=${medicine.id}">查看</a>
                        <a href="/medicine?method=update&id=${medicine.id}">修改</a>
                        <a href="/medicine?method=delete&id=${medicine.id}">删除</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>