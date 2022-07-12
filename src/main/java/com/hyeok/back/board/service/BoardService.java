package com.hyeok.back.board.service;

import com.hyeok.back.board.dto.Board;
import com.hyeok.back.board.entity.BoardEntity;
import com.hyeok.back.board.heartEnum.HeartType;
import com.hyeok.back.board.param.HeartReq;
import com.hyeok.back.board.param.WriteReq;
import com.hyeok.back.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Resource
    private BoardRepository boardRepository;

    /* 게시글 저장 */
    @Transactional
    public boolean saveBoard(WriteReq writeReq) {
        Board board = Board.builder()
                .writer(writeReq.getWriter())
                .title(writeReq.getTitle())
                .content(writeReq.getContent())
                .filePath(writeReq.getFilePath())
                .fileName(writeReq.getFileName())
                .build();
        boardRepository.save(board.toEntity());

        return true;
    }

    /* 게시글 목록 불러오기 */
    @Transactional(readOnly = true)
    public List<Board> getBoardList() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<Board> boardDtoList = new ArrayList<>();

        for(BoardEntity boardEntity : boardEntities) {
            Board board = Board.builder()
                    .id(boardEntity.getId())
                    .writer(boardEntity.getWriter())
                    .title(boardEntity.getTitle())
                    .heart(boardEntity.getHeart())
                    .content(boardEntity.getContent())
                    .createdAt(boardEntity.getCreatedAt())
                    .updatedAt(boardEntity.getUpdatedBy())
                    .build();

            boardDtoList.add(board);
        }

        return boardDtoList;
    }

    /* 좋아요 갯수 관리 */
    @Transactional
    public boolean heartControl(HeartReq heartReq) {
        if(heartReq.getClickType().equals(HeartType.CLICK.getCode()))
            return BoardRepository.heartCountUp(heartReq.getId());
        else
            return BoardRepository.heartCountDown(heartReq.getId());
    }

    /* 작성한 게시물 읽기 */
    @Transactional(readOnly = true)
    public Board getBoard(Long id) {
        Optional<BoardEntity> boardDetail = boardRepository.findById(id);
        BoardEntity boardEntity = boardDetail.get();

        Board board = Board.builder()
                .id(boardEntity.getId())
                .writer(boardEntity.getWriter())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .heart(boardEntity.getHeart())
                .fileName(boardEntity.getFileName())
                .filePath(boardEntity.getFilePath())
                .build();

        return board;
    }

}
