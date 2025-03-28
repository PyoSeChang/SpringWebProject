package com.psc.springexam02.mapper;

import com.psc.springexam02.dto.BoardDTO;

import java.util.HashMap;
import java.util.List;

public interface BoardMapper {
    // 추가
    void insertBoard(BoardDTO board);
    // 전체보기
    List<BoardDTO> showBoards();
    // 검색 하기
    List<BoardDTO> searchBoards(HashMap<String, String> map);
    // 갯수 세기
    int countBoards();
    // 검색 갯수 세기
    int countSearchedBoards(HashMap<String, String> map);
    // 상세 보기
    BoardDTO showBoardDetail(int num);
    // 수정
    void updateBoard(BoardDTO board);
    // 삭제
    void deleteBoard(int num);

}
