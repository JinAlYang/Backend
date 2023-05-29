package com.JinAlYang.member.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Gender {
    MAN("남성"), WOMAN("여성");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
