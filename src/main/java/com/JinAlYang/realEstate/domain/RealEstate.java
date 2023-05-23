package com.JinAlYang.realEstate.domain;


import com.JinAlYang.region.domain.Region;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    @Column(name = "region_id")
    private Region region;
}
