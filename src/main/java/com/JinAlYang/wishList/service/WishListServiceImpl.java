package com.JinAlYang.wishList.service;

import com.JinAlYang.realEstate.web.dto.RealEstateResponseDto;

import java.util.List;

public class WishListServiceImpl implements WishListService{
    @Override
    public List<RealEstateResponseDto> findAllRecentHome(Long memberId) {
        return null;
    }

    @Override
    public boolean addRecentHome(String memberId, String realEstateId) {
        return false;
    }

    @Override
    public boolean removeRecentHome(String memberId, String realEstateId) {
        return false;
    }

    @Override
    public List<RealEstateResponseDto> findAllZzimHome(Long member) {
        return null;
    }

    @Override
    public boolean addZzimHome(String memberId, String realEstateId) {
        return false;
    }

    @Override
    public boolean removeZzimHome(String memberId, String realEstateId) {
        return false;
    }
}
