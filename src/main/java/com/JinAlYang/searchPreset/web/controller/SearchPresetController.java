package com.JinAlYang.searchPreset.web.controller;

import com.JinAlYang.searchPreset.service.SearchPresetService;
import com.JinAlYang.searchPreset.web.dto.SearchPresetResponseDto;
import com.JinAlYang.searchPreset.web.dto.SearchPresetSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.lang.Long;

@RequiredArgsConstructor
@RestController
@RequestMapping("/preset")
public class SearchPresetController {
    private final SearchPresetService searchPresetService;

    @GetMapping("/find/{memberId}")
    public List<SearchPresetResponseDto> getSearchPresetList(
            @PathVariable("memberId") Long memberId) {
        return searchPresetService.findAllSearchPreset(memberId);
    }

    @GetMapping("/find/{memberId}/{presetId}")
    public SearchPresetResponseDto getSearchPresetById(
            @PathVariable("memberId") Long memberId,
            @PathVariable("presetId") Long presetId) {
        return searchPresetService.findSearchPresetById(memberId, presetId);
    }

    @PostMapping("/alter/{memberId}")
    public boolean addSearchPreset(
            @PathVariable("memberId") Long memberId,
            @RequestBody SearchPresetSaveRequestDto requestDto) {
        return searchPresetService.addSearchPreset(memberId, requestDto);
    }

    @DeleteMapping("/alter/{memberId}/{presetId}")
    public boolean removeSearchPreset(
            @PathVariable("memberId") Long memberId,
            @PathVariable("presetId") Long presetId) {
        return searchPresetService.removeSearchPreset(memberId, presetId);
    }
}
