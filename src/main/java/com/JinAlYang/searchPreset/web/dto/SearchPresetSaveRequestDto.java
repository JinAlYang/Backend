package com.JinAlYang.searchPreset.web.dto;

import com.JinAlYang.searchPreset.domain.SearchPreset;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SearchPresetSaveRequestDto {
    private String name;
    private String url;
    private String preset_info;

    @Builder
    public SearchPresetSaveRequestDto(String name, String url, String present_info) {
        this.name = name;
        this.url = url;
        this.preset_info = present_info;
    }

    public SearchPreset toEntity() {
        return SearchPreset.builder()
                .name(name)
                .url(url)
                .preset_info(preset_info)
                .build();
    }
}
