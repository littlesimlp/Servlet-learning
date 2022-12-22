package com.dlnu.service;

import com.dlnu.dao.UserDao;
import com.dlnu.entity.User;

import java.sql.SQLException;

public class UserService {
    UserDao userDao = new UserDao();
    public void addUser(User user) throws SQLException, ClassNotFoundException {
        userDao.add(user);
    }

    public User login(String uname) throws SQLException, ClassNotFoundException {
        return userDao.findByUname(uname);
    }

    public void update(User user) throws SQLException, ClassNotFoundException {
        userDao.update(user);
    }
}
