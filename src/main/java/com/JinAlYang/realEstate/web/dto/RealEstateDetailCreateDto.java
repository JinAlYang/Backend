package com.JinAlYang.realEstate.web.dto;

import com.JinAlYang.realEstate.domain.RealEstateDetail;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Data
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

    @Builder
    public RealEstateDetailCreateDto(int managementFees, boolean sink, boolean airCondition_status, boolean shoebox_status, boolean washingMachine_status, boolean refrigerator_status, boolean closet_status, boolean gasStoves_status, boolean bed_status, String detail_info, boolean cafe_status, boolean convenienceStore_status, boolean laundry_status, boolean supermarket_status, boolean busStation_status, boolean subway_status) {
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
