package com.fc.dao;

import com.fc.entity.Department;
import com.fc.entity.Employee;
import org.apache.ibatis.annotations.Param;


public interface DepartmentDao {

    //根据部门id获取部门的对象（包括所有的员工id）
    Department findByDepartmentId(@Param("id")Integer id);

}
