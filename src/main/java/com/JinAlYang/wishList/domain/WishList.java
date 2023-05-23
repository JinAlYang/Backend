package com.JinAlYang.wishList.domain;

import com.JinAlYang.member.domain.Member;
import com.JinAlYang.realEstate.domain.RealEstate;
import com.JinAlYang.region.domain.Region;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wishList")
@NoArgsConstructor
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wishList_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "realEstate_id")
    private RealEstate realEstate;

    private boolean recentHome_status;

    private boolean realEstateAgency_status;

}
