package com.fc.service;

import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.vo.ResultVO;

public interface MessageBoardService {
    //留言板添加
    ResultVO add(MessageBoardWithBLOBs messageBoardWithBLOBs);

    //留言板删除
    ResultVO delete(Long id);

    //留言板获取
    ResultVO getList(Integer pageNum, Integer pageSize, Long id);

    //留言板回复
    ResultVO reply(MessageBoardWithBLOBs messageBoardWithBLOBs);

}
