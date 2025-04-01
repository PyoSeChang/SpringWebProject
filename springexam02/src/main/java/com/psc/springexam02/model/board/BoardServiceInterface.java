package com.psc.springexam02.model.board;

import com.psc.springexam02.dto.board.*;

import java.util.List;

public interface BoardServiceInterface {
    // 추가
    void insertBoard(BoardViewDTO board);
    BoardPageDTO selectBoardsByCategory(String category, int offset, int limit);
    BoardPageDTO selectBoardsByCategory(String category, String field, String word, int offset, int limit);
    // 상세보기
    BoardViewDTO showBoardDetail(int num);
    // 수정
    void updateBoard(BoardDTO board);
    // 삭제
    void deleteBoard(int num);
    // 보드 가져오기
    BoardDTO getBoard(int num);
    // 메타 정보 가져오기
    BoardMetaDTO getMeta(int num);

    // Status 정보 가져오기
    BoardStatusDTO getStatus(int num);

    // BoardViewDTO 조립
    BoardViewDTO assembleBoardViewDTO(int num);

    void increaseLikeCount(int num);
    void decreaseLikeCount(int num);
    void increaseDislikeCount(int num);
    void decreaseDislikeCount(int num);

    void increaseReadCount(int num);
}
