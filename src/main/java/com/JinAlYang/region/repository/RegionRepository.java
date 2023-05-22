package com.JinAlYang.region.repository;

import com.JinAlYang.realEstate.domain.RealEstate;
import com.JinAlYang.region.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region,Long> {
}