package com.JinAlYang.realEstate.service;

import com.JinAlYang.realEstate.domain.RealEstate;
import com.JinAlYang.realEstate.web.dto.RealEstateCreateDto;
import com.JinAlYang.realEstate.web.dto.RealEstateResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RealEstateService {

    RealEstateResponseDto findRealEstateById(Long id);

    List<RealEstate> findAllRealEstateByFilter(String location, String filter);
    List<RealEstateResponseDto> findAllRealEstateResponseDtoByFilter(String location, String filter);
    Optional<RealEstate> createRealEstate(RealEstateCreateDto dto);

}
