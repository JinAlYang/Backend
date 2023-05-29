package com.JinAlYang.wishList.service;

import com.JinAlYang.realEstate.web.dto.RealEstateResponseDto;

import java.util.List;

public interface WishListService {

    public List<RealEstateResponseDto> findAllRecentHome(Long memberId);

    public boolean addRecentHome(Long memberId, Long realEstateId);

    public boolean removeRecentHome(Long memberId, Long realEstateId);

    public List<RealEstateResponseDto> findAllZzimHome(Long member);

    public boolean addZzimHome(Long memberId, Long realEstateId);


    public boolean removeZzimHome(Long memberId, Long realEstateId);
}
