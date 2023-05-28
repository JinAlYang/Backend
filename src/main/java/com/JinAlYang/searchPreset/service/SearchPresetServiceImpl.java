package com.JinAlYang.searchPreset.service;

import com.JinAlYang.searchPreset.domain.SearchPreset;
import com.JinAlYang.searchPreset.repository.SearchPresetRepository;
import com.JinAlYang.searchPreset.web.dto.SearchPresetResponseDto;
import com.JinAlYang.searchPreset.web.dto.SearchPresetSaveRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchPresetServiceImpl implements SearchPresetService{

    private final SearchPresetRepository searchPresetRepository;

    @Override
    @Transactional
    public List<SearchPresetResponseDto> findAllSearchPreset() {
        /* All-tuples find */
        return searchPresetRepository.findAllSearchPreset().stream()
                .map(SearchPresetResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Long addSearchPreset(SearchPresetSaveRequestDto requestDto) {
        /* 1-tuple insert */
        return searchPresetRepository.save(requestDto.toEntity()).getId();
    }

    @Override
    @Transactional
    public SearchPresetResponseDto findSearchPresetById(Long preset_id) {
        /* 1-tuple find */
        SearchPreset entity = searchPresetRepository.findById(preset_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 프리셋이 없습니다. id=" + preset_id));

        return new SearchPresetResponseDto(entity);
    }

    @Override
    @Transactional
    public void removeSearchPreset(Long preset_id) {
        /* 1-tuple delete */
        SearchPreset searchPreset = searchPresetRepository.findById(preset_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 프리셋이 없습니다. id=" + preset_id));

        searchPresetRepository.delete(searchPreset);
    }
}
