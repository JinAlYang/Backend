package com.JinAlYang.searchPreset.service;

import com.JinAlYang.searchPreset.domain.SearchPreset;
import com.JinAlYang.searchPreset.repository.SearchPresetRepository;
import com.JinAlYang.searchPreset.web.dto.SearchPresetResponseDto;
import com.JinAlYang.searchPreset.web.dto.SearchPresetSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SearchPresetServicempl implements SearchPresetService{

    private final SearchPresetRepository searchPresetRepository;

    @Override
    public List<SearchPresetResponseDto> findAllSearchPreset() {
        return searchPresetRepository.findAllSearchPreset().stream()
                .map(SearchPresetResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Long addSearchPreset(SearchPresetSaveRequestDto requestDto) {
        return searchPresetRepository.save(requestDto.toEntity()).getId();
    }

    @Override
    public SearchPresetResponseDto findById(Long id) {
        /* 굳이 findById를 할 필요가 있을까?*/
        SearchPreset entity = searchPresetRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 프리셋이 없습니다. id=" + id));

        return new SearchPresetResponseDto(entity);
    }

    @Override
    public void removeSearchPreset(Long preset_id) {
        SearchPreset searchPreset = searchPresetRepository.findById(preset_id)
                .orElseThrow(() -> new IllegalArgumentException("???"));

        searchPresetRepository.delete(searchPreset);
    }
}
