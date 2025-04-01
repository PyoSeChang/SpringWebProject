package com.psc.springexam02.mapper.board;

import com.psc.springexam02.dto.board.BoardDTO;
import com.psc.springexam02.dto.board.BoardMetaDTO;
import com.psc.springexam02.dto.board.BoardStatusDTO;
import com.psc.springexam02.dto.board.BoardViewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
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
    BoardViewDTO showBoardDetail(@Param("num")int num);
    // 수정
    void updateBoard(BoardDTO board);
    // 삭제
    void deleteBoard(int num);
    //
    BoardDTO selectBoard(@Param("num")int num);


}
