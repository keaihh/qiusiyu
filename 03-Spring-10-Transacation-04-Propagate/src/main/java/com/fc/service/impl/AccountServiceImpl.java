package com.fc.service.impl;

import com.fc.dao.AccountDao;
import com.fc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private LocationServiceImpl locationService;

    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
    public void add(String name, String location) {

        accountDao.add(name);

        int a=1/0;

        locationService.add(location);
    }
}
