package com.dlnu.test;

import com.dlnu.dao.UserDao;
import com.dlnu.entity.User;
import com.dlnu.util.DBUtil;

import java.sql.SQLException;

public class DBTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("dbUtil = " + DBUtil.getConnection());

//        测试userDao.add
//        User user = new User("qqq","123456","186@.com");
//        UserDao userDao = new UserDao();
//        userDao.add(user);
//
//        测试userDao.findByUname
//        UserDao userDao = new UserDao();
//        System.out.println("userDao.findByUname(\"zby\") = " + userDao.findByUname("zby"));

    }
}
