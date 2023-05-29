package com.JinAlYang.realEstate.domain;


import com.JinAlYang.region.domain.Region;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "realEstate")
@NoArgsConstructor
@AllArgsConstructor
public class RealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "realEstate_id")
    private Long id;

    @Column(name = "jeonse_monthlyRent_type",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private MonthlyRentType monthlyRentType;

    @Column(name = "realEstate_deposit")
    private int deposit;

    @Column(name = "realEstate_roomSize")
    private int roomSize;

    @Column(name = "realEstate_spaceType")
    @Enumerated(value = EnumType.STRING)
    private SpaceType spaceType;

    @Column(name = "realEstate_monthly_payment")
    private int monthlyPayment;

    @Column(name = "realEstate_occupancyPeriods")
    private LocalDateTime occupancyPeriods;

    @Column(name = "realEstate_windowDirection")
    @Enumerated(value = EnumType.STRING)
    private WindowDirection windowDirection;

    @Column(name = "realEstate_builtDate")
    private LocalDateTime builtDate;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToOne
    @JoinColumn(name="realEstateDetail")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RealEstateDetail realEstateDetail;

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

    @Override
    public String toString() {
        return "RealEstate{" +
                "id=" + id +
                ", monthlyRentType=" + monthlyRentType +
                ", deposit=" + deposit +
                ", roomSize=" + roomSize +
                ", spaceType=" + spaceType +
                ", monthlyPayment=" + monthlyPayment +
                ", occupancyPeriods=" + occupancyPeriods +
                ", windowDirection=" + windowDirection +
                ", builtDate=" + builtDate +
                ", region=" + region +
                ", realEstateDetail=" + realEstateDetail +
                '}';
    }

    public void setRealEstateDetail(RealEstateDetail realEstateDetail) {
        this.realEstateDetail = realEstateDetail;
    }
}
