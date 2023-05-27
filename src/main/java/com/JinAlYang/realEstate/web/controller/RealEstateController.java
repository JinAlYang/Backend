package com.JinAlYang.realEstate.web.controller;

import com.JinAlYang.member.service.MemberService;
import com.JinAlYang.member.web.dto.MemberResponseDto;
import com.JinAlYang.member.web.dto.MemberSignInDto;
import com.JinAlYang.member.web.dto.MemberUpdateDto;
import com.JinAlYang.realEstate.domain.RealEstate;
import com.JinAlYang.realEstate.service.RealEstateService;
import com.JinAlYang.realEstate.web.dto.RealEstateCreateDto;
import com.JinAlYang.realEstate.web.dto.RealEstateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/realEstate")
public class RealEstateController {
    private final RealEstateService realEstateService;

    @PostMapping("")
    public boolean createRealEstate(RealEstateCreateDto dto){
        return realEstateService.createRealEstate(dto).isPresent();
    }

    @GetMapping("/{id}")
    public RealEstateResponseDto getRealEstate(@PathVariable Long id) {
        return realEstateService.findRealEstateById(id);
    }

    @GetMapping("/bbox")
    public List<RealEstateResponseDto> getRealEstateListInMap(
            @RequestParam("location") String location,
            @RequestParam("filter") String filter
    ) {

        return null;
    }

}
