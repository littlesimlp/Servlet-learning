package com.dlnu.servlet;

import com.dlnu.entity.Blog;
import com.dlnu.entity.BlogPage;
import com.dlnu.entity.User;
import com.dlnu.service.BlogService;
import com.dlnu.service.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();

        String uri = req.getRequestURI();

        String path = uri.substring(uri.lastIndexOf('/'),uri.lastIndexOf('.'));

        UserService userService = new UserService();
        BlogService blogService = new BlogService();
        if (path.equals("/register")){
            String uname = req.getParameter("username");
            String pwd = req.getParameter("password");
            String pwd1 = req.getParameter("password1");
            String emil = req.getParameter("emil");
            System.out.println(uname+pwd+" "+pwd1);

            if (uname.equals("")){
                req.setAttribute("umsg","用户名不得为空");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
                return;
            }
            if (pwd.equals("")){
                req.setAttribute("umsg","密码不得为空");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
                return;
            }
            if (!pwd.equals(pwd1)){
                req.setAttribute("umsg","两次密码不一致");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
                return;
            }

            User user = new User(uname,pwd,emil,"default.jpg");
            try {
                userService.addUser(user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else if (path.equals("/login")) {
            User user = null;
            String uname = req.getParameter("username");
            String pwd = req.getParameter("password");
            String ck = req.getParameter("ck");

            try {
                user = userService.login(uname);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            req.setAttribute("uname",uname);
            if (user == null){
                req.setAttribute("umsg","用户名错误");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
                return;
            }
            if (!user.getPwd().equals(pwd)){
                req.setAttribute("umsg","密码错误");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
                return;
            }
            String ck2=(String) session.getAttribute("ck");
            System.out.println(ck);
            if (!ck.equals(ck2)){
                req.setAttribute("umsg","验证码错误");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
                return;
            }
            session.setAttribute("u",user);
            resp.sendRedirect("list.do");
        } else if (path.equals("/upuserdata")) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(factory);

            String filename="";

            try {
                List<FileItem> items = sfu.parseRequest(req);
                String uname = items.get(0).getString();
                String pwd = items.get(1).getString();
                String pwd1 = items.get(2).getString();
                String emil = items.get(3).getString();

                if (!pwd.equals(pwd1)){
                    req.setAttribute("umsg","两次密码不一致");
                    req.getRequestDispatcher("upuserdata.jsp").forward(req,resp);
                    return;
                }

                User user = (User) session.getAttribute("u");
                ServletContext sctx = this.getServletContext();
                String imgpath = sctx.getRealPath("avatar");
                filename = items.get(4).getName();
                //System.out.println("filename = " + filename);

                if (filename.equals("")){
                    filename = user.getImgaddress();
                }

                if (!filename.equals("default.jpg")){
                    System.out.println("yes");
                    File file=new File(imgpath+"\\"+filename);
                    items.get(4).write(file);
                }

                user.setPwd(pwd);
                user.setEmil(emil);
                user.setImgaddress(filename);
                System.out.println("user = " + user);
                userService.update(user);

                resp.sendRedirect("list.do");

            }  catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (path.equals("/list")) {
            try {
                User user = (User) session.getAttribute("u");
                String current=req.getParameter("current");
                BlogPage blogPage = new BlogPage();
                int rows = blogService.findRows(user.getId());
                blogPage.setRows(rows);

                if (current!=null){
                    int cur = Integer.parseInt(current);
                    blogPage.setCurrentPage(cur);
                }

                List<Blog> blogs = blogService.find(user.getId(),blogPage);
                req.setAttribute("blogs",blogs);
                req.setAttribute("page",blogPage);

                RequestDispatcher dis = req.getRequestDispatcher("list.jsp");
                dis.forward(req,resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (path.equals("/detail")) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                Blog blog = blogService.findById(id);
                req.setAttribute("blog",blog);
                RequestDispatcher dis = req.getRequestDispatcher("detail.jsp");
                dis.forward(req,resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (path.equals("/addblog")) {
            User user = (User) session.getAttribute("u");
            String title = req.getParameter("title");
            String content = req.getParameter("content");

            Blog blog = new Blog();
            blog.setTitle(title);
            blog.setContent(content);
            blog.setUserId(user.getId());
            try {
                blogService.add(blog);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("list.do");
        } else if (path.equals("/del")) {
            int blogId = Integer.parseInt(req.getParameter("id"));
            try {
                blogService.delete(blogId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("list.do");
        }else if (path.equals("/toUpdata")){
            int blogId = Integer.parseInt(req.getParameter("blogId"));
            try {
                Blog blog = blogService.findById(blogId);
                req.setAttribute("blog",blog);
                req.getRequestDispatcher("upblogdata.jsp").forward(req,resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        } else if (path.equals("/upblogdata")) {
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            int id = Integer.parseInt(req.getParameter("id"));

            Blog blog = new Blog();
            blog.setId(id);
            blog.setTitle(title);
            blog.setContent(content);

            try {
                blogService.update(blog);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("list.do");
        } else if (path.equals("/exit")) {
            session.removeAttribute("u");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }


    }
}
