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
    public List<RealEstateResponseDto> getRecentHomeWishList(@PathVariable("memberId") String memberId) {

        return null;
    }

    @GetMapping("/zzimHome/{memberId}")
    public String getZzimHomeWishList(@PathVariable("memberId") String memberId) {

        return null;
    }

    @PostMapping("/recentHome")
    public String addToRecentHomeWishList(
            @RequestParam("memberId") String memberId,
            @RequestParam("realEstateId") String realEstateId
    ) {

        return null;
    }

    @PostMapping("/zzimHome")
    public String addToZzimHomeWishList(
            @RequestParam("memberId") String memberId,
            @RequestParam("realEstateId") String realEstateId
    ) {

        return null;
    }

    @DeleteMapping("/recentHome")
    public String removeFromRecentHomeWishList(
            @RequestParam("memberId") String memberId,
            @RequestParam("realEstateId") String realEstateId
    ) {
        return null;
    }

    @DeleteMapping("/zzimHome")
    public String removeFromZzimHomeWishList(
            @RequestParam("memberId") String memberId,
            @RequestParam("realEstateId") String realEstateId
    ) {

        return null;
    }
}
