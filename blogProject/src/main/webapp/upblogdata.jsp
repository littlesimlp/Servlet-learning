<%@ page import="com.dlnu.entity.User" %>
<%@ page import="com.dlnu.entity.Blog" %><%--
  Created by IntelliJ IDEA.
  User: 18364
  Date: 2022/12/13
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>博客编辑页</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/blog_edit.css">

    <!-- 引入 editor.md 的依赖 -->
    <link rel="stylesheet" href="editor.md/css/editormd.min.css" />
    <script src="js/jquery.min.js"></script>
    <script src="editor.md/lib/marked.min.js"></script>
    <script src="editor.md/lib/prettify.min.js"></script>
    <script src="editor.md/editormd.js"></script>
</head>
<body>
<!-- 这是导航栏 -->
<div class="nav">
    <%
        User user = (User) session.getAttribute("u");
        Blog blog = (Blog) request.getAttribute("blog");
    %>
    <span style="margin-left: 3ch"><%=user.getUname()%></span>
    <!-- 空白元素, 用来占位置 -->
    <div class="spacer"></div>
    <a href="list.do">主页</a>
    <a href="#">写博客</a>
    <a href="exit.do">注销</a>
</div>
<!-- 包裹整个博客编辑页内容的顶级容器 -->
<div class="blog-edit-container">
    <form action="upblogdata.do" method="post" style="height: 100%">
        <div class="title">
            <input type="hidden" name="id" value="<%=blog.getId()%>">
            <input type="text" placeholder="在此处输入标题" name="title" id="title" value="<%=blog.getTitle()%>">
            <!--                <button>发布文章</button>-->
            <input type="submit" value="提交" id="submit">
        </div>
        <%System.out.println(blog.getContent());%>
        <!-- 放置 md 编辑器 -->
        <div id="editor">
            <!-- 为了进行 form 的提交,此处搞一个 textarea 多行编辑器,借助这个编辑框来实现表单的提交 -->
            <!-- 可以设置 editor.md,让编辑器把 markdown 内容也同步的保存到这个隐藏的 textarea 中,从而进行 form 提交 -->
            <textarea name="content" style="display: none"></textarea>
        </div>
    </form>

</div>

<script>
    //初始化编辑器
    let editor = editormd("editor",{
        //这里的尺寸必须在这里设置,设置样式会被 editormd 自动覆盖掉
        width: "100%",
        //设定编辑器高度
        height: "calc(100% - 50px)",
        //编辑器中的初始内容
        markdown: "<%=blog.getContent()%>",
        //指定 editor.md 依赖的插件路径
        path: "editor.md/lib/",
        // 此处要加上一个重要的选项,然后 editor.md 就会自动把用户在编辑器输入的内容同步保存到 隐藏的 textarea 中了!
        saveHTMLToTextarea: true,
    });
</script>
</body>
</html>
