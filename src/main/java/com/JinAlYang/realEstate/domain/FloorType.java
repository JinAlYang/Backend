package com.JinAlYang.realEstate.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FloorType {
    ROOFTOP("옥탑"), GROUND("지상층"), UNDER("반지하");

    @Getter
    private String value;

    FloorType(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
        return value;
    }
}
