package com.hyeok.back.enums;

import lombok.Getter;

@Getter
public enum ApiCode {
    API_0000("0000", "성공")
    , API_1000("1000", "입력값 부족")
    , API_2000("2000", "데이터 형식 미일치")
    , API_3000("3000", "처리 불가")
    , API_4000("4000", "네트워크 에러")
    , API_5000("5000", "기타 오류");

    private String code;
    private String msg;

    ApiCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
