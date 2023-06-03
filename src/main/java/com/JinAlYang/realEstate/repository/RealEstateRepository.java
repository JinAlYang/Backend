package com.JinAlYang.realEstate.repository;

import com.JinAlYang.realEstate.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RealEstateRepository extends JpaRepository<RealEstate,Long>, JpaSpecificationExecutor<RealEstate> {
}
