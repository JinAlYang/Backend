package com.JinAlYang.member.web.dto;

import com.JinAlYang.member.domain.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDto {

    private Long id;
    private String name;
    private String email;
    private String profileUrl;
    private Gender gender;
    private int age;
    private int livingExpenses;
    private int savingMoney;
    private int loanInterest;

    @Builder
    public MemberResponseDto(Long id, String name, String email, String profileUrl, Gender gender, int age, int livingExpenses, int savingMoney, int loanInterest) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profileUrl = profileUrl;
        this.gender = gender;
        this.age = age;
        this.livingExpenses = livingExpenses;
        this.savingMoney = savingMoney;
        this.loanInterest = loanInterest;
    }
}
