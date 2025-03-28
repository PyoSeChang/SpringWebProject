package com.psc.springexam02.model.board;

import com.psc.springexam02.dto.BoardDTO;
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
    public BoardDTO showBoardDetail(int num) {
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

}
