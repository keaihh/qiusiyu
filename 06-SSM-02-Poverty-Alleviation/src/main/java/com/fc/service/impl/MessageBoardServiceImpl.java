package com.fc.service.impl;

import com.fc.dao.MessageBoardMapper;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageBoardServiceImpl implements MessageBoardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;

    //留言板添加
    @Override
    public ResultVO add(MessageBoardWithBLOBs messageBoardWithBLOBs) {
        if (messageBoardWithBLOBs.getCreateTime() == null) {
            messageBoardWithBLOBs.setCreateTime(new Date());
        }

        int affectedRows = messageBoardMapper.insertSelective(messageBoardWithBLOBs);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "成功", true, messageBoardWithBLOBs);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }

    //留言板删除
    @Override
    public ResultVO delete(Long id) {
        int affectedRows = messageBoardMapper.deleteByPrimaryKey(id);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "成功", true, null);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }

    //留言板获取
    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {
        List<MessageBoardWithBLOBs> messageBoardWithBLOBs;
        ResultVO resultVO;
        try {

            if (id != null) {
                MessageBoardWithBLOBs messageBoardWithBLOBs1 = messageBoardMapper.selectByPrimaryKey(id);
                messageBoardWithBLOBs = new ArrayList<>();
                messageBoardWithBLOBs.add(messageBoardWithBLOBs1);
            } else {
                PageHelper.startPage(pageNum, pageSize);
                messageBoardWithBLOBs = messageBoardMapper.selectByExample(null);
            }
            PageInfo<MessageBoardWithBLOBs> PageInfo = new PageInfo<>(messageBoardWithBLOBs);

            DataVO<MessageBoardWithBLOBs> dataVO = new DataVO<>(PageInfo.getTotal(), messageBoardWithBLOBs, pageNum, pageSize);

            resultVO = new ResultVO(200, "扶贫政策获取成功", true, dataVO);
        } catch (Exception e) {
            resultVO = new ResultVO(-1000, "扶贫政策获取失败", false, null);
        }
        return resultVO;
    }

    //留言板回复
    @Override
    public ResultVO reply(MessageBoardWithBLOBs messageBoardWithBLOBs) {

        MessageBoardWithBLOBs bloBs = messageBoardMapper.selectByPrimaryKey(messageBoardWithBLOBs.getId());
        bloBs.setId(messageBoardWithBLOBs.getId());
        if (messageBoardWithBLOBs.getReply().equals(messageBoardWithBLOBs.getContent())) {
            messageBoardWithBLOBs.setReply(messageBoardWithBLOBs.getContent());
        }
        int affectedRows = messageBoardMapper.updateByPrimaryKeyWithBLOBs(messageBoardWithBLOBs);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "成功", true, null);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;

    }

}
