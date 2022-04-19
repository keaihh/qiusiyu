package com.fc.service.impl;

import com.fc.dao.PoorMapper;
import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
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
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;

    //贫困户添加
    @Override
    public ResultVO add(PoorWithBLOBs poorWithBLOBs) {
        if (poorWithBLOBs.getCreateTime() == null) {
            poorWithBLOBs.setCreateTime(new Date());
        }

        //刚刚创建出来的扶贫政策点击量应该为0
        poorWithBLOBs.setClickNum(0);
        poorWithBLOBs.setLastClickTime(null);

        int affectedRows = poorMapper.insertSelective(poorWithBLOBs);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "成功", true, poorWithBLOBs);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }

    //贫困户修改
    @Override
    public ResultVO update(PoorWithBLOBs poorWithBLOBs) {
        int affectedRows = poorMapper.updateByPrimaryKeySelective(poorWithBLOBs);
        ResultVO resultVO;

        if (affectedRows > 0) {
            Poor result = poorMapper.selectByPrimaryKey(poorWithBLOBs.getId());

            resultVO = new ResultVO(200, "成功", true, result);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }

    //贫困户删除
    @Override
    public ResultVO delete(Long id) {
        int affectedRows = poorMapper.deleteByPrimaryKey(id);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "成功", true, null);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }

    //贫困户点击
    @Override
    public ResultVO click(Long id, Date lastClickTime) {
        if (lastClickTime == null) {
            lastClickTime = new Date();
        }

        Integer affectedRows = poorMapper.click(id, lastClickTime);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "点击量加1", true, null);
        } else {
            resultVO = new ResultVO(-1, "点击失败", false, null);
        }

        return resultVO;
    }

    //贫困户获取
    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {
        List<Poor> poors;
        ResultVO resultVO;
        try {

            if (id != null) {
                Poor poor = poorMapper.selectByPrimaryKey(id);
                poors = new ArrayList<>();
                poors.add(poor);
                //如果调用了查询单个，就应该对点击量进行加1操作
                click(poor.getId(), poor.getLastClickTime());
            } else {
                PageHelper.startPage(pageNum, pageSize);
                poors = poorMapper.selectByExample(null);
            }
            PageInfo<Poor> PageInfo = new PageInfo<>(poors);

            DataVO<Poor> dataVO = new DataVO<>(PageInfo.getTotal(), poors, pageNum, pageSize);

            resultVO = new ResultVO(200, "扶贫政策获取成功", true, dataVO);
        } catch (Exception e) {
            resultVO = new ResultVO(-1000, "扶贫政策获取失败", false, null);
        }
        return resultVO;
    }


}
