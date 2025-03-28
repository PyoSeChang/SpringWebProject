package com.psc.springexam02.model.board;

import com.psc.springexam02.dto.BoardDTO;
import com.psc.springexam02.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Repository
@RequiredArgsConstructor
public class BoardDAO implements BoardRepository {
    private final BoardMapper boardMapper;
    @Override
    public void dao_insertBoard(BoardDTO board) {
        boardMapper.insertBoard(board);
    }

    @Override
    public List<BoardDTO> dao_showBoards() {
        return boardMapper.showBoards();
    }
    @Override
    public List<BoardDTO> dao_showBoards(HashMap<String, String> map) {
        return boardMapper.searchBoards(map);
    }
    @Override
    public int dao_countBoards(HashMap<String, String> map) {
        return boardMapper.countSearchedBoards(map);
    }
    @Override
    public BoardDTO dao_showBoardDetail(int num) {
        return boardMapper.showBoardDetail(num);
    }

    @Override
    public int dao_countBoards() {
        return boardMapper.countBoards();
    }

    @Override
    public void dao_updateBoard(BoardDTO board) {
        boardMapper.updateBoard(board);
    }

    @Override
    public void dao_deleteBoard(int num) {
        boardMapper.deleteBoard(num);
    }


}
