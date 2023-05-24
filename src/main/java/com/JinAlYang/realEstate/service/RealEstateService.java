package com.JinAlYang.realEstate.service;

import com.JinAlYang.realEstate.web.dto.RealEstateResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RealEstateService {

    public RealEstateResponseDto findRealEstateById(Long id);

    public List<RealEstateResponseDto> findAllRealEstateByFilter(String location, String filter);

}
