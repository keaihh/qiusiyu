package com.fc.service;

import com.fc.vo.UserVo;
import org.springframework.stereotype.Service;


public interface UserService{
    UserVo login(String username, String password);
}
