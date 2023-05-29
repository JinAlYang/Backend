package com.JinAlYang.region.repository;

import com.JinAlYang.member.domain.Member;
import com.JinAlYang.realEstate.domain.RealEstate;
import com.JinAlYang.region.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region,Long> {
    Optional<Region> findByName(String name);

}