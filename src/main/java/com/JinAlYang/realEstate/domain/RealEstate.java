package com.JinAlYang.realEstate.domain;


import com.JinAlYang.region.domain.Region;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "realEstate")
@NoArgsConstructor
public class RealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "realEstate_id")
    private Long id;

    @Column(name = "jeonse_monthlyRent_type",nullable = false)
    private MonthlyRentType monthlyRentType;

    @Column(name = "realEstate_deposit")
    private int deposit;

    @Column(name = "realEstate_roomSize")
    private int roomSize;

    @Column(name = "realEstate_spaceType")
    private SpaceType spaceType;

    @Column(name = "realEstate_monthly_payment")
    private int monthlyPayment;

    @Column(name = "realEstate_occupancyPeriods")
    private LocalDateTime occupancyPeriods;

    @Column(name = "realEstate_windowDirection")
    private WindowDirection windowDirection;

    @Column(name = "realEstate_builtDate")
    private LocalDateTime builtDate;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "realEstate")
    private List<RealEstateDetail> realEstateDetailList;

    @Builder
    public RealEstate(MonthlyRentType monthlyRentType, int deposit, int roomSize, SpaceType spaceType, int monthlyPayment, LocalDateTime occupancyPeriods, WindowDirection windowDirection, LocalDateTime builtDate) {
        this.monthlyRentType = monthlyRentType;
        this.deposit = deposit;
        this.roomSize = roomSize;
        this.spaceType = spaceType;
        this.monthlyPayment = monthlyPayment;
        this.occupancyPeriods = occupancyPeriods;
        this.windowDirection = windowDirection;
        this.builtDate = builtDate;
    }

    public void setRealEstateDetailList(List<RealEstateDetail> realEstateDetailList) {
        this.realEstateDetailList = realEstateDetailList;
    }
}
