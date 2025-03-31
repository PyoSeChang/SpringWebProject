package com.psc.springexam02.model.board;

import com.psc.springexam02.dto.board.BoardDTO;
import com.psc.springexam02.dto.board.BoardMetaDTO;
import com.psc.springexam02.dto.board.BoardStatusDTO;

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

    // 메타 정보 가져오기
    BoardMetaDTO dao_selectBoardMeta(int num);
    // Status 정보 가져오기
    BoardStatusDTO dao_selectBoardStatus(int num);



}
