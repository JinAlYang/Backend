package com.JinAlYang.searchPreset.service;

import com.JinAlYang.searchPreset.web.dto.SearchPresetResponseDto;
import com.JinAlYang.searchPreset.web.dto.SearchPresetSaveRequestDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface SearchPresetService {

    @Transactional
    Long addSearchPreset(SearchPresetSaveRequestDto requestDto);

    @Transactional
    void removeSearchPreset(Long preset_id);

    public SearchPresetResponseDto findById(Long preset_id);

    @Transactional
    List<SearchPresetResponseDto> findAllSearchPreset(Long memberId);
}
