package com.JinAlYang.realEstate.web.dto;

import com.JinAlYang.realEstate.domain.FloorType;
import com.JinAlYang.realEstate.domain.MonthlyRentType;
import com.JinAlYang.realEstate.domain.SpaceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
public class RealEstateSearchDto {
    private Long id;
    private String region, locationBottom, locationLeft, locationTop, locationRight;
    private SpaceType spaceType;
    private FloorType floorType;
    private MonthlyRentType monthlyRentType;
    private Integer roomSizeStart, roomSizeEnd, depositStart, depositEnd, monthlyPaymentStart, monthlyPaymentEnd;
    private Boolean sink, airCondition_status, shoebox_status, washingMachine_status, refrigerator_status,
            closet_status, gasStoves_status, bed_status, cafe_status, convenienceStore_status,
            laundry_status, supermarket_status, busStation_status, subway_status;

    //추가적으로 옵션으로 사용할 것은 여기에
}
