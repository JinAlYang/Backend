package com.JinAlYang.member.service;

import com.JinAlYang.member.domain.Member;
import com.JinAlYang.member.repository.MemberRepository;
import com.JinAlYang.member.web.dto.MemberCreateDto;
import com.JinAlYang.member.web.dto.MemberResponseDto;
import com.JinAlYang.member.web.dto.MemberSignInDto;
import com.JinAlYang.member.web.dto.MemberUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    @Override
    public Optional<Member> createMember(MemberCreateDto dto) {
        return Optional.of(memberRepository.save(dto.toEntity()));
    }

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
