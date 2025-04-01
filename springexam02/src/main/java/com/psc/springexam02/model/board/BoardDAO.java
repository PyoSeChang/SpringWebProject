package com.psc.springexam02.model.board;

import com.psc.springexam02.dto.board.BoardDTO;
import com.psc.springexam02.dto.board.BoardMetaDTO;
import com.psc.springexam02.dto.board.BoardStatusDTO;
import com.psc.springexam02.dto.board.BoardViewDTO;
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
    public void dao_insertBoard(BoardViewDTO board) {
        boardMapper.insertBoard(board);
    }

    @Override
    public List<BoardViewDTO> selectBoardsByCategory(String category, int offset, int limit) {
        return boardMapper.selectBoardsByCategory(category, offset, limit);
    }

    @Override
    public List<BoardViewDTO> selectBoardsByCategory(String category, String field, String word, int offset, int limit) {
        return boardMapper.selectBoardsByCategoryWithSearch(category, field, word, offset, limit);
    }

    @Override
    public int countBoardsByCategory(String category) {
        return boardMapper.countBoardsByCategory(category);
    }

    @Override
    public int countBoardsByCategory(String category, String field, String word) {
        return boardMapper.countBoardsByCategoryWithSearch(category, field, word);
    }


    @Override
    public BoardViewDTO dao_showBoardDetail(int num) {
        return boardMapper.showBoardDetail(num);
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
    public BoardDTO dao_selectBoard(int num) {
        return boardMapper.selectBoard(num);
    }

    @Override
    public BoardMetaDTO dao_selectBoardMeta(int num) {
        return boardMetaMapper.selectBoardMeta(num);
    }

    @Override
    public BoardStatusDTO dao_selectBoardStatus(int num) {
        return boardStatusMapper.selectBoardStatus(num);
    }

    @Override
    public void dao_updateLikeCount(int num, boolean isIncrement) {
        int amount = isIncrement ? 1 : -1;
        boardStatusMapper.updateLikeCount(num, amount);  // ✔️ num 전달
    }

    @Override
    public void dao_updateDislikeCount(int num, boolean isIncrement) {
        int amount = isIncrement ? 1 : -1;
        boardStatusMapper.updateDislikeCount(num, amount);  // ✔️ num 전달
    }

    @Override
    public void dao_updateReadCount(int num) {
        boardStatusMapper.updateReadCount(num);
    }


}
