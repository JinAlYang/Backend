package com.JinAlYang.searchPreset.service;

import com.JinAlYang.searchPreset.repository.SearchPresetRepository;
import com.JinAlYang.searchPreset.web.dto.SearchPresetResponseDto;
import com.JinAlYang.searchPreset.web.dto.SearchPresetSaveRequestDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SearchPresetServicempl implements SearchPresetService{

    private final SearchPresetRepository searchPresetRepository;

    @Override
    public List<SearchPresetResponseDto> findAllSearchPreset(Long memberId) {
        return searchPresetRepository.findAllSearchPreset().stream()
                .map(SearchPresetResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public long addSearchPreset(SearchPresetSaveRequestDto requestDto) {
        return searchPresetRepository.save(requestDto.toEntity()).getId();
    }

    @Override
    public boolean removeSearchPreset(Long memberId, String searchPresetUrl) { return false; }
}
