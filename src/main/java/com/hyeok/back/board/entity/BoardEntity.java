package com.hyeok.back.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "board")
public class BoardEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "writer", length = 10, nullable = false)
    private String writer; //작성자

    @Column(name = "title", length = 100, nullable = false)
    private String title; //제목

    @Column(name = "heart")
    private Integer heart; //좋아요

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content; //내용

    @Column(name = "file_path", length = 100)
    private String filePath; //파일경로

    @Column(name = "file_name", length = 100)
    private String fileName; //파일명
}
