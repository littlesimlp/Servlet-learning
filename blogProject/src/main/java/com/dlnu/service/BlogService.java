package com.dlnu.service;

import com.dlnu.dao.BlogDao;
import com.dlnu.entity.Blog;
import com.dlnu.entity.BlogPage;

import java.sql.SQLException;
import java.util.List;

public class BlogService {
    BlogDao blogDao = new BlogDao();
    public List<Blog> find(int userid, BlogPage blogPage) throws SQLException, ClassNotFoundException {
        return blogDao.findall(userid,blogPage);
    }

    public int findRows(int userid) throws SQLException, ClassNotFoundException {
        return blogDao.findRows(userid);
    }

    public Blog findById(int id) throws SQLException, ClassNotFoundException {
        return blogDao.findById(id);
    }

    public void add(Blog blog) throws SQLException, ClassNotFoundException {
        blogDao.add(blog);
    }

    public void delete(int blogid) throws SQLException, ClassNotFoundException {
        blogDao.delete(blogid);
    }

    public void update(Blog blog) throws SQLException, ClassNotFoundException {
        blogDao.update(blog);
    }
}
