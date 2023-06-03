package com.JinAlYang.realEstate.web.dto;

import com.JinAlYang.realEstate.domain.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class RealEstateResponseDto {

    private Long id;

    private String address;

    private String latitude;

    private String longitude;

    private MonthlyRentType monthlyRentType;

    private int deposit;

    private int roomSize;

    private SpaceType spaceType;

    private int monthlyPayment;

    private LocalDateTime occupancyPeriods;

    private WindowDirection windowDirection;

    private LocalDateTime builtDate;

    private RealEstateDetail realEstateDetail;

    @Builder
    public RealEstateResponseDto(String address, String latitude, String longitude, Long id,MonthlyRentType monthlyRentType, int deposit, int roomSize, SpaceType spaceType, int monthlyPayment, LocalDateTime occupancyPeriods, WindowDirection windowDirection, LocalDateTime builtDate, RealEstateDetail realEstateDetail) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.id = id;
        this.monthlyRentType = monthlyRentType;
        this.deposit = deposit;
        this.roomSize = roomSize;
        this.spaceType = spaceType;
        this.monthlyPayment = monthlyPayment;
        this.occupancyPeriods = occupancyPeriods;
        this.windowDirection = windowDirection;
        this.builtDate = builtDate;
        this.realEstateDetail = realEstateDetail;
    }

    //entity -> dto
    public RealEstateResponseDto(RealEstate entity) {
        this.address = entity.getAddress();
        this.latitude = entity.getLatitude();
        this.longitude = entity.getLongitude();
        this.id = entity.getId();
        this.monthlyRentType = entity.getMonthlyRentType();
        this.deposit = entity.getDeposit();
        this.roomSize = entity.getRoomSize();
        this.spaceType = entity.getSpaceType();
        this.monthlyPayment = entity.getMonthlyPayment();
        this.occupancyPeriods = entity.getOccupancyPeriods();
        this.windowDirection = entity.getWindowDirection();
        this.builtDate = entity.getBuiltDate();
        this.realEstateDetail = entity.getRealEstateDetail();
    }
}
