package com.fc.service.impl;

import com.fc.dao.CarouselMapper;
import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    //轮播图添加(需要主键回填)
    @Override
    public ResultVO add(Carousel carousel) {

        if (carousel.getAvailable() == null) {
            carousel.setAvailable(false);
        }

        int affectedRows = carouselMapper.insertSelective(carousel);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "成功", true, null);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }

    //轮播图删除
    @Override
    public ResultVO delete(Integer id) {
        int affectedRows = carouselMapper.deleteByPrimaryKey(id);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "成功", true, null);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }

    //轮播图修改
    @Override
    public ResultVO update(Carousel carousel) {
        int affectedRows = carouselMapper.updateByPrimaryKeySelective(carousel);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "成功", true, carousel);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }

    //轮播图获取
    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Integer id) {
        List<Carousel> carousels;
        ResultVO resultVO;
        try {
            if (id != null) {
                //通过id查询单个学生
                Carousel carousel = carouselMapper.selectByPrimaryKey(id);
                carousels = new ArrayList<>();
                carousels.add(carousel);
            } else {
                //开启分页
                PageHelper.startPage(pageNum, pageSize);

                carousels = carouselMapper.selectByExample(null);
            }
            //分页信息
            PageInfo<Carousel> pageInfo = new PageInfo<>(carousels);

            DataVO<Carousel> dataVO = new DataVO<>(pageInfo.getTotal(), carousels, pageNum, pageSize);
            resultVO = new ResultVO(200, "成功", true, dataVO);
        } catch (Exception e) {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }

    //轮播图状态
    @Override
    public ResultVO state(Integer id) {
        Carousel carousel = carouselMapper.selectByPrimaryKey(id);
        carousel.setId(carousel.getId());
        carousel.setAvailable(!carousel.getAvailable());

        int affectedRows = carouselMapper.updateByPrimaryKeySelective(carousel);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "成功", true, carousel.getAvailable());
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }

}
