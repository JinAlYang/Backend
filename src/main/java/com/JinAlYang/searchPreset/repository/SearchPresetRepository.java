package com.JinAlYang.searchPreset.repository;

import com.JinAlYang.searchPreset.domain.SearchPreset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchPresetRepository extends JpaRepository<SearchPreset, Long> {

    @Query("select sp from SearchPreset sp order by sp.id desc")
    List<SearchPreset> findAllSearchPreset();
}
