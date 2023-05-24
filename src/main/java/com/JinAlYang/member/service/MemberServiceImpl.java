package com.JinAlYang.member.service;

import com.JinAlYang.member.web.dto.MemberResponseDto;
import com.JinAlYang.member.web.dto.MemberSignInDto;
import com.JinAlYang.member.web.dto.MemberUpdateDto;

public class MemberServiceImpl implements MemberService{

    @Override
    public MemberResponseDto findMemberById(Long id) {
        return null;
    }

    @Override
    public Long signIn(Long id, MemberSignInDto memberSignInDto) {
        return null;
    }

    @Override
    public boolean updateMemberInfo(Long id, MemberUpdateDto memberUpdateDto) {
        return false;
    }

    @Override
    public boolean addInterestRegion(Long id) {
        return false;
    }
}
