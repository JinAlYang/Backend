package com.JinAlYang.realEstate.repository;

import com.JinAlYang.member.domain.Member;
import com.JinAlYang.realEstate.domain.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<RealEstate,Long> {
}
