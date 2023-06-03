package com.JinAlYang.searchPreset.repository;

import com.JinAlYang.searchPreset.domain.SearchPreset;
import com.JinAlYang.wishList.domain.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchPresetRepository extends JpaRepository<SearchPreset,Long> {
}
