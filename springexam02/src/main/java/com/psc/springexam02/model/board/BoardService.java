package com.psc.springexam02.model.board;

import com.psc.springexam02.dto.board.BoardDTO;
import com.psc.springexam02.dto.board.BoardMetaDTO;
import com.psc.springexam02.dto.board.BoardStatusDTO;
import com.psc.springexam02.dto.board.BoardViewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@RequiredArgsConstructor
@Service
public class BoardService implements BoardServiceInterface {
    private final BoardDAO boardDAO;
    @Override
    public void insertBoard(BoardDTO board) {
        boardDAO.dao_insertBoard(board);
    }

    @Override
    public List<BoardDTO> showBoards() {
        return boardDAO.dao_showBoards();
    }
    @Override
    public List <BoardDTO> showBoards(String searchField, String searchWord) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("searchField", searchField);
        map.put("searchWord", searchWord);
        return boardDAO.dao_showBoards(map);
    }

    @Override
    public int countBoards() {
        return boardDAO.dao_countBoards();
    }
    @Override
    public int countBoards(String searchField, String searchWord) {
        HashMap<String, String> map = new HashMap<>();
        map.put("searchField", searchField);
        map.put("searchWord", searchWord);
        return boardDAO.dao_countBoards(map);
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

}
