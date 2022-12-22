<%@ page import="com.dlnu.entity.User" %><%--
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
  <title>更新用户页面</title>
  <link rel="stylesheet" href="css/common.css">
  <link rel="stylesheet" href="css/upuserdata.css">
</head>
<body>
<div class="nav">
  <%
    User user = (User) session.getAttribute("u");
  %>
  <span style="margin-left: 3ch"><%=user.getUname()%></span>
  <!-- 空白元素, 用来占位置 -->
  <div class="spacer"></div>
  <a href="list.jsp">主页</a>
  <a href="blog_edit.html">写博客</a>
  <a href="exit.do">注销</a>
</div>
<div class="login-container">
  <form action="upuserdata.do" method="post" enctype="multipart/form-data">
    <div class="login-dialog">
      <h3>编辑信息</h3>
      <span style="color:red;padding-left: 145px">
                <%=request.getAttribute("umsg")==null?  "":request.getAttribute("umsg") %>
            </span>
      <div class="row">
        <span>用户名</span>
        <input type="text" id="username" name="username" placeholder="输入用户名" readonly="readonly" value="<%=user.getUname()%>">
      </div>
      <div class="row">
        <span>新密码</span>
        <input type="password" id="password" name="password" placeholder="输入密码" value="<%=user.getPwd()%>">
      </div>
      <div class="row">
        <span>确认密码</span>
        <input type="password" id="password1" name="password1" placeholder="确认密码" >
      </div>
      <div class="row">
        <span>emil</span>
        <input type="text" id="emil" name="emil" placeholder="输入邮箱地址" value="<%=user.getEmil()%>">
      </div>
      <div class="row" style="padding-left: 22px">
        <span>上传头像</span>
        <input type="file" name="file">
      </div>
      <div class="row">
        <!--                 <button>提交</button> -->
        <input type="submit" id="submit" value="提交">
      </div>
    </div>
  </form>
</div>
</body>
</html>
