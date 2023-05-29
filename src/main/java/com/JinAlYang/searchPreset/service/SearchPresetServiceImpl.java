package com.JinAlYang.searchPreset.service;

import com.JinAlYang.member.domain.Member;
import com.JinAlYang.member.repository.MemberRepository;
import com.JinAlYang.searchPreset.domain.SearchPreset;
import com.JinAlYang.searchPreset.repository.SearchPresetRepository;
import com.JinAlYang.searchPreset.web.dto.SearchPresetResponseDto;
import com.JinAlYang.searchPreset.web.dto.SearchPresetSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.lang.Long;

@Service
@RequiredArgsConstructor
public class SearchPresetServiceImpl implements SearchPresetService{

    private final MemberRepository memberRepository;
    private final SearchPresetRepository searchPresetRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SearchPresetResponseDto> findAllSearchPreset(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalMember.isPresent())
            throw new IllegalArgumentException("해당 멤버가 없습니다.");

        Member member = optionalMember.get();
        List<SearchPreset> searchPresets = member.initializeOrGetSearchPreset();

        List<SearchPresetResponseDto> searchPresetResponseDtoList = new ArrayList<>();

        for(SearchPreset value : searchPresets) {
            searchPresetResponseDtoList.add(new SearchPresetResponseDto(value));
        }

        return searchPresetResponseDtoList;
    }

    @Override
    @Transactional
    public SearchPresetResponseDto findSearchPresetById(Long memberId, Long presetId) {
        Optional<SearchPreset> optionalSearchPreset = searchPresetRepository.findById(presetId);
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalSearchPreset.isPresent())
            throw new IllegalArgumentException("해당 프리셋이 없습니다.");
        else if(!optionalMember.isPresent())
            throw new IllegalArgumentException("해당 멤버가 없습니다.");

        return new SearchPresetResponseDto(optionalSearchPreset.get());
    }

    @Override
    @Transactional
    public boolean addSearchPreset(Long memberId, SearchPresetSaveRequestDto requestDto) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalMember.isPresent())
            throw new IllegalArgumentException("해당 멤버가 없습니다.");

        Member member = optionalMember.get();
        List<SearchPreset> searchPresets = member.initializeOrGetSearchPreset();
        for(SearchPreset searchPreset : searchPresets) {
            if(searchPreset.getUrl().compareTo(requestDto.getUrl()) == 0) {
                throw new IllegalArgumentException("해당 프리셋이 이미 존재합니다.");
            }
        }

        SearchPreset searchPreset = SearchPreset.builder()
                .member(member)
                .name(requestDto.getName())
                .url(requestDto.getUrl())
                .preset_info(requestDto.getPreset_info())
                .build();

        searchPresetRepository.save(searchPreset);
        searchPresets.add(searchPreset);

        return true;
    }

    @Override
    @Transactional
    public boolean removeSearchPreset(Long memberId, Long presetId) {
        Optional<SearchPreset> optionalSearchPreset = searchPresetRepository.findById(presetId);
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalSearchPreset.isPresent())
            throw new IllegalArgumentException("해당 프리셋이 없습니다.");
        else if(!optionalMember.isPresent())
            throw new IllegalArgumentException("해당 멤버가 없습니다.");

        Member member = optionalMember.get();
        List<SearchPreset> searchPresets = member.initializeOrGetSearchPreset();

        searchPresets.remove(findSearchPresetById(memberId, presetId).getPreset_id());
        searchPresetRepository.deleteById(presetId);
        return true;
    }
}
