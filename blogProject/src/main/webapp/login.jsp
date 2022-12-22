<%--
  Created by IntelliJ IDEA.
  User: 18364
  Date: 2022/12/11
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录页面</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<!-- 这是导航栏 -->
<div class="nav">
    <span style="margin-left: 3ch">卷王小组的博客系统</span>
    <!-- 空白元素, 用来占位置 -->
    <div class="spacer"></div>
<%--    <a href="blog_list.html">主页</a>--%>
<%--    <a href="blog_edit.html">写博客</a>--%>
    <!-- 注销按钮没必要在登录页面展示 -->


</div>
<div class="login-container">
    <form action="login.do" method="post">
        <div class="login-dialog">
            <h3>登录</h3>
            <span style="color:red;padding-left: 145px">
                <%=request.getAttribute("umsg")==null?  "":request.getAttribute("umsg") %>
            </span>
            <div class="row">
                <span>用户名</span>
                <input type="text" id="username" name="username">
            </div>
            <div class="row">
                <span>密码</span>
                <input type="password" id="password" name="password">
            </div>
            <div class="row">
                    <td>
                        <span>验证码</span>
                        <img style="margin-right:10px;width:25%" id="num" src="code." href="javascript:;"  onclick="document.getElementById('num').src = 'code.?'+(new Date()).getTime()"/>
                    </td>
                    <td>
                        <input type="text" id="ck" name="ck" />
                    </td>
            </div>
            <div class="row">
                 <input type="submit" id="submit" value="登录">
            </div>
            <p style="font-size: small;margin-top: 10%;display: flex;align-items: center;justify-content: center;">新用户点击此处<a href="register.jsp">注册</a></p>
        </div>
    </form>
</div>
</body>
</html>
