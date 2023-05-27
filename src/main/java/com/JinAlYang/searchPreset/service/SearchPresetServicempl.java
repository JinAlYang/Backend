package com.JinAlYang.searchPreset.service;

import com.JinAlYang.searchPreset.web.dto.SearchPresetResponseDto;

import java.util.List;

public class SearchPresetServicempl implements SearchPresetService{

    @Override
    public List<SearchPresetResponseDto> findAllSearchPreset(Long memberId) { return null; }

    @Override
    public boolean addSearchPreset(Long memberId, String searchPresetUrl) { return false; }

    @Override
    public boolean removeSearchPreset(Long memberId, String searchPresetUrl) { return false; }
}
