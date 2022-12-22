package com.dlnu.test;

import com.dlnu.dao.BlogDao;
import com.dlnu.entity.Blog;

import java.sql.SQLException;

public class BlogTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        BlogDao blogDao = new BlogDao();
//        System.out.println("blogDao.findall() = " + blogDao.findall(1));
//        System.out.println("blogDao.findRows(1) = " + blogDao.findRows(1));
//        System.out.println("blogDao.findById(1) = " + blogDao.findById(1));
//        Blog blog = new Blog();
//        blog.setTitle("test");
//        blog.setContent("# qweqweqweqewq");
//        blog.setUserId(5);
//        blogDao.add(blog);
        blogDao.delete(13);
    }
}
