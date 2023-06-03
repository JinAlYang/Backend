package com.JinAlYang.member.domain;

import com.JinAlYang.member.web.dto.MemberSignInDto;
import com.JinAlYang.member.web.dto.MemberUpdateDto;
import com.JinAlYang.memberRegion.MemberRegion;
import com.JinAlYang.searchPreset.domain.SearchPreset;
import com.JinAlYang.wishList.domain.WishList;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "member")
@Getter
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
    @Enumerated(value = EnumType.STRING)
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
    private List<MemberRegion> InterestMemberRegions;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @MapKeyColumn(name = "regionId", nullable=true)
    private Map<Long, WishList> wishLists;

    @OneToMany(mappedBy = "member")
    private List<SearchPreset> memberSearchPresets;

    @Builder
    public Member(String name, String email, String profileUrl, Gender gender, int age, int livingExpenses, int savingMoney, int loanInterest) {
        this.name = name;
        this.email = email;
        this.profileUrl = profileUrl;
        this.gender = gender;
        this.age = age;
        this.livingExpenses = livingExpenses;
        this.savingMoney = savingMoney;
        this.loanInterest = loanInterest;
    }

    public Member signIn(MemberSignInDto memberSignInDto)
    {
        this.gender = memberSignInDto.getGender();
        this.age = memberSignInDto.getAge();
        this.livingExpenses = memberSignInDto.getLivingExpenses();
        this.savingMoney = memberSignInDto.getSavingMoney();
        this.loanInterest = memberSignInDto.getLoanInterest();

        return this;
    }

    public Member update(MemberUpdateDto memberUpdateDto) {
        this.profileUrl = memberUpdateDto.getProfileUrl();
        this.email = memberUpdateDto.getEmail();
        this.livingExpenses = memberUpdateDto.getLivingExpenses();
        this.savingMoney = memberUpdateDto.getSavingMoney();
        this.loanInterest = memberUpdateDto.getLoanInterest();

        return this;
    }

    public Map<Long, WishList> initializeOrGetWishList(){
        if(this.wishLists == null)
        {
            this.wishLists = new HashMap<>();
            System.out.println("해당 Member( "+this.getId()+" )의 wishList가 Null이었습니다.");
        }
        return this.wishLists;
    }
}
