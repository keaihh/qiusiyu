package com.fc.service.impl;

import com.fc.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("添加一个用户");
    }

    @Override
    public void update() {
//        int a=1/0;
        System.out.println("修改用户信息");
    }
}
