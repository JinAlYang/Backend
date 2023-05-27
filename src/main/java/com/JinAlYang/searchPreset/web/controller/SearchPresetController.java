package com.JinAlYang.searchPreset.web.controller;

import com.JinAlYang.searchPreset.service.SearchPresetService;
import com.JinAlYang.searchPreset.web.dto.SearchPresetResponseDto;
import com.JinAlYang.searchPreset.web.dto.SearchPresetSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class SearchPresetController {

    private final SearchPresetService searchPresetService;

    @PostMapping("")
    public Long addSearchPreset(@RequestBody SearchPresetSaveRequestDto requestDto) {
        return searchPresetService.addSearchPreset(requestDto);
    }

    @GetMapping("")
    public SearchPresetResponseDto findById(@PathVariable Long preset_id) {
        return searchPresetService.findById(preset_id);
    }

    @DeleteMapping("")
    public Long removeSearchPreset(@PathVariable Long preset_id) {
        searchPresetService.removeSearchPreset(preset_id);
        return preset_id;
    }
}
