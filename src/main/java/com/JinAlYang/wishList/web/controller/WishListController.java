package com.JinAlYang.wishList.web.controller;

import com.JinAlYang.realEstate.web.dto.RealEstateResponseDto;
import com.JinAlYang.wishList.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wishList")
public class WishListController {

    private final WishListService wishListService;

    @GetMapping("/recentHome/{memberId}")
    public List<RealEstateResponseDto> getRecentHomeWishList(@PathVariable("memberId") Long memberId) {

        return wishListService.findAllRecentHome(memberId);
    }

    @GetMapping("/zzimHome/{memberId}")
    public List<RealEstateResponseDto> getZzimHomeWishList(@PathVariable("memberId") Long memberId) {

        return wishListService.findAllZzimHome(memberId);
    }

    @PostMapping("/recentHome/{memberId}/{realEstateId}")
    public boolean addToRecentHomeWishList(
            @PathVariable("memberId") Long memberId,
            @PathVariable("realEstateId") Long realEstateId
    ) {
        return wishListService.addRecentHome(memberId, realEstateId);
    }

    @PostMapping("/zzimHome/{memberId}/{realEstateId}")
    public boolean addToZzimHomeWishList(
            @PathVariable("memberId") Long memberId,
            @PathVariable("realEstateId") Long realEstateId
    ) {
        return wishListService.addZzimHome(memberId, realEstateId);
    }

    @DeleteMapping("/recentHome/{memberId}/{realEstateId}")
    public boolean removeFromRecentHomeWishList(
            @PathVariable("memberId") Long memberId,
            @PathVariable("realEstateId") Long realEstateId
    ) {
        return wishListService.removeRecentHome(memberId, realEstateId);
    }

    @DeleteMapping("/zzimHome/{memberId}/{realEstateId}")
    public boolean removeFromZzimHomeWishList(
            @PathVariable("memberId") Long memberId,
            @PathVariable("realEstateId") Long realEstateId
    ) {

        return wishListService.removeZzimHome(memberId, realEstateId);
    }
}
