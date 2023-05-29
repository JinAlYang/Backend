package com.JinAlYang.searchPreset.service;

import com.JinAlYang.searchPreset.web.dto.SearchPresetResponseDto;
import com.JinAlYang.searchPreset.web.dto.SearchPresetSaveRequestDto;

import java.util.List;
import java.lang.Long;

public interface SearchPresetService {

    public List<SearchPresetResponseDto> findAllSearchPreset(Long memberId);

    public SearchPresetResponseDto findSearchPresetById(Long memberId, Long presetId);

    public boolean addSearchPreset(Long memberId, SearchPresetSaveRequestDto requestDto);

    public boolean removeSearchPreset(Long memberId, Long presetId);

}
