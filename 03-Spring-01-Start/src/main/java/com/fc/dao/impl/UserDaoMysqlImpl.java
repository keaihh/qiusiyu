package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoMysqlImpl implements UserDao {

    @Override
    public void findAll() {
        System.out.println("Mysql~~~");
    }
}
