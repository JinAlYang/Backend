package com.JinAlYang.realEstate.repository;

import com.JinAlYang.realEstate.domain.RealEstate;
import com.JinAlYang.realEstate.domain.RealEstateDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface RealEstateDetailRepository extends JpaRepository<RealEstateDetail, Long>, JpaSpecificationExecutor<RealEstate> {
}
