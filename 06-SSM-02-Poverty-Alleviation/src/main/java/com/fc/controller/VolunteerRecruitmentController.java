package com.fc.controller;

import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerRecruitmentService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("volunteer")
public class VolunteerRecruitmentController {
    @Autowired
    private VolunteerRecruitmentService volunteerRecruitmentService;

    //招聘添加
    @PostMapping("add")
    public ResultVO add(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return volunteerRecruitmentService.add(volunteerRecruitment);
    }

    //招聘修改
    @PostMapping("update")
    public ResultVO update(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return volunteerRecruitmentService.update(volunteerRecruitment);
    }

    //招聘删除
    @GetMapping("delete")
    public ResultVO delete(Long id){
        return volunteerRecruitmentService.delete(id);
    }

    //招聘点击
    @PostMapping("click")
    public ResultVO click(VolunteerRecruitment volunteerRecruitment){
        return volunteerRecruitmentService.click(volunteerRecruitment.getId(),volunteerRecruitment.getLastClickTime());
    }

    //招聘获取
    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize,
                            Long id){
        return volunteerRecruitmentService.getList(pageNum,pageSize,id);
    }

}
