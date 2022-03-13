package com.fc.test;


import com.fc.dao.DepartmentDao;
import com.fc.entity.Department;
import com.fc.entity.Employee;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class LazyLoadText {
    @Test
    public void text(){
        DepartmentDao mapper = MyBatisUtil.getMapper(DepartmentDao.class);

        Department departmentId = mapper.findByDepartmentId(1);

        System.out.println(departmentId);

        MyBatisUtil.commit();
    }



}
