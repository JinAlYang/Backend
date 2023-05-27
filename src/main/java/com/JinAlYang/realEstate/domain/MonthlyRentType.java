package com.JinAlYang.realEstate.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public enum MonthlyRentType {
    MONTHLY("MONTHLY"), JEONSE("JEONSE");

    @Getter
    private String value;

    MonthlyRentType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
