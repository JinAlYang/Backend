package com.JinAlYang.wishList.service;

import com.JinAlYang.realEstate.web.dto.RealEstateResponseDto;

import java.util.List;

public interface WishListService {

    public List<RealEstateResponseDto> findAllRecentHome(Long memberId);

    public boolean addRecentHome(String memberId, String realEstateId);

    public boolean removeRecentHome(String memberId, String realEstateId);

    public List<RealEstateResponseDto> findAllZzimHome(Long member);

    public boolean addZzimHome(String memberId, String realEstateId);


    public boolean removeZzimHome(String memberId, String realEstateId);
}
