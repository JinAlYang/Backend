package com.JinAlYang.member.domain;

import com.JinAlYang.region.domain.Region;
import com.JinAlYang.searchPreset.domain.SearchPreset;
import com.JinAlYang.wishList.domain.WishList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "member")
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_name",nullable = false)
    private String name;
    @Column(name = "member_email",nullable = false)
    private String email;
    @Column(name = "member_profileUrl")
    private String profileUrl;
    @Column(name = "member_gender",nullable = false)
    private Gender gender;
    @Column(name = "member_age",nullable = false)
    private int age;
    @Column(name = "member_livingExpenses")
    private int livingExpenses;
    @Column(name = "member_savingMoney")
    private int savingMoney;
    @Column(name = "member_loanInterest")
    private int loanInterest;

    @OneToMany(mappedBy = "member")
    private List<Region> InterestMemberRegion;

    @OneToMany(mappedBy = "member")
    private List<WishList> memberRealEstate;

    @OneToMany(mappedBy = "member")
    private List<SearchPreset> memberSearchPreset;
}
