<%@ page import="com.dlnu.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dlnu.entity.Blog" %>
<%@ page import="com.dlnu.entity.BlogPage" %><%--
  Created by IntelliJ IDEA.
  User: 18364
  Date: 2022/12/11
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>博客列表</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/blog_list.css">
</head>
<body>
<!-- 这是导航栏 -->
<div class="nav">
    <%
        User user = (User) session.getAttribute("u");
    %>
    <span style="margin-left: 3ch"><%=user.getUname()%></span>
    <!-- 空白元素, 用来占位置 -->
    <div class="spacer"></div>
    <a href="list.do">主页</a>
    <a href="edit.jsp">写博客</a>
    <a href="exit.do">注销</a>
</div>
<%
    BlogPage p =(BlogPage) request.getAttribute("page");
    int cur=p.getCurrentPage();
    int totalPage=p.getTotalPage();
%>
<!-- 这里的 .container 作为页面的版心 -->
<div class="container">
    <!-- 左侧个人信息 -->
    <div class="left">
        <!-- 表示整个用户信息区域. -->
        <div class="card">
            <img src="avatar/<%=user.getImgaddress()%>" alt="">
            <a href="upuserdata.jsp">编辑个人信息</a>
<%--            <h3></h3>--%>
            <div class="counter">
                <span>文章</span>
            </div>
            <div class="counter">
                <span class="total"><%=p.getRows()%></span>
            </div>
        </div>
    </div>
    <!-- 右侧内容详情 -->
    <%
        List<Blog> blogs=(List<Blog>) request.getAttribute("blogs");
    %>
    <div class="right">
        <!-- .blog 就对应一个博客 -->
        <%
            for (Blog blog:blogs) {
        %>
       <div class="blog">
            <div class="title">
                <%=blog.getTitle()%>
            </div>
            <div class="date">
                <%=blog.getPostTime()%>
            </div>
            <div class="desc">
                <%=blog.getContent()%>
            </div>
            <a id="a1" href="detail.do?id=<%=blog.getId()%>">查看全文 &gt;&gt; </a>
           <a id="a2" href="del.do?id=<%=blog.getId()%>">点击删除此博客</a>
        </div>
        <%
            }
        %>

        <p style="padding-left: 350px">
            <%
                if (cur!=1){
            %>
            <a href="list.do?current=<%=cur-1%>">上一页</a>
            <%
                }
            %>
            <%
                for (int i = 1; i <=totalPage; i++) {
            %>
            <a href="list.do?current=<%=i%>"><%=i%></a>
            <%
                }
            %>
            <%
                if (cur!=totalPage){
            %>
            <a href="list.do?current=<%=cur+1%>">下一页</a>
            <%
                }
            %>
        </p>
    </div>
</div>
</div>

</body>
</html>
