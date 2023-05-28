package com.JinAlYang.searchPreset.service;

import com.JinAlYang.searchPreset.web.dto.SearchPresetResponseDto;
import com.JinAlYang.searchPreset.web.dto.SearchPresetSaveRequestDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface SearchPresetService {

    List<SearchPresetResponseDto> findAllSearchPreset();

    Long addSearchPreset(SearchPresetSaveRequestDto requestDto);

    void removeSearchPreset(Long preset_id);

    SearchPresetResponseDto findSearchPresetById(Long preset_id);
}
