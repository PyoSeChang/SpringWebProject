package com.psc.springexam02.model;

import com.psc.springexam02.dto.BoardDTO;

import java.util.List;

public interface BoardServiceInterface {
    // 추가
    void insertBoard(BoardDTO board);
    // 전체보기
    List<BoardDTO> showBoards();
    // 검색한 보드 보기
    List<BoardDTO> showBoards(String searchField, String searchWord);
    // 갯수
    int countBoards();
    // 검색한 갯수 보기
    int countBoards(String searchField, String searchWord);
    // 상세보기
    BoardDTO showBoardDetail(int num);
    // 수정
    void updateBoard(BoardDTO board);
    // 삭제
    void deleteBoard(int num);

}
