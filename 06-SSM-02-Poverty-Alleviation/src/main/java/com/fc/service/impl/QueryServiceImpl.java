package com.fc.service.impl;

import com.fc.dao.*;
import com.fc.entity.Alleviation;
import com.fc.entity.AlleviationExample;
import com.fc.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QueryServiceImpl implements QueryService {
    @Autowired
    private AlleviationMapper alleviationMapper;
    @Autowired
    private CarouselMapper carouselMapper;
    @Autowired
    private CollectionMapper collectionMapper;
    @Autowired
    private MessageBoardMapper messageBoardMapper;
    @Autowired
    private PoorMapper poorMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;
    @Override
    public List<Alleviation> alleviationSearch(String keyword) {
        AlleviationExample alleviationExample = new AlleviationExample();

        AlleviationExample.Criteria criteria = alleviationExample.createCriteria();

        criteria.andTitleLike("%" + keyword + "%");

        return alleviationMapper.selectByExample(alleviationExample);

    }

    @Override
    public List<Alleviation> carouselSearch(String keyword) {
        return null;
    }

    @Override
    public List<Alleviation> collectionSearch(String keyword) {
        return null;
    }

    @Override
    public List<Alleviation> messageBoardSearch(String keyword) {
        return null;
    }

    @Override
    public List<Alleviation> poorSearch(String keyword) {
        return null;
    }

    @Override
    public List<Alleviation> userSearch(String keyword) {
        return null;
    }

    @Override
    public List<Alleviation> volunteerRecruitmentSearch(String keyword) {
        return null;
    }
}
