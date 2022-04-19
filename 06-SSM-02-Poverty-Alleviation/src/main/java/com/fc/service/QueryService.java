package com.fc.service;

import com.fc.entity.Alleviation;

import java.util.List;

public interface QueryService {
    List<Alleviation> alleviationSearch(String keyword);

    List<Alleviation> carouselSearch(String keyword);

    List<Alleviation> collectionSearch(String keyword);

    List<Alleviation> messageBoardSearch(String keyword);

    List<Alleviation> poorSearch(String keyword);

    List<Alleviation> userSearch(String keyword);

    List<Alleviation> volunteerRecruitmentSearch(String keyword);
}
