package com.hyeok.back.board.service;

import com.hyeok.back.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BoardService {
    @Resource
    private BoardRepository boardRepository;

}
