package com.hyeok.back.enums;

import lombok.Getter;

@Getter
public enum ApiCode {
    /* Api 규격서 코드*/
    API_0000("0000", "성공")
    ,API_1000("1000", "입력값 부족")
    ,API_1001("1001", "데이터 형식 미일치")
    ,API_1002("1002", "처리 불가")
    ,API_1003("1003", "네트워크 에러")

    /* 로그인 에러 */
    ,API_2000("2000", "존재하지 않는 계정입니다.")
    ,API_2001("2001", "비밀번호가 틀렸습니다.")

    /* 회원가입 에러 */
    ,API_2002("2002", "존재하는 아이디또는 닉네임 입니다.")

    /* 기타오류 */
    ,API_9999("9999", "기타 오류");
    private String code;
    private String msg;

    ApiCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
