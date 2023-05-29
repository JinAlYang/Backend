package com.JinAlYang.wishList.domain;

import com.JinAlYang.member.domain.Member;
import com.JinAlYang.realEstate.domain.RealEstate;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wishList")
@Getter
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

    private boolean zzimList_status;

    public void setRecentHome_status(boolean recentHome_status) {
        this.recentHome_status = recentHome_status;
    }

    public void setZzimList_status(boolean zzimList_status) {
        this.zzimList_status = zzimList_status;
        System.out.println("true로 바꾸기");
    }

    @Builder
    public WishList(Member member, RealEstate realEstate) {
        this.member = member;
        this.realEstate = realEstate;
        this.recentHome_status = false;
        this.zzimList_status = false;
    }
}
