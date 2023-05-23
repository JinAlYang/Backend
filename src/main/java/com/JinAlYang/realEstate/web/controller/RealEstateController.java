package com.JinAlYang.realEstate.web.controller;

import com.JinAlYang.member.service.MemberService;
import com.JinAlYang.member.web.dto.MemberResponseDto;
import com.JinAlYang.member.web.dto.MemberSignInDto;
import com.JinAlYang.member.web.dto.MemberUpdateDto;
import com.JinAlYang.realEstate.web.dto.RealEstateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/realEstate")
public class RealEstateController {
    private final MemberService memberService;

    @GetMapping("/{id}")
    public RealEstateResponseDto getRealEstate(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/bboxList")
    public List<RealEstateResponseDto> getRealEstateList(
            @RequestParam("location") String location,
            @RequestParam("filter") String filter
    ) {

        return null;
    }

    @GetMapping("/bbox")
    public String getRealEstateList(
            @RequestParam("location") String location
    ) {

        return null;
    }
}
