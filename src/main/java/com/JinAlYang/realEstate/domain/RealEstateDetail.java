package com.JinAlYang.realEstate.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

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

}
