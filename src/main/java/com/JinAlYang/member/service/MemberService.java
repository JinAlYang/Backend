package com.JinAlYang.member.service;

import com.JinAlYang.member.domain.Member;
import com.JinAlYang.member.web.dto.MemberCreateDto;
import com.JinAlYang.member.web.dto.MemberResponseDto;
import com.JinAlYang.member.web.dto.MemberSignInDto;
import com.JinAlYang.member.web.dto.MemberUpdateDto;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MemberService {

    public Optional<Member> createMember(MemberCreateDto dto);
    public MemberResponseDto findMemberById(Long id);

    public Long signIn(Long id, MemberSignInDto memberSignInDto);

    public boolean updateMemberInfo(Long id, MemberUpdateDto memberUpdateDto);

    public boolean addInterestRegion(Long id);

}
