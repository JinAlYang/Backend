package com.JinAlYang.realEstate.service;

import com.JinAlYang.realEstate.domain.RealEstate;
import com.JinAlYang.realEstate.domain.RealEstateDetail;
import com.JinAlYang.realEstate.repository.RealEstateDetailRepository;
import com.JinAlYang.realEstate.repository.RealEstateRepository;
import com.JinAlYang.realEstate.web.dto.RealEstateCreateDto;
import com.JinAlYang.realEstate.web.dto.RealEstateDetailCreateDto;
import com.JinAlYang.realEstate.web.dto.RealEstateResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RealEstateServiceImpl implements RealEstateService{

    RealEstateRepository realEstateRepository;
    RealEstateDetailRepository realEstateDetailRepository;

    @Override
    public Optional<RealEstate> createRealEstate(RealEstateCreateDto realEstateCreateDto) {

        List<RealEstateDetail> realEstateDetailList = new ArrayList<>();
        List<RealEstateDetailCreateDto> realEstateDetailCreateDtoList = realEstateCreateDto.getRealEstateDetailCreateDtoList();
        for (int i = 0; i < realEstateDetailList.size(); i++) {
            realEstateDetailList.add(realEstateDetailRepository.save(realEstateDetailCreateDtoList.get(i).toEntity()));
        }

        RealEstate realEstate = realEstateCreateDto.toEntity();
        realEstate.setRealEstateDetailList(realEstateDetailList);

        return Optional.of(realEstateRepository.save(realEstate));
    }
    @Override
    public RealEstateResponseDto findRealEstateById(Long id) {
        return null;
    }

    @Override
    public List<RealEstateResponseDto> findAllRealEstateByFilter(String location, String filter) {
        return null;
    }
}
