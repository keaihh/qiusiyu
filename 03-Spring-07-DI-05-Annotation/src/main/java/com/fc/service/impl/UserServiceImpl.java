package com.fc.service.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource(name = "UserMysqlImpl")
//    @Autowired
//    @Qualifier("userDaoImpl")
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }


}
