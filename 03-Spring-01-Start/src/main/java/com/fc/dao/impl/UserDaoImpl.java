package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void findAll() {
        System.out.println("用Mysql连接数据库~~~");
    }
}
