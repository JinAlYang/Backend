package com.JinAlYang.searchPreset.service;

import com.JinAlYang.searchPreset.web.dto.SearchPresetResponseDto;
import com.JinAlYang.searchPreset.web.dto.SearchPresetSaveRequestDto;

import java.util.List;

public interface SearchPresetService {
    Long addSearchPreset(SearchPresetSaveRequestDto requestDto);
    void removeSearchPreset(Long memberId, String searchPresetUrl);

    List<SearchPresetResponseDto> findAllSearchPreset(Long memberId);
}
