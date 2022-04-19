package com.fc.service.impl;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserVo login(String username, String password) {
        //连接数据库
        UserVo userVo=null;
        if (username.equals("易烊千玺")&&password.equals("123456")){
//            userVo = new UserVo(1, "易烊千玺", new Date());
            userVo = new UserVo();
            userVo.setId(1);
            userVo.setUsername(username);
            userVo.setLastAccessTime(new Date());
        }

          return userVo;
    }
}
