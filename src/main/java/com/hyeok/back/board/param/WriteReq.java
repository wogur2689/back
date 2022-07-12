package com.hyeok.back.board.param;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class WriteReq {
    /**
     * 게시판 글 작성
     */
    private String writer;  //작성자
    private String title;   //제목
    private String content; //내용
    private String filePath; //파일경로
    private String fileName; //파일명
}
