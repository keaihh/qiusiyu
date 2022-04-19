package com.fc.service;

import com.fc.entity.Carousel;
import com.fc.vo.ResultVO;

public interface CarouselService {

    //轮播图添加
    ResultVO add(Carousel carousel);

    //轮播图删除
    ResultVO delete(Integer id);

    //轮播图修改
    ResultVO update(Carousel carousel);

    //轮播图获取
    ResultVO getList(Integer pageNum, Integer pageSize, Integer id);

    //轮播图状态
    ResultVO state(Integer id);
}
