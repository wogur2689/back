package com.hyeok.back.board.dto;

import com.hyeok.back.board.entity.BoardEntity;
import com.hyeok.back.member.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Board {
    private Long id;          //아이디
    private String writer;    //작성자
    private String title;     //제목
    private String content;   //컨텐츠
    private Integer heart;    //좋아요
    private String filePath;  //파일경로
    private String fileName;  //파일명
    private LocalDateTime createdAt; //작성일시
    private LocalDateTime updatedAt; //수정일시

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .filePath(filePath)
                .fileName(fileName)
                .build();
    }

    @Builder
    public Board(Long id, String writer, String title, String content, Integer heart, String filePath, String fileName, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.heart = heart;
        this.filePath = filePath;
        this.fileName = fileName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
