package com.JinAlYang.member.web.controller;

import com.JinAlYang.member.service.MemberService;
import com.JinAlYang.member.web.dto.MemberCreateDto;
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

    //테스트용
    @PostMapping("/test")
    public Long createMember(@RequestBody MemberCreateDto memberCreateDto) {
        return memberService.createMember(memberCreateDto);
    }

    @GetMapping("{id}")
    public MemberResponseDto getMember(@PathVariable Long id) {
        return memberService.findMemberById(id);
    }

    //소셜 로그인 백에서 진행하면 이름, 이메일, 프로필url만 db에 저장된 상태
    //나머지 정보 없데이트 해줘야함
    @PostMapping("{id}")
    public MemberResponseDto signIn(@PathVariable Long id, @RequestBody MemberSignInDto memberSignInDto) {
        return memberService.signIn(id, memberSignInDto);
    }

    @PutMapping("{id}")
    public MemberResponseDto updateMemberInfo(@PathVariable Long id, @RequestBody MemberUpdateDto memberUpdateDto){
        return memberService.updateMemberInfo(id, memberUpdateDto);
    }

    @PostMapping("/region/{memberId}/{regionName}")
    public MemberResponseDto addInterestRegion(
            @PathVariable Long memberId,
            @PathVariable String regionName
    ) {
        return memberService.addInterestRegion(memberId, regionName);
    }
    @DeleteMapping("{id}")
    public boolean removeMember(@PathVariable Long id) {
        return removeMember(id);
    }
}
