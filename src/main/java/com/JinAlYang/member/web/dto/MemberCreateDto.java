package com.JinAlYang.member.web.dto;

import com.JinAlYang.member.domain.Gender;
import com.JinAlYang.member.domain.Member;
import com.JinAlYang.memberRegion.MemberRegion;
import com.JinAlYang.realEstate.domain.RealEstate;
import com.JinAlYang.searchPreset.domain.SearchPreset;
import com.JinAlYang.wishList.domain.WishList;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MemberCreateDto {

    private String name;
    private String email;
    private String profileUrl;
    private Gender gender;
    private int age;
    private int livingExpenses;
    private int savingMoney;
    private int loanInterest;

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .email(email)
                .profileUrl(profileUrl)
                .gender(gender)
                .age(age)
                .livingExpenses(livingExpenses)
                .savingMoney(savingMoney)
                .loanInterest(loanInterest)
                .build();
    }
}
