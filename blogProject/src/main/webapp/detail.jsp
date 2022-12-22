<%@ page import="com.dlnu.entity.User" %>
<%@ page import="com.dlnu.entity.BlogPage" %>
<%@ page import="com.dlnu.entity.Blog" %><%--
  Created by IntelliJ IDEA.
  User: 18364
  Date: 2022/12/12
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>博客详情页</title>
  <link rel="stylesheet" href="css/common.css">
  <link rel="stylesheet" href="css/blog_detail.css">

  <!-- 引入 editor.md 的依赖 -->
  <link rel="stylesheet" href="editor.md/css/editormd.min.css" />
  <script src="js/jquery.min.js"></script>
  <script src="editor.md/lib/marked.min.js"></script>
  <script src="editor.md/lib/prettify.min.js"></script>
  <script src="editor.md/editormd.js"></script>
</head>
<body>
<div class="nav">
  <%
    User user = (User) session.getAttribute("u");
  %>
  <img src="avatar/<%=user.getImgaddress()%>" alt="">
  <span><%=user.getUname()%></span>
  <!-- 空白元素, 用来占位置 -->
  <div class="spacer"></div>
  <a href="list.do">主页</a>
  <a href="edit.jsp">写博客</a>
  <a href="exit.do">注销</a>
</div>
<%
  Blog blog = (Blog) request.getAttribute("blog");
  String content = "111";
  content = blog.getContent();
  System.out.println("content = " + content);
%>
<!-- 这里的 .container 作为页面的版心 -->
<div class="container">
  <!-- 左侧个人信息 -->
  <div class="left">
    <!-- 表示整个用户信息区域. -->
    <div class="card">
      <img src="avatar/<%=user.getImgaddress()%>" alt="">
      <a href="toUpdata.do?blogId=<%=blog.getId()%>">编辑此博客</a>
      <%--            <h3></h3>--%>
    </div>
  </div>

  <!-- 右侧内容详情 -->
  <div class="right">
    <!-- 使用这个 div 来包裹整个博客的内容详情 -->
    <div class="blog-content">
      <!-- 博客标题 -->
      <h3><%=blog.getTitle()%></h3>
      <!-- 博客的时间 -->
      <div class="date"><%=blog.getPostTime()%></div>
      <!-- 博客的正文内容 -->
      <div id="content" style="opacity: 80%">

      </div>
    </div>
  </div>
  <script type="text/javascript">
    mdToHml = function(){
      editormd.markdownToHTML('content', {
        markdown: "<%=content.replace("\"", "\\\"").replace("</script>", "<\"+\"/script>").replace("\r", "").replace("\n", "\\\n")%>"
      });
    };

    mdToHml();
  </script>
</div>
</body>
</html>
