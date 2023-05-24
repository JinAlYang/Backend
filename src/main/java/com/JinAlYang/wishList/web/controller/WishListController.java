package com.JinAlYang.wishList.web.controller;

import com.JinAlYang.realEstate.web.dto.RealEstateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wishList")
public class WishListController {

    @GetMapping("/recentHome/{memberId}")
    public List<RealEstateResponseDto> getRecentHomeWishList(@PathVariable("memberId") Long memberId) {

        return null;
    }

    @GetMapping("/zzimHome/{memberId}")
    public String getZzimHomeWishList(@PathVariable("memberId") Long memberId) {

        return null;
    }

    @PostMapping("/recentHome")
    public boolean addToRecentHomeWishList(
            @RequestParam("memberId") String memberId,
            @RequestParam("realEstateId") String realEstateId
    ) {

        return true;
    }

    @PostMapping("/zzimHome")
    public boolean addToZzimHomeWishList(
            @RequestParam("memberId") String memberId,
            @RequestParam("realEstateId") String realEstateId
    ) {

        return true;
    }

    @DeleteMapping("/recentHome")
    public boolean removeFromRecentHomeWishList(
            @RequestParam("memberId") String memberId,
            @RequestParam("realEstateId") String realEstateId
    ) {
        return true;
    }

    @DeleteMapping("/zzimHome")
    public boolean removeFromZzimHomeWishList(
            @RequestParam("memberId") String memberId,
            @RequestParam("realEstateId") String realEstateId
    ) {

        return true;
    }
}
