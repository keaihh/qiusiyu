package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class PageHelperText {

    @Test
    public void text(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);
//        声明当前页和显示每条数据
        PageHelper.startPage(2,2);

        List<Student> students = mapper.findAll();

        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testPageInfo(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        // 开启分页
        PageHelper.startPage(1,2);

        List<Student> students = studentDao.findAll();

        //  封装PageInfo
        PageInfo<Student> pageInfo = new PageInfo<>(students);

        System.out.println(pageInfo);
    }

}
