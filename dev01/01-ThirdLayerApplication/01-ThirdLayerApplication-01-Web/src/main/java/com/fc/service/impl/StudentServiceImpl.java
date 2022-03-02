package com.fc.service.impl;

import com.fc.dao.Impl.StudentDaoImpl;
import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.service.StudentService;
import com.fc.vo.PageInfo;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    //数据访问层对象
    StudentDao studentDao=new StudentDaoImpl();

    //此方法就是为了获取PageInfo的，因为获取PageInfo需要两个参数
    //问题就变成了如何获取两个参数：totalCount和List
    //这两个参数都是和数据库相关的
    //业务逻辑层是不能直接操作数据库的
    //需要一个dao对象
    //没有就创建一个
    //因为是接口，创建接口的实现类
    @Override
    public PageInfo<Student> getPageInfo(int pageNo, int pageSize) {
        //通过dao对象获取每页显示的内容以及总数量
        int totalCount = studentDao.getTotalCount();

        List<Student> list=studentDao.getList(pageNo,pageSize);

        return new PageInfo<>(pageSize,pageNo,totalCount,list);
    }
}
