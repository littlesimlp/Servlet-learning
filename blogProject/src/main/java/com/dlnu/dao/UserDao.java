package com.dlnu.dao;

import com.dlnu.entity.User;
import com.dlnu.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into user (uname,pwd,emil,imgaddress)values(?,?,?,?)";
        PreparedStatement prep = connection.prepareStatement(sql);
        prep.setString(1,user.getUname());
        prep.setString(2,user.getPwd());
        prep.setString(3,user.getEmil());
        prep.setString(4, user.getImgaddress());
        prep.executeUpdate();
    }

    public User findByUname(String uname) throws SQLException, ClassNotFoundException {
        User user = null;
        Connection connection = DBUtil.getConnection();
        String sql = "select * from user where uname=?";
        PreparedStatement prep = connection.prepareStatement(sql);
        prep.setString(1,uname);
        ResultSet rs = prep.executeQuery();
        while (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUname(rs.getString("uname"));
            user.setPwd(rs.getString("pwd"));
            user.setEmil(rs.getString("emil"));
            user.setImgaddress(rs.getString("imgaddress"));
        }
        return user;
    }

    public void update(User user) throws SQLException, ClassNotFoundException {
        Connection connection = DBUtil.getConnection();

        String sql = "update user set pwd=?, emil=?, imgaddress=? where id=?";
        PreparedStatement prep = connection.prepareStatement(sql);
        prep.setString(1, user.getPwd());
        prep.setString(2, user.getEmil());
        prep.setString(3, user.getImgaddress());
        prep.setInt(4,user.getId());
        prep.executeUpdate();
    }
}
