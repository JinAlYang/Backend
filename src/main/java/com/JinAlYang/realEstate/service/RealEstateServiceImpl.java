package com.JinAlYang.realEstate.service;

import com.JinAlYang.realEstate.domain.RealEstate;
import com.JinAlYang.realEstate.domain.RealEstateDetail;
import com.JinAlYang.realEstate.repository.RealEstateDetailRepository;
import com.JinAlYang.realEstate.repository.RealEstateRepository;
import com.JinAlYang.realEstate.web.dto.RealEstateCreateDto;
import com.JinAlYang.realEstate.web.dto.RealEstateDetailCreateDto;
import com.JinAlYang.realEstate.web.dto.RealEstateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RealEstateServiceImpl implements RealEstateService{

    private final RealEstateRepository realEstateRepository;
    private final RealEstateDetailRepository realEstateDetailRepository;

    @Override
    @Transactional
    public Optional<RealEstate> createRealEstate(RealEstateCreateDto realEstateCreateDto) {

        RealEstateDetailCreateDto realEstateDetailCreateDto = realEstateCreateDto.getRealEstateDetailCreateDto();
        RealEstateDetail savedRealEstateDetail = realEstateDetailRepository.save(realEstateDetailCreateDto.toEntity());

        RealEstate realEstate = realEstateCreateDto.toEntity();
        realEstate.setRealEstateDetail(savedRealEstateDetail);

        return Optional.of(realEstateRepository.save(realEstate));
    }
    @Override
    public RealEstateResponseDto findRealEstateById(Long id) {
        Optional<RealEstate> optionalRealEstate = realEstateRepository.findById(id);

        if(!optionalRealEstate.isPresent())
            throw new IllegalStateException();

        RealEstate realEstate = optionalRealEstate.get();
        return RealEstateResponseDto.builder()
                .id(realEstate.getId())
                .monthlyRentType(realEstate.getMonthlyRentType())
                .deposit(realEstate.getDeposit())
                .roomSize(realEstate.getRoomSize())
                .spaceType(realEstate.getSpaceType())
                .monthlyPayment(realEstate.getMonthlyPayment())
                .occupancyPeriods(realEstate.getOccupancyPeriods())
                .windowDirection(realEstate.getWindowDirection())
                .builtDate(realEstate.getBuiltDate())
                .realEstateDetail(realEstate.getRealEstateDetail())
                .build();
    }

    @Override
    public List<RealEstateResponseDto> findAllRealEstateByFilter(String location, String filter) {
        return null;
    }
}
