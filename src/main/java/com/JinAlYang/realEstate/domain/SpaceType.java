package com.JinAlYang.realEstate.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SpaceType {
    ONEROOM("원룸"), TWOROOM("투룸"), OFFICETEL("오피스텔");

    @Getter
    private String value;

    SpaceType(String value) { this.value = value; }
    @JsonValue
    public String getValue(){
        return value;
    }
}
