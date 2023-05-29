package com.JinAlYang.member.service;

import com.JinAlYang.member.domain.Member;
import com.JinAlYang.member.repository.MemberRepository;
import com.JinAlYang.member.web.dto.MemberCreateDto;
import com.JinAlYang.member.web.dto.MemberResponseDto;
import com.JinAlYang.member.web.dto.MemberSignInDto;
import com.JinAlYang.member.web.dto.MemberUpdateDto;
import com.JinAlYang.memberRegion.MemberRegion;
import com.JinAlYang.memberRegion.MemberRegionRepository;
import com.JinAlYang.region.domain.Region;
import com.JinAlYang.region.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final RegionRepository regionRepository;

    private final MemberRegionRepository memberRegionRepository;
    @Override
    @Transactional
    public Long createMember(MemberCreateDto dto) {
        return memberRepository.save(dto.toEntity()).getId();
    }

    @Override
    public MemberResponseDto findMemberById(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);

        if (!optionalMember.isPresent()) {
            throw new IllegalArgumentException("해당 멤버가 없습니다");
        }
        Member member = optionalMember.get();
        return getMemberResponseDto(member);
    }

    @Override
    @Transactional
    public MemberResponseDto signIn(Long id, MemberSignInDto memberSignInDto) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (!optionalMember.isPresent()) {
            throw new IllegalArgumentException("해당 멤버가 없습니다");
        }
        Member member = optionalMember.get().signIn(memberSignInDto);
        memberRepository.save(member);

        return getMemberResponseDto(member);
    }

    @Override
    @Transactional
    public MemberResponseDto updateMemberInfo(Long id, MemberUpdateDto memberUpdateDto) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (!optionalMember.isPresent()) {
            throw new IllegalArgumentException("해당 멤버가 없습니다");
        }

        Member member = optionalMember.get().update(memberUpdateDto);
        memberRepository.save(member);

        return getMemberResponseDto(member);
    }

    @Override
    @Transactional
    public MemberResponseDto addInterestRegion(Long memberId,String regionName) {
        Optional<Region> optionalRegion = regionRepository.findByName(regionName);
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalRegion.isPresent())
            throw new IllegalArgumentException("해당 지역이 없습니다");
        else if(!optionalMember.isPresent())
            throw new IllegalArgumentException("해당 멤버가 없습니다");

        Region region = optionalRegion.get();
        Member member = optionalMember.get();

        MemberRegion memberRegion = MemberRegion.builder()
                .member(member)
                .region(region)
                .build();

        memberRegionRepository.save(memberRegion);

        return getMemberResponseDto(member);
    }

    private static MemberResponseDto getMemberResponseDto(Member member) {
        return MemberResponseDto.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .profileUrl(member.getProfileUrl())
                .gender(member.getGender())
                .age(member.getAge())
                .livingExpenses(member.getLivingExpenses())
                .savingMoney(member.getSavingMoney())
                .loanInterest(member.getLoanInterest())
                .build();
    }
}
