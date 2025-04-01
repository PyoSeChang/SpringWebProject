package com.psc.springexam02.model.board;

import com.psc.springexam02.dto.board.BoardDTO;
import com.psc.springexam02.dto.board.BoardMetaDTO;
import com.psc.springexam02.dto.board.BoardStatusDTO;
import com.psc.springexam02.dto.board.BoardViewDTO;

import java.util.HashMap;
import java.util.List;

public interface BoardRepository {
    // 추가
    void dao_insertBoard(BoardViewDTO board);
    List<BoardViewDTO> selectBoardsByCategory(String category, int offset, int limit);
    List<BoardViewDTO> selectBoardsByCategory(String category, String field, String word, int offset, int limit);
    int countBoardsByCategory(String category);
    int countBoardsByCategory(String category, String field, String word);
    // 상세보기
    BoardViewDTO dao_showBoardDetail(int num);
    // 수정
    void dao_updateBoard(BoardDTO board);
    // 삭제
    void dao_deleteBoard(int num);
    // 보드 정보 가져오기
    BoardDTO dao_selectBoard(int num);
    // 메타 정보 가져오기
    BoardMetaDTO dao_selectBoardMeta(int num);
    // Status 정보 가져오기
    BoardStatusDTO dao_selectBoardStatus(int num);

    // update LikeCount
    void dao_updateLikeCount(int num, boolean isIncrement);
    // update DislikeCount
    void dao_updateDislikeCount(int num, boolean isIncrement);


    void dao_updateReadCount(int num);
}
