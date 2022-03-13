package com.fc.service.Impl;

import com.fc.dao.Impl.UserDaoImpl;
import com.fc.dao.Impl.UserDaoMysqlImpl;
import com.fc.dao.UserDao;
import com.fc.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public void useJDBC() {
        userDao.useJDBC();
    }

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }
}
