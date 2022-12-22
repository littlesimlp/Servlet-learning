<%--
  Created by IntelliJ IDEA.
  User: 18364
  Date: 2022/12/11
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册页面</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/register.css">
</head>
<body>
<div class="nav">
    <span style="margin-left: 3ch">卷王小组的博客系统</span>
    <div class="spacer"></div>
<%--    <a href="blog_list.html">主页</a>--%>
<%--    <a href="blog_edit.html">写博客</a>--%>
    <a href="login.jsp">登录</a>
</div>
<div class="login-container">
    <form action="register.do" method="post">
        <div class="login-dialog">
            <h3>注册</h3>
            <span style="color:red;padding-left: 145px">
                <%=request.getAttribute("umsg")==null?  "":request.getAttribute("umsg") %>
            </span>
            <div class="row">
                <span>用户名</span>
                <input type="text" id="username" name="username" placeholder="输入用户名">
            </div>
            <div class="row">
                <span>密码</span>
                <input type="password" id="password" name="password" placeholder="输入密码">
            </div>
            <div class="row">
                <span>确认密码</span>
                <input type="password" id="password1" name="password1" placeholder="输入密码">
            </div>
            <div class="row">
                <span>emil</span>
                <input type="text" id="emil" name="emil" placeholder="输入邮箱地址">
            </div>
            <div class="row">
                <!--                 <button>提交</button> -->
                <input type="submit" id="submit" value="注册">
            </div>
        </div>
    </form>
</div>
</body>
</html>
