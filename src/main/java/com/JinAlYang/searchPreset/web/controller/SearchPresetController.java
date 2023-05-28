package com.JinAlYang.searchPreset.web.controller;

import com.JinAlYang.searchPreset.service.SearchPresetService;
import com.JinAlYang.searchPreset.web.dto.SearchPresetResponseDto;
import com.JinAlYang.searchPreset.web.dto.SearchPresetSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/preset")
public class SearchPresetController {
    private final SearchPresetService searchPresetService;

    @GetMapping("/get")
    public List<SearchPresetResponseDto> getSearchPresetList() {
        return null;
    }

    @PostMapping("/save")
    public Long addSearchPreset(@RequestBody SearchPresetSaveRequestDto requestDto) {
        return searchPresetService.addSearchPreset(requestDto);
    }

    @GetMapping("/{preset_id}")
    public SearchPresetResponseDto getSearchPresetById(@PathVariable Long preset_id) {
        return searchPresetService.findSearchPresetById(preset_id);
    }

    @DeleteMapping("/delete/{preset_id}")
    public Long removeSearchPreset(@PathVariable Long preset_id) {
        searchPresetService.removeSearchPreset(preset_id);
        return preset_id;
    }
}
