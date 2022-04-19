package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    //轮播图添加
    @PostMapping("add")
    public ResultVO add(@RequestBody Carousel carousel){
        return carouselService.add(carousel);
    }

    //轮播图删除
    @GetMapping("delete")
    public ResultVO delete(Integer id){
        return carouselService.delete(id);
    }

    //轮播图修改
    @PostMapping("update")
    public ResultVO update(@RequestBody Carousel carousel){
        return carouselService.update(carousel);
    }

    //轮播图获取
    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize,
                            Integer id){
        return carouselService.getList(pageNum,pageSize,id);
    }

    //轮播图状态
    @GetMapping("state")
    public ResultVO state(Integer id){
        return carouselService.state(id);
    }


}
