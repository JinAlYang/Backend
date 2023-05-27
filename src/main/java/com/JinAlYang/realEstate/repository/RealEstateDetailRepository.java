package com.JinAlYang.realEstate.repository;

import com.JinAlYang.realEstate.domain.RealEstate;
import com.JinAlYang.realEstate.domain.RealEstateDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealEstateDetailRepository extends JpaRepository<RealEstateDetail, Long> {
}
