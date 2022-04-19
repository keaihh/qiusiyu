package com.fc.service;

import com.fc.entity.VolunteerRecruitment;
import com.fc.vo.ResultVO;

import java.util.Date;

public interface VolunteerRecruitmentService {
    //招聘添加
    ResultVO add(VolunteerRecruitment volunteerRecruitment);

    //招聘修改
    ResultVO update(VolunteerRecruitment volunteerRecruitment);

    //招聘删除
    ResultVO delete(Long id);

    //招聘点击
    ResultVO click(Long id, Date lastClickTime);

    //招聘获取
    ResultVO getList(Integer pageNum, Integer pageSize, Long id);
}
