<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>返回各个列表</title>
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
                <li class="active"><a href="/doctor?method=queryAll" style="text-decoration:none">医生</a></li>
                <li class="active"><a href="/patient?method=queryAll" style="text-decoration:none">病人</a></li>
                <li class="active"><a href="/medicine?method=queryAll" style="text-decoration:none">药品</a></li>
                <li class="active"><a href="page/register/addRegister.jsp">挂号</a></li>
                <li class="active"><a href="page/pay/pay.jsp">缴费</a></li>
                <li class="active"><a href="/register?method=queryAll" style="text-decoration:none">病历</a></li>
                <li class="active"><a href="home.jsp" style="text-decoration:none">主页</a></li>
            </ul>
        </div>
        <div class="title">
            <h1>
                <span style="color: crimson;">执行 </span> 操作
                <span style="color: crimson;">成功！ </span>
            </h1>
        </div>
    </header>
</body>
</html>
