package com.fc.test;


import com.fc.dao.AccountDao;
import com.fc.entity.Account;
import com.fc.entity.TAcount;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class ORMTest {
    @Test
    public void findAllTest(){
        AccountDao mapper = MyBatisUtil.getMapper(AccountDao.class);

        List<Account> all = mapper.findAll();

        for (Account account : all) {
            System.out.println(account);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void findAllOnMap(){
        AccountDao mapper = MyBatisUtil.getMapper(AccountDao.class);

        List<Account> allOnMap = mapper.findAllOnMap();

        for (Account account : allOnMap) {
            System.out.println(account);
        }
        MyBatisUtil.commit();
    }
    @Test
    public void testUnderscore(){
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

        List<TAcount> account = accountDao.findById(1);

        System.out.println(account);


        MyBatisUtil.commit();
    }

}
