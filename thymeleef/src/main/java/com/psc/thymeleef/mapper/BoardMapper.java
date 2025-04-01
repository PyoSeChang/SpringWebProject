package com.psc.thymeleef.mapper;


import com.psc.thymeleef.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시글 전체 조회
    List<BoardDTO> selectAll();

    // 게시글 등록
    void insertBoard(BoardDTO dto);

    // 게시글 조회
    BoardDTO selectBoardByNum(int num);

    // 게시글 업데이트
    void updateBoard(BoardDTO dto);

    // 게시글 삭제
    void deleteBoard(int num);
}
