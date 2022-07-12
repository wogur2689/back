package com.hyeok.back.board.param;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class HeartReq {
    /**
     * 좋아요 누를시 받는 값
     */
    private Long id; //게시물 식별번호(기본키)
    private String userId; //아이디
    private String clickType; //좋아요인지 좋아요취소인지 구별
}
