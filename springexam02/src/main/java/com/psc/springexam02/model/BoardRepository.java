package com.psc.springexam02.model;

import com.psc.springexam02.dto.BoardDTO;

import java.util.HashMap;
import java.util.List;

public interface BoardRepository {
    // 추가
    void dao_insertBoard(BoardDTO board);
    // 전체보기
    List<BoardDTO> dao_showBoards();
    // 검색보기
    List<BoardDTO> dao_showBoards(HashMap<String, String> map);
    // 갯수
    int dao_countBoards();
    // 검색한 보드 갯수
    int dao_countBoards(HashMap<String, String> map);
    // 상세보기
    BoardDTO dao_showBoardDetail(int num);
    // 수정
    void dao_updateBoard(BoardDTO board);
    // 삭제
    void dao_deleteBoard(int num);



}
