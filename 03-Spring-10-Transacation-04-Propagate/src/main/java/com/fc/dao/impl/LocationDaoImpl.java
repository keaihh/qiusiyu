package com.fc.dao.impl;

import com.fc.dao.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class LocationDaoImpl extends JdbcDaoSupport implements LocationDao {

    @Override
    public void add(String location) {
        getJdbcTemplate().update("insert into location(name) values (?)",location);

    }
}
