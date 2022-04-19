package com.fc.service;

import com.fc.entity.Alleviation;
import com.fc.vo.ResultVO;

import java.util.Date;

public interface AlleviationService {
    //扶贫政策添加
    ResultVO add(Alleviation alleviation);

    //扶贫政策修改
    ResultVO update(Alleviation alleviation);

    //扶贫政策删除
    ResultVO delete(Long id);

    //扶贫政策点击
    ResultVO click(Long id, Date lastClickTime);

    //扶贫政策获取
    ResultVO getList(Integer pageNum, Integer pageSize, Long id);

}


