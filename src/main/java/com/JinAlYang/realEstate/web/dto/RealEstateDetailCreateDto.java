package com.JinAlYang.realEstate.web.dto;

import com.JinAlYang.realEstate.domain.RealEstateDetail;

public class RealEstateDetailCreateDto {

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

    public RealEstateDetail toEntity(){
        return RealEstateDetail.builder()
                .managementFees(managementFees)
                .sink(sink)
                .airCondition_status(airCondition_status)
                .shoebox_status(shoebox_status)
                .washingMachine_status(washingMachine_status)
                .refrigerator_status(refrigerator_status)
                .closet_status(closet_status)
                .gasStoves_status(gasStoves_status)
                .bed_status(bed_status)
                .detail_info(detail_info)
                .cafe_status(cafe_status)
                .convenienceStore_status(convenienceStore_status)
                .laundry_status(laundry_status)
                .supermarket_status(supermarket_status)
                .busStation_status(busStation_status)
                .subway_status(subway_status)
                .build();
    }
}
