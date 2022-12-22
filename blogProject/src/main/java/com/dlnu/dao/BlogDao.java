package com.dlnu.dao;

import com.dlnu.entity.Blog;
import com.dlnu.entity.BlogPage;
import com.dlnu.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogDao {
    public List<Blog> findall(int id, BlogPage blogPage) throws SQLException, ClassNotFoundException {
        List<Blog> blogs = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        String sql = "select * from blog where userId=? limit ?,3";
        PreparedStatement prep = connection.prepareStatement(sql);
        prep.setInt(1,id);
        prep.setInt(2,blogPage.getBegin());
        ResultSet rs = prep.executeQuery();
        while (rs.next()){
            Blog blog = new Blog();
            blog.setId(rs.getInt("id"));
            blog.setTitle(rs.getString("title"));
            blog.setContent(rs.getString("content"));
            blog.setUserId(rs.getInt("userId"));
            blog.setPostTime(rs.getTimestamp("postTime"));
            blogs.add(blog);
        }
        return blogs;
    }

    public int findRows(int userid) throws SQLException, ClassNotFoundException {
        int count = 0;
        Connection connection = DBUtil.getConnection();
        String sql = "select count(*) c from blog where userId=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,userid);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()){
            count = rs.getInt("c");
        }
        return count;
    }

    public Blog findById(int id) throws SQLException, ClassNotFoundException {
        Blog blog = null;
        Connection connection = DBUtil.getConnection();
        String sql = "select * from blog where id=?";

        PreparedStatement prep = connection.prepareStatement(sql);
        prep.setInt(1,id);
        ResultSet rs = prep.executeQuery();
        while (rs.next()){
            blog = new Blog();
            blog.setId(rs.getInt("id"));
            blog.setTitle(rs.getString("title"));
            blog.setContent(rs.getString("content"));
            blog.setUserId(rs.getInt("userId"));
            blog.setPostTime(rs.getTimestamp("postTime"));
        }
        return blog;
    }

    public void add(Blog blog) throws SQLException, ClassNotFoundException {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into blog(title, content, userId, postTime) values (?,?,?,now())";
        PreparedStatement prep = connection.prepareStatement(sql);
        prep.setString(1,blog.getTitle());
        prep.setString(2,blog.getContent());
        prep.setInt(3,blog.getUserId());
        prep.executeUpdate();
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection connection = DBUtil.getConnection();
        String sql = "delete from blog where id=?";
        PreparedStatement prep = connection.prepareStatement(sql);
        prep.setInt(1,id);
        prep.executeUpdate();
    }

    public void update(Blog blog) throws SQLException, ClassNotFoundException {
        Connection connection = DBUtil.getConnection();
        String sql = "update blog set title=?, content=? where id=?";
        PreparedStatement prep = connection.prepareStatement(sql);
        prep.setString(1,blog.getTitle());
        prep.setString(2, blog.getContent());
        prep.setInt(3,blog.getId());
        prep.executeUpdate();
    }
}
