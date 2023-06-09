package com.JinAlYang.searchPreset.web.dto;

import com.JinAlYang.searchPreset.domain.SearchPreset;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.lang.Long;

@Getter
@RequiredArgsConstructor
public class SearchPresetResponseDto {
    private Long preset_id;
    private String name;
    private String url;
    private String preset_info;

    @Builder
    public SearchPresetResponseDto(SearchPreset entity) {
        this.preset_id = entity.getId();
        this.name = entity.getName();
        this.url = entity.getUrl();
        this.preset_info = entity.getPreset_info();
    }
}
