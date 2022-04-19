package com.fc.service.impl;

import com.fc.dao.VolunteerRecruitmentMapper;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerRecruitmentService;
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
public class VolunteerRecruitmentServiceImpl implements VolunteerRecruitmentService {
    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;

    //招聘添加
    @Override
    public ResultVO add(VolunteerRecruitment volunteerRecruitment) {
        if (volunteerRecruitment.getCreateTime() == null) {
            volunteerRecruitment.setCreateTime(new Date());
        }

        if (volunteerRecruitment.getRecruitsTime() == null) {
            volunteerRecruitment.setRecruitsTime(new Date());
        }

        //刚刚创建出来的扶贫政策点击量应该为0
        volunteerRecruitment.setClickNum(0);
        volunteerRecruitment.setLastClickTime(null);

        int affectedRows = volunteerRecruitmentMapper.insertSelective(volunteerRecruitment);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "成功", true, volunteerRecruitment);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }

    //招聘修改
    @Override
    public ResultVO update(VolunteerRecruitment volunteerRecruitment) {
        int affectedRows = volunteerRecruitmentMapper.updateByPrimaryKeySelective(volunteerRecruitment);
        ResultVO resultVO;

        if (affectedRows > 0) {
            VolunteerRecruitment result = volunteerRecruitmentMapper.selectByPrimaryKey(volunteerRecruitment.getId());

            resultVO = new ResultVO(200, "成功", true, result);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }

    //招聘删除
    @Override
    public ResultVO delete(Long id) {
        int affectedRows = volunteerRecruitmentMapper.deleteByPrimaryKey(id);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "成功", true, null);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }

    //招聘点击
    @Override
    public ResultVO click(Long id, Date lastClickTime) {
        if (lastClickTime == null) {
            lastClickTime = new Date();
        }

        Integer affectedRows = volunteerRecruitmentMapper.click(id, lastClickTime);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "点击量加1", true, null);
        } else {
            resultVO = new ResultVO(-1, "点击失败", false, null);
        }

        return resultVO;
    }

    //招聘获取
    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {
        List<VolunteerRecruitment> volunteerRecruitments;
        ResultVO resultVO;
        try {

            if (id != null) {
                VolunteerRecruitment volunteerRecruitment = volunteerRecruitmentMapper.selectByPrimaryKey(id);
                volunteerRecruitments = new ArrayList<>();
                volunteerRecruitments.add(volunteerRecruitment);
                //如果调用了查询单个，就应该对点击量进行加1操作
                click(volunteerRecruitment.getId(), volunteerRecruitment.getLastClickTime());
            } else {
                PageHelper.startPage(pageNum, pageSize);
                volunteerRecruitments = volunteerRecruitmentMapper.selectByExampleWithBLOBs(null);
            }
            PageInfo<VolunteerRecruitment> PageInfo = new PageInfo<>(volunteerRecruitments);

            DataVO<VolunteerRecruitment> dataVO = new DataVO<>(PageInfo.getTotal(), volunteerRecruitments, pageNum, pageSize);

            resultVO = new ResultVO(200, "扶贫政策获取成功", true, dataVO);
        } catch (Exception e) {
            resultVO = new ResultVO(-1000, "扶贫政策获取失败", false, null);
        }
        return resultVO;
    }
}
