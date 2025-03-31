package com.psc.springexam02.model.board;

import com.psc.springexam02.dto.board.BoardDTO;
import com.psc.springexam02.dto.board.BoardMetaDTO;
import com.psc.springexam02.dto.board.BoardStatusDTO;
import com.psc.springexam02.mapper.board.BoardMapper;
import com.psc.springexam02.mapper.board.BoardMetaMapper;
import com.psc.springexam02.mapper.board.BoardStatusMapper;
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
    private final BoardMetaMapper boardMetaMapper;
    private final BoardStatusMapper boardStatusMapper;
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

    @Override
    public BoardMetaDTO dao_selectBoardMeta(int num) {
        return boardMetaMapper.getMeta(num);
    }

    @Override
    public BoardStatusDTO dao_selectBoardStatus(int num) {
        return boardStatusMapper.getStatus(num);
    }


}
