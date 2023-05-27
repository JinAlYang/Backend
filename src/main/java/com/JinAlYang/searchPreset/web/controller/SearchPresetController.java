package com.JinAlYang.searchPreset.web.controller;

import com.JinAlYang.searchPreset.service.SearchPresetService;
import com.JinAlYang.searchPreset.web.dto.SearchPresetSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class SearchPresetController {

    private final SearchPresetService searchPresetService;

    @PostMapping("") //TODO: 적어야 함...
    public Long addSearchPreset(@RequestBody SearchPresetSaveRequestDto requestDto) {
        return searchPresetService.addSearchPreset(requestDto);
    }

    @DeleteMapping("")
    public Long removeSearchPreset(@PathVariable Long id)
}
