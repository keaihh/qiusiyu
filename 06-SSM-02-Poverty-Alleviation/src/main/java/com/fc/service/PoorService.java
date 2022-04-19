package com.fc.service;

import com.fc.entity.PoorWithBLOBs;
import com.fc.vo.ResultVO;

import java.util.Date;

public interface PoorService {
    //贫困户添加
    ResultVO add(PoorWithBLOBs poorWithBLOBs);

    //贫困户修改
    ResultVO update(PoorWithBLOBs poorWithBLOBs);

    //贫困户删除
    ResultVO delete(Long id);

    //贫困户点击
    ResultVO click(Long id, Date lastClickTime);

    //贫困户获取
    ResultVO getList(Integer pageNum, Integer pageSize, Long id);

}
