package com.JinAlYang.realEstate.repository;

import com.JinAlYang.realEstate.domain.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealEstateRepository extends JpaRepository<RealEstate,Long> {
}
