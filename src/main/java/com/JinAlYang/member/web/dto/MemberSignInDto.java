package com.JinAlYang.member.web.dto;

import com.JinAlYang.member.domain.Gender;
import com.JinAlYang.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSignInDto {
    private Long id;
    private Gender gender;
    private int age;
    private int livingExpenses;
    private int savingMoney;
    private int loanInterest;
}
