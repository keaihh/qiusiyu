package com.fc.dao.Impl;

import com.fc.dao.UserDao;

public class UserDaoMysqlImpl implements UserDao {

    @Override
    public void useJDBC() {
        System.out.println("使用Mysql");
    }
}
