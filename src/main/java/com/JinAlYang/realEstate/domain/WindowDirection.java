package com.JinAlYang.realEstate.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WindowDirection {
    EAST("동향"),
    WEST("서향"),
    SOUTH("남향"),
    NORTH("북향"),
    SOUTHEAST("남동향"),
    SOUTHWEST("남서향"),
    NORTHEAST("북동향"),
    NORTHWEST("북서향");

    private String value;

    WindowDirection(String value) { this.value = value; }

    @JsonValue
    public String getValue(){
        return value;
    }
}
