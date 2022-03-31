package com.fc.service.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository("UserMysqlImpl")
public class UserMysqlImpl implements UserDao {


    @Override
    public List<User> findAll() {
        ArrayList<User> list = new ArrayList<>();

        list.add(new User(4, "玛卡巴卡", "123456"));
        list.add(new User(5, "唔系迪西", "123456"));
        list.add(new User(6, "汤布力不", "123456"));
        return list;
    }
}
