package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("poor")
public class PoorController {
    @Autowired
    private PoorService poorService;

    //贫困户添加
    @PostMapping("add")
    public ResultVO add(@RequestBody PoorWithBLOBs poorWithBLOBs){
        return poorService.add(poorWithBLOBs);
    }

    //贫困户修改
    @PostMapping("update")
    public ResultVO update(@RequestBody PoorWithBLOBs poorWithBLOBs){
        return poorService.update(poorWithBLOBs);
    }

    //贫困户删除
    @GetMapping("delete")
    public ResultVO delete(Long id){
        return poorService.delete(id);
    }

    //贫困户点击
    @PostMapping("click")
    public ResultVO click(Alleviation alleviation){
        return poorService.click(alleviation.getId(),alleviation.getLastClickTime());
    }

    //贫困户获取
    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize,
                            Long id){
        return poorService.getList(pageNum,pageSize,id);
    }
}
