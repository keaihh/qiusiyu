package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class QueryCollection {
    @Autowired
    private QueryService queryService;

    @RequestMapping("alleviation/title")
    public List<Alleviation> search1(String keyword) {
        return queryService.alleviationSearch(keyword);
    }
    @RequestMapping("carousel/search")
    public List<Alleviation> search2(String keyword) {
        return queryService.carouselSearch(keyword);
    }
    @RequestMapping("collection/search")
    public List<Alleviation> search3(String keyword) {
        return queryService.collectionSearch(keyword);
    }
    @RequestMapping("messageBoard/search")
    public List<Alleviation> search4(String keyword) {
        return queryService.messageBoardSearch(keyword);
    }
    @RequestMapping("poor/search")
    public List<Alleviation> search5(String keyword) {
        return queryService.poorSearch(keyword);
    }
    @RequestMapping("user/search")
    public List<Alleviation> search6(String keyword) {
        return queryService.userSearch(keyword);
    }
    @RequestMapping("volunteerRecruitment/search")
    public List<Alleviation> search7(String keyword) {
        return queryService.volunteerRecruitmentSearch(keyword);
    }
}
