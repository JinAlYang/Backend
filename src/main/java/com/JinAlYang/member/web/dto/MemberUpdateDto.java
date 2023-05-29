package com.JinAlYang.member.web.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberUpdateDto {

    private String email;
    private String profileUrl;
    private int livingExpenses;
    private int savingMoney;
    private int loanInterest;
}
