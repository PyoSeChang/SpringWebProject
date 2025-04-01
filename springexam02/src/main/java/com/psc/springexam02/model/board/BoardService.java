package com.psc.springexam02.model.board;

import com.psc.springexam02.dto.board.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@RequiredArgsConstructor
@Service
public class BoardService implements BoardServiceInterface {
    private final BoardDAO boardDAO;
    @Override
    public void insertBoard(BoardViewDTO board) {
        boardDAO.dao_insertBoard(board);
    }

    @Override
    public BoardPageDTO selectBoardsByCategory(String category, int offset, int limit) {
        List<BoardViewDTO> list = boardDAO.selectBoardsByCategory(category, offset, limit);
        int count = boardDAO.countBoardsByCategory(category);

        BoardPageDTO dto = new BoardPageDTO();
        dto.setBoardList(list);
        dto.setTotalCount(count);
        return dto;
    }

    @Override
    public BoardPageDTO selectBoardsByCategory(String category, String field, String word, int offset, int limit) {
        List<BoardViewDTO> list = boardDAO.selectBoardsByCategory(category, field, word, offset, limit);
        int count = boardDAO.countBoardsByCategory(category, field, word);

        BoardPageDTO dto = new BoardPageDTO();
        dto.setBoardList(list);
        dto.setTotalCount(count);
        return dto;
    }


    @Override
    public BoardViewDTO showBoardDetail(int num) {
        return boardDAO.dao_showBoardDetail(num);
    }
    @Override
    public void updateBoard(BoardDTO board) {
        boardDAO.dao_updateBoard(board);
    }

    @Override
    public void deleteBoard(int num) {
        boardDAO.dao_deleteBoard(num);
    }

    @Override
    public BoardDTO getBoard(int num) {
        return boardDAO.dao_selectBoard(num);
    }
    @Override
    public BoardMetaDTO getMeta(int num) {
        return boardDAO.dao_selectBoardMeta(num);
    }

    @Override
    public BoardStatusDTO getStatus(int num) {
        return boardDAO.dao_selectBoardStatus(num);
    }

    @Override
    public BoardViewDTO assembleBoardViewDTO(int num) {
        BoardDTO board = boardDAO.dao_selectBoard(num);
        BoardMetaDTO meta = boardDAO.dao_selectBoardMeta(num);
        BoardStatusDTO status =boardDAO.dao_selectBoardStatus(num);
        BoardViewDTO dto = new BoardViewDTO();

        // 본문
        dto.setNum(board.getNum());
        dto.setUserid(board.getUserid());
        dto.setSubject(board.getSubject());
        dto.setContent(board.getContent());
        dto.setPassword(board.getPassword());

        // 메타
        dto.setCategory(meta.getCategory());
        dto.setTags(meta.getTags());
        dto.setRegdate(meta.getRegdate());
        dto.setUpdatedate(meta.getUpdatedate());

        // 상태
        dto.setReadcount(status.getReadcount());
        dto.setLikecount(status.getLikecount());
        dto.setDislikecount(status.getDislikecount());
        dto.setCommentcount(status.getCommentcount());

        return dto;
    }

    @Override
    public void increaseLikeCount(int num) {
        boardDAO.dao_updateLikeCount(num, true);
    }

    @Override
    public void decreaseLikeCount(int num) {
        boardDAO.dao_updateLikeCount(num, false);
    }

    @Override
    public void increaseDislikeCount(int num) {
        boardDAO.dao_updateDislikeCount(num, true);
    }

    @Override
    public void decreaseDislikeCount(int num) {
        boardDAO.dao_updateDislikeCount(num, false);
    }

    @Override
    public void increaseReadCount(int num) {
        boardDAO.dao_updateReadCount(num);
    }

}
