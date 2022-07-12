package com.hyeok.back.board.heartEnum;

import lombok.Getter;

@Getter
public enum HeartType {
    CLICK("Like"),
    CANCEL("Cancel");

    private String code;

    HeartType(String code) {
        this.code = code;
    }
}
