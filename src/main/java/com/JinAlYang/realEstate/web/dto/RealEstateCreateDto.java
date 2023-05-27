package com.JinAlYang.realEstate.web.dto;

import com.JinAlYang.realEstate.domain.*;
import com.JinAlYang.region.domain.Region;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class RealEstateCreateDto {

    private MonthlyRentType monthlyRentType;

    private int deposit;

    private int roomSize;

    private SpaceType spaceType;

    private int monthlyPayment;

    private LocalDateTime occupancyPeriods;

    private WindowDirection windowDirection;

    private LocalDateTime builtDate;

    private List<RealEstateDetailCreateDto> realEstateDetailCreateDtoList;

    public RealEstate toEntity(){
        return RealEstate.builder()
                .monthlyRentType(monthlyRentType)
                .deposit(deposit)
                .roomSize(roomSize)
                .spaceType(spaceType)
                .monthlyPayment(monthlyPayment)
                .occupancyPeriods(occupancyPeriods)
                .windowDirection(windowDirection)
                .builtDate(builtDate)
                .build();
    }
}
