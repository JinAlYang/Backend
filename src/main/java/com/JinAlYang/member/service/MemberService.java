package com.JinAlYang.member.service;

import com.JinAlYang.member.web.dto.MemberResponseDto;
import com.JinAlYang.member.web.dto.MemberSignInDto;
import com.JinAlYang.member.web.dto.MemberUpdateDto;

public interface MemberService {

    public MemberResponseDto findMemberById(Long id);

    public Long signIn(Long id, MemberSignInDto memberSignInDto);

    public boolean updateMemberInfo(Long id, MemberUpdateDto memberUpdateDto);

    public boolean addInterestRegion(Long id);

}
