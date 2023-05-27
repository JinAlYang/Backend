package com.JinAlYang.realEstate.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "realEstateDetail")
@NoArgsConstructor
public class RealEstateDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "realEstateDetail_id")
    private Long id;

    private int managementFees;

    private boolean sink;

    private boolean airCondition_status;

    private boolean shoebox_status;

    private boolean washingMachine_status;

    private boolean refrigerator_status;

    private boolean closet_status;

    private boolean gasStoves_status;

    private boolean bed_status;

    private String detail_info;

    private boolean cafe_status;

    private boolean convenienceStore_status;

    private boolean laundry_status;

    private boolean supermarket_status;

    private boolean busStation_status;

    private boolean subway_status;

    @ManyToOne
    @JoinColumn(name = "realEstate_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RealEstate realEstate;

    @Builder
    public RealEstateDetail(int managementFees, boolean sink, boolean airCondition_status, boolean shoebox_status, boolean washingMachine_status, boolean refrigerator_status, boolean closet_status, boolean gasStoves_status, boolean bed_status, String detail_info, boolean cafe_status, boolean convenienceStore_status, boolean laundry_status, boolean supermarket_status, boolean busStation_status, boolean subway_status) {
        this.managementFees = managementFees;
        this.sink = sink;
        this.airCondition_status = airCondition_status;
        this.shoebox_status = shoebox_status;
        this.washingMachine_status = washingMachine_status;
        this.refrigerator_status = refrigerator_status;
        this.closet_status = closet_status;
        this.gasStoves_status = gasStoves_status;
        this.bed_status = bed_status;
        this.detail_info = detail_info;
        this.cafe_status = cafe_status;
        this.convenienceStore_status = convenienceStore_status;
        this.laundry_status = laundry_status;
        this.supermarket_status = supermarket_status;
        this.busStation_status = busStation_status;
        this.subway_status = subway_status;
    }
}
