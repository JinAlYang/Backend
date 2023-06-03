package com.JinAlYang.member.service;

import com.JinAlYang.member.domain.Member;
import com.JinAlYang.member.web.dto.MemberCreateDto;
import com.JinAlYang.member.web.dto.MemberResponseDto;
import com.JinAlYang.member.web.dto.MemberSignInDto;
import com.JinAlYang.member.web.dto.MemberUpdateDto;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MemberService {

    public Long createMember(MemberCreateDto dto);
    public MemberResponseDto findMemberById(Long id);

    public MemberResponseDto signIn(Long id, MemberSignInDto memberSignInDto);

    public MemberResponseDto updateMemberInfo(Long id, MemberUpdateDto memberUpdateDto);

    public MemberResponseDto addInterestRegion(Long memberId,String regionName);

    public boolean removeMember(Long id);
}
