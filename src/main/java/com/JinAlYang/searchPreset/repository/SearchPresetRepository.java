package com.JinAlYang.searchPreset.repository;

import com.JinAlYang.searchPreset.domain.SearchPreset;
import com.JinAlYang.wishList.domain.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchPresetRepository extends JpaRepository<SearchPreset, Long> {
    List<SearchPreset> findAllSearchPreset();
}
