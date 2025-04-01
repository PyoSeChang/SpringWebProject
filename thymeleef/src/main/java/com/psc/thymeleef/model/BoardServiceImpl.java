package com.psc.thymeleef.model;


import com.psc.thymeleef.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardDAOImpl boardDAO;
    @Override // 전체 조회
    public List<BoardDTO> getList() {
        return boardDAO.searchAllBoard();
    }

    @Override // 게시글 가져오기
    public BoardDTO getBoardByNum() {
        return null;
    }

    @Override // 게시글 삽입
    public void writeBoard(BoardDTO dto) {

    }

    @Override
    public void removeBoard(BoardDTO dto) {

    }

    @Override
    public void modifyBoard(BoardDTO dto) {

    }
}
