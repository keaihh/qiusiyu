package com.fc.test;

import com.fc.dao.Impl.UserDaoMysqlImpl;
import com.fc.service.Impl.UserServiceImpl;
import com.fc.service.UserService;
import org.junit.Test;

public class ThreeTest {

    @Test
    public void test(){
        UserService userService = new UserServiceImpl();

        userService.setUserDao(new UserDaoMysqlImpl());

        userService.useJDBC();
    }

}
