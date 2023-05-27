package com.JinAlYang.searchPreset.service;

import com.JinAlYang.searchPreset.web.dto.SearchPresetResponseDto;

import java.util.List;

public interface SearchPresetService {
    public List<SearchPresetResponseDto> findAllSearchPreset(Long memberId);

    public boolean addSearchPreset(Long memberId, String searchPresetUrl);
    public boolean removeSearchPreset(Long memberId, String searchPresetUrl);
}
