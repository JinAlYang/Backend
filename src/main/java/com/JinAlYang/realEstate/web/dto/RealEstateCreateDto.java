package com.JinAlYang.realEstate.web.dto;

import com.JinAlYang.realEstate.domain.*;
import com.JinAlYang.region.domain.Region;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Data
public class RealEstateCreateDto {

    private MonthlyRentType monthlyRentType;

    private int deposit;

    private int roomSize;

    private SpaceType spaceType;

    private int monthlyPayment;

    private LocalDateTime occupancyPeriods;

    private WindowDirection windowDirection;

    private LocalDateTime builtDate;

    private RealEstateDetailCreateDto realEstateDetailCreateDto;

    @Builder
    public RealEstateCreateDto(MonthlyRentType monthlyRentType, int deposit, int roomSize, SpaceType spaceType, int monthlyPayment, LocalDateTime occupancyPeriods, WindowDirection windowDirection, LocalDateTime builtDate, RealEstateDetailCreateDto realEstateDetailCreateDto) {
        this.monthlyRentType = monthlyRentType;
        this.deposit = deposit;
        this.roomSize = roomSize;
        this.spaceType = spaceType;
        this.monthlyPayment = monthlyPayment;
        this.occupancyPeriods = occupancyPeriods;
        this.windowDirection = windowDirection;
        this.builtDate = builtDate;
        this.realEstateDetailCreateDto = realEstateDetailCreateDto;
    }

    @Override
    public String toString() {
        return "RealEstateCreateDto{" +
                "monthlyRentType=" + monthlyRentType +
                ", deposit=" + deposit +
                ", roomSize=" + roomSize +
                ", spaceType=" + spaceType +
                ", monthlyPayment=" + monthlyPayment +
                ", occupancyPeriods=" + occupancyPeriods +
                ", windowDirection=" + windowDirection +
                ", builtDate=" + builtDate +
                ", realEstateDetailCreateDto=" + realEstateDetailCreateDto +
                '}';
    }

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
