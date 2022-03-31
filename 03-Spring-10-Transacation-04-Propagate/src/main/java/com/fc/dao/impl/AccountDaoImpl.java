package com.fc.dao.impl;

import com.fc.dao.AccountDao;
import com.fc.service.LocationService;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void add(String name) {
       getJdbcTemplate().update("insert into account(name) values (?)",name);



    }
}
