package com.fc.service;

import com.fc.vo.UserVo;


public interface UserService{
    UserVo login(String username, String password);
}
