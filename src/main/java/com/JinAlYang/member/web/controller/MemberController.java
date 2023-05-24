package com.JinAlYang.member.web.controller;

import com.JinAlYang.member.service.MemberService;
import com.JinAlYang.member.web.dto.MemberResponseDto;
import com.JinAlYang.member.web.dto.MemberSignInDto;
import com.JinAlYang.member.web.dto.MemberUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{id}")
    public MemberResponseDto getMember(@PathVariable Long id) {
        return memberService.findMemberById(id);
    }

    @PostMapping("")
    public long signIn(@PathVariable Long id, @RequestBody MemberSignInDto memberSignInDto) {
        //member id 리턴
        return 1;
    }

    @PutMapping("/{id}")
    public boolean updateMemberInfo(@PathVariable Long id, @RequestBody MemberUpdateDto memberUpdateDto){
        return true;
    }

    @PostMapping("{regionId}")
    public boolean addInterestRegion(@PathVariable Long regionId) {
        return true;
    }
}
